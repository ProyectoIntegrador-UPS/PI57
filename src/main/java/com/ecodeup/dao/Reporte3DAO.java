package com.ecodeup.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ecodeup.model.Reporte3;


@Stateless
public class Reporte3DAO {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JSF_JPA_CRUD");
	
	private EntityManager em=entityManagerFactory.createEntityManager();
	public List<Reporte3> listarReporte3(){
		Query query=em.createNativeQuery("SELECT * FROM public.reporte3", Reporte3.class);
		List<Reporte3> lst=query.getResultList();
		return lst;
	}
}