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

@ManagedBean(name="publicaciones")
@RequestScoped
public class ChartViewPublicaciones implements Serializable{
		
			
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
				barModel.setTitle("LOS PERIODOS DE TIEMPO EN LOS CUALES SE HAN REALIZADO MÁS PUBLICACIONES -DÉCADA 90");
				barModel.setLegendPosition("c");
				barModel.setAnimate(true);
				
				Axis xAxis = barModel.getAxis(AxisType.X);
				xAxis.setLabel("AÑO");
				
				Axis yAxis = barModel.getAxis(AxisType.Y);
				yAxis.setLabel("PUBLICACIONES");
				yAxis.setMin(0);
				yAxis.setMax(20);
			}
			
			
			private BarChartModel initBarModel() {
				BarChartModel model = new BarChartModel();
				
				ChartSeries aps = new ChartSeries();
				aps.setLabel("ARCH VIROL");
				aps.set("1990-2000", 7);
				
				ChartSeries vir = new ChartSeries();
				vir.setLabel("ARCH VIROL");
				vir.set("1990-2000", 9);
				
				ChartSeries sci = new ChartSeries();
				sci.setLabel("ARCH VIROL");
				sci.set("1990-2000", 7);
				
				ChartSeries spi = new ChartSeries();
				spi.setLabel("ARCH VIROL");
				spi.set("1990-2000", 11);
				
				ChartSeries plos = new ChartSeries();
				plos.setLabel("ARCH VIROL");
				plos.set("1990-2000", 9);
				
				ChartSeries fro = new ChartSeries();
				fro.setLabel("ARCH VIROL");
				fro.set("1990-2000", 4);
				
				ChartSeries eye = new ChartSeries();
				eye.setLabel("BONE MARROW TRANSPLANT");
				eye.set("1990-2000", 4);
				
				ChartSeries inte = new ChartSeries();
				inte.setLabel("INTENSIVE CARE MED");
				inte.set("1990-2000", 5);
				
				ChartSeries intc = new ChartSeries();
				intc.setLabel("INTENSIVE CARE MED");
				intc.set("1990-2000", 6);
				
				ChartSeries intq = new ChartSeries();
				intq.setLabel("INTENSIVE CARE MED");
				intq.set("1990-2000", 5);
				
				model.addSeries(aps);
				model.addSeries(vir);
				model.addSeries(sci);
				model.addSeries(spi);
				model.addSeries(plos);
				model.addSeries(fro);
				model.addSeries(eye);
				model.addSeries(inte);
				model.addSeries(intc);
				model.addSeries(intq);
				
				return model;
			}
}

