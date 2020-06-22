package com.ingSoft.simulador;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Ventana3 implements ActionListener{
	private JFrame ventana;
	private JPanel panel,panel2;
	private JTextField tasaMortalidad,radioContagio,movilidad;
	private JComboBox graph;
	private JButton apply;
	private String s[] = {"Histogram","Cake"};
	private Poblacion pob;
	private Simulador sim;
	private String graphChoice;
	
	public Ventana3(Poblacion pob, Simulador sim) {
		this.sim = sim;
		this.pob = pob;
		//showVentana();
	}
	
	public void showVentana() {
		ventana = new JFrame();
		ventana.setSize(500,100);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel2 = new JPanel();
		
		tasaMortalidad = new JTextField("",6);
		radioContagio = new JTextField("",6);
		movilidad = new JTextField("",6);
		graph = new JComboBox(s);
		apply = new JButton("Apply");
		
		//panel.setLayout(new GridLayout(1,5));
		panel.add(tasaMortalidad);
		panel.add(radioContagio);
		panel.add(movilidad);
		panel.add(graph);
		panel.add(apply);
		
		panel2.setLayout(new GridLayout(1,5));
		panel2.add(new JLabel("Tasa Mortalidad /"));
		panel2.add(new JLabel(" Radio Contagio /"));
		panel2.add(new JLabel(" Movilidad /"));
		panel2.add(new JLabel(" Graph"));
		ventana.add(panel,BorderLayout.CENTER);
		ventana.add(panel2,BorderLayout.NORTH);
		ventana.setVisible(true);
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
	public JPanel getpanel1() {
		return panel;
	}
	public JPanel getpanel2() {
		return panel2;
	}
}
