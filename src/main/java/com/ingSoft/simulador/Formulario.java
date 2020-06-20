package com.ingSoft.simulador;

import javax.swing.*;
import java.awt.event.*;
public class Formulario extends JFrame implements ActionListener {
    JButton boton1, boton2;
    Simulador simulador;
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
        
    }
    
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource()==boton1) {
            simulador.setMovilidad(simulador.getMovilidad()+1);
        }
    	if (e.getSource()==boton2) {
            simulador.setMovilidad(simulador.getMovilidad()-1);
        }
    }

    
}