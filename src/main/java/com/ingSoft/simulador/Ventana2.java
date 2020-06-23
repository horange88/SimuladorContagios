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
	private JRadioButton rb3;
	private ButtonGroup group;
	private Container cp; 
	
	private FrameGrafico frameGrafico;
	private JTextField tm; //tasa mortalidad
	private JTextField rc; //radio de contagio 
	private JTextField mov;//movilidad
	private JComboBox  graph;
	private JButton    apply;

	private Simulador simulador;
	public static int poblacionTotal;
	public static int pobTotInfectados;
	public static int tasaMortalidad;
	public static int tiempoIncubacion;
	public static int radioContagio;
	public static int areaParam;
	public static int movilidad;
	public static int tiempoSimulacion;
	public String grafico;
	
	public Ventana2() {
	}
	
	//Metodos que permiten determinar si hay cambios en los espacios en blanco
	@Override
	public void changedUpdate(DocumentEvent arg0) {validarDatos();}

	@Override
	public void insertUpdate(DocumentEvent arg0) {validarDatos();}

	@Override
	public void removeUpdate(DocumentEvent arg0) {validarDatos();}
	
    //Metodo que permite deterimar si hay cambio en los botones
	@Override
	public void actionPerformed(ActionEvent e) {
         frameGrafico = new FrameGrafico();
		 if (e.getSource()==aceptar) {
			 
	        try {     

	             poblacionTotal   = Integer.valueOf(whiteSpaces.get(0).getText());
				 pobTotInfectados = Integer.valueOf(whiteSpaces.get(1).getText());
				 tasaMortalidad   = Integer.valueOf(whiteSpaces.get(2).getText());
				 tiempoIncubacion = Integer.valueOf(whiteSpaces.get(3).getText());
				 radioContagio    = Integer.valueOf(whiteSpaces.get(4).getText());
				 areaParam        = Integer.valueOf(whiteSpaces.get(5).getText());
				 movilidad        = Integer.valueOf(whiteSpaces.get(6).getText());
				 tiempoSimulacion = Integer.valueOf(whiteSpaces.get(7).getText());
				 
				 startSim(poblacionTotal,pobTotInfectados,tasaMortalidad,tiempoIncubacion,radioContagio,areaParam,movilidad,tiempoSimulacion);
				
				 if(rb1.isSelected()) {
					 frameGrafico.setJChart(new  Histogram(simulador));
					 
				 }
				 else if(rb2.isSelected()) {
					 frameGrafico.setJChart(new  PieChart(simulador));
					
				 }
				 else if (rb3.isSelected()){
					 frameGrafico.setJChart(new  LineChart(simulador));
					
				 }
				 
				 ventana.setVisible(false);
				 parameterConfig();
	        }
	        catch(NumberFormatException error) {
	        	JOptionPane.showMessageDialog(null, "Las casillas no pueden estar vacias", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	           
	     }
		 else if(e.getSource() == cancelar) {
			 ventana.dispatchEvent(new WindowEvent(ventana, WindowEvent.WINDOW_CLOSING));
		 }
		 else if (e.getSource() == apply){//"Histogram","Pie","Line"
			
			 if(graph.getSelectedItem()=="Histogram") {
				 frameGrafico.setJChart(new  Histogram(simulador));
			 }
			 else if(graph.getSelectedItem()=="Pie") {
				 frameGrafico.setJChart(new  PieChart(simulador));
				
			 }
			 else if (graph.getSelectedItem()=="Line"){
				 frameGrafico.setJChart(new  LineChart(simulador));
			 }
			 simulador.setMortalidad((float)(Integer.valueOf(tm.getText())));
			 simulador.setRadioContagio(Integer.valueOf(rc.getText()));
			 simulador.setMovilidad(Integer.valueOf(mov.getText()));
			
		 }
	  }
	
		public void validarDatos() {
			boolean isNull=false;
			for(int i=0;i<whiteSpaces.size();i++) {
				if(whiteSpaces.get(i).getText().equals("")) {
					isNull = true;
				}
				if(Integer.valueOf(whiteSpaces.get(0).getText())<0) {
					System.out.println("NEGATIVO= "+Integer.valueOf(whiteSpaces.get(0).getText()) );
				}
			}
			if(isNull) {
				aceptar.setEnabled(false);
				JOptionPane.showMessageDialog(null, "Las casillas no pueden estar vacias", "Error", JOptionPane.ERROR_MESSAGE);
			}else {
				aceptar.setEnabled(true);
			}
		}
		
		public void addListeners() {
			//Agregado de listener botones
			aceptar.addActionListener(this);
			cancelar.addActionListener(this);
			
			//Agregado listener espacios en blanco
			for(int i=0; i<whiteSpaces.size();i++) {
				whiteSpaces.get(i).getDocument().addDocumentListener(this);
			}
		}
		
		public void armadoVentana() {
			ventana = new JFrame("ventanita");
			ventana.setSize(350,400); //ancho*largo
			ventana.setLocationRelativeTo(null);
			ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JPanel panel = new JPanel();
			GridLayout gl = new GridLayout(8,2,0,10);
			panel.setLayout(gl);
		
			//Inicializacion de frames, botones y botones redondos
		    for(int i=0;i<8;i++) {
		    	panel.add(new JLabel(nombre.get(i)));
		    	panel.add(whiteSpaces.get(i));
		    }
			
			JPanel panelBoton = new JPanel();
			panelBoton.setLayout(new FlowLayout());
			panelBoton.add(cancelar);
			panelBoton.add(aceptar);
			
			JPanel panelRadio = new JPanel();
			panelRadio.setLayout(new GridLayout(4,1));
			panelRadio.add(new JLabel("Seleccionar:"));
			panelRadio.add(rb1);
			panelRadio.add(rb2);
			panelRadio.add(rb3);
			
		
			cp = ventana.getContentPane();
			cp.add(panel,BorderLayout.NORTH);
			cp.add(panelRadio,BorderLayout.CENTER);
			cp.add(panelBoton,BorderLayout.SOUTH);
			ventana.setVisible(true);
		}
		
		public static ArrayList<Integer> getParametrosSimulacion(){
			ArrayList<Integer> param = new ArrayList<Integer> ();
			param.add(poblacionTotal);
			param.add(pobTotInfectados);
			param.add(tasaMortalidad);
			param.add(tiempoIncubacion);
			param.add(radioContagio);
			param.add(areaParam);
			param.add(movilidad);
			param.add(tiempoSimulacion);
			
			return param;
		}
		
		public void showVentana() {
			//Inicializacion de espacios en blancos para escritura y nombres de parametros
			whiteSpaces = new ArrayList<JTextField>();
			nombre      = new ArrayList<String>();
		
			nombre.add("poblacion total");
			nombre.add("poblacion inicial infectados");
			nombre.add("tasa de mortalidad");
			nombre.add("tiempo de incubacion");
			nombre.add("radio de contagio");
			nombre.add("Area");
			nombre.add("movilidad");
			nombre.add("tiempo de simulacion (seg)");
			
			for(int i=0; i<8;i++) {
				whiteSpaces.add(new JTextField(10));
			}
			
			rb1 = new JRadioButton("Histogram");
			rb2 = new JRadioButton("Pie");
			rb3 = new JRadioButton("Line");
			aceptar = new JButton("Aceptar");
			cancelar = new JButton("Cancelar");
			
			//Listeners de botones y whiteSpaces
			addListeners();
			//Se inicializa con "aceptar" deshabilitado
			aceptar.setEnabled(false);
			//Se aniaade a ButtonGrup a los radioButton
			
		    group = new ButtonGroup();
			group.add(rb1);
			group.add(rb2);
			group.add(rb3);
			
			//Se fabrica toda la ventana
			armadoVentana();
		}
		
		//Aca se ejecuta el simulador de contagios
		public  void startSim(int poblacionTotal, int pobTotInfectados, int tasaMortalidad, int tiempoIncubacion, int radioContagio, int areaParam, int movilidad, int tiempoSimulacion) {
			//Instancia parametros de simulacion
			Area area = new Area(areaParam,areaParam);
			Poblacion p = new Poblacion(area,poblacionTotal ,pobTotInfectados);
		    simulador = new Simulador(area,p);
			Log log = new Log(simulador);
			LogWriter logwriter = new LogWriter(simulador);
			//seteo de parametros del simulador
			simulador.setVisor(VisorSimulador.getVisor());
			simulador.setMortalidad((float)(0.01*tasaMortalidad));
			simulador.setMovilidad(movilidad);
			simulador.setDuracionEnfermedad(tiempoIncubacion);
			simulador.setTiempoSimulacion(tiempoSimulacion);
			simulador.setRadioContagio(radioContagio);
			
			log.displayPoblacion();
		    //visor simulador
			JFrame j1 = new JFrame("Simulacion de contagios");
		    j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        j1.setVisible(true);
		    j1.add(simulador.getVisor().getPanel());
		    j1.pack();
     
		    MyThread t = new MyThread(simulador);
	        t.start();  
		}
		
		public void parameterConfig() {
			 String s[] = {"Histogram","Pie","Line"};
			 JFrame ventana = new JFrame();
		     ventana.setSize(500,100);
		     ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 ventana.setLocationRelativeTo(null);
			
			 JPanel panel1 = new JPanel();
			 JPanel panel2 = new JPanel();

			 tm  = new JTextField("",6);
			 rc  = new JTextField("",6);
			 mov = new JTextField("",6);
			 
			 graph = new JComboBox(s);
			 apply = new JButton("Apply");
			 apply.addActionListener(this);

			 //creacion de panel 1 y 2
			 panel1.add(tm);
			 panel1.add(rc);
			 panel1.add(mov);
			 panel1.add(graph);
			 panel1.add(apply);

			 panel2.setLayout(new GridLayout(1,5));
			 panel2.add(new JLabel("Tasa Mortalidad/"));
			 panel2.add(new JLabel("Radio Contagio/"));
			 panel2.add(new JLabel("Movilidad/"));
			 panel2.add(new JLabel("Graph"));
   
			 ventana.add(panel1,BorderLayout.CENTER);
			 ventana.add(panel2,BorderLayout.NORTH);
			 //ventana.add(histograma,BorderLayout.SOUTH);
			 ventana.setVisible(true);
		}
}
