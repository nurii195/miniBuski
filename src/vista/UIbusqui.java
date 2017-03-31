package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridLayout;

public class UIbusqui extends JFrame {

	protected JPanel contentPane;
	protected JPanel panelBotones;
	


	public UIbusqui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblBuscaminuquis = new JLabel("Buscaminuquis");
		lblBuscaminuquis.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblBuscaminuquis, BorderLayout.NORTH);
		
		panelBotones = new JPanel();
		contentPane.add(panelBotones, BorderLayout.CENTER);
		
	}

}
