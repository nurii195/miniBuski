package test;

import static org.junit.Assert.*;

import org.junit.Test;

import control.Desvelador;
import control.Iniciador;
import modelo.Casilla;
import modelo.Coordenada;
import modelo.Tablero;

public class DesveladorTest {

	@Test
	public void testDesvelarCasillas() {
		
		Coordenada coord=new Coordenada(0, 0);
		Casilla casilla=new Casilla();
		
		
		Iniciador iniciador=new Iniciador();
		Tablero tablero = iniciador.crearTablero(3, 3, 2);
		Desvelador desvelar=new Desvelador(tablero);
		
		int minasAlrededor = casilla.getMinasAlrededor();
		casilla.setMinas(true);
			
		//desvelar.desvelarCasillas(coord.getX(), coord.getY());
		
		assertEquals(minasAlrededor, 0);

	
	}

}
