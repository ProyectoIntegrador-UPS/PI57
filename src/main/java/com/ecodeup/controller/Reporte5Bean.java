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

import com.ecodeup.dao.Reporte5DAO;
import com.ecodeup.model.Reporte5;
import java.io.Serializable;

@ManagedBean(name =  "reporte5Bean")
@RequestScoped
public class Reporte5Bean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private Reporte5DAO reporte5DAO;
	
	private List<Reporte5> listado;
	
	private BarChartModel barra;
	
	public void listar() {
		listado=reporte5DAO.listarReporte5();
		graficar();
	}
	
	public void graficar() {
	barra = new BarChartModel();
	ChartSeries serie=new BarChartSeries();
	serie.setLabel("Publicaciones");
	for (int i = 0; i < reporte5DAO.listarReporte5().size(); i++) {
		//ChartSeries serie=new BarChartSeries();
		
		//serie.setLabel(personaDAO.obtenerTodas().get(i).getNombrePersona());
		serie.set(reporte5DAO.listarReporte5().get(i).getRevistaCientifica(), reporte5DAO.listarReporte5().get(i).getTotalPublicaciones());
		//barra.addSeries(serie);
	}
	barra.setTitle("MAYOR NUMERO DE PUBLICACIONES DE REVISTAS CIENTIFICAS REALIZADAS EN LA DECADA DE 1990 a 2000");
	barra.addSeries(serie);
	barra.setLegendPosition("ne");
	//barra.setAnimate(true);
	
	Axis xAxis=barra.getAxis(AxisType.X);
		xAxis.setLabel("Revista Cientifica");
		Axis yAxis=barra.getAxis(AxisType.Y);
		yAxis.setLabel("N�mero de publicaciones por a�o");
		yAxis.setMin(0);
		yAxis.setMax(25);
}
	public List<Reporte5> getListado() {
		return listado;
	}

	public void setListado(List<Reporte5> listado) {
		this.listado = listado;
	}

	public BarChartModel getBarra() {
		return barra;
	}

	public void setBarra(BarChartModel barra) {
		this.barra = barra;
	}
}