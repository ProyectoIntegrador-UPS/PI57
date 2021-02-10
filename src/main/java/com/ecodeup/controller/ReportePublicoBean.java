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

import com.ecodeup.dao.ReportePublicoDAO;
import com.ecodeup.model.ReportePublico;
import java.io.Serializable;

@ManagedBean(name ="reportePublicoBean")
@RequestScoped
public class ReportePublicoBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ReportePublicoDAO reportePublicoDAO;
	
	private List<ReportePublico> listado;
	
	private BarChartModel barra;
	
	public void listar() {
		listado=reportePublicoDAO.listarReportePublico();
		graficar();
	}

	public void graficar() {
		barra = new BarChartModel();
		for (int i = 0; i < reportePublicoDAO.listarReportePublico().size(); i++) {
			ChartSeries serie=new BarChartSeries();
			
			serie.setLabel(reportePublicoDAO.listarReportePublico().get(i).getNombre_autor());
			serie.set(reportePublicoDAO.listarReportePublico().get(i).getNombre_autor(), reportePublicoDAO.listarReportePublico().get(i).getCantidad_publicaciones());
			barra.addSeries(serie);
		}
		barra.setTitle("AUTORES QUE MAS PUBLICACIONES HAN REALIZADO - A�O 2020");
		barra.setLegendPosition("ne");
		barra.setAnimate(true);
		
		Axis xAxis=barra.getAxis(AxisType.X);
			xAxis.setLabel("Nombre del Autor");
			Axis yAxis=barra.getAxis(AxisType.Y);
			yAxis.setLabel("Cantidad de Publicaciones");
			yAxis.setMin(0);
			yAxis.setMax(12);
	}



	public List<ReportePublico> getListado() {
		return listado;
	}

	public void setListado(List<ReportePublico> listado) {
		this.listado = listado;
	}

	public BarChartModel getBarra() {
		return barra;
	}

	public void setBarra(BarChartModel barra) {
		this.barra = barra;
	}
}