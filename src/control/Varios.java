package control;
import javax.swing.JButton;
import modelo.Coordenada;

public class Varios {

	public Coordenada obtenerCoordenada(JButton boton){
		
		String actionCommand = boton.getActionCommand();
		String[] coords = actionCommand.split(",");
		if(coords.length > 1){
			return new Coordenada( Integer.parseInt(coords[0]) , Integer.parseInt(coords[1]) );
		}
		return new Coordenada( -1 , -1 );
	}
}
