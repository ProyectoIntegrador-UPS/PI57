package com.ecodeup.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reporte1")
public class Reporte1 implements Serializable{
	private static final long serialVersionUID = 1L;
	@Column
	private int cantidad;
	@Id
	@Column
	private String nombre_fuente;
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getNombre_fuente() {
		return nombre_fuente;
	}
	public void setNombre_fuente(String nombre_fuente) {
		this.nombre_fuente = nombre_fuente;
	}
}