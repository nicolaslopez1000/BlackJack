package bljk;

import java.util.ArrayList;
import java.util.Random;

public class Mazo {

	private ArrayList<Carta> colCartas;

	public Mazo() {

		this.colCartas = new ArrayList<Carta>();
		// TODO Auto-generated constructor stub
	}

	public void abarajar() {
		abarajar(0);
	}

	@SuppressWarnings("unused")
	public void abarajar(int pos) {
		if (pos == this.colCartas.size())
			return;

		Carta card = this.colCartas.get(pos);

		Random random = new Random();
		int randomnumber = random.nextInt((this.colCartas.size() - pos) + 0) + pos;
		this.colCartas.set(pos, this.colCartas.get(randomnumber));

		this.colCartas.set(randomnumber, card);

		abarajar(++pos);
	}
	/*
	 * public ArrayList<Carta> abarajar(ArrayList<Carta> cards, int pos) { if (pos
	 * == cards.size() ) return cards;
	 * 
	 * Carta card = cards.get(pos);
	 * 
	 * Random random = new Random(); int randomnumber =
	 * random.nextInt((this.colCartas.size()-pos) +0)+ pos; cards.set(pos,
	 * cards.get(randomnumber));
	 * 
	 * cards.set(randomnumber, card);
	 * 
	 * 
	 * return abarajar(cards, ++pos); }
	 */

	public void agregarCarta(Carta card) {
		this.colCartas.add(card);

	}

	public Carta getCarta(int i) {

		return this.colCartas.get(i);

	}

	public void deleteCarta(int i) {

		this.colCartas.remove(i);
	}

	public void robarCarta(Mazo desdeMazo) {

		this.agregarCarta(desdeMazo.getCarta(0));
		desdeMazo.deleteCarta(0);

	}

	public void crearMazo() {
		for (Tipo tipo : Tipo.values()) {

			for (Valor val : Valor.values()) {

				this.colCartas.add(new Carta(tipo, val));

			}
		}

	}

	public String toString() {
		String carta = "";

		for (Carta cart : this.colCartas) {

			carta += "\n" + cart.toString();

		}
		return carta;

	}

	public int valorMazo() {

		int total = 0;
		int as = 0;

		for (Carta card : this.colCartas) {

			switch (card.getValor()) {
			case DOS:
				total += 2;

				break;
			case TRES:
				total += 3;

				break;
			case CUATRO:
				total += 4;

				break;
			case CINCO:
				total += 5;

				break;
			case SEIS:
				total += 6;

				break;
			case SIETE:
				total += 7;

				break;
			case OCHO:
				total += 8;

				break;
			case NUEVE:
				total += 9;

				break;
			case DIEZ:
				total += 10;

				break;
			case J:
				total += 10;

				break;
			case Q:
				total += 10;

				break;
			case K:
				total += 10;

				break;
			case AS:
				as += 1;
				break;

			default:
				break;
			}

		}
		for (int i = 0; i < as; i++) {

			if (total > 10) {
				total += 1;

			} else {

				total += 11;
			}
		}

		return total;
	}

	public int tamañoMazo() {

		return this.colCartas.size();
	}

	public void moverAlMazo(Mazo destino) {
		// put cards in moveTo deck
		int size = this.tamañoMazo();
		for (int i = 0; i < size; i++) {
			destino.agregarCarta(this.getCarta(i));
		}
		// empty out the deck
		for (int i = 0; i < size; i++) {
			this.deleteCarta(0);
		}
	}
}
