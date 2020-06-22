package com.ingSoft.simulador;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jfree.chart.*;
import org.jfree.data.category.*;
import org.jfree.chart.plot.*;

public class Histogram implements ActionListener,ObserverPoblacion{
	
	public static ChartPanel histograma;
	private Poblacion poblacion;
	private Simulador simulacion;
	//--------------------
	private JPanel panel1,panel2;
	private JTextField tasaMortalidad,radioContagio,movilidad;
	private JComboBox graph;
	private JButton apply;
	private JFrame ventana;
	private String s[] = {"Histogram","Cake"};
	private Poblacion pob;
	private Simulador sim;
	private String graphChoice;
	
	private int pobSana,pobEnfermo,pobMuertos,pobRecuperados;
	
	
	public Histogram(Poblacion p, Simulador s){
		
		poblacion      = p;
		simulacion     = s;
		pobSana        = poblacion.getCantSanos();
		pobEnfermo     = poblacion.getCantEnfermos();
		pobMuertos     = poblacion.getCantMuertos();
		pobRecuperados = poblacion.getCantRecuperados();
		
		histogramCalling();
		parametersCalling();
	}

	public void histogramCalling() {
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		final String var1 = "var1";
		final String var2 = "var2";
		final String var3 = "var3";
		final String var4 = "var4";
		
		data.addValue(pobSana,var1,"Sanas");
		data.addValue(pobEnfermo,var2,"Enfermas");
		data.addValue(pobMuertos,var3,"Recuperadas");
		data.addValue(pobRecuperados,var4,"Muertas");
		
		JFreeChart graph = ChartFactory.createBarChart("", "", "Cantidad de Personas", data, PlotOrientation.VERTICAL, false, true, false);
		histograma = new ChartPanel(graph);
		histograma.setBounds(100,100,10,10);
		
		
		/*JFrame ventana = new JFrame("Histogram");
		ventana.setVisible(true);
		ventana.setSize(400,400);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		ventana.add(panel);*/
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==apply) {
			sim.setMovilidad(Integer.valueOf(tasaMortalidad.getText()));
			sim.setRadioContagio(Integer.valueOf(radioContagio.getText()));
			sim.setMovilidad(Integer.valueOf(movilidad.getText()));
			graphChoice = graph.getSelectedItem().toString();
		}
	}
	@Override
	public void updatePoblacion() {
		pobSana        = poblacion.getCantSanos();
		pobEnfermo     = poblacion.getCantEnfermos();
		pobMuertos     = poblacion.getCantMuertos();
		pobRecuperados = poblacion.getCantRecuperados();
		histogramCalling();
		ventana.add(histograma,BorderLayout.SOUTH);
		ventana.setVisible(true);
		
	}
	
	public void parametersCalling() {
	    ventana = new JFrame();
		ventana.setSize(500,525);
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		
		tasaMortalidad = new JTextField("",6);
		radioContagio = new JTextField("",6);
		movilidad = new JTextField("",6);
		graph = new JComboBox(s);
		apply = new JButton("Apply");
		
		//panel.setLayout(new GridLayout(1,5));
		panel1.add(tasaMortalidad);
		panel1.add(radioContagio);
		panel1.add(movilidad);
		panel1.add(graph);
		panel1.add(apply);
		
		panel2.setLayout(new GridLayout(1,5));
		panel2.add(new JLabel("Tasa Mortalidad/"));
		panel2.add(new JLabel("Radio Contagio/"));
		panel2.add(new JLabel("Movilidad/"));
		panel2.add(new JLabel("Graph"));
		
		ventana.add(panel1,BorderLayout.CENTER);
		ventana.add(panel2,BorderLayout.NORTH);
		ventana.add(histograma,BorderLayout.SOUTH);
		ventana.setVisible(true);
	}
	
}
