package Utilidades;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import java.io.Serializable;

@ManagedBean(name="barChart")
@RequestScoped
public class ChartView implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BarChartModel barModel;
	
	
	//DIAGRAMA iDENTIFICADOR
	@PostConstruct
	public void init() {
		createBarModels();
	}

	public BarChartModel getBarModel() {
		return barModel;
	}

	public void setBarModel(BarChartModel barModel) {
		this.barModel = barModel;
	}
	
	private void createBarModels() {
		createBarModel();
	}	

	private void createBarModel(){
		barModel = initBarModel();
		barModel.setTitle("LA CANTIDAD DE ARTICULOS CON CADA IDENTIFICADOR");
		barModel.setLegendPosition("ne");
		barModel.setAnimate(true);
		Axis xAxis = barModel.getAxis(AxisType.X);
		xAxis.setLabel("");
		
		Axis yAxis = barModel.getAxis(AxisType.Y);
		yAxis.setLabel("Artículos");
		yAxis.setMin(0);
		yAxis.setMax(49980);
	}
	
	
	private BarChartModel initBarModel() {
		BarChartModel model = new BarChartModel();
		
		ChartSeries s2 = new ChartSeries();
		s2.setLabel("S2");
		s2.set("Identificador", 13268);
		
		ChartSeries pmc = new ChartSeries();
		pmc.setLabel("PMC");
		pmc.set("Identificador", 36712);
		
		ChartSeries pubmed = new ChartSeries();
		pubmed.setLabel("PUBMED");
		pubmed.set("Identificador", 27872);
		
		ChartSeries who = new ChartSeries();
		who.setLabel("WHO");
		who.set("Identificador", 9491);
		
		
		model.addSeries(s2);
		model.addSeries(pmc);
		model.addSeries(pubmed);
		model.addSeries(who);
		
		return model;
	}
}