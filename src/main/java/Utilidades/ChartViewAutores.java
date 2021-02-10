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

@ManagedBean(name="autores")
@RequestScoped
public class ChartViewAutores implements Serializable{
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
		barModel.setTitle("LOS AUTORES QUE MAS PUBLICACIONES HAN REALIZADO\r\n"
				+ "DE 1922 AL 2020");
		barModel.setLegendPosition("ne");
		barModel.setAnimate(true);
		Axis xAxis = barModel.getAxis(AxisType.X);
		xAxis.setLabel("AÑO");
		
		Axis yAxis = barModel.getAxis(AxisType.Y);
		yAxis.setLabel("PUBLICACIONES");
		yAxis.setMin(0);
		yAxis.setMax(60);
	}
	
	
	private BarChartModel initBarModel() {
		BarChartModel model = new BarChartModel();
		
		ChartSeries sr = new ChartSeries();
		sr.setLabel("SLARSEN, REINHARD");
		sr.set("2020", 60);
		
		ChartSeries ta = new ChartSeries();
		ta.setLabel("TORRES, ANTONI");
		ta.set("2020", 26);
		
		ChartSeries xz = new ChartSeries();
		xz.setLabel("XU, ZHONGLIN");
		xz.set("2020", 24);
		
		ChartSeries ms = new ChartSeries();
		ms.setLabel("MODROW, SUSANNE");
		ms.set("2020", 21);
		
		ChartSeries ww = new ChartSeries();
		ww.setLabel("WANG, WEI");
		ww.set("2020", 21);
		
		ChartSeries tu = new ChartSeries();
		tu.setLabel("TRUYEN, UWE");
		tu.set("2020", 21);
		
		model.addSeries(sr);
		model.addSeries(ta);
		model.addSeries(xz);
		model.addSeries(ms);
		model.addSeries(ww);
		model.addSeries(tu);
		
		return model;
	}
}