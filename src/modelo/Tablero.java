package modelo;

public class Tablero {
	private Casilla[][] casillas;

	public Tablero(int filas, int columnas) {
		super();
		generarTablero(filas, columnas);
	}

	public Tablero(int cuadrada) {
		this(cuadrada, cuadrada);
	}

	private void generarTablero(int filas, int columnas) {
		casillas = new Casilla[filas][columnas];
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				casillas[i][j] = new Casilla();
			}
		}
	}

	public Casilla[][] getCasillas() {
		return casillas;
	}

	private void setCasillas(Casilla[][] casillas) {
		this.casillas = casillas;
	}

	public Casilla getCasilla(Coordenada coordenada) {
		return casillas[coordenada.getX()][coordenada.getY()];
	}
	

}
