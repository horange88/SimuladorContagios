package com.ingSoft.simulador;

import org.jfree.chart.ChartPanel;


public interface GraphicBehaviour {
	
	//Obtener Panel
	public ChartPanel getPanel();
	
	//armado de ventana de ingreso de param  + el grafico que corresponda
	public void  show(); //parametersCalling()

}
