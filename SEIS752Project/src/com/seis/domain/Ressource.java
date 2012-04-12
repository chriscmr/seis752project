package com.seis.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the RESSOURCE database table.
 * 
 */
@Entity
public class Ressource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RESSOURCE_ID_GENERATOR", sequenceName="S_RESSOURCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RESSOURCE_ID_GENERATOR")
	private long id;

    @Temporal( TemporalType.DATE)
	@Column(name="DATE_CREATED")
	private Date dateCreated;

	private String description;

	private String icon;

	private String location;

	private String title;

	//bi-directional many-to-one association to Contributor
	@OneToMany(mappedBy="ressource")
	private List<Contributor> contributors;

	//bi-directional many-to-many association to Grade
	@ManyToMany(mappedBy="ressources")
	private List<Grade> grades;

	//bi-directional many-to-many association to Subject
	@ManyToMany(mappedBy="ressources")
	private List<Subject> subjects;

	//bi-directional many-to-one association to Type
	@OneToMany(mappedBy="ressource")
	private List<Type> types;

    public Ressource() {
    }

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Contributor> getContributors() {
		return this.contributors;
	}

	public void setContributors(List<Contributor> contributors) {
		this.contributors = contributors;
	}
	
	public List<Grade> getGrades() {
		return this.grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}
	
	public List<Subject> getSubjects() {
		return this.subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	public List<Type> getTypes() {
		return this.types;
	}

	public void setTypes(List<Type> types) {
		this.types = types;
	}
	
}