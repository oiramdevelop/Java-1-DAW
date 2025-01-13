package Unidad3;

import java.util.Arrays;

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
	 * Recibe un array y deuelve la suma
	 * 
	 * @param listaNumero lista de numeros en double
	 * @return la suma de los double
	 */

	public static double suma(double listaNumero[]) {

		double sumatorio = 0;

		// Recorremos todos los numeros
		for (int i = 0; i < listaNumero.length; i++) {

			// Vamos sumando los numeros en la variable
			sumatorio += listaNumero[i];
		}
		return sumatorio;
	}

	/**
	 * el factorial de un numero consiste en multiplicar todo los numeros entre 1 y
	 * dicho numero Por ejemplo el factorial de 5 seria
	 * 
	 * @param num
	 * @return el factorial
	 */
	public static int factorial(int num) {

		double factorial = 1;

		for (int i = 1; i <= num; i++) {

			factorial = factorial * i;
		}
		return (int) factorial;
	}

	/**
	 * La funcion recibe un string de numeros y suma todas sus cifras
	 * 
	 * @param numeros
	 * @return devuelve la suma de las cifras del string o 0 si hay eleementos no
	 *         numericos
	 */

	/*
	 * FACIL public static int suma(String numeros) { // variable que va alamacenar
	 * la suma de todos los numeros int sumatorio = 0;
	 * 
	 * // Vamos recorriendo todas las posiciones de la cadena for (int i = 0; i <
	 * numeros.length(); i++) {
	 * 
	 * // Guardamos el caracterde la posicion i actual char numero =
	 * numeros.charAt(i);
	 * 
	 * int num = Character.valueOf(numero) - 48;
	 * 
	 * // SI es un numero no valido devolvemos 0 if (num < 0 || num > 9) return 0;
	 * else sumatorio += num;
	 * 
	 * } return sumatorio; }
	 */
	/**
	 * Para resolver el factorial de los 5 primeros numeros se podri poner asi
	 * 5!=4!*5 4!=3!*4 3!=2!*3 2!=1!*2 1!=1 este ultimo ya no requiere utilizar
	 * unaversion reducia del problema Esto se llama el caso base
	 * 
	 * @param num
	 * @return
	 */
	public static int factorialRecursivo(int num) {

		if (num == 1)
			return 1;// caso base
		else
			// Si no es caso base se llama a la funcion con un caso mas pequño
			return num * factorialRecursivo(num - 1);
	}

	/**
	 * Recibe un array y devuelve la suma resolviendolo de forma revursiva el caso
	 * base es que el array solo tenga un numero cuyo caso devuelvo ese numero
	 * 
	 * @param listaNumero lista de numeros en doyble
	 * @return la suma de los double
	 */
	public static double sumaRecursiva(double listaNumeros[]) {

		// si solo hya un numero lo devolvemos
		if (listaNumeros.length == 1)
			return listaNumeros[0];
		else {
			// si hay mas de un numero devolvemos la suma del primer numero
			// Mas la sumaRecursiva del array a partir de este numero
			double primero = listaNumeros[0];
			// Primero partimos del array
			listaNumeros = Arrays.copyOfRange(listaNumeros, 1, listaNumeros.length);

			System.out.println("Array cortado" + Arrays.toString(listaNumeros));
			return primero + sumaRecursiva(listaNumeros);

		}

	}
}
