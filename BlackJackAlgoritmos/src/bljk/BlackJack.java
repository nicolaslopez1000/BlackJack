package bljk;

import java.util.Random;
import java.util.Scanner;

public class BlackJack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Bienvendio a BlackJack");
		
		Mazo mazo = new Mazo();
		mazo.crearMazo();
		mazo.abarajar();
		
		
		Scanner input = new Scanner(System.in);
		
		System.out.println(mazo.toString());
		
		
		
	}

}
