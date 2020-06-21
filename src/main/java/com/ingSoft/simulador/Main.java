package com.ingSoft.simulador;

import java.util.ArrayList;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		MainMenu mm = new MainMenu();
		mm.main();
		
		ArrayList<Integer> params = mm.getParams();
		
		Area area = new Area(600,600);
		Poblacion p = new Poblacion(area, params.get(0),params.get(1));
		Simulador simulador = new Simulador(area,p);
		Log log = new Log(simulador);
		LogWriter logwriter = new LogWriter(simulador);
		simulador.setVisor(VisorSimulador.getVisor());
		simulador.setMortalidad((float) 0.01*params.get(2));
		simulador.setMovilidad(params.get(6));
		simulador.setDuracionEnfermedad(params.get(3));
		simulador.setTiempoSimulacion(params.get(7));
		simulador.setRadioContagio(params.get(4));
		log.displayPoblacion();
		
        JFrame j1 = new JFrame();
        j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j1.setVisible(true);
        j1.add(simulador.getVisor().getPanel());
        j1.pack();
        
        Formulario f = new Formulario(simulador);
        f.setVisible(true);
        
        simulador.simular();
        
        
	}
	
	public void startSim() {
		
	}

}
