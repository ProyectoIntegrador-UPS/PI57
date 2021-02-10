package com.ecodeup.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reporte10")
public class Reporte10 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column
	private int NumeroPublicaciones;
	@Id
	@Column
	private String Publicaciones;
	
	public int getNumeroPublicaciones() {
		return NumeroPublicaciones;
	}
	public void setNumeroPublicaciones(int numeroPublicaciones) {
		NumeroPublicaciones = numeroPublicaciones;
	}
	public String getPublicaciones() {
		return Publicaciones;
	}
	public void setPublicaciones(String publicaciones) {
		Publicaciones = publicaciones;
	}
	
	
}