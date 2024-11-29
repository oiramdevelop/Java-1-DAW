package Unidad2bucles;

public class ejemploArray2 {

	public static void main(String[] args) {

		// Creamos un array de 10 numeros
		int listaNumeros[] = new int[10];

		// Recorremos todas las poisiciones del arrya y le vamos insertando numeros
		for (int i = 0; i < listaNumeros.length; i++) {

			listaNumeros[i] = (int) ((Math.random() * 11) - 1);
		}
		// queremos sacar el numero mayor y menor de todos los que hay en el array

		int maxNum = Integer.MIN_VALUE;
		int minNum = Integer.MAX_VALUE;
		// Recorremos todas las poisiciones del array buscando max y min
		for (int i = 0; i < listaNumeros.length; i++) {
			// Si el numero actual es mayor que nuestro maximo hasta ahora
			// Este numero es el nuevo maximo
			if (listaNumeros[i] > maxNum) {
				maxNum = listaNumeros[i];

			}
			// igual para el minimo , en caso de que el actual sea menor que nuestro minimo
			// temporal
			if (listaNumeros[i] > minNum) {
				minNum = listaNumeros[i];

			}
			// Comprobacioon de la cantidad de numeros que se repiten
			// vamos a guardar el numero actual
			int numABuscar = listaNumeros[i];
			int cantRep = 0;
			// Recorremos todas las posiciones del array buscando el numero a buscar
			for (int j = 0; j < listaNumeros.length; j++) {
				// si el numero en la posicion j del array es el numero a buscar
				// Es que hay un numero igual al buscado y incremento la cantidad de repetido
				if (listaNumeros[j] == numABuscar) {
					// incrementado la cantidad de numeros encotnrados
					cantRep++;
				}

			}
			// Si hemos encontrado mas de una repeticion lo sacamos por pantallas
			if (cantRep > 1) {
				System.out.println("El numero " + numABuscar + " se repite " + (cantRep - 1) + " veces");
			}
		}

	}

}
