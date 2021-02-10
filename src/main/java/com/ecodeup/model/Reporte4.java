package com.ecodeup.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="reporte4")
public class Reporte4 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column
	private int numero_de_publicaciones;
	@Id
	@Column
	private String nombre_del_autor;
	public int getNumero_de_publicaciones() {
		return numero_de_publicaciones;
	}
	public void setNumero_de_publicaciones(int numero_de_publicaciones) {
		this.numero_de_publicaciones = numero_de_publicaciones;
	}
	public String getNombre_del_autor() {
		return nombre_del_autor;
	}
	public void setNombre_del_autor(String nombre_del_autor) {
		this.nombre_del_autor = nombre_del_autor;
	}
}