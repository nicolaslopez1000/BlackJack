package bljk;

public class Jugador {

	private double dineroJugador;

	public double getDineroJugador() {
		return dineroJugador;
	}

	public void setDineroJugador(double dineroJugador) {
		this.dineroJugador = dineroJugador;
	}

	public Mazo mazoJugador;

	public Mazo getMazoJugador() {
		return mazoJugador;
	}

	public void setMazoJugador(Mazo mazoJugador) {
		this.mazoJugador = mazoJugador;
	}

	public String getNombreJugador() {
		return nombreJugador;
	}

	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}

	private String nombreJugador;

}
