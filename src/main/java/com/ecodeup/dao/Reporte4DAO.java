package com.ecodeup.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ecodeup.model.Reporte4;

@Stateless
public class Reporte4DAO {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JSF_JPA_CRUD");
	
	private EntityManager em=entityManagerFactory.createEntityManager();
	public List<Reporte4> listarReporte4(){
		Query query=em.createNativeQuery("SELECT * FROM public.reporte4", Reporte4.class);
		List<Reporte4> lst=query.getResultList();
		return lst;
	}
}