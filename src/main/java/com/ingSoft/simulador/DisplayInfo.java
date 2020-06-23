package com.ingSoft.simulador;

public class DisplayInfo implements ObserverPoblacion, ObserverParametros {
	private Simulador simulador;
	private Poblacion poblacion;
	int pasoActual, sanos, enfermos, recuperados, muertos, movilidad, mortalidad;
	
	public DisplayInfo(Simulador s) {
		simulador = s;
		poblacion = s.getPoblacion();
		poblacion.atachObserverPoblacion(this);
	}

	public int getPasoActual() {
		return pasoActual;
	}
	public int getSanos() {
		return sanos;
	}
	public int getEnfermos() {
		return enfermos;
	}
	public int getRecuperados() {
		return recuperados;
	}
	public int getMuertos() {
		return muertos;
	}
	public int getMortalidad() {
		return muertos;
	}
	public int getMovilidad() {
		return muertos;
	}
	@Override
	public void updatePoblacion() {
		pasoActual= simulador.getPasoActual();
		sanos=poblacion.getCantSanos();
		enfermos = poblacion.getCantEnfermos();
		recuperados = poblacion.getCantRecuperados();
		muertos = poblacion.getCantMuertos();
		
	}

	@Override
	public void updateParametros() {
		mortalidad = (int)simulador.getMortalidad()*100;
		movilidad = simulador.getMovilidad();
		
	}

}
