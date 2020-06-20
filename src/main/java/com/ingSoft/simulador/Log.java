package com.ingSoft.simulador;

public class Log implements Observer {
	private Poblacion poblacion;
	private Simulador simulador;

	public Log(Simulador s) {
		simulador = s;
		poblacion = simulador.getPoblacion();
		poblacion.atachObserver(this);
	}

	public void setPoblacion(Poblacion p) {
		poblacion = p;
		poblacion.atachObserver(this);
	}

	public void display() {
		System.out.println("Paso: " + simulador.getPasoActual() + ". Sanos: " + poblacion.getCantSanos() + ". Enfermos: "
				+ poblacion.getCantEnfermos() + ". Muertos: " + poblacion.getCantMuertos() + ". Recuperados: "
				+ poblacion.getCantRecuperados());
	}

	@Override
	public void update() {
		display();

	}

}
