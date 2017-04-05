package control;

import modelo.Casilla;
import modelo.Coordenada;
import modelo.Tablero;
import vista.UIbusqui;
import java.awt.event.ActionListener;
<<<<<<< HEAD
<<<<<<< HEAD
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
=======
>>>>>>> parent of 50ed265... nuria. banderas, bombas
=======
>>>>>>> parent of 50ed265... nuria. banderas, bombas
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

public class ParaUIBusqui extends UIbusqui {

	private Mostrador xuleta = new Mostrador();
	private Marcador marcador = new Marcador();
	private Iniciador iniciador= new Iniciador();
	private Varios auxiliar = new Varios();
<<<<<<< HEAD
<<<<<<< HEAD

	private Tablero tablero;
=======
=======
>>>>>>> parent of 50ed265... nuria. banderas, bombas
	
	private Tablero tablero;	
>>>>>>> parent of 50ed265... nuria. banderas, bombas
	private Desvelador desvelador;
	private Finalizador finalizador;
	private JButton[][] botones;

	public ParaUIBusqui() {

		crearBotones(15, 10);
<<<<<<< HEAD
<<<<<<< HEAD

	}

	MouseListener listenerRaton = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			JButton boton = (JButton) e.getSource();
			Coordenada coord = auxiliar.obtenerCoordenada(boton);
			Casilla casilla=tablero.getCasilla(coord);
			
			System.out.println(e.getButton());

<<<<<<< HEAD
			if (e.getButton() == MouseEvent.BUTTON3) {

				ImageIcon icono_bandera = new ImageIcon("bandera.gif");
				((AbstractButton) e.getSource()).setIcon(icono_bandera);
							
=======
			if (e.getButton() == MouseEvent.BUTTON3 ) {
				if (casilla.isMarcada()) {
					casilla.setMarcada(false);
					
				}else {
					casilla.setMarcada(true);
				}
>>>>>>> parent of b3146ef... Revert "nuria. Gestion bandera"

			}
			else{
				casilla.setMarcada(false);
			}
			marcador.sincronizar(botones, tablero.getCasillas());
		}
	};
	
	

=======
	}

>>>>>>> parent of 50ed265... nuria. banderas, bombas
=======
	}

>>>>>>> parent of 50ed265... nuria. banderas, bombas
	ActionListener listener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
<<<<<<< HEAD

=======
			//marcador.marcarCasilla((JButton) e.getSource(), tablero);
			
>>>>>>> parent of 50ed265... nuria. banderas, bombas
=======
			//marcador.marcarCasilla((JButton) e.getSource(), tablero);
			
>>>>>>> parent of 50ed265... nuria. banderas, bombas
			JButton boton = (JButton) e.getSource();
			Coordenada coord = auxiliar.obtenerCoordenada(boton);
			Casilla casilla=tablero.getCasilla(coord);
			casilla.setMarcada(false);
			desvelador.desvelarCasillas(coord.getX(), coord.getY());
			marcador.sincronizar(botones, tablero.getCasillas());
			
			int estado = finalizador.estado();
			switch (estado) {
			case Finalizador.GANADO:
<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> parent of 50ed265... nuria. banderas, bombas
=======
>>>>>>> parent of 50ed265... nuria. banderas, bombas
				JOptionPane.showMessageDialog(null, "De puretita suerte");

				try {
					AudioInputStream audioInputStream = AudioSystem
							.getAudioInputStream(new File("ganar.wav").getAbsoluteFile());
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				} catch (Exception ex) {
					System.out.println("Error with playing sound.");
					ex.printStackTrace();
				}

				fin();
				break;
			
			case Finalizador.PERDIDO:
				JOptionPane.showMessageDialog(null, "Un mojjjjjjoooon pa ti");
<<<<<<< HEAD
<<<<<<< HEAD
				try {

					AudioInputStream audioInputStream = AudioSystem
							.getAudioInputStream(new File("perder.wav").getAbsoluteFile());
					Clip clip = AudioSystem.getClip();
					clip.open(audioInputStream);
					clip.start();
				} catch (Exception ex) {
					System.out.println("Error with playing sound.");
					ex.printStackTrace();
				}

=======
>>>>>>> parent of 50ed265... nuria. banderas, bombas
=======
>>>>>>> parent of 50ed265... nuria. banderas, bombas
				fin();
				break;
			}
		}
	};

	public void crearBotones(int ancho, int alto) {
<<<<<<< HEAD
		tablero = iniciador.crearTablero(ancho, alto, 5);
		desvelador = new Desvelador(tablero);
		botones = new JButton[alto][ancho];
=======
		tablero = iniciador.crearTablero(ancho, alto, 20);
	
		desvelador = new Desvelador(tablero);
		botones = new JButton[alto][ancho];
		
<<<<<<< HEAD
>>>>>>> parent of 50ed265... nuria. banderas, bombas
=======
>>>>>>> parent of 50ed265... nuria. banderas, bombas
		finalizador = new Finalizador(tablero);
		
		panelBotones.setLayout(new GridLayout(0, ancho, 0, 0));

		for (int i = 0; i < alto; i++) {
			for (int j = 0; j < ancho; j++) {
				botones[i][j] = new JButton("");
				botones[i][j].addActionListener(listener);
				botones[i][j].setActionCommand(i + "," + j);
				panelBotones.add(botones[i][j]);

			}

		}
		xuleta.imprimir(tablero);
	}
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======


>>>>>>> parent of b3146ef... Revert "nuria. Gestion bandera"

	protected void fin() {

=======
=======
>>>>>>> parent of 50ed265... nuria. banderas, bombas

	protected void fin() {
		for (JButton[] jButtons : botones) {
			for (JButton jButton : jButtons) {
				jButton.setEnabled(false);
			}
		}
<<<<<<< HEAD
>>>>>>> parent of 50ed265... nuria. banderas, bombas
=======
>>>>>>> parent of 50ed265... nuria. banderas, bombas
		for (Casilla[] fila : tablero.getCasillas()) {
			for (Casilla casilla : fila) {
				casilla.setVelada(false);
			}
		}
		marcador.sincronizar(botones, tablero.getCasillas());
	}
<<<<<<< HEAD
	
=======
>>>>>>> parent of b3146ef... Revert "nuria. Gestion bandera"

}
