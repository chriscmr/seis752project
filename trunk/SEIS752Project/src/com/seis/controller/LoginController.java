package com.seis.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.openid4java.OpenIDException;
import org.openid4java.consumer.ConsumerException;
import org.openid4java.consumer.ConsumerManager;
import org.openid4java.consumer.InMemoryConsumerAssociationStore;
import org.openid4java.consumer.InMemoryNonceVerifier;
import org.openid4java.consumer.VerificationResult;
import org.openid4java.discovery.DiscoveryInformation;
import org.openid4java.discovery.Identifier;
import org.openid4java.message.AuthRequest;
import org.openid4java.message.AuthSuccess;
import org.openid4java.message.ParameterList;
import org.openid4java.message.ax.AxMessage;
import org.openid4java.message.ax.FetchRequest;
import org.openid4java.message.ax.FetchResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory
			.getLogger(LoginController.class);

	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public void createAuthRequest(HttpServletRequest httpReq,
			HttpServletResponse httpResp,
			@RequestParam("openid_identifier") String openIdIdentifier) {
		logger.debug("createAuthRequest invoked");

		this.authRequest(openIdIdentifier, httpReq, httpResp);
	}

	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public void verifyAuthResponse(HttpServletRequest httpReq,
			HttpServletResponse httpResp) {
		logger.debug("verifyAuthResponse invoked");

		Identifier identifier = this.verifyResponse(httpReq);
		// if openid login succeeded redirect to login page
		if (identifier != null) {
			try {
				httpResp.sendRedirect("upload.jsp");
			} catch (IOException e) {
				String message = "Exception redirecting to login page";
				logger.error(message);
				throw new RuntimeException(message);
			}
		} else {
			String message = "Exception authenticating with OpenID";
			logger.error(message);
			throw new RuntimeException(message);
		}
	}

	@SuppressWarnings("unchecked")
	private void authRequest(String userSuppliedString,
			HttpServletRequest httpReq, HttpServletResponse httpResp) {
		try {
			// configure the return_to URL where your application will receive
			// the authentication responses from the OpenID provider
			String returnToUrl = httpReq.getRequestURL().toString();

			// get consumer manager
			ConsumerManager manager = getConsumerManager();

			// perform discovery on the user-supplied identifier
			List<DiscoveryInformation> discoveries = manager
					.discover(userSuppliedString);

			// attempt to associate with the OpenID provider
			// and retrieve one service end point for authentication
			DiscoveryInformation discovered = manager.associate(discoveries);

			// store the discovery information in the user's session
			httpReq.getSession().setAttribute("discovered", discovered);

			// obtain a AuthRequest message to be sent to the OpenID provider
			AuthRequest authReq = manager.authenticate(discovered, returnToUrl);

			FetchRequest fetch = FetchRequest.createFetchRequest();
			fetch.addAttribute("email", "http://axschema.org/contact/email",
					true);

			// attach the extension to the authentication request
			authReq.addExtension(fetch);

			httpResp.sendRedirect(authReq.getDestinationUrl(true));

		} catch (OpenIDException e) {
			String message = "Exception building OpenID auth request";
			logger.error(message, e);
			throw new RuntimeException(message, e);
		} catch (IOException e) {
			String message = "Exception redirecting to OpenID URL";
			logger.error(message, e);
			throw new RuntimeException(message, e);
		}
	}

	@SuppressWarnings("unchecked")
	private Identifier verifyResponse(HttpServletRequest httpReq) {
		try {
			// extract the parameters from the authentication response
			// (which comes in as a HTTP request from the OpenID provider)
			ParameterList response = new ParameterList(
					httpReq.getParameterMap());

			// retrieve the previously stored discovery information
			DiscoveryInformation discovered = (DiscoveryInformation) httpReq
					.getSession().getAttribute("discovered");

			// extract the receiving URL from the HTTP request
			StringBuffer receivingURL = httpReq.getRequestURL();
			String queryString = httpReq.getQueryString();
			if (queryString != null && queryString.length() > 0)
				receivingURL.append("?").append(httpReq.getQueryString());

			// get consumer manager
			ConsumerManager manager = getConsumerManager();
			
			// verify the response; ConsumerManager needs to be the same
			// (static) instance used to place the authentication request
			VerificationResult verification = manager.verify(
					receivingURL.toString(), response, discovered);

			// examine the verification result and extract the verified
			// identifier
			Identifier verified = verification.getVerifiedId();
			if (verified != null) {
				AuthSuccess authSuccess = (AuthSuccess) verification
						.getAuthResponse();

				if (authSuccess.hasExtension(AxMessage.OPENID_NS_AX)) {
					FetchResponse fetchResp = (FetchResponse) authSuccess
							.getExtension(AxMessage.OPENID_NS_AX);

					List<String> emails = fetchResp.getAttributeValues("email");
					String email = emails.get(0);
					HttpSession session = httpReq.getSession(true);
					session.setAttribute("email", email);
				}

				return verified; // success
			}
		} catch (OpenIDException e) {
			String message = "Exception verifying OpenID response";
			logger.error(message, e);
			throw new RuntimeException(message, e);
		}
		
		return null;
	}

	private static ConsumerManager consumerManager;

	private static ConsumerManager getConsumerManager() {
		try {
			if (consumerManager == null) {
				consumerManager = new ConsumerManager();
				consumerManager
						.setAssociations(new InMemoryConsumerAssociationStore());
				consumerManager.setNonceVerifier(new InMemoryNonceVerifier(
						10000));
			}
		} catch (ConsumerException e) {
			String message = "Exception creating ConsumerManager";
			logger.error(message, e);
			throw new RuntimeException(message, e);
		}
		return consumerManager;
	}

}
