package test;

import static org.junit.Assert.*;

import org.junit.Test;

import control.Iniciador;
import modelo.Casilla;
import modelo.Tablero;

public class IniciadorTest {

	@Test
	public void testCrearTablero1x1() {
		
		Iniciador instancia= new Iniciador();
		
		Tablero tablero1x1 = instancia.crearTablero(1, 1, 1);	
		
		
		assertNotNull(tablero1x1);
		
		
		Casilla[][] casillas = tablero1x1.getCasillas();
		assertNotNull(casillas);
		
		assertEquals(1, casillas.length);
		assertEquals(1, casillas[0].length);
		
		Casilla casilla = casillas[0][0];
		
		assertNotNull(casilla);
		assertTrue(casilla.isMinas());
		assertTrue(casilla.isVelada());
		assertFalse(casilla.isMarcada());
	}
	
	@Test
	public void testCrearTableroMenos1x1() {
		
		Iniciador instancia= new Iniciador();
		try {
			Tablero tablero1x1 = instancia.crearTablero(0, 1, 1);	
			fail();
		} catch (Exception e) {
			// expected
		}
	}

	@Test
	public void testCrearTablero1x1MinasdeMas() {
		
		Iniciador instancia= new Iniciador();
		try {
			Tablero tablero1x1 = instancia.crearTablero(1, 1, 2);
			fail("Minas > alto * ancho");
		} catch (Exception e) {
			//Expected
		}
		 
	}
	
	@Test
	public void testCrearTablero2x3() {
		
		Iniciador instancia= new Iniciador();
		
		Tablero tablero1x1 = instancia.crearTablero(2, 3, 2);	
		
		
		assertNotNull(tablero1x1);
		
		
		Casilla[][] casillas = tablero1x1.getCasillas();
		assertNotNull(casillas);
		
		assertEquals(3, casillas.length);
		assertEquals(2, casillas[0].length);
		
		int minas = 0;
		for (Casilla[] fila : casillas) {
			for (Casilla casilla : fila) {
				assertNotNull(casilla);
				assertTrue(casilla.isVelada());
				assertFalse(casilla.isMarcada());
				if (casilla.isMinas()) {
					minas++;
				}
			}
		}
		assertEquals(2, minas);
	}
}
