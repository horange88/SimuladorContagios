package com.ingSoft.simulador;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Area area = new Area(300,300);
		Poblacion p = new Poblacion(area, 1,0);
	
		ArrayList <Persona> sanas = p.getSanas();
		
		for(Persona sana:sanas) {
			System.out.println(sana.getPos().getPosx()+" "+sana.getPos().getPosy());
		}
		p.animar();
		for(Persona sana:sanas) {
			System.out.println(sana.getPos().getPosx()+" "+sana.getPos().getPosy());
		}
	}

}
