package com.ecodeup.controller;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import com.ecodeup.dao.*;
import com.ecodeup.model.*;

@ManagedBean(name = "auditoriaBean")
@RequestScoped
public class AuditoriaBean {
	

	
	public List<Auditoria> obtenerAuditoria() {
		AuditoriaDAO auditoriaDAO = new AuditoriaDAO();
		return auditoriaDAO.obtenerAuditoria();
	}

}
