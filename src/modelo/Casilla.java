package modelo;

public class Casilla {
	private boolean velada = true;
	private boolean marcada = false;
	private boolean minas = false;
	private int minasAlrededor = 0;

	public boolean isVelada() {
		return velada;
	}

	public void setVelada(boolean velada) {
		this.velada = velada;
	}

	public boolean isMarcada() {
		return marcada;
	}

	public void setMarcada(boolean marcada) {
		this.marcada = marcada;
	}

	public boolean isMinas() {
		return minas;
	}

	public void setMinas(boolean minas) {
		this.minas = minas;
	}

	public int getMinasAlrededor() {
		return minasAlrededor;
	}

	public void setMinasAlrededor(int minasAlrededor) {
		this.minasAlrededor = minasAlrededor;
	}

	@Override
	public String toString() {
		
		String resultado="*";
		
		if (isVelada()) {
			resultado="["+minasAlrededor+"]";
		}else{
			resultado=""+minasAlrededor;
		}
		
		if (isMinas() && isVelada()) {
			resultado= "[X]";
			
		}else if (isMinas()) {
			resultado= "X";
		}
		
		return resultado;
	}
	
	
}
