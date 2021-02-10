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

import com.ecodeup.dao.Reporte4DAO;
import com.ecodeup.model.Reporte4;
import java.io.Serializable;

@ManagedBean(name = "reporte4Bean")
@RequestScoped
public class Reporte4Bean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private Reporte4DAO reporte4DAO;
	
	private List<Reporte4> listado;
	
	private BarChartModel barra;
	
	public void listar() {
		listado=reporte4DAO.listarReporte4();
		graficar();
	}

	public void graficar() {
		barra = new BarChartModel();
		for (int i = 0; i < reporte4DAO.listarReporte4().size(); i++) {
			ChartSeries serie=new BarChartSeries();
			
			serie.setLabel(reporte4DAO.listarReporte4().get(i).getNombre_del_autor());
			serie.set(reporte4DAO.listarReporte4().get(i).getNombre_del_autor(), reporte4DAO.listarReporte4().get(i).getNumero_de_publicaciones());
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
		yAxis.setMax(70);
	}


	public List<Reporte4> getListado() {
		return listado;
	}

	public void setListado(List<Reporte4> listado) {
		this.listado = listado;
	}

	public BarChartModel getBarra() {
		return barra;
	}

	public void setBarra(BarChartModel barra) {
		this.barra = barra;
	}
}