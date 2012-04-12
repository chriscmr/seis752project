package com.seis.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TYPE database table.
 * 
 */
@Entity
public class Type implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="TYPE_ID_GENERATOR", sequenceName="S_TYPE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RESSOURCE_ID_GENERATOR")
	private long id;

	private String type;

	//bi-directional many-to-one association to Ressource
    @ManyToOne
	@JoinColumn(name="ID1")
	private Ressource ressource;

    public Type() {
    }

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Ressource getRessource() {
		return this.ressource;
	}

	public void setRessource(Ressource ressource) {
		this.ressource = ressource;
	}
	
}