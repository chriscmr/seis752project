package com.seis.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the GRADE database table.
 * 
 */
@Entity
public class Grade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GRADE_ID_GENERATOR", sequenceName="S_GRADE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GRADE_ID_GENERATOR")
	private long id;

	private String grade;

	//bi-directional many-to-many association to Ressource
    @ManyToMany
	@JoinTable(
		name="APPLIES"
		, joinColumns={
			@JoinColumn(name="GRADE_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="RESSOURCE_ID")
			}
		)
	private List<Ressource> ressources;

    public Grade() {
    }

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public List<Ressource> getRessources() {
		return this.ressources;
	}

	public void setRessources(List<Ressource> ressources) {
		this.ressources = ressources;
	}
	
}