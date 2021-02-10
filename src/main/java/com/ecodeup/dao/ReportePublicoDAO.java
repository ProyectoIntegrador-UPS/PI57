package com.ecodeup.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ecodeup.model.ReportePublico;

@Stateless
public class ReportePublicoDAO {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JSF_JPA_CRUD");
	
	private EntityManager em=entityManagerFactory.createEntityManager();
	public List<ReportePublico> listarReportePublico() {
		Query query=em.createNativeQuery("SELECT * FROM public.reporte_publico", ReportePublico.class);
		List<ReportePublico> lst=query.getResultList();
		return lst;
	}
}