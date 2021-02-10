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

import com.ecodeup.dao.Reporte2DAO;
import com.ecodeup.model.Reporte2;
import java.io.Serializable;

@ManagedBean(name = "reporte2Bean")
@RequestScoped
public class Reporte2Bean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private Reporte2DAO reporte2DAO;
	
	private List<Reporte2> listado;
	
	private BarChartModel barra;
	
	public void listar() {
		listado=reporte2DAO.listarReporte2();
		graficar();
	}

	public void graficar() {
	barra = new BarChartModel();
	ChartSeries serie=new BarChartSeries();
	serie.setLabel("Reporte2");
	for (int i = 0; i < reporte2DAO.listarReporte2().size(); i++) {
		//ChartSeries serie=new BarChartSeries();
		
		//serie.setLabel(reporte2DAO.listarReporte2().get(i).getIdentificador());
		serie.set(reporte2DAO.listarReporte2().get(i).getIdentificador(), reporte2DAO.listarReporte2().get(i).getTotal_articulos());
		//barra.addSeries(serie);
	}
	barra.addSeries(serie);
	barra.setTitle("CANTIDAD DE ARTICULOS CON CADA IDENTIFICADOR");
	barra.setLegendPosition("ne");
	//barra.setAnimate(true);
	
	Axis xAxis=barra.getAxis(AxisType.X);
		xAxis.setLabel("Tipo de Identificador");
		Axis yAxis=barra.getAxis(AxisType.Y);
		yAxis.setLabel("Cantidad de Articulos");
		yAxis.setMin(0);
		yAxis.setMax(50000);
}
	
	
	
	
	
	
	
	
	
	
	

	public List<Reporte2> getListado() {
		return listado;
	}

	public void setListado(List<Reporte2> listado) {
		this.listado = listado;
	}

	public BarChartModel getBarra() {
		return barra;
	}

	public void setBarra(BarChartModel barra) {
		this.barra = barra;
	}
}