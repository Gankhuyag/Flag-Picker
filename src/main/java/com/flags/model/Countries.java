package com.flags.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mysql.cj.jdbc.Blob;

@Entity
public class Countries {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	public Long id;
	public String name;
	public String flag;
	
	 
	//@ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne   //(cascade = CascadeType.ALL)
    @JoinColumn(name="Continent", insertable = true, updatable = true)
	@JsonIgnore
	public Continent cont;

	public Continent getCont() {
		return cont;
	}

	public void setCont(Continent cont) {
		this.cont = cont;
	}

	// private Continent cont;
	/*
	 * public Continent getCont() { return cont; }
	 * 
	 * public void setCont(Continent cont) { this.cont = cont; }
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Countries(String name, String flag, Continent cont) {
		super();
		this.name = name;
		this.flag = flag;
		this.cont = cont;
	}

	public Countries() {
		super();
	}

}
