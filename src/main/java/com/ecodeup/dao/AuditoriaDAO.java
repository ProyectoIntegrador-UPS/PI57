package com.ecodeup.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.hibernate.Session;
import com.ecodeup.model.Auditoria;
import com.ecodeup.model.JPAUtil;


public class AuditoriaDAO{
	
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	private Session session;
	

	public List<Auditoria> obtenerAuditoria() {
		List<Auditoria> listaAuditoria = new ArrayList<>();
		Query q = entity.createNamedQuery("consulta");
		listaAuditoria  = q.getResultList();
		return listaAuditoria;
	}
	


}
