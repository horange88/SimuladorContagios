package com.ingSoft.simulador;

import javax.swing.*;
import java.awt.event.*;
public class Formulario extends JFrame implements ActionListener {
    JButton boton1, boton2;
    Simulador simulador;
    FrameGrafico frame;
    public Formulario(Simulador s) {
    	simulador = s;
        setLayout(null);
        boton1=new JButton("Aumentar Movilidad");
        boton2=new JButton("Reducir Movilidad");
        boton1.setBounds(100,250,100,30);
        add(boton1);
        boton2.setBounds(300,250,100,30);
        add(boton2);
        boton1.addActionListener(this);
        boton2.addActionListener(this);
        pack();
        frame = new FrameGrafico();
        
        
    }
    
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource()==boton1) {
    		frame.setJChart(new LineChart(simulador));
    		
        }
    	if (e.getSource()==boton2) {
    		frame.setJChart(new PieChart(simulador));

        }
    	
    }

    
}