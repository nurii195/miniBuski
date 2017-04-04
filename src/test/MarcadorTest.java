package test;

import static org.junit.Assert.*;
import javax.swing.JButton;
import org.junit.Test;
import control.Marcador;
import modelo.Casilla;
import modelo.Tablero;

public class MarcadorTest {


	@Test
	public void testSincronizar() {
		
		Tablero instancia=new Tablero(3, 3);
		Casilla[][] casillas = instancia.getCasillas();
		JButton botones[][]=new JButton[3][3];
		
		casillas[0][0].setMinas(true);
		casillas[0][0].setVelada(false);
		casillas[0][1].setMinasAlrededor(1);
		casillas[1][0].setMinasAlrededor(1);
		casillas[1][1].setMinasAlrededor(1);
		
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[i].length; j++) {
				botones[i][j]= new JButton();
			}
		}
		
		Marcador marcador = new Marcador();
		marcador.sincronizar(botones, casillas);
		
		for (JButton[] jButtons : botones) {
			for (JButton jButton : jButtons) {
				assertTrue(jButton.isEnabled());
				
			}
		}
		
	}

}
