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

import com.ecodeup.dao.Reporte1DAO;
import com.ecodeup.model.Reporte1;
import java.io.Serializable;

@ManagedBean(name = "reporte1Bean")
@RequestScoped
public class Reporte1Bean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private Reporte1DAO reporte1DAO;
	
	private List<Reporte1> listado;
	
	private BarChartModel barra;
	
	public void listar() {
		listado=reporte1DAO.listarReporte1();
		graficar();
	}
	
	public void graficar() {
		barra = new BarChartModel();
		for (int i = 0; i < reporte1DAO.listarReporte1().size(); i++) {
			ChartSeries serie=new BarChartSeries();
			
			serie.setLabel(reporte1DAO.listarReporte1().get(i).getNombre_fuente());
			serie.set(reporte1DAO.listarReporte1().get(i).getNombre_fuente(), reporte1DAO.listarReporte1().get(i).getCantidad());
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
	}

	public List<Reporte1> getListado() {
		return listado;
	}

	public void setListado(List<Reporte1> listado) {
		this.listado = listado;
	}

	public BarChartModel getBarra() {
		return barra;
	}

	public void setBarra(BarChartModel barra) {
		this.barra = barra;
	}
}