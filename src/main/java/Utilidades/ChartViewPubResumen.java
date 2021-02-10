package Utilidades;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

@ManagedBean(name="pubres")
@RequestScoped
public class ChartViewPubResumen implements Serializable{
		
			
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
				barModel.setTitle("PUBLICACIONES CON RESUMEN");
				barModel.setLegendPosition("ne");
				barModel.setAnimate(true);
				Axis xAxis = barModel.getAxis(AxisType.X);
				xAxis.setLabel("");
				
				Axis yAxis = barModel.getAxis(AxisType.Y);
				yAxis.setLabel("RESUMEN");
				yAxis.setMin(0);
				yAxis.setMax(49980);
			}
			
			
			private BarChartModel initBarModel() {
				BarChartModel model = new BarChartModel();
				
				ChartSeries aps = new ChartSeries();
				aps.setLabel("CON RESUMEN ABSTRACT");
				aps.set("", 32971);
				
				ChartSeries vir = new ChartSeries();
				vir.setLabel("SIN RESUMEN ABSTRACT");
				vir.set("", 17009);
				
							
				model.addSeries(aps);
				model.addSeries(vir);
				return model;
			}
}

