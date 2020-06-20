package com.ingSoft.simulador;

public class Log implements Observer {
	private Poblacion poblacion;
	
	public Log() {
	}
	public void setPoblacion(Poblacion p) {
		poblacion = p;
		poblacion.atachObserver(this);
	}
	public void display() {
		System.out.println("Sanos: " +poblacion.getCantSanos()+ ". Enfermos: "+poblacion.getCantEnfermos() + ". Muertos: "+poblacion.getCantMuertos() + ". Recuperados: " + poblacion.getCantRecuperados());
	}

	@Override
	public void update() {
		display();
		
	}

}
