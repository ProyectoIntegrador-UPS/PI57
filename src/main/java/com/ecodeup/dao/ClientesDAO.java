package com.ecodeup.dao;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ecodeup.model.Cliente;
import com.ecodeup.model.JPAUtil;


@Stateless
public class ClientesDAO {
	//@PersistenceContext
	//EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JSF_JPA_CRUD");
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	
	public List<Cliente> listarTodos() {
		List<Cliente> listaClientes = new ArrayList<>();
		Query q = entity.createQuery("SELECT c FROM Cliente c");
		listaClientes = q.getResultList();
		return listaClientes;
	}
	
	public List<Cliente> obtenerClientes() {
		List<Cliente> listaClientes = new ArrayList<>();
		Query q = entity.createQuery("SELECT c FROM Cliente c");
		listaClientes = q.getResultList();
		return listaClientes;
	}
	
}
