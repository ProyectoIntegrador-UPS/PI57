package com.ecodeup.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.ecodeup.dao.ClienteDAO;
import com.ecodeup.model.Cliente;
import org.primefaces.model.chart.*;
@ManagedBean(name = "clienteBean")
@RequestScoped
public class ClienteBean {
	
	public String nuevo() {
		Cliente c= new Cliente();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente", c);
		return  "/registro.xhtml";
	}
	
	public String guardar (Cliente cliente) {
		//guarda la fecha de registro
		Date fechaActual= new Date();
		cliente.setFregistro(new java.sql.Date(fechaActual.getTime()));
		cliente.setTipo(2);
		cliente.setEstado("1");
		ClienteDAO clienteDAO= new ClienteDAO();
		clienteDAO.guardar(cliente);
		return  "/index.xhtml";
	}
	
	public String guardarAdm (Cliente cliente) {
		//guarda la fecha de registro
		Date fechaActual= new Date();
		cliente.setFregistro(new java.sql.Date(fechaActual.getTime()));
		cliente.setTipo(1);
		cliente.setEstado("1");
		ClienteDAO clienteDAO= new ClienteDAO();
		clienteDAO.guardar(cliente);
		return  "/index.xhtml";
	}

	public List<Cliente> obtenerClientes() {
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.obtenerClientes();
	}


	public String editar(Long id) {
		System.out.println(id);
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente c = new Cliente();
		c = clienteDAO.buscar(id);
		System.out.println("******************************************");
		System.out.println(c);

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente", c);
		return "/editar.xhtml";
	}
	
	
	public String editar2(String nombre) {
		System.out.println(nombre);
		return "/index.xhtml";
	}
	
	
	
	
	

	public String actualizar(Cliente cliente) {
		//guarda la fecha de actualizacion
		Date fechaActual= new Date();
		cliente.setFactualizar(new java.sql.Date(fechaActual.getTime()));
		
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.editar(cliente);
		return "/respuestaAdmin.xhtml";
	}

	// eliminar un cliente
	public String eliminar(Long id) {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.eliminar(id);
		System.out.println("Cliente eliminado..");
		return "/respuestaAdmin.xhtml";
	}
	

	

}
