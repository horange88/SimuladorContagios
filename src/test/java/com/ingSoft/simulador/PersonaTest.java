package com.ingSoft.simulador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonaTest {

	@Test
	void testVelocidadCalculaaDebeSerCero() {
		Area a = new Area(100,100);
		Persona p = new Persona(a);
		p.calcularVelocidad();
		assertEquals(0, p.getVel().getVelx(), "La velocidad debe ser 0");
		assertEquals(0, p.getVel().getVely(), "La velocidad debe ser 0");
	}
	
	void testVelocidadCalculadaDebeCumplirLimites() {
		Area a = new Area(100,100);
		Persona p = new Persona(a);
		int m =10;
		p.setMovilidad(m);
		
		for(int i=0;i<100;i++) {
			p.calcularVelocidad();
			assertTrue(p.getVel().getVelx()<=m);
			assertTrue(p.getVel().getVelx()>=-m);
			assertTrue(p.getVel().getVely()<=m);
			assertTrue(p.getVel().getVely()>=-m);
		}
	}

	@Test
	void testMover() {
		Area a = new Area(100,100);
		Persona p = new Persona(a);
		p.getPos().setPosx(0);
		p.getPos().setPosy(0);
		p.getVel().setVelx(15);
		p.getVel().setVely(10);
		p.mover();
		
		assertEquals(15, p.getPos().getPosx(), "La posición x debe ser 15");
		assertEquals(10, p.getPos().getPosy(), "La posición y debe ser 10");

	}
	
	@Test
	void testNoExcederLimitesArea() {
		Area a = new Area(100,100);
		Persona p = new Persona(a);
		p.getPos().setPosx(10);
		p.getPos().setPosy(0);
		p.getVel().setVelx(-15);
		p.getVel().setVely(-10);
		p.mover();
		
		assertEquals(10, p.getPos().getPosx(), "La posición x debe ser 10");
		assertEquals(0, p.getPos().getPosy(), "La posición y debe ser 0");
		
		p.getPos().setPosx(95);
		p.getPos().setPosy(97);
		p.getVel().setVelx(15);
		p.getVel().setVely(10);
		p.mover();
		
		assertEquals(95, p.getPos().getPosx(), "La posición x debe ser 95");
		assertEquals(97, p.getPos().getPosy(), "La posición y debe ser 97");

	}

	@Test
	void testEnfermar() {
		Persona p = new Persona();
		p.enfermar();
		assertEquals(Estados.Enfermo, p.getEstado(), "La persona debe enfermar");
		
	}

	@Test
	void testEvolucionarEnfermedad() {
		Persona p = new Persona();
		p.setDuracionEnfermedad(100);
		p.evolucionarEnfermedad();
		assertTrue(99 == p.getDuracionEnfermedad());
		
		p.setDuracionEnfermedad(16);
		p.evolucionarEnfermedad();
		assertTrue(15 == p.getDuracionEnfermedad());
	}
	
	@Test
	void testEvolucionarEnfermedadNoDeberiaSerNegativo() {
		Persona p = new Persona();
		p.setDuracionEnfermedad(0);
		p.evolucionarEnfermedad();
		assertTrue(0 == p.getDuracionEnfermedad());
	}

	@Test
	void testFinEnfermedad() {
		Persona p = new Persona();
		p.setDuracionEnfermedad(10);
		assertFalse(p.finEnfermedad());
		p.setDuracionEnfermedad(0);
		assertTrue(p.finEnfermedad());
	}

	@Test
	void testRecuperar() {
		Persona p = new Persona();
		p.recuperar();
		assertEquals(Estados.Recuperado, p.getEstado(), "La persona debe recuperarse");
	}

	@Test
	void testMorir() {
		Persona p = new Persona();
		p.morir();
		assertEquals(Estados.Muerto, p.getEstado(), "La persona debe recuperarse");
	}

	@Test
	void testDebeMorir() {
		Persona p = new Persona();
		p.setMortalidad(1);
		for(int i=0;i<100;i++) {
			assertTrue(p.debeMorir());
		}
		p.setMortalidad(0);
		for(int i=0;i<100;i++) {
			assertFalse(p.debeMorir());
		}
	}
}
