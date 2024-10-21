package Unidad2;

import java.util.Scanner;

public class ejemploCondicionales1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// leemos de teclado la edad de una persona y le decimos si es mayor de edad o
		// no
		Scanner teclado = new Scanner(System.in);

		System.out.println("¿Que edad tienes colega ?");

		// Leemos un entero

		int edad = teclado.nextInt();

		// Con la senetica if se evalua una condicion
		// Si a condicion es cierta entra en el bloque de codigo y lo ejecuta
		if (edad > 17) {
			System.out.println("Entra picha con tu copa primo");
		} else { // Si la condcion del if es falsa entra en el codigo del else
			System.out.println("Vete al chiquipark");
		}
	}

}
