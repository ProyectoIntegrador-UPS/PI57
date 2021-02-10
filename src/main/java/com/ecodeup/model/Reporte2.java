package com.ecodeup.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="reporte2")
public class Reporte2 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column
	private int total_articulos;
	@Id
	@Column
	private String identificador;
	public int getTotal_articulos() {
		return total_articulos;
	}
	public void setTotal_articulos(int total_articulos) {
		this.total_articulos = total_articulos;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
}