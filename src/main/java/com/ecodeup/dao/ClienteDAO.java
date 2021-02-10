package com.ecodeup.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.*;
import com.ecodeup.model.*;
@Stateless
public class ClienteDAO {
	long valorID;
	EntityManager entity = JPAUtil2.getEntityManagerFactory().createEntityManager();
	List<Cliente> listaClientes = new ArrayList<>();
	private Session session;
	// guardar cliente
	public void guardar(Cliente cliente) {
		entity.getTransaction().begin();
		entity.persist(cliente);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
	}

	// editar cliente
	public void editar(Cliente cliente) {
		entity.getTransaction().begin();
		entity.merge(cliente);
		entity.getTransaction().commit();
		/// JPAUtil.shutdown();
	}

	// buscar cliente
	public Cliente buscar(Long id) {
		Cliente c = new Cliente();
		c = entity.find(Cliente.class, id);
		// JPAUtil.shutdown();
		return c;
	}
	
	public int validar(String login, String password)  {
		System.out.println("BANDERA");
		
		Cliente cliente=null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			entity.getTransaction().begin();
			cliente = (Cliente) session.createQuery("From Cliente C where C.login=:login").setParameter("login", login).uniqueResult();
			valorID=cliente.getId();
			//envioID(cliente.getId());
			System.out.println(cliente.getId());	
			if (cliente != null && cliente.getPassword().equals(password) && cliente.getTipo()==1) {
				System.out.println("Login exitoso");	
				
				return 1;
			}
			if (cliente != null && cliente.getPassword().equals(password) && cliente.getTipo()==2) {
				System.out.println("Login exitoso");	
				
				return 2;
			}
			entity.getTransaction().commit();
			
		} catch (Exception e) {
			if (entity.getTransaction() != null) {
				System.out.println("Login fallido");	
				entity.getTransaction().rollback();;
				
			}
			e.printStackTrace();
		}


		
		return 0;
		
	}
	
	public String bloqueo(String login, String password)  {
		System.out.println("BANDERA");
		
	
		Cliente cliente=null;
		Session session = HibernateUtil.getSessionFactory().openSession();
			//entity.getTransaction().begin();
			
			cliente = (Cliente) session.createQuery("From Cliente C where C.login=:login").setParameter("login", login).uniqueResult();
			//List<Cliente> listaClientes = new ArrayList<>();
			long id=cliente.getId();
			System.out.println(cliente.getId());
			Query q = entity.createNativeQuery("SELECT * FROM clientes WHERE id = ?1", Cliente.class);q.setParameter(1, id);
			listaClientes = q.getResultList();
			
			return cliente.getEstado();
	
	}
	
	public List<Cliente> obtenerActual(String login, String password)  {
		System.out.println("BANDERA");
		System.out.println(login);
	
		Cliente cliente=null;
		Session session = HibernateUtil.getSessionFactory().openSession();
			//entity.getTransaction().begin();
			
			cliente = (Cliente) session.createQuery("From Cliente C where C.login=:login").setParameter("login", login).uniqueResult();
			//List<Cliente> listaClientes = new ArrayList<>();
			long id=cliente.getId();
			System.out.println(cliente.getId());
			Query q = entity.createNativeQuery("SELECT * FROM clientes WHERE id = ?1", Cliente.class);q.setParameter(1, id);
			listaClientes = q.getResultList();
			
			return listaClientes;
	
	}
	public Long obtenerID(String login, String password)  {
		System.out.println("BANDERA");
		System.out.println(login);
	
		Cliente cliente=null;
		Session session = HibernateUtil.getSessionFactory().openSession();
			//entity.getTransaction().begin();
			
			cliente = (Cliente) session.createQuery("From Cliente C where C.login=:login").setParameter("login", login).uniqueResult();
			//List<Cliente> listaClientes = new ArrayList<>();
			long id=cliente.getId();
			
			
			return id;
	
	}

	public long envioID() {
		System.out.println("---->");
		System.out.println(valorID);
		return valorID;
	}
	

	

	

	/// eliminar cliente
	public void eliminar(Long id) {
		Cliente c = new Cliente();
		c = entity.find(Cliente.class, id);
		entity.getTransaction().begin();
		entity.remove(c);
		entity.getTransaction().commit();
	}

	// obtener todos los cliente
	public List<Cliente> obtenerClientes() {
		List<Cliente> listaClientes = new ArrayList<>();
		Query q = entity.createQuery("SELECT c FROM Cliente c");
		listaClientes = q.getResultList();
		return listaClientes;
	}


	public long getValorID() {
		return valorID;
	}

	public void setValorID(long valorID) {
		this.valorID = valorID;
	}
	
	


	

}
