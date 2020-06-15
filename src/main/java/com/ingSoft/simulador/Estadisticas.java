package com.ingSoft.simulador;

public class Estadisticas implements Observer {
	private Subject poblacion; 
	public Estadisticas(Subject poblacion) {
		this.poblacion = poblacion;
	}
	void display(int cantSanos, int cantEnfermos, int cantMuertos, int cantRecuperados) {
		System.out.printf("%d %d %d %d",cantSanos,cantEnfermos, cantMuertos, cantRecuperados);
	}

	@Override
	public void update() {
		Poblacion p = (Poblacion)poblacion;
		display(p.getCantSanos(), p.getCantEnfermos(), p.getCantMuertos(), p.getCantRecuperados());
	}

}
