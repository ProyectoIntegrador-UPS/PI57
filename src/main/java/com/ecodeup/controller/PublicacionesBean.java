package com.ecodeup.controller;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.ChartSeries;

import com.ecodeup.dao.PublicacionesDAO;
import com.ecodeup.model.Publicaciones;
import java.io.Serializable;

@Named(value = "publicaciones")
@ViewScoped
public class PublicacionesBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PublicacionesDAO publicacionesDAO;
	
	private List<Publicaciones> listado;
	
	private BarChartModel barra;
	
	public void listar() {
		listado=publicacionesDAO.listarPublicaciones();
		graficar();
	}
	
	/*public void graficar() {
		barra = new BarChartModel();
		for (int i = 0; i < reporte10DAO.listarReporte1().size(); i++) {
			ChartSeries serie=new BarChartSeries();
			
			serie.setLabel(reporte10DAO.listarReporte1().get(i).getPublicaciones());
			serie.set(reporte10DAO.listarReporte1().get(i).getPublicaciones(), reporte10DAO.listarReporte1().get(i).getNumeroPublicaciones());
			barra.addSeries(serie);
		}
		barra.setTitle("Publicaciones cient�ficas realizadas por cada Fuente de Datos");
		barra.setLegendPosition("ne");
		barra.setAnimate(true);
		
		Axis xAxis=barra.getAxis(AxisType.X);
		xAxis.setLabel("Fuentes de Datos");
		Axis yAxis=barra.getAxis(AxisType.Y);
		yAxis.setLabel("N�mero de publicaciones");
		yAxis.setMin(0);
		yAxis.setMax(50000);
	}*/
	
	public void graficar() {
	barra = new BarChartModel();
	ChartSeries serie=new BarChartSeries();
	serie.setLabel("Publicaciones");
	for (int i = 0; i < publicacionesDAO.listarPublicaciones().size(); i++) {
		//ChartSeries serie=new BarChartSeries();
		
		//serie.setLabel(personaDAO.obtenerTodas().get(i).getNombrePersona());
		serie.set(publicacionesDAO.listarPublicaciones().get(i).getPublicaciones(), publicacionesDAO.listarPublicaciones().get(i).getNumeroPublicaciones());
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
	public List<Publicaciones> getListado() {
		return listado;
	}

	public void setListado(List<Publicaciones> listado) {
		this.listado = listado;
	}

	public BarChartModel getBarra() {
		return barra;
	}

	public void setBarra(BarChartModel barra) {
		this.barra = barra;
	}
}