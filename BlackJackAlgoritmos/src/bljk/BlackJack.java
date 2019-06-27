package bljk;

import java.util.Scanner;

public class BlackJack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Bienvendio a BlackJack");

		Mazo mazo = new Mazo();
		mazo.crearMazo();
		mazo.abarajar();

		Scanner inputUsuario = new Scanner(System.in);

		Jugador dealer = new Jugador();
		Jugador jugador = new Jugador();
		jugador.mazoJugador = new Mazo();
		dealer.mazoJugador = new Mazo();
		jugador.setDineroJugador(100.00);

		while (jugador.getDineroJugador() > 0) {

			System.out.println("Tienes $" + jugador.getDineroJugador() + " ¿Cuanto deseas apostar?");
			double apuesta = 0;
			boolean finRonda = false;
			apuesta = inputUsuario.nextDouble();

			while (apuesta > jugador.getDineroJugador()) {
				if (apuesta > jugador.getDineroJugador()) {
					System.out.println("No tiene esa cantidad de dinero , seleccione una cantidad accesible");
				}
				apuesta = inputUsuario.nextDouble();
			}

			jugador.mazoJugador.robarCarta(mazo);
			jugador.mazoJugador.robarCarta(mazo);

			dealer.mazoJugador.robarCarta(mazo);
			dealer.mazoJugador.robarCarta(mazo);

			while (true) {

				System.out.println("Tu mano es: " + jugador.mazoJugador.toString());
				System.out.println("El valor de la misma es:" + jugador.mazoJugador.valorMazo());

				System.out.println(
						"Mano del dealer: " + dealer.mazoJugador.getCarta(0).toString() + "  Otra carta: escondida");

				if (jugador.mazoJugador.valorMazo() < 21) {

					System.out.println("Te gustaria: \n 1-Pedir \n 2-Plantarse");
					int respuesta = inputUsuario.nextInt();

					while (respuesta == 1) {

						jugador.mazoJugador.robarCarta(mazo);
						System.out.println("Has robado:"
								+ jugador.mazoJugador.getCarta(jugador.mazoJugador.tamañoMazo() - 1).toString());
						System.out.println("El valor de tu mano actualmente es:" + jugador.mazoJugador.valorMazo());
						if (jugador.mazoJugador.valorMazo() > 21) {
							System.out.println("El valor de tu mazo supera los 21 , pierdes el dinero de tu apuesta");

							jugador.setDineroJugador(jugador.getDineroJugador() - apuesta);

							finRonda = true;
							break;
						}
						if (jugador.mazoJugador.valorMazo() == 21) {

							System.out.println("Te has plantado automaticamente, felicitaciones , tienes 21");
							break;
						}
						System.out.println("Te gustaria: \n 1-Pedir \n 2-Plantarse");
						respuesta = inputUsuario.nextInt();

					}
					if (respuesta == 2) {
						break;
					}
					break;
				}
				if (jugador.mazoJugador.valorMazo() == 21) {

					System.out.println("Te has plantado automaticamente, felicitaciones , tienes 21");
					break;
				}

			}

			System.out.println("Cartas del dealer:" + dealer.mazoJugador.toString());
			if (dealer.mazoJugador.valorMazo() > jugador.mazoJugador.valorMazo() && finRonda == false) {
				System.out.println("La mano del dealer es:" + dealer.mazoJugador.valorMazo());
				System.out.println("El dealer te ha ganado");
				jugador.setDineroJugador(jugador.getDineroJugador() - apuesta);
				break;
			}

			while ((dealer.mazoJugador.valorMazo() < 17) && finRonda == false) {

				dealer.mazoJugador.robarCarta(mazo);
				System.out.println("El dealer ha pedido una carta :"
						+ dealer.mazoJugador.getCarta(dealer.mazoJugador.tamañoMazo() - 1).toString());

			}
			System.out.println("La mano del dealer es:" + dealer.mazoJugador.valorMazo());
			if (dealer.mazoJugador.valorMazo() > 21 && finRonda == false) {
				System.out.println("El dealer se ha pasado, ganaste tu apuesta");
				jugador.setDineroJugador(jugador.getDineroJugador() + apuesta);
				finRonda = true;
			}

			if (dealer.mazoJugador.valorMazo() == jugador.mazoJugador.valorMazo() && finRonda == false) {

				System.out.println("Han empatado, se devuelve el valor de la apuesta");
				finRonda = true;
			}

			if (dealer.mazoJugador.valorMazo() > jugador.mazoJugador.valorMazo() && finRonda == false) {

				System.out.println("Ha ganado el dealer, pierdes el valor de la apuesta");
				jugador.setDineroJugador(jugador.getDineroJugador() - apuesta);
				finRonda = true;
			}

			if (dealer.mazoJugador.valorMazo() < jugador.mazoJugador.valorMazo() && finRonda == false) {

				System.out.println("Haz ganado, se duplica el valor de la apuesta");
				jugador.setDineroJugador(jugador.getDineroJugador() + apuesta);
				finRonda = true;
			}

			jugador.mazoJugador.moverAlMazo(mazo);
			dealer.mazoJugador.moverAlMazo(mazo);

			System.out.println("Fin de la mano");

		}

		System.out.println("Gracias por jugar");

	}

}
