package com.ecodeup.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="reportePublico")
public class ReportePublico implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column
	private int cantidad_publicaciones;
	@Id
	@Column
	private String nombre_autor;
	public int getCantidad_publicaciones() {
		return cantidad_publicaciones;
	}
	public void setCantidad_publicaciones(int cantidad_publicaciones) {
		this.cantidad_publicaciones = cantidad_publicaciones;
	}
	public String getNombre_autor() {
		return nombre_autor;
	}
	public void setNombre_autor(String nombre_autor) {
		this.nombre_autor = nombre_autor;
	}
}