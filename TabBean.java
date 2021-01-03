package com.controller.proyecto;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean
@ViewScoped
public class TabBean {
	private List<TabInfo> tabs;
	
	
	
	@PostConstruct
	public void init() {
		tabs=Arrays.asList(new TabInfo("Acerca de Nosotros","about us"),
				new TabInfo("Misión","mision"),
				new TabInfo("Visión","vision")
				);
		
	}
	
	public List<TabInfo> getTabs(){
		return tabs;
	}
}
