package com.ingSoft.simulador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PosicionTest {

	@Test
	void testPosicionArea() {
		int ancho =10;
		int alto =20;
		Area a = new Area(ancho, alto);
		Posicion p;
		for (int i = 0; i < 100; i++) {
			p = new Posicion(a);
			assertTrue(p.getPosx()>=0 && p.getPosx()<ancho);
			assertTrue(p.getPosy()>=0 && p.getPosy()<alto);
		}
	}

	@Test
	void testMover() {
		Area a = new Area(100,80);
		Posicion p= new Posicion(a);
		Velocidad v = new Velocidad();
		p.setPosx(0);
		p.setPosy(0);
		v.setVelx(15);
		v.setVely(10);
		p.mover(v);
		
		assertEquals(15, p.getPosx(), "La posición x debe ser 15");
		assertEquals(10, p.getPosy(), "La posición y debe ser 10");
	}
	
	@Test
	void testMoverNoDebeExcederLimites() {
		Area a = new Area(100,80);
		Posicion p= new Posicion(a);
		Velocidad v = new Velocidad();
		p.setPosx(0);
		p.setPosy(0);
		v.setVelx(-15);
		v.setVely(-10);
		p.mover(v);
		
		assertEquals(0, p.getPosx(), "La posición x debe ser 0");
		assertEquals(0, p.getPosy(), "La posición y debe ser 0");
		
		p.setPosx(90);
		p.setPosy(90);
		v.setVelx(20);
		v.setVely(30);
		p.mover(v);
		
		assertEquals(90, p.getPosx(), "La posición x debe ser 90");
		assertEquals(90, p.getPosy(), "La posición y debe ser 90");
	}

}
