package Unidad2bucles;

import java.util.Scanner;

public class examenBicis {

	public static final int CAT_MTB = 1;
	public static final int CAT_DESC = 2;
	public static final int CAT_CAR = 3;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner teclado = new Scanner(System.in);

		// Definicion de variables

		String modelo = " ";
		String marca = " ";
		double precio;
		int puntTec = 0;
		int stock = 0;
		int numBicis = 0;
		int categoria = 0;

		// Variables del tratamiento
		double mediaPrecio = 0;
		double maxPrecio = Integer.MIN_VALUE;
		double minPrecio = Integer.MAX_VALUE;
		String modeloMax = " ";
		String modeloMin = " ";
		int sumaStock = 0;
		String[] listaModelosCond;
		String[] listaModelosStock;

		// PReguntamos al usuario cuantas biciletas leemos
		System.out.println("Dime cuantas biciclestas quieres leer");
		numBicis = teclado.nextInt();

		// El tamaño de elementos del array sera el numero de biciletas a leer
		// Ya que pueden cumplir todas la condicion
		listaModelosCond = new String[numBicis];
		listaModelosStock = new String[numBicis];
		// Vamos leyendo numBicis veces todo los datos de cada bicicleta
		for (int i = 0; i < numBicis; i++) {

			/**************************************
			 * TRATAMIENTO DE DATOS
			 ************************************/
			System.out.println("Introduce el modelo de la bicicleta " + (i + 1));
			modelo = teclado.next();

			// Validamos de la marca
			// Mientras no sea ninguna de las tres marcas validad
			// lE hacemos repetir indefinididamente que ponga la marca
			do {
				System.out.println("Introduce la marca de la bicicleta " + (i + 1) + (""));
				marca = teclado.next();
			} while (!marca.equalsIgnoreCase("orbea") && !marca.equalsIgnoreCase("decathlon")
					&& !marca.equalsIgnoreCase("bh"));

			do {
				System.out.println("Inroduce la categoria" + (i + 1) + ("1= MTB , 2 = Descenso , 3 = Carrera "));
				categoria = teclado.nextInt();
			} while (categoria < 1 || categoria > 3);

			System.out.println("Introduce el precio de la bicicleta " + (i + 1));
			precio = teclado.nextDouble();

			do {
				System.out.println("Inroduce los puntos " + (i + 1));
				puntTec = teclado.nextInt();
			} while (puntTec < 1 || puntTec > 10);

			System.out.println("Introduce el stock de la bicicleta " + (i + 1));
			stock = teclado.nextInt();

			System.out.println("Introduce el modelo de la bicicleta " + (i + 1));
			numBicis = teclado.nextInt();

			/**************************************
			 * TRATAMIENTO DE DATOS
			 ************************************/

			// Para calucar la media vamos sumando todos los precios de las bicis

			mediaPrecio = mediaPrecio + precio;

			// Para calcular el precio maximo vamos comparando todo los precios
			// de las biciletas y si es mayor que nuestro
			// Pasara ser el nuevo maximo

			if (precio > maxPrecio) {
				maxPrecio = precio;
				modeloMax = modelo;
			}

			// Para el minimo

			if (precio > minPrecio) {
				minPrecio = precio;
				modeloMin = modelo;

			}

			// Mostar el modelo de las biciletas de carreras cuya puntuacion sea superior
			// a 9 o cuesten menos de 190 euros
			if (categoria == CAT_CAR && (puntTec > 9 || precio < 190)) {
				listaModelosCond[i] = modelo;
			}

			// Mostrara el stock total de biciletas de tipo Descneso

			if (categoria == CAT_DESC)
				sumaStock += stock;

			// Cuando una bicicleta tenga stock 0 y puntuacion supeior a 6
			// guardara su nombre en un array y mostrara al final la lista de productos
			// sin stock a pedir de nuevo

		}

		// Una vez hemos acabado el bulce tenemos todo los precios sumadnos
		// Lo dividimos entre la cantidad de bicis para sacar la media
		mediaPrecio = mediaPrecio / numBicis;

		for (int i = 0; i < listaModelosCond.length; i++) {
			if (listaModelosCond[i] != null) {
				System.out.println(listaModelosCond[i]);

			}

		}
		for (int i = 0; i < listaModelosStock.length; i++) {
			if (listaModelosStock[i] != null) {
				System.out.println(listaModelosStock[i]);
			}
		}

	}

}
