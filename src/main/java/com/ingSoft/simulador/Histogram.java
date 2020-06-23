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
	private String s[] = {"Histogram","Pie","Line"};
	private Poblacion pob;
	private Simulador sim;
	private String graphChoice;
	private DefaultCategoryDataset data;
	
	private int pobSana,pobEnfermo,pobMuertos,pobRecuperados;
	
	public Histogram(Poblacion p, Simulador s){
		
		poblacion      = p;
		sim     = s;
		pobSana        = poblacion.getCantSanos();
		pobEnfermo     = poblacion.getCantEnfermos();
		pobMuertos     = poblacion.getCantMuertos();
		pobRecuperados = poblacion.getCantRecuperados();
		
		histogramCalling();
		parametersCalling();
	}

	public void histogramCalling() {
		data = new DefaultCategoryDataset();
		
		data.addValue(pobSana,"1","Sanas");
		data.addValue(pobEnfermo,"2","Enfermas");
		data.addValue(pobMuertos,"3","Recuperadas");
		data.addValue(pobRecuperados,"4","Muertas");
		
		JFreeChart graph = ChartFactory.createBarChart("", "", "Cantidad de Personas", data, PlotOrientation.VERTICAL, false, true, false);
		histograma = new ChartPanel(graph);
		histograma.setBounds(100,100,10,10);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==apply) {
			sim.setMortalidad((float)(Integer.valueOf(tasaMortalidad.getText())));
			sim.setRadioContagio(Integer.valueOf(radioContagio.getText()));
			sim.setMovilidad(Integer.valueOf(movilidad.getText()));
			graphChoice = graph.getSelectedItem().toString();
		}
	}
	
	@Override
	public void updatePoblacion() {
		data.setValue(poblacion.getCantSanos(),"1","Sanas");
		data.setValue(poblacion.getCantEnfermos(),"2","Enfermas");
		data.setValue(poblacion.getCantRecuperados(),"3","Recuperadas");
		data.setValue(poblacion.getCantMuertos(),"4","Muertas");
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
		apply.addActionListener(this);
		
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
