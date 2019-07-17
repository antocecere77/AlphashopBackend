package com.xantrix.webapp.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class FamAssort {
	
	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "DESCRIZIONE")
	private String descrizione;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "famAssort")
	@JsonBackReference
	private Set<Articoli> articoli = new HashSet<>();
	
}

