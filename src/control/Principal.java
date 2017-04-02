package control;

import java.awt.EventQueue;

import vista.UIbusqui;

public class Principal {
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParaUIBusqui frame = new ParaUIBusqui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
