package Unidad2;

import java.util.Scanner;

public class Dado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int p1dado1 = (int) (Math.random() * 6) + 1;
		int p1dado2 = (int) (Math.random() * 6) + 1;
		int p2dado1 = (int) (Math.random() * 6 + 1);
		int p2dado2 = (int) (Math.random() * 6 + 1);

		String jugador1 = " ";
		String jugador2 = " ";

		Scanner teclado = new Scanner(System.in);

		// Le preguntamos el nombre a los jugadores
		// guardamos el nombre en la variable
		System.out.println("Dime tu nombre jugador1");
		jugador1 = teclado.next();
		System.out.println("Dime tu nombre jugador2");
		jugador2 = teclado.next();

		teclado.close();

		// Realizamos los saques de cada jugador en pantalla

		// Saque jugador 1
		System.out.println(jugador1 + " ha sacado en el primer dado  " + p1dado1 + " y en el segundo " + p1dado2);
		// Pareja mayor o no pareja
		if (p1dado1 == p1dado2 && p1dado1 != 6 && p1dado2 != 6) {
			System.out.println("Ha sacado pareja de numero " + p1dado1);

		} else if (p1dado1 == 6 && p1dado2 == 6) {
			System.out.println("Ha sacado pareja mayor , pareja de numero " + p1dado1);
		}
		// saque jugador 1
		System.out.println(jugador2 + " ha sacado en el primer dado  " + p2dado1 + " y en el segundo " + p2dado2);
		if (p2dado1 == p2dado2 && p2dado1 != 6 && p2dado2 != 6) {
			System.out.println("Ha sacado pareja de numero " + p2dado1);
		} else if (p2dado1 == 6 && p2dado2 == 6) {
			System.out.println("Ha sacado pareja mayor , pareja de numero " + p2dado1);
		}

		if (p1dado1 + p1dado2 == p2dado1 + p2dado2) {
			System.out.println("Empate loco");
		} else if (p1dado1 + p1dado2 > p2dado1 + p2dado2) {
			System.out.println("El " + jugador1 + "ha ganado");

		}
	}

}
