package control;

import modelo.Casilla;
import modelo.Tablero;

public class Finalizador {
	public static final int GANADO = 1;
	public static final int PERDIDO = 2;
	public static final int EN_CURSO = 3;

	private final Casilla[][] casillas;
	

	public Finalizador(Tablero talerone) {
		super();
		this.casillas = talerone.getCasillas();
	}

	public int estado() {
		if (haPerdido()) {
			return PERDIDO;
		} else if (casillasVeladas()) {
			return EN_CURSO;
		}
		return GANADO;
	}

	private boolean haPerdido() {
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				Casilla casilla = casillas[i][j];
				if (!casilla.isVelada() && casilla.isMinas()) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean casillasVeladas() {
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				Casilla casilla = casillas[i][j];
				if (casilla.isVelada() && !casilla.isMinas()) {
					return true;
				}
			}
		}
		return false;
	}
}
