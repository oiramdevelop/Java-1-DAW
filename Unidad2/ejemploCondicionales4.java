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
		// ,-,*,/,
		operacion = teclado.next().charAt(0);

		// Realizamos la operacion del cliente
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
		default:
			System.out.println("EL operador no es valido");

			// El return finaliza la funcion principal
			// En este caso el main por lo cual es el porgrama principal

		}
		// Sacamos por pantalla el resultado
		System.out.println("El resultado es " + resultado);

		// Vamos a generar una nota aleatoria y que saque por pantalla si es un
		// insuficiente un suficiente...
		int nota = (int) (Math.random() + 10 + 1);

		Math.round(nota);

		System.out.println("Con una " + nota + "tendras un ");
		switch (nota) {
		case 1:
		case 2:
		case 3:
		case 4:
			System.out.println("Insuficiente");
			break;
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
		case 10:
			System.out.println("Suficiente");
			break;

		}

	}
}
