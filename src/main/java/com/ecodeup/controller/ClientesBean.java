package com.ecodeup.controller;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ecodeup.dao.ClientesDAO;
import com.ecodeup.model.Cliente;


import javax.persistence.Query;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.ChartSeries;

@Named(value = "clientesBean")
@ViewScoped
public class ClientesBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private ClientesDAO clienteDAO;
	
	private List<Cliente> listado;
	
	private BarChartModel barra;
	
	public void listar() {
		listado=clienteDAO.listarTodos();
		graficar();
	}
	
	public void graficar() {
		barra = new BarChartModel();
		for (int i = 0; i < clienteDAO.listarTodos().size(); i++) {
			ChartSeries serie=new BarChartSeries();
			
			serie.setLabel(clienteDAO.listarTodos().get(i).getNombres());
			serie.set(clienteDAO.listarTodos().get(i).getNombres(), clienteDAO.listarTodos().get(i).getId());
			barra.addSeries(serie);
		}
		barra.setTitle("Usuarios");
		barra.setLegendPosition("ne");
		barra.setAnimate(true);
		
		Axis xAxis=barra.getAxis(AxisType.X);
		xAxis.setLabel("Usuarios");
		Axis yAxis=barra.getAxis(AxisType.Y);
		yAxis.setLabel("Cantidad");
		yAxis.setMin(0);
		yAxis.setMax(50);
	}

	public List<Cliente> getListado() {
		return listado;
	}

	public void setListado(List<Cliente> listado) {
		this.listado = listado;
	}

	public BarChartModel getBarra() {
		return barra;
	}

	public void setBarra(BarChartModel barra) {
		this.barra = barra;
	}
	
	/*public static void main(String[] args) {
		ListadoVictimas();
	}*/
}