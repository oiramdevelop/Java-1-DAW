package Unidad2;

import java.util.Scanner;

public class ejemploCondicionales4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stubç
		/*
		 * Escribir un programa en java que lea dos numeros y una operacion la operacion
		 * podra ser suma, resta , multiplicacion . division y pontencia se
		 * correspondera a los caracteres +,-,*,/,^
		 */
		Scanner teclado = new Scanner(System.in);

		int num1 = 0;
		int num2 = 0;
		char operacion = ' ';
		double resultado = 0;

		System.out.println("Mete el primer numero");
		// Almacenamos en la variable num1 el numero de teclado
		num1 = teclado.nextInt();

		System.out.println("Mete el segundo numero");
		// Almacenamos en la variable num2 el numero de teclado
		num2 = teclado.nextInt();

		System.out.println("Dime el operador (+ ,-,*,/, ^) ");
		// Almacenamos en la variable operacion el caracter de la operacion que pide (+
		// ,-,*,/, ^
		operacion = teclado.next().charAt(0);

		switch (operacion) {
		case '+':
			resultado = num1 + num2;
			break;
		case '-':
			resultado = num1 - num2;
			break;
		case '/':
			resultado = num1 / num2;
			break;
		case '*':
			resultado = num1 * num2;
			break;
		case '^':
			resultado = Math.pow(num1, num2);
			break;

		}
		// Sacamos por pantalla el resultado
		System.out.println("El resultado es " + resultado);
	}

}