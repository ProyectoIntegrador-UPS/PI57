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
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.ChartSeries;

import com.ecodeup.dao.Reporte6DAO;
import com.ecodeup.model.Reporte6;
import com.sun.jdi.event.Event;

import java.io.Serializable;
import org.primefaces.model.chart.PieChartModel;


@ManagedBean(name =  "reporte6Bean")
@RequestScoped
public class Reporte6Bean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private Reporte6DAO reporte6DAO;
	
	private List<Reporte6> listado;
	
	private PieChartModel torta;
	
	public void listar() {
		listado=reporte6DAO.listarReporte6();
		graficar();
	}
/*	
	public void graficar() {
		barra = new BarChartModel();
		for (int i = 0; i < reporte2DAO.listarReporte2().size(); i++) {
			ChartSeries serie=new BarChartSeries();
			
			serie.setLabel(reporte2DAO.listarReporte2().get(i).getIdentificador());
			serie.set(reporte2DAO.listarReporte2().get(i).getIdentificador(), reporte2DAO.listarReporte2().get(i).getTotal_articulos());
			barra.addSeries(serie);
		}
		barra.setTitle("CANTIDAD DE ARTICULOS CON CADA IDENTIFICADOR");
		barra.setLegendPosition("ne");
		barra.setAnimate(true);
		
		Axis xAxis=barra.getAxis(AxisType.X);
		xAxis.setLabel("Tipo de Identificador");
		Axis yAxis=barra.getAxis(AxisType.Y);
		yAxis.setLabel("Cantidad de Articulos");
		yAxis.setMin(0);
		yAxis.setMax(90000);
	}
*/	
	
	
	
	public void graficar() {
	torta = new PieChartModel();

/*
	ChartSeries serie=new BarChartSeries();
	serie.setLabel("Reporte6");
	for (int i = 0; i < reporte6DAO.listarReporte6().size(); i++) {
		//ChartSeries serie=new BarChartSeries();
		
		//serie.setLabel(reporte2DAO.listarReporte2().get(i).getIdentificador());
		serie.set(reporte6DAO.listarReporte6().get(i).getNombre_de_las_publicaciones(), reporte6DAO.listarReporte6().get(i).getNumero_de_autores());
		//barra.addSeries(serie);
	}
 */
	for(Reporte6 evn: reporte6DAO.listarReporte6()) {
		torta.set(evn.getNombre_de_las_publicaciones(),evn.getNumero_de_autores());
		
	}
	
/*		
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
*/

	torta.setTitle("Porcentaje de Autores");
	torta.setLegendPosition("c");
	torta.setFill(true);
	torta.setShowDataLabels(true);
	torta.setDiameter(400);
	torta.getSliceMargin();
	

	
	
}
	
	
	
	

	

	public List<Reporte6> getListado() {
		return listado;
	}

	public void setListado(List<Reporte6> listado) {
		this.listado = listado;
	}

	public PieChartModel getTorta() {
		return torta;
	}

	public void setTorta(PieChartModel torta) {
		this.torta = torta;
	}
}