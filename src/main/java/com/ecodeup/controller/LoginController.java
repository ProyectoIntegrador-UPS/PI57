package com.ecodeup.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecodeup.dao.ClienteDAO;
import com.ecodeup.model.Cliente;



/**
 * @email Ramesh Fadatare
 */

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteDAO loginDao;

	public void init() {
		loginDao = new ClienteDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			authenticate(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void authenticate(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int respuesta=loginDao.validar(username, password);
		String estado=loginDao.bloqueo(username, password);
		//loginDao.validar2(username, password);

		if (respuesta==1) {
			System.out.println("EXITO");
			//ClienteDAO clie=new ClienteDAO();
			//List<Cliente> listaClientes = new ArrayList<>();
			//listaClientes=clie.obtenerActual(username);
			RequestDispatcher dispatcher = request.getRequestDispatcher("respuestaAdmin.jsf");
			dispatcher.forward(request, response);
		}	
		if (respuesta==2) {
			if (estado.equalsIgnoreCase("1")) {
				System.out.println("EXITO");
				//loginDao.validar2(username, password);
				//RequestDispatcher dispatcher = request.getRequestDispatcher("respuestaCliente.jsf");
				//dispatcher.forward(request, response);
				List<Cliente> listData =loginDao.obtenerActual(username, password);
			    request.setAttribute("listData", listData);
			    Long id=loginDao.obtenerID(username, password);
			    request.setAttribute("id", id);
			    RequestDispatcher dispatcher = request.getRequestDispatcher("respuestaCliente.jsf");
			    dispatcher.forward(request, response);
			}
			if (estado.equalsIgnoreCase("2")){
				RequestDispatcher dispatcher = request.getRequestDispatcher("bloqueado.jsf");
			    dispatcher.forward(request, response);
			}
			
			

		
		}else {
			System.out.println("FALLO");
			RequestDispatcher dispatcher = request.getRequestDispatcher("registro.jsf");
			dispatcher.forward(request, response);
			throw new Exception("Login not successful..");
		}
	}

}