package com.ecodeup.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ecodeup.model.Reporte6;


@Stateless
public class Reporte6DAO {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JSF_JPA_CRUD");
	
	private EntityManager em=entityManagerFactory.createEntityManager();
	public List<Reporte6> listarReporte6() {
		Query query=em.createNativeQuery("SELECT * FROM public.reporte6", Reporte6.class);
		List<Reporte6> lst=query.getResultList();
		return lst;
	}
}