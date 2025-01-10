package Unidad2bucles;

import java.util.Scanner;

public class contadorPrimosYDivisores {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Pedir al usuario cuántos números va a introducir
		System.out.println("Introduce la cantidad de números:");
		int n = scanner.nextInt(); // Leer la cantidad de números

		int[] numeros = new int[n];

		// Leer los números
		System.out.println("Introduce los números:");
		for (int i = 0; i < n; i++) {
			numeros[i] = scanner.nextInt();
		}

		// Contar los números primos
		int cantidadPrimos = 0;
		for (int i = 0; i < n; i++) {
			int num = numeros[i];
			boolean esPrimo = true;
			if (num <= 1) {
				esPrimo = false; // Los números menores o iguales a 1 no son primos
			}
			for (int j = 2; j <= Math.sqrt(num); j++) {
				if (num % j == 0) {
					esPrimo = false; // Si encuentra un divisor, no es primo
					break;
				}
			}
			if (esPrimo) {
				cantidadPrimos++;
			}
		}

		// Contar los divisores del primer número
		int divisoresPrimerNumero = 0;
		int primerNumero = numeros[0];
		for (int i = 1; i <= primerNumero; i++) {
			if (primerNumero % i == 0) {
				divisoresPrimerNumero++;
			}
		}

		// Mostrar los resultados
		System.out.println("Cantidad de números primos: " + cantidadPrimos);
		System.out.println("Cantidad de divisores del primer número: " + divisoresPrimerNumero);

		scanner.close();
	}

}
