package Unidad2bucles;

import java.util.Scanner;

public class contarPalabrasVocales {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Leer la entrada directamente desde el Scanner
		System.out.println("Introduce una frase:");
		String frase = scanner.nextLine();

		int totalPalabras = 0;
		int palabrasConVocal = 0;
		boolean enPalabra = false; // Para saber si estamos dentro de una palabra
		StringBuilder palabraActual = new StringBuilder();

		// Iterar sobre cada carácter de la cadena
		for (int i = 0; i < frase.length(); i++) {
			char c = frase.charAt(i);

			// Si encontramos un espacio, se terminó una palabra
			if (c == ' ') {
				if (enPalabra) {
					totalPalabras++;
					// Verificar si la palabra empieza o termina con vocal
					char primerCaracter = palabraActual.charAt(0);
					char ultimoCaracter = palabraActual.charAt(palabraActual.length() - 1);
					primerCaracter = Character.toLowerCase(primerCaracter);
					ultimoCaracter = Character.toLowerCase(ultimoCaracter);

					if (primerCaracter == 'a' || primerCaracter == 'e' || primerCaracter == 'i' || primerCaracter == 'o'
							|| primerCaracter == 'u' || ultimoCaracter == 'a' || ultimoCaracter == 'e'
							|| ultimoCaracter == 'i' || ultimoCaracter == 'o' || ultimoCaracter == 'u') {
						palabrasConVocal++;
					}
					palabraActual.setLength(0); // Limpiar la palabra actual
				}
				enPalabra = false;
			} else {
				// Si no es un espacio, estamos dentro de una palabra
				palabraActual.append(c);
				enPalabra = true;
			}
		}

		// Verificar la última palabra si no termina en un espacio
		if (enPalabra) {
			totalPalabras++;
			char primerCaracter = palabraActual.charAt(0);
			char ultimoCaracter = palabraActual.charAt(palabraActual.length() - 1);
			primerCaracter = Character.toLowerCase(primerCaracter);
			ultimoCaracter = Character.toLowerCase(ultimoCaracter);

			if (primerCaracter == 'a' || primerCaracter == 'e' || primerCaracter == 'i' || primerCaracter == 'o'
					|| primerCaracter == 'u' || ultimoCaracter == 'a' || ultimoCaracter == 'e' || ultimoCaracter == 'i'
					|| ultimoCaracter == 'o' || ultimoCaracter == 'u') {
				palabrasConVocal++;
			}
		}

		// Mostrar resultados
		System.out.println("Número total de palabras: " + totalPalabras);
		System.out.println("Palabras que empiezan o terminan con vocal: " + palabrasConVocal);

		scanner.close();
	}
}
