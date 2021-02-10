package com.ecodeup.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ecodeup.model.Reporte10;


@Stateless
public class Reporte10DAO {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JSF_JPA_CRUD");
	
	private EntityManager em=entityManagerFactory.createEntityManager();
	public List<Reporte10> listarReporte10() {
		Query query=em.createNativeQuery("SELECT * FROM public.reporte10", Reporte10.class);
		List<Reporte10> lst=query.getResultList();
		return lst;
	}
}