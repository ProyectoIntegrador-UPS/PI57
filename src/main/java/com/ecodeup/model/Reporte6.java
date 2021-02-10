package com.ecodeup.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="reporte6")
public class Reporte6 implements Serializable{
/**
 * The persistent class for the reporte6 database table.
 * 
 */
	private static final long serialVersionUID = 1L;
/*
	@Column
*/
	private int numero_de_autores;

	@Id
	/*
	@Column
	*/
	private String nombre_de_las_publicaciones;
	public int getNumero_de_autores() {
		return numero_de_autores;
	}
	public void setTotal_articulos(int numero_de_autores) {
		this.numero_de_autores = numero_de_autores;
	}
	public String getNombre_de_las_publicaciones() {
		return nombre_de_las_publicaciones;
	}
	public void setIdentificador(String nombre_de_las_publicaciones) {
		this.nombre_de_las_publicaciones = nombre_de_las_publicaciones;
	}
}
