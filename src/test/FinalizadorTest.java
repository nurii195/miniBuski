package test;

import static org.junit.Assert.*;

import org.junit.Test;

import control.Finalizador;
import modelo.Casilla;
import modelo.Tablero;

public class FinalizadorTest {

	@Test
	public void testEstadoCurso() {
		Tablero tablero = new Tablero(3, 3);
		Casilla[][] casillas = tablero.getCasillas();
		casillas[0][0].setMinas(true);
		casillas[0][1].setVelada(false);
		Finalizador instancia = new Finalizador(tablero);

		int estado = instancia.estado();
		assertEquals(Finalizador.EN_CURSO, estado);

	}

	@Test
	public void testEstadoPerdido() {
		Tablero tablero = new Tablero(3, 3);
		Casilla[][] casillas = tablero.getCasillas();
		casillas[0][0].setMinas(true);
		casillas[0][0].setVelada(false);
		Finalizador instancia = new Finalizador(tablero);

		int estado = instancia.estado();
		assertEquals(Finalizador.PERDIDO, estado);

	}

	@Test
	public void testEstadoGanado() {
		Tablero tablero = new Tablero(3, 3);
		Casilla[][] casillas = tablero.getCasillas();
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[0].length; j++) {
				Casilla casilla = casillas[i][j];
				casilla.setVelada(false);
			}
		}

		casillas[0][0].setMinas(true);
		casillas[0][0].setVelada(true);
		Finalizador instancia = new Finalizador(tablero);

		int estado = instancia.estado();
		assertEquals(Finalizador.GANADO, estado);

	}

}
