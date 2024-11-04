package Unidad2;

import java.util.Scanner;

public class ejerciciosCondicionalesLeerOperacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner teclado = new Scanner(System.in);

		double numero1 = 0;
		double numero2 = 0;
		double resultado = 0;

		// Pedimos el primer numero y lo gaurdamos en la variable
		System.out.println("Dime un numero");
		numero1 = teclado.nextDouble();

		// Pedimos un segundo numero y lo guardamos en la variable
		System.out.println("Dime el otro numero");
		numero2 = teclado.nextDouble();

		// Pedimos que nos diga el resultado de la operacion que
		// he hecho con los otros dos numeros anteriores y lo guardamos
		// en la variable asignada
		System.out.println("Dime el resultado de la operacion realizada con los otros dos numeros");
		resultado = teclado.nextDouble();

		// Sabiendo todo los datos anteriores comparamos cada posible operacion con la
		// variable resultado
		// si es cierto nos mostrara por pantalla el tipo de operacionS
		if (resultado == (numero1 + numero2)) {
			System.out.println("La operacion utilizada ha sido una suma (+)");
		} else if (resultado == (numero1 - numero2)) {
			System.out.println("La operacion utilizada ha sido una rsta (-)");

		} else if (resultado == (numero1 * numero2)) {
			System.out.println("La operacion utilizada ha sido una multiplicacion (*)");
		} else if (resultado == (numero1 / numero2)) {
			System.out.println("La operacion utilizada ha sido una division  (/)");
		} else if (resultado == Math.sqrt(numero1)) {
			System.out.println("La operacion utilizada ha sido una raiz cuadrada");
		} else if (resultado == Math.sqrt(numero2)) {
			System.out.println("La operacion utilizada ha sido una raiz cuadrada");
		} else if (resultado == Math.pow(numero1, numero2)) {
			System.out.println("La operacion utilizada ha sido una potencia caudrada ");
		} else { // Si no es ninguna de las anteriores mostrara por pantalla que la oepracion es
					// invalida
			System.out.println("La operacion es invalida colega");
		}
		teclado.close();

	}
}
