package com.ingSoft.simulador;

import java.util.Random;

public class Persona {
	private Posicion pos;
	private Velocidad vel;
	private Estados Estado;
	private int movilidad;

	public Persona(Area area) {
		pos = new Posicion(area);
		vel = new Velocidad();
		movilidad = 10;
	}

	public Posicion getPos() {
		return pos;
	}

	public void setPos(Posicion pos) {
		this.pos = pos;
	}

	public Velocidad getVel() {
		return vel;
	}

	public void setVel(Velocidad vel) {
		this.vel = vel;
	}

	public Estados getEstado() {
		return Estado;
	}

	public void setEstado(Estados estado) {
		Estado = estado;
	}

	public int getMovilidad() {
		return movilidad;
	}

	public void setMovilidad(int movilidad) {
		this.movilidad = movilidad;
	}

	public void calcularVelocidad() {
		Random r = new Random();
		vel.setVelx(r.nextInt(2*movilidad+1)-movilidad);
		vel.setVely(r.nextInt(2*movilidad+1)-movilidad);
	}

	public void mover() {
		calcularVelocidad();
		pos.mover(vel);
	}

	public void enfermar() {
		this.Estado = Estados.Enfermo;
	}

	public void decaer() {

	}

	public void recuperar() {
		this.Estado = Estados.Recuperado;
	}

	public void morir() {
		this.Estado = Estados.Muerto;
	}

}
