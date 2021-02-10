package com.ecodeup.controller;

import java.util.Date;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.ecodeup.dao.ClienteDAO;
import com.ecodeup.model.Cliente;

@ManagedBean(name = "adminBean")
@RequestScoped
public class AdminBean {
	
	public String nuevo() {
		Cliente c= new Cliente();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente", c);
		return  "/registroAdmin.xhtml";
	}
	
	public String guardar (Cliente cliente) {
		//guarda la fecha de registro
		Date fechaActual= new Date();
		cliente.setFregistro(new java.sql.Date(fechaActual.getTime()));
		cliente.setTipo(1);
		ClienteDAO clienteDAO= new ClienteDAO();
		clienteDAO.guardar(cliente);
		return  "/respuestaAdmin.xhtml";
	}

}
