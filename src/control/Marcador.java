package control;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import modelo.Casilla;
import modelo.Coordenada;
import modelo.Tablero;

public class Marcador {

//	public void marcarCasilla(JButton boton,Tablero tablero) {
//		Coordenada coordenada=new Varios().obtenerCoordenada(boton);
//		Casilla casillaActual=tablero.getCasilla(coordenada);
//		if(casillaActual.isVelada()){
//			casillaActual.setMarcada(!casillaActual.isMarcada());
//			if(casillaActual.isMarcada()){
//				boton.setText(coordenada.toString());
//			}
//			else{
//				boton.setText("");
//			}
//		}
//	}
	
	public void sincronizar(JButton[][] botones, Casilla[][] casillas) {
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[0].length; j++) {
				Casilla casilla = casillas[i][j];
				JButton boton = botones[i][j];
				marcarBoton(boton, casilla);
			}
		}
	}

	private void marcarBoton(JButton boton, Casilla casilla) {
		
		if(casilla.isVelada()){
			boton.setText("");
			
		}
		else{
			//boton.setEnabled(false);
			if(casilla.isMinas()){
		
				ImageIcon icono_bomba=new ImageIcon("bomba1_32.png");
				boton.setIcon(icono_bomba);
				boton.setBackground(Color.RED);
			}
			else if(casilla.getMinasAlrededor() > 0){
				boton.setText(String.valueOf(casilla.getMinasAlrededor()));
			}
			else{
				boton.setText("agüita");
				boton.setBackground(Color.BLUE);
			}
		}
		
	}
	 
}
