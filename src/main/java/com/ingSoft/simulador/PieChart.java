package com.ingSoft.simulador;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class PieChart implements ObserverPoblacion {
	DefaultPieDataset dataset;
	Simulador simulador;
	Poblacion p;

	public PieChart(Simulador s) {
		simulador = s;
		p = s.getPoblacion();
		p.atachObserverPoblacion(this);

		dataset = new DefaultPieDataset();
		dataset.insertValue(0, "Sanos", p.getCantSanos());
		dataset.insertValue(1, "Enfermos", p.getCantEnfermos());
		dataset.insertValue(2, "Recuperados", p.getCantRecuperados());
		dataset.insertValue(3, "Muertos", p.getCantMuertos());

		JFreeChart chart = ChartFactory.createPieChart("Repeticion de randoms", dataset, true, true, true);
		ChartPanel panel = new ChartPanel(chart);
		
		
		JFrame frame = new JFrame("CrearGraficos - LineaDeCodigo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);

	}

	@Override
	public void updatePoblacion() {
		dataset.setValue("Sanos", p.getCantSanos());
		dataset.setValue("Enfermos", p.getCantEnfermos());
		dataset.setValue("Recuperados", p.getCantRecuperados());
		dataset.setValue("Muertos", p.getCantMuertos());
		
	}

}
