package com.seis.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seis.dao.impl.RessourceDaoImpl;
import com.seis.domain.Ressource;


@Controller
public class SearchController  {
	
	@Autowired
	RessourceDaoImpl R;
	
	@ModelAttribute("listResource")
	public List<Ressource> getAllResource(HttpServletRequest request) {		
		return R.getAll();
	}
	
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);				
	
	@RequestMapping(value="search.do", method = RequestMethod.GET)
   public String setUpForm(Map<?,?> model) {			
		logger.debug("setUpForm invoked");					
		return "search";
    }
		
}
