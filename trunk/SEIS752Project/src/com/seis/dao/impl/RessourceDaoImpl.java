package com.seis.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.seis.domain.Ressource;

@Repository
public class RessourceDaoImpl {
	
	@PersistenceContext
	private EntityManager entityManager;
	
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
		Query qRessource = entityManager.createQuery("select R from Ressource R where R.description like :keyword or R.title like like :keyword");
		qRessource.setParameter("keyword", "%" + keyword.toUpperCase() + "%");		
		
		List<Ressource> myRessourceList = (List<Ressource>) qRessource.getResultList();
		
		return myRessourceList;					
	}
	
}
