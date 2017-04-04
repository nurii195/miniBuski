package control;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import modelo.Casilla;


public class Marcador {
	
	public void sincronizar(JButton[][] botones, Casilla[][] casillas) {
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[0].length; j++) {
				Casilla casilla = casillas[i][j];
				JButton boton = botones[i][j];
				marcarBoton(boton, casilla);
				darColor(boton, casilla);
				
			}
		}
	}

	private void marcarBoton(JButton boton, Casilla casilla) {
		
		if(casilla.isVelada()){
			boton.setText("");
			
		}
		else{
			
			if(casilla.isMinas()){

				ImageIcon icono_bomba=new ImageIcon("bombita2.gif");
				boton.setIcon(icono_bomba);
				boton.setBackground(Color.WHITE);
		
		
			}
			else if(casilla.getMinasAlrededor() > 0){
		
				boton.setText(String.valueOf(casilla.getMinasAlrededor()));
				
			}
			else{
				boton.setBackground(Color.CYAN);
			}
		}
		
	}
	
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
		default:
			boton.setBackground(Color.CYAN);
			break;
		}
	}
	 
}
