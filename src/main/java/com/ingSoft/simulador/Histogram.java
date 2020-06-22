package com.ingSoft.simulador;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;

import org.jfree.chart.*;
import org.jfree.data.category.*;
import org.jfree.chart.plot.*;

public class Histogram {
	
	public static ChartPanel panel;
	public Histogram(){
		histogramFactory();
	}
	public void histogramFactory() {
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		final String var1 = "var1";
		final String var2 = "var2";
		final String var3 = "var3";
		final String var4 = "var4";
		
		data.addValue(100,var1,"Sanas");
		data.addValue(200,var2,"Enfermas");
		data.addValue(160,var3,"Recuperadas");
		data.addValue(310,var4,"Muertas");
		
		JFreeChart graph = ChartFactory.createBarChart("", "", "Cantidad de Personas", data, PlotOrientation.VERTICAL, false, true, false);
		panel = new ChartPanel(graph);
		panel.setBounds(100,100,10,10);
		
		/*JFrame ventana = new JFrame("Histogram");
		ventana.setVisible(true);
		ventana.setSize(400,400);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		ventana.add(panel);*/
	}
	
	public ChartPanel getPanel() {
		return panel;
	}
}
