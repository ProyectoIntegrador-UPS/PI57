package com.ecodeup.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="reporte3")
public class Reporte3 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column
	private int total_publicaciones;
	@Id
	@Column
	private String revista_cientifica;
	public int getTotal_publicaciones() {
		return total_publicaciones;
	}
	public void setTotal_publicaciones(int total_publicaciones) {
		this.total_publicaciones = total_publicaciones;
	}
	public String getRevista_cientifica() {
		return revista_cientifica;
	}
	public void setRevista_cientifica(String revista_cientifica) {
		this.revista_cientifica = revista_cientifica;
	}
}