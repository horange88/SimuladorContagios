package com.ingSoft.simulador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainMenu {
		static JFrame ventana;
		static Ventana2 v2;
		
		//---------------------
		private static  JFrame ventana3;
		private  JPanel p2;
		//----------------------
		
	public void main() {
		v2 = new Ventana2();
		
		ventana = new JFrame("Simulador de Contagios");
		ventana.setVisible(true);
		ventana.setSize(250, 250);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.gray);
		
		JButton b1 = new JButton("Nueva Simulacion");
		JButton b2 = new JButton("Historial de Simulaciones");
		JButton b3 = new JButton("Comparar Simulaciones");
		
		
		b1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ventana.setVisible(false);
				v2.showVentana();
				
				
			}
		});
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.setVisible(false);
				historialSim();
			}
		});
		
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10,10,10,10);
		c.gridx = 0; c.gridy = 1;
		panel.add(b1,c);
		c.gridx = 0; c.gridy = 2;
		panel.add(b2,c);	
		c.gridx = 0; c.gridy = 3;
		panel.add(b3,c);
		ventana.add(panel);		
	}
	
	public static void historialSim() {
		/*HistorialMenu hm = new HistorialMenu();
		hm.main(ventana);*/
		//Histogram histo = new Histogram();
		
	   /* ventana3 = new JFrame("Histogramita");
		ventana3.setSize(800,600);
		ventana3.setLocationRelativeTo(null);
		ventana3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		//ventana3.add(panel);
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(new JButton("presioname :)"));
		
		JPanel panelDePaneles = new JPanel();
		
		panelDePaneles.setLayout(new FlowLayout());
		panelDePaneles.add(histo.getPanel(),BorderLayout.WEST);
		panelDePaneles.add(new JButton("holis"));
		
		Container cp = ventana3.getContentPane();
		//cp.setLayout(new FlowLayout());
		
		cp.add(panel,BorderLayout.NORTH);
		cp.add(panelDePaneles,BorderLayout.SOUTH);
		ventana3.setVisible(true);*/

	}
	
	

}