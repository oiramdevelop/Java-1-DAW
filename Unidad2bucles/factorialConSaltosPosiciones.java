package Unidad2bucles;

import java.util.Scanner;

public class factorialConSaltosPosiciones {

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
		int num1 = 0;
		int num2 = 0;
		int suma = 0;

		Scanner teclado = new Scanner(System.in);

		// Leemos por teclado el primer numero y lo guardamos en la variable
		System.out.println("Dime el priemr numero ");
		num1 = teclado.nextInt();

		// Leemos por teclado el segundo numero y lo guardamos en la variable
		System.out.println("Dime el segundo numero");
		num2 = teclado.nextInt();
		teclado.close();

		for (int i = num2; i <= num1; i += num2) {
			suma += i;

		}
		System.out.println(suma);
	}

}
