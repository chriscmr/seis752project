package com.seis.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.seis.domain.Grade;
import com.seis.domain.Ressource;
import com.seis.domain.Subject;

@Repository
public class RessourceDaoImpl {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	GradeDaoImpl gradeDao;
	
	@Autowired
	SubjectDaoImpl subjectDao;
	
	public Ressource get (long id){
		Query qRessource = entityManager.createQuery("select R from Ressource R where R.id = :id");
		qRessource.setParameter("id", id);			
		
		List<Ressource> myRessourceList = (List<Ressource>) qRessource.getResultList();		
		
		if (myRessourceList.size() > 0){
			return myRessourceList.get(0);
		}else{
			return null;
		}								
	}
	
	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
	public List<Ressource> getAll (){
		Query qRessource = entityManager.createQuery("select R from Ressource R");						
		List<Ressource> myRessourceList = (List<Ressource>) qRessource.getResultList();						
		return myRessourceList;					
	}
	
	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
	public List<Ressource> getByDescriptionOrTitle (String keyword){
		Query qRessource = entityManager.createQuery("select R from Ressource R where upper(R.description) like :keyword or upper(R.title) like :keyword");
		qRessource.setParameter("keyword", "%" + keyword.trim().toUpperCase() + "%");		
		
		List<Ressource> myRessourceList = (List<Ressource>) qRessource.getResultList();
		
		return myRessourceList;					
	}
	
	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
	public List<Ressource> getByDescription (String keyword){
		Query qRessource = entityManager.createQuery("select R from Ressource R where upper(R.description) like :keyword");
		qRessource.setParameter("keyword", "%" + keyword.trim().toUpperCase() + "%");		
		
		List<Ressource> myRessourceList = (List<Ressource>) qRessource.getResultList();
		
		return myRessourceList;					
	}
	
	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
	public List<Ressource> getByGrade (String keyword, String gradeID){		
		Grade myGrade = gradeDao.getByID(gradeID);		
		Query qRessource = entityManager.createQuery("select R from Ressource R where ((upper(R.description) like :keyword) or (upper(R.title) like :keyword)) and (R.grades = :myGrade)");
		qRessource.setParameter("keyword", "%" + keyword.trim().toUpperCase() + "%");
		qRessource.setParameter("myGrade", myGrade);				
		List<Ressource> myRessourceList = (List<Ressource>) qRessource.getResultList();		
		return myRessourceList;					
	}
	
	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
	public List<Ressource> getBySubject (String keyword, String subjectID){		
		Subject mySubject = subjectDao.getByID(subjectID);		
		Query qRessource = entityManager.createQuery("select R from Ressource R where ((upper(R.description) like :keyword) or (upper(R.title) like :keyword)) and (R.subjects = :mySubject)");
		qRessource.setParameter("keyword", "%" + keyword.trim().toUpperCase() + "%");
		qRessource.setParameter("mySubject", mySubject);				
		List<Ressource> myRessourceList = (List<Ressource>) qRessource.getResultList();		
		return myRessourceList;					
	}
}
