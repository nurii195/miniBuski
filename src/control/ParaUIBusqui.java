package control;

import modelo.Casilla;
import modelo.Coordenada;
import modelo.Tablero;
import vista.UIbusqui;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

public class ParaUIBusqui extends UIbusqui {

	private Mostrador xuleta = new Mostrador();
	private Marcador marcador = new Marcador();
	private Iniciador iniciador = new Iniciador();
	private Varios auxiliar = new Varios();

	private Tablero tablero;
	private Desvelador desvelador;
	private Finalizador finalizador;
	private JButton[][] botones;

	public ParaUIBusqui() {

		crearBotones(15, 10);
	}

	MouseListener listenerRaton = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println(e.getButton());

			if (e.getButton() == MouseEvent.BUTTON3) {
				ImageIcon icono_bomba = new ImageIcon("tablero1_18_bandera.png");
				((AbstractButton) e.getSource()).setIcon(icono_bomba);

			}
		}
	};

	ActionListener listener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			JButton boton = (JButton) e.getSource();
			Coordenada coord = auxiliar.obtenerCoordenada(boton);
			desvelador.desvelarCasillas(coord.getX(), coord.getY());
			marcador.sincronizar(botones, tablero.getCasillas());

			int estado = finalizador.estado();
			switch (estado) {
			case Finalizador.GANADO:
				JOptionPane.showMessageDialog(null, "De puretita suerte");
				
				 try {
				        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("ganar.wav").getAbsoluteFile());
				        Clip clip = AudioSystem.getClip();
				        clip.open(audioInputStream);
				        clip.start();
				    } catch(Exception ex) {
				        System.out.println("Error with playing sound.");
				        ex.printStackTrace();
				    }
				
				
				fin();
				break;

			case Finalizador.PERDIDO:
				JOptionPane.showMessageDialog(null, "Un mojjjjjjoooon pa ti");
				 try {
					 
				        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("perder.wav").getAbsoluteFile());
				        Clip clip = AudioSystem.getClip();
				        clip.open(audioInputStream);
				        clip.start();
				    } catch(Exception ex) {
				        System.out.println("Error with playing sound.");
				        ex.printStackTrace();
				    } 
				 
				fin();
				break;
			}
		}
	};

	public void crearBotones(int ancho, int alto) {
		tablero = iniciador.crearTablero(ancho, alto, 20);

		desvelador = new Desvelador(tablero);
		botones = new JButton[alto][ancho];

		finalizador = new Finalizador(tablero);

		panelBotones.setLayout(new GridLayout(0, ancho, 0, 0));

		for (int i = 0; i < alto; i++) {
			for (int j = 0; j < ancho; j++) {
				botones[i][j] = new JButton("");
				botones[i][j].addActionListener(listener);
				botones[i][j].setActionCommand(i + "," + j);
				botones[i][j].addMouseListener(listenerRaton);
				panelBotones.add(botones[i][j]);
			}

		}
		xuleta.imprimir(tablero);
	}
	

	protected void fin() {
//		for (JButton[] jButtons : botones) {
//			for (JButton jButton : jButtons) {
//				//jButton.setEnabled(false);
//			}
//		}
		for (Casilla[] fila : tablero.getCasillas()) {
			for (Casilla casilla : fila) {
				casilla.setVelada(false);
			}
		}
		marcador.sincronizar(botones, tablero.getCasillas());
	}
}
