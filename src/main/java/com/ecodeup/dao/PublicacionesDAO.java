package com.ecodeup.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ecodeup.model.Publicaciones;


@Stateless
public class PublicacionesDAO {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JSF_JPA_CRUD");
	
	private EntityManager em=entityManagerFactory.createEntityManager();
	public List<Publicaciones> listarPublicaciones() {
		Query query=em.createNativeQuery("SELECT * FROM public.publicaciones", Publicaciones.class);
		List<Publicaciones> lst=query.getResultList();
		return lst;
	}
}