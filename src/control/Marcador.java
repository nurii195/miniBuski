package control;
<<<<<<< HEAD
<<<<<<< HEAD

import java.awt.Color;
import java.awt.Font;
=======

import java.awt.Color;
import java.awt.Font;

import javax.swing.AbstractButton;
>>>>>>> parent of b3146ef... Revert "nuria. Gestion bandera"
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
=======

import java.awt.Color;
import java.time.temporal.JulianFields;

import javax.swing.JButton;

>>>>>>> parent of 50ed265... nuria. banderas, bombas
import modelo.Casilla;
<<<<<<< HEAD
=======
import modelo.Tablero;
>>>>>>> parent of b3146ef... Revert "nuria. Gestion bandera"

public class Marcador {

<<<<<<< HEAD
=======
	public void marcarCasilla(JButton boton,Tablero tablero) {
		Coordenada coordenada=new Varios().obtenerCoordenada(boton);
		Casilla casillaActual=tablero.getCasilla(coordenada);
		if(casillaActual.isVelada()){
			casillaActual.setMarcada(!casillaActual.isMarcada());
			if(casillaActual.isMarcada()){
				boton.setText(coordenada.toString());
			}
			else{
				boton.setText("");
			}
		}
	}
	
>>>>>>> parent of 50ed265... nuria. banderas, bombas
	public void sincronizar(JButton[][] botones, Casilla[][] casillas) {
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[0].length; j++) {
				Casilla casilla = casillas[i][j];
				JButton boton = botones[i][j];
				marcarBoton(boton, casilla);
<<<<<<< HEAD
				darColor(boton, casilla);
=======
>>>>>>> parent of 50ed265... nuria. banderas, bombas
			}
		}
	}

	private void marcarBoton(JButton boton, Casilla casilla) {

<<<<<<< HEAD
		if (casilla.isVelada()) {
			boton.setText("");

=======
		if(!casilla.isMarcada())
			boton.setIcon(null);
		
		if (casilla.isVelada()) {
			boton.setText("");
<<<<<<< HEAD
			if (casilla.isMarcada()) {
				ImageIcon icono_bandera = new ImageIcon("bandera.gif");
				boton.setIcon(icono_bandera);
				
=======
		}
		else{
			//boton.setEnabled(false);
			if(casilla.isMinas()){
				boton.setText("Moj");
				boton.setForeground(Color.BLACK);
				boton.setBackground(Color.RED);
>>>>>>> parent of 50ed265... nuria. banderas, bombas
			}
>>>>>>> parent of b3146ef... Revert "nuria. Gestion bandera"
		} else {

			if (casilla.isMinas()) {

				ImageIcon icono_bomba = new ImageIcon("bombita2.gif");
				boton.setIcon(icono_bomba);
				boton.setBackground(Color.WHITE);

			} else if (casilla.getMinasAlrededor() > 0) {

				boton.setText(String.valueOf(casilla.getMinasAlrededor()));
<<<<<<< HEAD
				boton.setBackground(Color.WHITE);
			} else {
				boton.setBackground(Color.CYAN);
=======
			}
			else{
				boton.setText("agüita");
				boton.setBackground(Color.BLUE);
>>>>>>> parent of 50ed265... nuria. banderas, bombas
			}
		}

	}
<<<<<<< HEAD

	private void darColor(JButton boton, Casilla casilla) {

		boton.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		boton.setHorizontalAlignment(SwingConstants.CENTER);
		switch (casilla.getMinasAlrededor()) {
		case 1:
			boton.setForeground(Color.BLUE);
			break;
		case 2:
			boton.setForeground(Color.YELLOW);
			break;
		case 3:
			boton.setForeground(Color.RED);
			break;
		case 4:
			boton.setForeground(Color.PINK);
			break;
		case 5:
			boton.setForeground(Color.ORANGE);
			break;
		case 6:
			boton.setForeground(Color.BLACK);
			break;
		case 7:
			boton.setForeground(Color.GREEN);
			break;

		}
	}

=======
>>>>>>> parent of 50ed265... nuria. banderas, bombas
}
