package com.ecodeup.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ecodeup.model.Reporte5;


@Stateless
public class Reporte5DAO {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JSF_JPA_CRUD");
	
	private EntityManager em=entityManagerFactory.createEntityManager();
	public List<Reporte5> listarReporte5() {
		Query query=em.createNativeQuery("SELECT * FROM public.reporte5", Reporte5.class);
		List<Reporte5> lst=query.getResultList();
		return lst;
	}
}