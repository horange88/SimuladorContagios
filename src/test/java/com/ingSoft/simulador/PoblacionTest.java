package com.ingSoft.simulador;

import static org.junit.Assert.*;

import org.junit.Test;


public class PoblacionTest {

	@Test
	public void testIniciarSanas() {
		Area a = new Area(100,100);
		Poblacion p = new Poblacion(a,0,0);
		p.iniciarSanos(0);
		assertEquals(0, p.getSanas().size());
		p.iniciarSanos(100);
		assertEquals(100, p.getSanas().size());
	}

	@Test
	public void testIniciarEnfermos() {
		Area a = new Area(100,100);
		Poblacion p = new Poblacion(a,0,0);
		p.iniciarEnfermos(0);
		assertEquals(0, p.getEnfermas().size());
		p.iniciarEnfermos(100);
		assertEquals(100, p.getEnfermas().size());
	}

	@Test
	public void testEnfermarPersona() {
		Area a = new Area(100,100);
		Poblacion p = new Poblacion(a,100,0);
		Persona per = p.getSanas().get(1);
		p.enfermarPersona(per);
		assertEquals(Estados.Enfermo, per.getEstado());
		assertEquals(1, p.getEnfermas().size());
		assertEquals(99, p.getSanas().size());
		
		per = p.getSanas().get(1);
		p.enfermarPersona(per);
		assertEquals(Estados.Enfermo, per.getEstado());
		assertEquals(2, p.getEnfermas().size());
		assertEquals(98, p.getSanas().size());
	}

	@Test
	public void testMorirPersona() {
		Area a = new Area(100,100);
		Poblacion p = new Poblacion(a,100,10);
		Persona per = p.getEnfermas().get(1);
		p.morirPersona(per);
		assertEquals(Estados.Muerto, per.getEstado());
		assertEquals(1, p.getMuertas().size());
		assertEquals(9, p.getEnfermas().size());
		assertEquals(90, p.getSanas().size());
		
		per = p.getEnfermas().get(1);
		p.morirPersona(per);
		assertEquals(Estados.Muerto, per.getEstado());
		assertEquals(2, p.getMuertas().size());
		assertEquals(8, p.getEnfermas().size());
		assertEquals(90, p.getSanas().size());
	}

	@Test
	public void testRecuperarPersona() {
		Area a = new Area(100,100);
		Poblacion p = new Poblacion(a,100,10);
		Persona per = p.getEnfermas().get(1);
		p.recuperarPersona(per);
		assertEquals(Estados.Recuperado, per.getEstado());
		assertEquals(1, p.getRecuperadas().size());
		assertEquals(9, p.getEnfermas().size());
		assertEquals(90, p.getSanas().size());
		
		per = p.getEnfermas().get(1);
		p.recuperarPersona(per);
		assertEquals(Estados.Recuperado, per.getEstado());
		assertEquals(2, p.getRecuperadas().size());
		assertEquals(8, p.getEnfermas().size());
		assertEquals(90, p.getSanas().size());
	}

	@Test
	public void testSetMovilidad() {
		Area a = new Area(100,100);
		Poblacion p = new Poblacion(a,100,10);
		int m = 10;
		p.setMovilidad(m);
		for (Persona per: p.getSanas()) {
			assertEquals(m, per.getMovilidad());
		}
		for (Persona per: p.getEnfermas()) {
			assertEquals(m, per.getMovilidad());
		}
		for (Persona per: p.getRecuperadas()) {
			assertEquals(m, per.getMovilidad());
		}
		
		m = 0;
		p.setMovilidad(m);
		for (Persona per: p.getSanas()) {
			assertEquals(m, per.getMovilidad());
		}
		for (Persona per: p.getEnfermas()) {
			assertEquals(m, per.getMovilidad());
		}
		for (Persona per: p.getRecuperadas()) {
			assertEquals(m, per.getMovilidad());
		}
	}
	
	public void testSetMortalidad() {
		Area a = new Area(100,100);
		Poblacion p = new Poblacion(a,100,10);
		float m = (float) 0.1;
		p.setMortalidad(m);
		for (Persona per: p.getSanas()) {
			assertTrue(m== per.getMortalidad());
		}
		for (Persona per: p.getEnfermas()) {
			assertTrue(m== per.getMortalidad());
		}
		for (Persona per: p.getRecuperadas()) {
			assertTrue(m== per.getMortalidad());
		}
		
		m = (float) 0.3;
		p.setMortalidad(m);
		for (Persona per: p.getSanas()) {
			assertTrue(m== per.getMortalidad());
		}
		for (Persona per: p.getEnfermas()) {
			assertTrue(m== per.getMortalidad());
		}
		for (Persona per: p.getRecuperadas()) {
			assertTrue(m== per.getMortalidad());
		}
	}

}
