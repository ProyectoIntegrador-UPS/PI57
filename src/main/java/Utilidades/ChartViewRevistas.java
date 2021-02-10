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

@ManagedBean(name="revistas")
@RequestScoped
public class ChartViewRevistas implements Serializable{
		
			
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
				barModel.setTitle("LAS REVISTAS CIENTÍFICAS CON MÁS PUBLICACIONES EN EL AÑO 2019");
				barModel.setLegendPosition("ne");
				barModel.setAnimate(true);
				Axis xAxis = barModel.getAxis(AxisType.X);
				xAxis.setLabel("AÑO");
				
				Axis yAxis = barModel.getAxis(AxisType.Y);
				yAxis.setLabel("REVISTAS CIENTÍFICAS");
				yAxis.setMin(0);
				yAxis.setMax(80);
			}
			
			
			private BarChartModel initBarModel() {
				BarChartModel model = new BarChartModel();
				
				ChartSeries aps = new ChartSeries();
				aps.setLabel("ACTA PHARMACOL SIN");
				aps.set("2019", 73);
				
				ChartSeries vir = new ChartSeries();
				vir.setLabel("EYE LOND");
				vir.set("2019", 43);
				
				ChartSeries sci = new ChartSeries();
				sci.setLabel("FRONT IMMUNOL");
				sci.set("2019", 33);
				
				ChartSeries spi = new ChartSeries();
				spi.setLabel("PLOS ONE");
				spi.set("2019", 34);
				
				ChartSeries plos = new ChartSeries();
				plos.setLabel("SCI REP");
				plos.set("2019", 43);
				
				ChartSeries fro = new ChartSeries();
				fro.setLabel("SPINAL CORD SER CASESS");
				fro.set("2019", 57);
				
				ChartSeries eye = new ChartSeries();
				eye.setLabel("VIRUSSES");
				eye.set("2019", 53);
				
				model.addSeries(aps);
				model.addSeries(vir);
				model.addSeries(sci);
				model.addSeries(spi);
				model.addSeries(plos);
				model.addSeries(fro);
				model.addSeries(eye);
				
				return model;
			}
}

