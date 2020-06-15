package com.ingSoft.simulador;

import java.awt.Color;

public class Simulador {
	private Poblacion poblacion;
	private Area area;
	private int cantEnfermos;
	private float mortalidad;
	private int tiempoRecuperacion;
	private int tiempoIncubacion;
	private int radioContagio;
	private boolean inmunidad;
	private float movilidad;
	private int tiempoSimulacion;
	private VisorSimulador visor;

	public Simulador(Area a, Poblacion p) {
		area = a;
		poblacion = p;
		
		visor = new VisorSimulador("Simulador", area.getAncho(), area.getAlto(), Color.white);
	}
	
	public void simular(int pasos) {
		
		for (int i=0;i< pasos;i++)
		{
			simularUnPaso();
		}
	}
	public void  simularUnPaso() {
		poblacion.animar();
	}
	public void  transmitir() {
		
	}
	public void  sanar() {
		
	}
	public void  decaer() {
		
	}

}
