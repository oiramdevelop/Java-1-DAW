package Unidad2;

import java.util.Scanner;

public class sacarMediaMaximoMinimo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner teclado = new Scanner(System.in);

		int i = 0;
		int max = Integer.MIN_VALUE, min;
		double media, suma = 0;

		while (i < 10) {
			System.out.println("Introduce el numero " + (i + 1) + " : ");
			int num = teclado.nextInt();

			// Vamos sumando los numeros

			suma = suma + num;

			if (num > max)
				max = num;

			i++;

		}
		// Fuera del bucle dividimos la suma de los numeros entre
		// La cantidad de elementos para calcular la media
		media = suma / 10;
		System.out.println("La media es : " + media);
	}

}
