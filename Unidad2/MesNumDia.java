package Unidad2;

import java.util.Scanner;

public class MesNumDia {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		String mes = " ";
		char febrero = ' ';

		// Le pedimos que nos diga el mes el cual quiere
		// saber cuantos dias tiene
		System.out.println("¿Cual es el mes el cual quieres saber cuantos dias tiene?");
		mes = teclado.next();

		// Dependiendo del mes saldran los dias asignados en este switch

		switch (mes) {
		case "Enero":
			System.out.println("Enero tiene 31 dias");
			break;
		case "Febrero":
			// Le preguntamos si es bisiesto y si es asi son 29 y sino 28
			System.out.println("¿Es bisiesto ? (S/N) ");
			febrero = teclado.next().charAt(0);
			if (febrero == 'S') {
				System.out.println("Febrero tiene 29 dias");
			} else if (febrero == 'N') {
				System.out.println("Febrero tiene 28 dias");
			}
			break;
		case "Marzo":
			System.out.println("Marzo tiene 30 dias");
			break;
		case "Abril ":
			System.out.println("Marzo tiene 31 dias");
			break;
		case "Mayo":
			System.out.println("Marzo tiene 31 dias");
			break;
		case "Junio":
			System.out.println("Marzo tiene 30 dias");
			break;
		case "Julio":
			System.out.println("Marzo tiene 31 dias");
			break;
		case "Agosto":
			System.out.println("Marzo tiene 31 dias");
			break;
		case "Septiembre":
			System.out.println("Marzo tiene 30 dias");
			break;
		case "Octubre":
			System.out.println("Marzo tiene 31 dias");
			break;
		case "Noviembre":
			System.out.println("Marzo tiene 30 dias");
			break;
		case "Diciembre":
			System.out.println("Marzo tiene 31 dias");
			break;

		}
		teclado.close();
	}

}
