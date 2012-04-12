package com.seis.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SUBJECT database table.
 * 
 */
@Entity
public class Subject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SUBJECT_ID_GENERATOR", sequenceName="S_SUBJECT")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SUBJECT_ID_GENERATOR")
	private long id;

	private String name;

	//bi-directional many-to-many association to Ressource
    @ManyToMany
	@JoinTable(
		name="RELATES"
		, joinColumns={
			@JoinColumn(name="SUBJECT_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="RESSOURCE_ID")
			}
		)
	private List<Ressource> ressources;

    public Subject() {
    }

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Ressource> getRessources() {
		return this.ressources;
	}

	public void setRessources(List<Ressource> ressources) {
		this.ressources = ressources;
	}
	
}