package com.ingSoft.simulador;

import static org.junit.Assert.*;

import org.junit.Test;
public class SimuladorTest {

	@Test
	public void testTodoseberianMorir() {
		Area a = new Area(10,10);
		Poblacion p= new Poblacion(a,10,10);
		Simulador s = new Simulador(a,p);
		for(Persona enferma: p.getEnfermas()) {
			enferma.setDuracionEnfermedad(0);
			enferma.setMortalidad(1);
		}
		s.morirRecuperar();
		assertEquals(0,p.getEnfermas().size());
		assertEquals(10,p.getMuertas().size());
		assertEquals(0,p.getRecuperadas().size());
	}
	
	// @Test
	// public void testTodoseberianRecuperarse() {
	// 	Area a = new Area(10,10);
	// 	Poblacion p= new Poblacion(a,10,10);
	// 	Simulador s = new Simulador(a,p);
	// 	for(Persona enferma: p.getEnfermas()) {
	// 		enferma.setDuracionEnfermedad(0);
	// 		enferma.setMortalidad(0);
	// 	}
	// 	s.morirRecuperar();
	// 	assertEquals(0,p.getEnfermas().size());
	// 	assertEquals(0,p.getMuertas().size());
	// 	assertEquals(10,p.getRecuperadas().size());
	// }

	// @Test
	// public void testTransmitirATodos() {
	// 	// fail("Not yet implemented");
	// 	Area a = new Area(10,10);
	// 	Poblacion p= new Poblacion(a,10,1);
	// 	Simulador s = new Simulador(a,p);
		
	// 	s.setRadioContagio(100);
	// 	s.transmitir();
		
	// 	assertTrue(p.getSanas().size()==0);
	// 	assertTrue(p.getEnfermas().size()==10);
	// }
	
	// @Test
	// public void testTransmitirANadie() {
	// 	// fail("Not yet implemented");
	// 	Area a = new Area(10,10);
	// 	Poblacion p= new Poblacion(a,10,1);
	// 	Simulador s = new Simulador(a,p);
		
	// 	s.setRadioContagio(5);
	// 	p.getEnfermas().get(0).getPos().setPosx(0);
	// 	p.getEnfermas().get(0).getPos().setPosy(0);
	// 	for(Persona sana: p.getSanas()) {
	// 		sana.getPos().setPosx(10);
	// 		sana.getPos().setPosy(10);
	// 	}
	// 	s.transmitir();
		
	// 	assertTrue(p.getSanas().size()==9);
	// 	assertTrue(p.getEnfermas().size()==1);
	// }

	// @Test
	// public void testEstanCerca() {
	// 	Persona p1 = new Persona();
	// 	Persona p2 = new Persona();
	// 	p1.getPos().setPosx(0);
	// 	p1.getPos().setPosy(0);

	// 	p2.getPos().setPosx(5);
	// 	p2.getPos().setPosy(0);

	// 	Simulador s = new Simulador();

	// 	s.setRadioContagio(5);
	// 	assertTrue(s.estanCerca(p1, p2));
	// 	s.setRadioContagio(100);
	// 	assertTrue(s.estanCerca(p1, p2));
	// 	s.setRadioContagio(0);
	// 	assertFalse(s.estanCerca(p1, p2));

	// }

	// @Test
	// public void testDibujar() {
	// 	// fail("Not yet implemented");
	// }

	// @Test
	// public void testGetPasoActual(){
	// 	Simulador s = new Simulador();

	// 	assertTrue(s.getPasoActual() == 0);
	// }

	// @Test
	// public void testVisor(){
	// 	Simulador s = new Simulador();
	// 	VisorSimulador v = new VisorSimulador("Test", 10, 10);

	// 	s.setVisor(v);

	// 	assertEquals(v, s.getVisor());
	// }

	// @Test
	// public void testPoblacion(){
	// 	Area a = new Area(10, 10);
	// 	Poblacion p = new Poblacion(a, 100, 20);
	// 	Simulador s = new Simulador();

	// 	s.setPoblacion(p);

	// 	assertEquals(p, s.getPoblacion());
	// }

	// @Test
	// public void testDuracionEnfermedad(){
	// 	Simulador s = new Simulador();

	// 	s.setDuracionEnfermedad(120);

	// 	assertTrue(s.getDuracionEnfermedad == 120);
	// }

	// @Test
	// public void testMovilidad(){
	// 	Simulador s = new Simulador();

	// 	s.setMovilidad(30);

	// 	assertTrue(s.getMovilidad == 30);
	// }

	// @Test
	// public void testMortalidad(){
	// 	Simulador s = new Simulador();

	// 	s.setMortalidad(0.5);

	// 	assertTrue(s.getMortalidad == 0.5);
	// }

	// @Test
	// public void testTiempoSimulacion(){
	// 	Simulador s = new Simulador();

	// 	s.setTiempoSimulacion(200);

	// 	assertTrue(s.getTiempoSimulacion() == 200);
	// }

	// @Test
	// public void testRadioContagio(){
	// 	Simulador s = new Simulador();

	// 	s.setRadioContagio(20);

	// 	assertTrue(s.getRadioContagio() == 20);
	// }
}
