package com.ingSoft.simulador;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		Area area = new Area(600,600);
		Poblacion p = new Poblacion(area, 150,10);
		Log log = new Log();
		Simulador simulador = new Simulador(area,p);
		simulador.setVisor(VisorSimulador.getVisor());
		simulador.setMortalidad((float) 0.1);
		simulador.setMovilidad(3);
		simulador.setDuracionEnfermedad(500);
		simulador.setTiempoSimulacion(2000);
		simulador.setRadioContagio(10);
		log.setPoblacion(p);
		log.display();
		
        JFrame j1 = new JFrame();
        j1.setVisible(true);
        j1.add(simulador.getVisor().getPanel());
        j1.pack();

        
        simulador.simular();
        
        
	}

}
