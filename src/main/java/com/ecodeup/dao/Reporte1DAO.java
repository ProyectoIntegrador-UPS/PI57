package com.ecodeup.dao;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.ecodeup.model.Reporte1;


@Stateless
public class Reporte1DAO {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TEST");
	
	private EntityManager em=entityManagerFactory.createEntityManager();
	public List<Reporte1> listarReporte1() {
		Query query=em.createNativeQuery("SELECT * FROM public.reporte1", Reporte1.class);
		List<Reporte1> lst=query.getResultList();
		return lst;
	}
}