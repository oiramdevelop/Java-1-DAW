package Unidad2bucles;

import java.util.Scanner;

public class factorialSaltosPosiciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Escribir un algoritmo que lea dos números n y d. Realizará la suma de todos
		 * los números desde 1 hasta n realizando saltos de d posiciones. Es decir es
		 * cómo el factorial, realizando saltos de d posiciones Por ejemplo si
		 * introducimos n=15 y d=2 Debería de mostrar el resultado de sumar
		 * 2+4+6+8+10+12+14
		 * 
		 */
		Scanner teclado = new Scanner(System.in);
		int n = 0;
		int d = 0;
		int suma = 0;

		System.out.println("Dime el numero el cual quieres saber la suma");
		n = teclado.nextInt();

		System.out.println("Dime los saltos de posicion que quieres saber la suma");
		d = teclado.nextInt();
		teclado.close();
		for (int i = d; i <= n; i += d) {
			suma += i;
			System.out.print(i + " ");

		}
		System.out.println();
		System.out.println("El resultado es " + suma);
		;
	}

}
