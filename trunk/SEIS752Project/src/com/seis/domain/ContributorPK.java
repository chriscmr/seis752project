package com.seis.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CONTRIBUTOR database table.
 * 
 */
@Embeddable
public class ContributorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private long id;

	private long id1;

    public ContributorPK() {
    }
	public long getId() {
		return this.id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getId1() {
		return this.id1;
	}
	public void setId1(long id1) {
		this.id1 = id1;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ContributorPK)) {
			return false;
		}
		ContributorPK castOther = (ContributorPK)other;
		return 
			(this.id == castOther.id)
			&& (this.id1 == castOther.id1);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.id ^ (this.id >>> 32)));
		hash = hash * prime + ((int) (this.id1 ^ (this.id1 >>> 32)));
		
		return hash;
    }
}