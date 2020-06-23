package com.ingSoft.simulador;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public class FrameGrafico extends JFrame{

	public FrameGrafico() {
		// TODO Auto-generated constructor stub
		this.setVisible(true);
		setTitle("grafico variable");
	}
	
	public void setJChart(GraphicBehaviour chart) {
		getContentPane().removeAll();
		add(chart.getPanel());
		repaint();;
	}

}
