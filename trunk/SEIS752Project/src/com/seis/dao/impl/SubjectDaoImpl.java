package com.seis.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.seis.domain.Subject;

@Repository
public class SubjectDaoImpl {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
	public List<Subject> getAll (){
		Query qSubject = entityManager.createQuery("select S from Subject S");						
		List<Subject> mySubjectList = (List<Subject>) qSubject.getResultList();						
		return mySubjectList;					
	}
	
	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
	public Subject getByID (String id){
		return entityManager.find(Subject.class, Long.valueOf(id).longValue());						
	}
}
