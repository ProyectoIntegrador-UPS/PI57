package com.ecodeup.controller;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.ChartSeries;

import com.ecodeup.dao.Reporte10DAO;
import com.ecodeup.model.Reporte10;

import java.io.Serializable;

@ManagedBean(name ="reporte10Bean")
@RequestScoped
public class Reporte10Bean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private Reporte10DAO reporte10DAO;
	
	private List<Reporte10> listado;
	
	private BarChartModel barra;
	
	public void listar() {
		listado=reporte10DAO.listarReporte10();
		graficar();
	}
	

	
	public void graficar() {
	barra = new BarChartModel();
	ChartSeries serie=new BarChartSeries();
	serie.setLabel("Publicaciones");
	for (int i = 0; i < reporte10DAO.listarReporte10().size(); i++) {
		//ChartSeries serie=new BarChartSeries();
		
		//serie.setLabel(personaDAO.obtenerTodas().get(i).getNombrePersona());
		serie.set(reporte10DAO.listarReporte10().get(i).getPublicaciones(), reporte10DAO.listarReporte10().get(i).getNumeroPublicaciones());
		//barra.addSeries(serie);
	}
	barra.setTitle("Publicaciones cient�ficas realizadas por cada Fuente de Datos");
	barra.addSeries(serie);
	barra.setLegendPosition("ne");
	//barra.setAnimate(true);
	
	Axis xAxis=barra.getAxis(AxisType.X);
		xAxis.setLabel("Fuentes de Datos");
		Axis yAxis=barra.getAxis(AxisType.Y);
		yAxis.setLabel("N�mero de publicaciones");
		yAxis.setMin(0);
		yAxis.setMax(50000);
}
	public List<Reporte10> getListado() {
		return listado;
	}

	public void setListado(List<Reporte10> listado) {
		this.listado = listado;
	}

	public BarChartModel getBarra() {
		return barra;
	}

	public void setBarra(BarChartModel barra) {
		this.barra = barra;
	}
}