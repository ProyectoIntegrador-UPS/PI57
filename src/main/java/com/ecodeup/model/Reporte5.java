package com.ecodeup.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reporte5")
public class Reporte5 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column
	private int TotalPublicaciones;
	@Id
	@Column
	private String RevistaCientifica;
	
	public int getTotalPublicaciones() {
		return TotalPublicaciones;
	}
	public void setTotalPublicaciones(int totalPublicacioness) {
		TotalPublicaciones = totalPublicacioness;
	}
	public String getRevistaCientifica() {
		return RevistaCientifica;
	}
	public void setRevistaCientifica(String revistaCientifica) {
		RevistaCientifica = revistaCientifica;
	}
	
}