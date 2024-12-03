package Unidad2bucles;

import java.util.Scanner;

public class contarPalabrasVocales {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Leer la entrada
		System.out.println("Introduce una frase:");
		String input = scanner.nextLine();

		// Dividir la cadena en palabras
		String[] palabras = input.split("\\s+"); // Divide por espacios, soportando múltiples espacios
		int totalPalabras = palabras.length;
		int palabrasConVocal = 0;

		// Procesar cada palabra
		for (String palabra : palabras) {
			// Convertir palabra a minúsculas para facilitar la comparación
			palabra = palabra.toLowerCase();
			if (palabra.matches("^[aeiou].*") || palabra.matches(".*[aeiou]$")) {
				palabrasConVocal++;
			}
		}

		// Mostrar resultados
		System.out.println("Número total de palabras: " + totalPalabras);
		System.out.println("Palabras que empiezan o terminan con vocal: " + palabrasConVocal);
	}
}
