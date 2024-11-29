package Unidad2bucles;

import java.util.Scanner;

public class divisores {

	public static void main(String[] args) {
		/*
		 * Escribir un programa que lea un número y muestre todos sus divisores impares.
		 * Un número es divisor de otro si a la hora de dividir el resto es 0. Por
		 * ejemplo 2 es divisor de 4, pero 3 no, así que los divisores de 75 serían
		 * 1,3,5,15,25 y 75.
		 * 
		 */

		int numero = 0;

		Scanner teclado = new Scanner(System.in);
		// Leemos por teclado los dos numeros que queremos

		System.out.println("DIme el primer Numero(Entero)");
		// Numero 1
		numero = teclado.nextInt();

		for (int i = 1; i <= numero; i++) {

			if (numero % i == 0 && i % 2 != 0) {
				System.out.println("Los divisores impares son " + i);
			}
		}
	}

}
