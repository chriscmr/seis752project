package com.seis.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.seis.dao.impl.GradeDaoImpl;
import com.seis.dao.impl.RessourceDaoImpl;
import com.seis.dao.impl.SubjectDaoImpl;
import com.seis.domain.Grade;
import com.seis.domain.Ressource;
import com.seis.domain.Subject;


@Controller
public class SearchController  {
	
	@Autowired
	RessourceDaoImpl R;
	
	@Autowired
	GradeDaoImpl gradeDao;
	
	@Autowired
	SubjectDaoImpl subjectDao;
	
	@ModelAttribute("listResource")
	public List<Ressource> getAllResource(HttpServletRequest request) {		
		return R.getAll();
	}
	
	@ModelAttribute("listGrade")
	public List<Grade> getAllGrade(HttpServletRequest request) {		
		return gradeDao.getAll();
	}
	
	@ModelAttribute("listSubject")
	public List<Subject> getAllSubject(HttpServletRequest request) {		
		return subjectDao.getAll();
	}
	
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);				
	
	@RequestMapping(value="search.do", method = RequestMethod.GET)
   public String setUpForm(Map model, @RequestParam(value="param", required=false) String param, @RequestParam(value="subject", required=false) String subject, @RequestParam(value="grade", required=false) String grade, @RequestParam(value="keyword", required=false) String keyword) {			
		logger.debug("setUpForm invoked");
		
		if (keyword != null){			
			if (!keyword.trim().equals("")){
				List<Ressource> resourceList = new ArrayList<Ressource>();
				model.put("keyword", keyword);
				if (param != null){					
					if (param.equalsIgnoreCase("description")){						
						logger.debug("invoked description");						
						resourceList = R.getByDescription(keyword);
					}
					if (param.equalsIgnoreCase("grade")){
						logger.debug("invoked grade");
						resourceList = R.getByGrade(keyword, grade);						
					}
					if (param.equalsIgnoreCase("subject")){
						logger.debug("invoked subject");
						resourceList = R.getBySubject(keyword, subject);						
					}
				}else{				
					logger.debug("invoked search without parameters");
					resourceList = R.getByDescriptionOrTitle(keyword);																		
				}
				model.put("param", param);
				model.put("subject", subject);
				model.put("grade", grade);
				model.put("resourceList", resourceList);
			}
			return "search_result";
		}
		return "search";		
    }
		
}
