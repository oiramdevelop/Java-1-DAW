package Unidad2bucles;

import java.util.Scanner;

public class videojuego {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		// Leer la cantidad de videojuegos
		System.out.print("¿Cuántos videojuegos deseas registrar? ");
		int n = teclado.nextInt();
		teclado.nextLine(); // Limpiar el buffer

		// Declaramos 4 arrays para gaurdar los videojuegos registrado
		String[] nombres = new String[n];
		double[] puntuaciones = new double[n];
		double[] precios = new double[n];
		String[] companias = new String[n];

		// Captura de datos
		for (int i = 0; i < n; i++) {
			System.out.println("Videojuego " + (i + 1) + ":");
			System.out.print("Nombre del videojuego: ");
			nombres[i] = teclado.nextLine();

			System.out.print("Puntuación del videojuego: ");
			puntuaciones[i] = teclado.nextDouble();

			System.out.print("Precio del videojuego: ");
			precios[i] = teclado.nextDouble();
			teclado.nextLine(); // Limpiar el buffer

			System.out.print("Compañía del videojuego: ");
			companias[i] = teclado.nextLine();
		}

		// Calcular la media de los precios
		double sumaPrecios = 0;
		for (double precio : precios) {
			sumaPrecios += precio;
		}
		double mediaPrecios = sumaPrecios / n;
		System.out.printf("\nMedia de los precios: %.2f euros\n", mediaPrecios);

		// Buscar puntuación máxima y mínima
		double puntuacionMax = puntuaciones[0];
		double puntuacionMin = puntuaciones[0];
		int indiceMax = 0;
		int indiceMin = 0;

		for (int i = 1; i < n; i++) {
			if (puntuaciones[i] > puntuacionMax) {
				puntuacionMax = puntuaciones[i];
				indiceMax = i;
			}
			if (puntuaciones[i] < puntuacionMin) {
				puntuacionMin = puntuaciones[i];
				indiceMin = i;
			}
		}

		System.out.println("Puntuación máxima: " + puntuacionMax + ", Juego: " + nombres[indiceMax]);
		System.out.println("Puntuación mínima: " + puntuacionMin + ", Juego: " + nombres[indiceMin]);

		// Contar la cantidad de juegos por compañía
		String[] companiasUnicas = new String[n];
		int[] conteoCompanias = new int[n];
		int unidadCompania = 0;

		for (int i = 0; i < n; i++) {
			boolean encontrada = false;
			for (int j = 0; j < unidadCompania; j++) {
				if (companias[i].equals(companiasUnicas[j])) {
					conteoCompanias[j]++;
					encontrada = true;
					break;
				}
			}
			if (!encontrada) {
				companiasUnicas[unidadCompania] = companias[i];
				conteoCompanias[unidadCompania] = 1;
				unidadCompania++;
			}
		}

		System.out.println("\nCantidad de juegos por compañía:");
		for (int i = 0; i < unidadCompania; i++) {
			System.out.println(companiasUnicas[i] + ": " + conteoCompanias[i]);
		}

		// Juegos que cuestan menos de 15 euros, son de Nintendo y cumplen las
		// condiciones
		System.out.println("\nJuegos de Nintendo que cuestan menos de 15 euros y:");
		System.out.println("- Empiezan con 'M' o");
		System.out.println("- Tienen puntuación superior a 8:");
		for (int i = 0; i < n; i++) {
			if (companias[i].equalsIgnoreCase("Nintendo") && precios[i] < 15
					&& (nombres[i].startsWith("M") || puntuaciones[i] > 8)) {
				System.out.println("- " + nombres[i]);
			}
		}

		teclado.close();
	}
}
