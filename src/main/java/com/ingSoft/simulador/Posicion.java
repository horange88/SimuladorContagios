package com.ingSoft.simulador;

import java.util.Random;

public class Posicion {
	private int posx;
	private int posy;
	
	public Posicion(Area area) {
		Random r = new Random();
		posx=r.nextInt(area.getAncho());
		posy=r.nextInt(area.getAlto());
	}
	
	public int getPosx() {
		return posx;
	}
	public void setPosx(int posx) {
		this.posx = posx;
	}
	public int getPosy() {
		return posy;
	}
	public void setPosy(int posy) {
		this.posy = posy;
	}

	public void mover(Velocidad vel) {
		posx += vel.getVelx();
		posy += vel.getVely();
		
	}


}
