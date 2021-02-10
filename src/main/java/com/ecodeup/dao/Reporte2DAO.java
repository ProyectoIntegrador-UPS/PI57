package com.ecodeup.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ecodeup.model.Reporte2;


@Stateless
public class Reporte2DAO {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JSF_JPA_CRUD");
	
	private EntityManager em=entityManagerFactory.createEntityManager();
	public List<Reporte2> listarReporte2() {
		Query query=em.createNativeQuery("SELECT * FROM public.reporte2", Reporte2.class);
		List<Reporte2> lst=query.getResultList();
		return lst;
	}
}