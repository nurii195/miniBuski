package test;

import static org.junit.Assert.*;

import org.junit.Test;

import control.Desvelador;
import modelo.Casilla;
import modelo.Coordenada;
import modelo.Tablero;

public class DesveladorTest {

	@Test
	public void testDesvelarCasillas() {
		Coordenada coord=new Coordenada(0, 0);
		Tablero instancia=new Tablero(3, 3);
		Casilla[][] casillas = instancia.getCasillas();
		Desvelador desvelador=new Desvelador(instancia);
	
		
		
		desvelador.desvelarCasillas(coord.getX(), coord.getY());
	}

}
