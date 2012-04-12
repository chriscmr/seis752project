package com.seis.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the CONTRIBUTOR database table.
 * 
 */
@Entity
public class Contributor implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId	
	private ContributorPK id;

	private String email;

    @Temporal( TemporalType.DATE)
	@Column(name="LAST_LOGIN_DATE")
	private Date lastLoginDate;

	//bi-directional many-to-one association to Ressource
    @ManyToOne
	@JoinColumn(name="ID1", insertable=false, updatable=false)	
	private Ressource ressource;

    public Contributor() {
    }

	public ContributorPK getId() {
		return this.id;
	}

	public void setId(ContributorPK id) {
		this.id = id;
	}
	
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getLastLoginDate() {
		return this.lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Ressource getRessource() {
		return this.ressource;
	}

	public void setRessource(Ressource ressource) {
		this.ressource = ressource;
	}
	
}