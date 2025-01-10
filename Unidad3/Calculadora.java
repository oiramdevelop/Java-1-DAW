package Unidad3;

public class Calculadora {
	/**
	 * Funcion que suma dos numeros La funcion es estatica para poder llamar a la
	 * funcion Sin ten
	 * 
	 * @param a
	 * @param b
	 * @return devuelve la suma de a y b
	 */
	public static int suma(int a, int b) {
		int resultado = a + b;
		return resultado;

	}

	/**
	 * La funcion recibe un string de numeros y suma todas sus cifras
	 * 
	 * @param numeros
	 * @return devuelve la suma de las cifras del string o 0 si hay eleementos no
	 *         numericos
	 */
	public static int suma(String numeros) {
		// variable que va alamacenar la suma de todos los numeros
		int sumatorio = 0;

		// Vamos recorriendo todas las posiciones de la cadena
		for (int i = 0; i < numeros.length(); i++) {

			// Guardamos el caracterde la posicion i actual
			char numero = numeros.charAt(i);

			int num = Character.valueOf(numero) - 48;

			// SI es un numero no valido devolvemos 0
			if (num < 0 || num > 9)
				return 0;
			else
				sumatorio += num;

		}
		return sumatorio;
	}
}
