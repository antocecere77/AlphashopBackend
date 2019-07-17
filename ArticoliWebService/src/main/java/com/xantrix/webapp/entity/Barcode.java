package com.xantrix.webapp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "ARTICOLI")
@Data
public class Barcode implements Serializable {

	private static final long serialVersionUID = -6866882625632614640L;
	
	@Id
	@Column(name= "BARCODE")
	private String barcode;
	
	@Column(name = "IDTIPOART")
	private String idTipoArt;
	
	@ManyToOne
	@EqualsAndHashCode.Exclude
	@JoinColumn(name = "CODART", referencedColumnName = "codArt")
	@JsonBackReference
	private Articoli articolo;
	
}
