package com.seis.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.seis.domain.Grade;

@Repository
public class GradeDaoImpl {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
	public List<Grade> getAll (){
		Query qGrade = entityManager.createQuery("select G from Grade G");						
		List<Grade> myGradeList = (List<Grade>) qGrade.getResultList();						
		return myGradeList;					
	}
	
	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
	public Grade getByID (String id){
		return entityManager.find(Grade.class, Long.valueOf(id).longValue());						
	}
}
