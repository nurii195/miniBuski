<<<<<<< HEAD
package control;

=======
package control;
>>>>>>> parent of b3146ef... Revert "nuria. Gestion bandera"
import modelo.Casilla;
import modelo.Tablero;

public class Iniciador {

	public Tablero crearTablero(int ancho, int alto, int minas) {
		
		if(ancho <= 0 || alto <= 0 || minas > (ancho*alto)){
			throw new IllegalArgumentException("ancho <= 0 || alto <= 0 || minas > (ancho*alto)");
		}
		
		Tablero tablero = new Tablero(alto, ancho);
		ponerMinas(minas, tablero);
		contarMinas(tablero);

		return tablero;

	}

	private void ponerMinas(int minas, Tablero tablero) {
		Casilla[][] casillas = tablero.getCasillas();
		int contador = 0;

		while (contador < minas) {
			int posicionX = (int) (Math.random() * casillas[0].length);
			int posicionY = (int) (Math.random() * casillas.length);

			Casilla casilla = casillas[posicionY][posicionX];

			boolean minita = casilla.isMinas();

			if (!minita) {
				casilla.setMinas(true);
				contador++;
				
			}

		}
		
	}

	private int contarMinarAlrededor(int filas, int columnas, Casilla[][] casillas) {
				int contador = 0;

		for (int i = filas - 1; i <= filas + 1; i++) {
			for (int j = columnas - 1; j <= columnas + 1; j++) {

				if(dentroDelimites(i,j,casillas)) {
					Casilla casilla = casillas[i][j];
					if (casilla.isMinas() && (filas != i || columnas != j) ) {

						contador++;	

					} 
				}
				
			}

		}
		
		return contador;

	}

	private boolean dentroDelimites(int fila, int columna, Casilla[][] casillas) {
		return fila >= 0 && fila < casillas.length && columna >= 0 && columna < casillas[fila].length;
	}

	private void contarMinas(Tablero tablero) {
		Casilla[][] casillas = tablero.getCasillas();

		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {

				Casilla casilla = casillas[i][j];
				int minarAlrededor = contarMinarAlrededor(i, j, casillas);
				casilla.setMinasAlrededor(minarAlrededor);

			}
		}

	}
	
}
