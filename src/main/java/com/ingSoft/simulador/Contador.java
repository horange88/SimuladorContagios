package com.ingSoft.simulador;

public class Contador implements Observer{
	private int cantSanos;
	private int cantEnfermos;
	private int cantMuertos;
	private int cantRecuperados;
	private Poblacion poblacion;
	public Contador(Poblacion p) {
		poblacion = p;
	}
	@Override
	public void update() {
		cantSanos = poblacion.getCantSanos();
		cantEnfermos = poblacion.getCantEnfermos();
		cantMuertos = poblacion.getCantMuertos();
		cantRecuperados = poblacion.getCantRecuperados();
		display();
		
	}
	
	public void display()
	{
		
	}

}
