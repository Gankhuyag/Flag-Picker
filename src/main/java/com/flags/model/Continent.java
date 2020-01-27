package com.flags.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

 
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Continent {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Continent_id")
	@JsonIgnore
	private Long continentId;
	public String continent;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "cont")
    public List<Countries> countries=new ArrayList<Countries>();
//	public String getName() {
//		return continent;
//	}
	//@OneToMany(cascade = CascadeType.ALL)
		//@Fetch(FetchMode.JOIN)
	    //public List<Countries> countries;

	public Long getContinentId() {
		return continentId;
	}

	public void setContinentId(Long continentId) {
		this.continentId = continentId;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public List<Countries> getCountries() {
		return countries;
	}

	public void setCountries(List<Countries> countries) {
		this.countries = countries;
	}

	public Continent(Long continentId, String continent, List<Countries> countries) {
		super();
		this.continentId = continentId;
		this.continent = continent;
		this.countries = countries;
	}

	public Continent() {
		super();
	}

	public Continent(String continent, List<Countries> countries) {
		super();
		this.continent = continent;
		this.countries = countries;
	}

	public Continent(Long continentId) {
		super();
		this.continentId = continentId;
	}
	 	 
}
