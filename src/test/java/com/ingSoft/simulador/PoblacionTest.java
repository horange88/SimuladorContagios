package com.ingSoft.simulador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PoblacionTest {

	@Test
	void testIniciarSanas() {
		Area a = new Area(100,100);
		Poblacion p = new Poblacion(a,0,0);
		p.iniciarSanos(0);
		assertEquals(0, p.getSanas().size(), "La cantidad de personas sanas debe ser 0");
		p.iniciarSanos(100);
		assertEquals(100, p.getSanas().size(), "La cantidad de personas sanas debe ser 100");
	}

	@Test
	void testIniciarEnfermos() {
		Area a = new Area(100,100);
		Poblacion p = new Poblacion(a,0,0);
		p.iniciarEnfermos(0);
		assertEquals(0, p.getEnfermas().size(), "La cantidad de personas sanas debe ser 0");
		p.iniciarEnfermos(100);
		assertEquals(100, p.getEnfermas().size(), "La cantidad de personas sanas debe ser 100");
	}

	@Test
	void testEnfermarPersona() {
		Area a = new Area(100,100);
		Poblacion p = new Poblacion(a,100,0);
		Persona per = p.getSanas().get(1);
		p.enfermarPersona(per);
		assertEquals(Estados.Enfermo, per.getEstado(), "La persona debe estar enferma");
		assertEquals(1, p.getEnfermas().size(), "La poblacion de enfermas debe ser 1");
		assertEquals(99, p.getSanas().size(), "La poblacion de sanas debe ser 99");
		
		per = p.getSanas().get(1);
		p.enfermarPersona(per);
		assertEquals(Estados.Enfermo, per.getEstado(), "La persona debe estar enferma");
		assertEquals(2, p.getEnfermas().size(), "La poblacion de enfermas debe ser 2");
		assertEquals(98, p.getSanas().size(), "La poblacion de sanas debe ser 98");
	}

	@Test
	void testMorirPersona() {
		Area a = new Area(100,100);
		Poblacion p = new Poblacion(a,100,10);
		Persona per = p.getEnfermas().get(1);
		p.morirPersona(per);
		assertEquals(Estados.Muerto, per.getEstado(), "La persona debe estar muerta");
		assertEquals(1, p.getMuertas().size(), "La poblacion de muertas debe ser 1");
		assertEquals(9, p.getEnfermas().size(), "La poblacion de enfermas debe ser 9");
		assertEquals(90, p.getSanas().size(), "La poblacion de sanas debe ser 90");
		
		per = p.getEnfermas().get(1);
		p.morirPersona(per);
		assertEquals(Estados.Muerto, per.getEstado(), "La persona debe estar muerta");
		assertEquals(2, p.getMuertas().size(), "La poblacion de muertas debe ser 2");
		assertEquals(8, p.getEnfermas().size(), "La poblacion de enfermas debe ser 8");
		assertEquals(90, p.getSanas().size(), "La poblacion de sanas debe ser 90");
	}

	@Test
	void testRecuperarPersona() {
		Area a = new Area(100,100);
		Poblacion p = new Poblacion(a,100,10);
		Persona per = p.getEnfermas().get(1);
		p.recuperarPersona(per);
		assertEquals(Estados.Recuperado, per.getEstado(), "La persona debe estar recuperada");
		assertEquals(1, p.getRecuperadas().size(), "La poblacion de recuperadas debe ser 1");
		assertEquals(9, p.getEnfermas().size(), "La poblacion de enfermas debe ser 9");
		assertEquals(90, p.getSanas().size(), "La poblacion de sanas debe ser 90");
		
		per = p.getEnfermas().get(1);
		p.recuperarPersona(per);
		assertEquals(Estados.Recuperado, per.getEstado(), "La persona debe estar recuperada");
		assertEquals(2, p.getRecuperadas().size(), "La poblacion de recuperadas debe ser 2");
		assertEquals(8, p.getEnfermas().size(), "La poblacion de enfermas debe ser 8");
		assertEquals(90, p.getSanas().size(), "La poblacion de sanas debe ser 90");
	}

	@Test
	void testSetMovilidad() {
		Area a = new Area(100,100);
		Poblacion p = new Poblacion(a,100,10);
		int m = 10;
		p.setMovilidad(m);
		for (Persona per: p.getSanas()) {
			assertEquals(m, per.getMovilidad(), "La movilidad debe ser 10");
		}
		for (Persona per: p.getEnfermas()) {
			assertEquals(m, per.getMovilidad(), "La movilidad debe ser 10");
		}
		for (Persona per: p.getRecuperadas()) {
			assertEquals(m, per.getMovilidad(), "La movilidad debe ser 10");
		}
		
		m = 0;
		p.setMovilidad(m);
		for (Persona per: p.getSanas()) {
			assertEquals(m, per.getMovilidad(), "La movilidad debe ser 10");
		}
		for (Persona per: p.getEnfermas()) {
			assertEquals(m, per.getMovilidad(), "La movilidad debe ser 10");
		}
		for (Persona per: p.getRecuperadas()) {
			assertEquals(m, per.getMovilidad(), "La movilidad debe ser 10");
		}
	}
	
	void testSetMortalidad() {
		Area a = new Area(100,100);
		Poblacion p = new Poblacion(a,100,10);
		float m = (float) 0.1;
		p.setMortalidad(m);
		for (Persona per: p.getSanas()) {
			assertEquals(m, per.getMortalidad(), "La mortalidad debe ser 0.1");
		}
		for (Persona per: p.getEnfermas()) {
			assertEquals(m, per.getMortalidad(), "La mortalidad debe ser 0.1");
		}
		for (Persona per: p.getRecuperadas()) {
			assertEquals(m, per.getMortalidad(), "La mortalidad debe ser 0.1");
		}
		
		m = (float) 0.3;
		p.setMortalidad(m);
		for (Persona per: p.getSanas()) {
			assertEquals(m, per.getMortalidad(), "La mortalidad debe ser 0.2");
		}
		for (Persona per: p.getEnfermas()) {
			assertEquals(m, per.getMortalidad(), "La mortalidad debe ser 0.2");
		}
		for (Persona per: p.getRecuperadas()) {
			assertEquals(m, per.getMortalidad(), "La mortalidad debe ser 0.2");
		}
	}

}
