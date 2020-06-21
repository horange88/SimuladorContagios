package com.ingSoft.simulador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class Ventana2 implements ActionListener, DocumentListener {

	
private JFrame ventana;
	
	private JButton aceptar;
	private JButton cancelar;
	private ArrayList<JTextField> whiteSpaces;
	private ArrayList<String>     nombre;
	private JRadioButton rb1;	
	private JRadioButton rb2;
	private ButtonGroup group;
	private Container cp; 
	
	public int poblacionTotal;
	public int pobTotInfectados;
	public Float tasaMortalidad;
	public int tiempoIncubacion;
	public int radioContagio;
	public int inmunidad;
	public int  movilidad;
	public int tiempoSimulacion;
	public String grafico;
	
	
	public Ventana2() {
		// TODO Auto-generated constructor stub
		whiteSpaces = new ArrayList<JTextField>();
		nombre      = new ArrayList<String>();
	
		nombre.add("poblacion total");
		nombre.add("poblacion inicial infectados");
		nombre.add("tasa de mortaldiad");
		nombre.add("tiempo de incubacion");
		nombre.add("radio de contagio");
		nombre.add("inmunidad");
		nombre.add("movilidad");
		nombre.add("tiempo de simulacion (seg)");
		
		
		
		for(int i=0; i<8;i++) {
			whiteSpaces.add(new JTextField(10));
		}
		dummmy();
		//Agregado de listener
		rb1 = new JRadioButton("Histograma");
		rb2 = new JRadioButton("Diagrama cake");
		aceptar = new JButton("Aceptar");
		cancelar = new JButton("Cancelar");
		
		aceptar.setEnabled(false);
		
	    group = new ButtonGroup();
		group.add(rb1);
		group.add(rb2);
		
		
		aceptar.addActionListener(this);
		cancelar.addActionListener(this);

		ventana = new JFrame("ventanita");
		ventana.setSize(350,400); //ancho*largo
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		GridLayout gl = new GridLayout(8,2,0,10);
		panel.setLayout(gl);
	
		//Inicializacion de frames, botones y botones redondos
	    for(int i=0;i<8;i++) {
	    	
	    	//System.out.println(i+" "+nombre.get(i));
	    	panel.add(new JLabel(nombre.get(i)));
	    	panel.add(whiteSpaces.get(i));
	    	
	    }
		
		
		JPanel panelBoton = new JPanel();
		panelBoton.setLayout(new FlowLayout());
		panelBoton.add(cancelar);
		panelBoton.add(aceptar);
		
		JPanel panelRadio = new JPanel();
		panelRadio.setLayout(new GridLayout(3,1));
		panelRadio.add(new JLabel("Seleccionar:"));
		panelRadio.add(rb1);
		panelRadio.add(rb2);
		
	
		cp = ventana.getContentPane();
		cp.add(panel,BorderLayout.NORTH);
		cp.add(panelRadio,BorderLayout.CENTER);
		cp.add(panelBoton,BorderLayout.SOUTH);
		ventana.setVisible(true);
		
	}
	
	@Override
	public void changedUpdate(DocumentEvent arg0) {

		validarDatos();
		
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
	
		validarDatos();
		
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		
		validarDatos();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		 if (e.getSource()==aceptar) {
	        try {     
	             poblacionTotal   = Integer.valueOf(whiteSpaces.get(0).getText());
				 pobTotInfectados = Integer.valueOf(whiteSpaces.get(1).getText());
				 tasaMortalidad   = Float.valueOf(whiteSpaces.get(2).getText());
				 tiempoIncubacion = Integer.valueOf(whiteSpaces.get(3).getText());
				 radioContagio    = Integer.valueOf(whiteSpaces.get(4).getText());
				 inmunidad        = Integer.valueOf(whiteSpaces.get(5).getText());
				 movilidad        = Integer.valueOf(whiteSpaces.get(6).getText());
				 tiempoSimulacion = Integer.valueOf(whiteSpaces.get(7).getText());
				 
				 grafico = (group.getSelection()==rb1) ? "Histograma":"DiagramaCake";
	        }
	        catch(NumberFormatException error) {
	        	JOptionPane.showMessageDialog(null, "Las casillas no pueden estar vacias", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	           
	        }
		 else if(e.getSource() == cancelar) {
			// cad=cancelar.getText();
			 ventana.dispatchEvent(new WindowEvent(ventana, WindowEvent.WINDOW_CLOSING));
		 }
		 
		
	}
	
	
		//Incompleto
		public void validarDatos() {
			boolean isNull=false;
			boolean isNegative = false;
			
			for(int i=0;i<whiteSpaces.size();i++) {
				if(whiteSpaces.get(i).getText().equals("")) {
					isNull = true;
				}
				if(Integer.valueOf(whiteSpaces.get(0).getText())<0) {
					isNegative = true;
				}
			}
			 System.out.println("CAMBIE ");
			if(isNull) {
				aceptar.setEnabled(false);
				//JOptionPane.showMessageDialog(null, "Las casillas no pueden estar vacias", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else if(isNegative) {
				aceptar.setEnabled(false);
				//JOptionPane.showMessageDialog(null, "Dato inválido", "Error", JOptionPane.ERROR_MESSAGE);
			}else {
				aceptar.setEnabled(true);
			}
		}
		public void dummmy() {
			
			
			whiteSpaces.get(0).getDocument().addDocumentListener(this);
			whiteSpaces.get(1).getDocument().addDocumentListener(this);
			whiteSpaces.get(2).getDocument().addDocumentListener(this);
			whiteSpaces.get(3).getDocument().addDocumentListener(this);
			whiteSpaces.get(4).getDocument().addDocumentListener(this);
			whiteSpaces.get(5).getDocument().addDocumentListener(this);
			whiteSpaces.get(6).getDocument().addDocumentListener(this);
			whiteSpaces.get(7).getDocument().addDocumentListener(this);
			
			
		}
		

}
