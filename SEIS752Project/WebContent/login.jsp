<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log In</title>
<link type="text/css" rel="stylesheet" href="css/openid.css" />
<script type="text/javascript" src="js/jquery-1.6.min.js"></script>
<script type="text/javascript" src="js/openid-jquery.js"></script>
<script type="text/javascript" src="js/openid-en.js"></script>

<link rel="stylesheet" href="css/reset.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/layout.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/chosen.css" type="text/css" media="screen">


<script type="text/javascript">
	$(document).ready(function() {
		openid.init('openid_identifier');
	});
</script>
<!-- /Simple OpenID Selector -->
<style type="text/css">
/* Basic page formatting */
body {
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
}
</style>
</head>
<body>
	
	<div class="main">	
		
		<div >
			<H1><a class="logo" href="index.jsp">Teacher Resources</a></H1>			
		</div>			
		
		<div class="row-4">
			<h2>Sign-in</h2>
			<p>This page illustrates logging in with Google or Yahoo. After
				signing in, the user is redirected to the Upload page, which right now
				just shows their email address which is stored in a session attribute.</p>								
			<br />
			<!-- Simple OpenID Selector -->
			<form action="login.do" method="post" id="openid_form">
				<input type="hidden" name="action" value="verify" />
				<fieldset>					
					<div id="openid_choice">
						<p>Please click your account provider:</p>
						<div id="openid_btns"></div>
					</div>
					<div id="openid_input_area">
						<input id="openid_identifier" name="openid_identifier" type="text"
							value="http://" /> <input id="openid_submit" type="submit"
							value="Sign-In" />
					</div>
					<noscript>
						<p>
							OpenID is service that allows you to log-on to many different
							websites using a single indentity. Find out <a
								href="http://openid.net/what/">more about OpenID</a> and <a
								href="http://openid.net/get/">how to get an OpenID enabled
								account</a>.
						</p>
					</noscript>
				</fieldset>
			</form>
			
			<br/>
			<h3>Why OpenID?</h3>
				It's a single username and password that allows you to log in to any OpenID-enabled site.
				It works on thousands of websites.
				It's an open standard.
				
		</div>
	</div>
	
	<div style="width:100%;overflow:hidden;padding-top:170px;text-align:center">
	 	&copy;&nbsp;2012&nbsp;&#45;&nbsp;University&nbsp;of&nbsp;St.&nbsp;Thomas&nbsp;-&nbsp;SEIS&nbsp;752&nbsp;Team&nbsp;I
	</div>	
</body>
</html>