package control;

import modelo.Casilla;
import modelo.Tablero;

public class Desvelador {
	
	//sto es una prueba del gato
	//hata el moño de esto

	private Casilla casillas[][];

	public Desvelador(Tablero tablero) {
		super();
		this.casillas = tablero.getCasillas();
	}

	public void desvelarCasillas(int filas, int columnas) {

		Casilla casilla = casillas[filas][columnas];

		casilla.setVelada(false);

		if (casilla.getMinasAlrededor() == 0 && !casilla.isMinas()) {

			for (int i = filas - 1; i <= filas + 1; i++) {
				for (int j = columnas - 1; j <= columnas + 1; j++) {

					if (dentroDelimites(i, j, casillas)) {
						Casilla casillita = casillas[i][j];
						if (casillita.isVelada()) {
							desvelarCasillas(i, j);
						} 
					}

				}

			}
		}

	}

	private boolean dentroDelimites(int fila, int columna, Casilla[][] casillas) {
		return fila >= 0 && fila < casillas.length && columna >= 0 && columna < casillas[fila].length;
	}
}
