package Unidad2;

import java.util.Scanner;

public class ejerciciosCondicionalesTareaUnidad2 {

	public static void main(String[] args) {
		int numero1 = 0;
		int numero2 = 0;
		int numero3 = 3;
		int numero4 = 0;
		char decir1 = ' ';

		Scanner teclado = new Scanner(System.in);

		// Pedimos que nos diga un numero
		System.out.println("Dime un numero entero");

		// Guardamos este numero en la variable numero1
		numero1 = teclado.nextInt();

		// Pedimos que nos diga otro numero entero
		System.out.println("Dime otro numero entero diferente");

		// Guardamos este otro numero en la variable numero2
		numero2 = teclado.nextInt();

		// Pedimos que nos diga un tercer numero entero
		System.out.println("DIme un tercer numero entero diferente");

		// Guardamos este numero en la variable numero3
		numero3 = teclado.nextInt();

		// Le preguntamos si quiere que le digamos que le digamos
		// el numero menor de los 3
		System.out.println("¿Quieres que te diga cual es el menor? (S o N)");
		decir1 = teclado.next().charAt(0);

		teclado.close();
		if (decir1 == 'S') {
			if (numero1 < numero2 && numero1 < numero3) {
				System.out.println(numero1);
			} else if (numero2 < numero1 && numero2 < numero3) {
				System.out.println(numero2);
			} else if (numero3 < numero1 && numero3 < numero2) {
				System.out.println(numero3);
			} else {
				System.out.println("Has puesto alguno igual picha ");
			}
		} else if (decir1 == 'N') {
			System.out.println("De acuerdo que tengas un buen dia");
		} else {
			System.out.println("Te he preguntado que si o no ");
		}
	}
}
