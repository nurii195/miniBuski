package control;

import modelo.Casilla;
import modelo.Tablero;

public class Mostrador {
	
	public void imprimir(Tablero tablero){
		
		Casilla[][] casillas = tablero.getCasillas();
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[0].length; j++) {
				System.out.print(casillas[i][j]+"\t");
				
			}
			System.out.println();
		}
		System.out.println("\n");
	}
}
