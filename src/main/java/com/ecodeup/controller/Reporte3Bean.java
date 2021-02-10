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

import com.ecodeup.dao.Reporte3DAO;
import com.ecodeup.model.Reporte3;
import java.io.Serializable;

@ManagedBean(name ="reporte3Bean")
@RequestScoped
public class Reporte3Bean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private Reporte3DAO reporte3DAO;
	
	private List<Reporte3> listado;
	
	private BarChartModel barra;
	
	public void listar() {
		listado=reporte3DAO.listarReporte3();
		graficar();
	}

	public void graficar() {
		barra = new BarChartModel();
		for (int i = 0; i < reporte3DAO.listarReporte3().size(); i++) {
			ChartSeries serie=new BarChartSeries();
			
			serie.setLabel(reporte3DAO.listarReporte3().get(i).getRevista_cientifica());
			serie.set(reporte3DAO.listarReporte3().get(i).getRevista_cientifica(), reporte3DAO.listarReporte3().get(i).getTotal_publicaciones());
			barra.addSeries(serie);
		}
		barra.setTitle("REVISTAS CIENT�FICAS CON MAS PUBLICACIONES");
		barra.setLegendPosition("ne");
		barra.setAnimate(true);
		
		Axis xAxis=barra.getAxis(AxisType.X);
		xAxis.setLabel("Nombre de la Revista");
		Axis yAxis=barra.getAxis(AxisType.Y);
		yAxis.setLabel("Total de Publicaciones");
		yAxis.setMin(0);
		yAxis.setMax(80);
	}


	

	public List<Reporte3> getListado() {
		return listado;
	}

	public void setListado(List<Reporte3> listado) {
		this.listado = listado;
	}

	public BarChartModel getBarra() {
		return barra;
	}

	public void setBarra(BarChartModel barra) {
		this.barra = barra;
	}
}