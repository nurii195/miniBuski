package control;

import modelo.Casilla;
import modelo.Coordenada;
import modelo.Tablero;
import vista.UIbusqui;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

public class ParaUIBusqui extends UIbusqui {

	private Mostrador xuleta = new Mostrador();
	private Marcador marcador = new Marcador();
	private Iniciador iniciador= new Iniciador();
	private Varios auxiliar = new Varios();
	
	private Tablero tablero;	
	private Desvelador desvelador;
	private Finalizador finalizador;
	private JButton[][] botones;

	public ParaUIBusqui() {

		crearBotones(15, 10);
	}

	ActionListener listener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			//marcador.marcarCasilla((JButton) e.getSource(), tablero);
			
			JButton boton = (JButton) e.getSource();
			Coordenada coord = auxiliar.obtenerCoordenada(boton);
			desvelador.desvelarCasillas(coord.getX(), coord.getY());
			marcador.sincronizar(botones, tablero.getCasillas());
			
			int estado = finalizador.estado();
			switch (estado) {
			case Finalizador.GANADO:
				JOptionPane.showMessageDialog(null, "De puretita suerte");
				fin();
				break;
			
			case Finalizador.PERDIDO:
				JOptionPane.showMessageDialog(null, "Un mojjjjjjoooon pa ti");
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
				panelBotones.add(botones[i][j]);
			}

		}
		xuleta.imprimir(tablero);
	}

	protected void fin() {
		for (JButton[] jButtons : botones) {
			for (JButton jButton : jButtons) {
				jButton.setEnabled(false);
			}
		}
		for (Casilla[] fila : tablero.getCasillas()) {
			for (Casilla casilla : fila) {
				casilla.setVelada(false);
			}
		}
		marcador.sincronizar(botones, tablero.getCasillas());
	}
}
