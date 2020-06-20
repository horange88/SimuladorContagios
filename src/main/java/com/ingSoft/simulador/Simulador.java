package com.ingSoft.simulador;

import java.util.ArrayList;

public class Simulador {
	private Poblacion poblacion;
	private Area area;
	private int cantEnfermos;
	private float mortalidad;
	private int duracionEnfermedad;
	private int tiempoIncubacion;
	private int radioContagio;
	private boolean inmunidad;
	private int movilidad;
	private int tiempoSimulacion;
	private VisorSimulador visor;

	public Simulador() {
		radioContagio = 0;
		mortalidad = 0;
	}

	public Simulador(Area a, Poblacion p) {
		area = a;
		poblacion = p;
		radioContagio = 0;
		mortalidad = 0;
	}

	public Poblacion getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(Poblacion poblacion) {
		this.poblacion = poblacion;
	}

	public int getDuracionEnfermedad() {
		return duracionEnfermedad;
	}

	public void setDuracionEnfermedad(int duracionEnfermedad) {
		this.duracionEnfermedad = duracionEnfermedad;
		poblacion.setDuracionEnfermedad(duracionEnfermedad);
	}

	public int getMovilidad() {
		return movilidad;
	}

	public void setMovilidad(int movilidad) {
		this.movilidad = movilidad;
		poblacion.setMovilidad(movilidad);
	}

	public float getMortalidad() {
		return mortalidad;
	}

	public void setMortalidad(float mortalidad) {
		this.mortalidad = mortalidad;
		poblacion.setMortalidad(mortalidad);
	}

	public int getTiempoSimulacion() {
		return tiempoSimulacion;
	}

	public void setTiempoSimulacion(int tiempoSimulacion) {
		this.tiempoSimulacion = tiempoSimulacion;
	}

	public int getRadioContagio() {
		return radioContagio;
	}

	public void setRadioContagio(int radioContagio) {
		this.radioContagio = radioContagio;
	}

	public void simular() {
		for (int i = 0; i < tiempoSimulacion; i++) {
			simularUnPaso();
		}
	}

	public void simularUnPaso() {
		poblacion.animar();
		evolucionarEnfermedad();
		morirRecuperar();
		transmitir();
		dibujar();
	}

	public void morirRecuperar() {
		ArrayList<Persona> tmpRecuperadas = new ArrayList<Persona>();
		ArrayList<Persona> tmpMuertas = new ArrayList<Persona>();

		for (Persona enferma : poblacion.getEnfermas()) {
			if (enferma.finEnfermedad()) {
				if (enferma.debeMorir())
					tmpMuertas.add(enferma);
				else
					tmpRecuperadas.add(enferma);
			}
		}
		for (Persona enferma : tmpMuertas) {
			poblacion.morirPersona(enferma);
		}
		for (Persona enferma : tmpRecuperadas) {
			poblacion.recuperarPersona(enferma);
		}
	}

	public void transmitir() {
		ArrayList<Persona> tmp = new ArrayList<Persona>();
		for (Persona enferma : poblacion.getEnfermas()) {
			for (Persona sana : poblacion.getSanas()) {
				if (estanCerca(enferma, sana) && !tmp.contains(sana))
					tmp.add(sana);
			}
		}
		for (Persona sana : tmp) {
			poblacion.enfermarPersona(sana);
		}
	}

	public void evolucionarEnfermedad() {
		for (Persona enferma : poblacion.getEnfermas()) {
			enferma.evolucionarEnfermedad();
		}
	}

	public boolean estanCerca(Persona enferma, Persona sana) {
		int dx = enferma.getPos().getPosx() - sana.getPos().getPosx();
		int dy = enferma.getPos().getPosy() - sana.getPos().getPosy();

		return ((dx * dx + dy * dy) <= radioContagio * radioContagio);
	}

	public void dibujar() {


	}

}
