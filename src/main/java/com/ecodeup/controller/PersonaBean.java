package com.ecodeup.controller;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.bean.RequestScoped;
import com.ecodeup.model.Persona;

@ManagedBean(name="persona")
@RequestScoped
public class PersonaBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String apellido;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String registrar() {
		Persona nuevaPersona = new Persona();
		nuevaPersona.setNombre(nombre);
		nuevaPersona.setApellido(apellido);
		return "registrado";
	}
	public String toString(){
		return ("Bienvenid@ " + nombre + " " + apellido);
	}
}