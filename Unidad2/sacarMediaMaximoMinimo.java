package Unidad2;

import java.util.Scanner;

public class sacarMediaMaximoMinimo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner teclado = new Scanner(System.in);

		int i = 0, num = 0;
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		double media, suma = 0;
		double factorial = 1;
		while (i < 10) {
			System.out.println("Introduce el numero " + (i + 1) + " : ");
			num = teclado.nextInt();

			// Vamos sumando los numeros

			suma = suma + num;
			// Si el numero que leoo es mayor que el maximo hasta este momento , ese numero
			// sera el nuevo maximo
			if (num > max)
				max = num;
			// Para sacar el minimo valor vamos comprobando si el numero leido es menor que
			// el min actual
			if (num < min)
				min = num;

			i++;

		}
		// Leer un numero y mostrar su factorial y los divisores hasta 100
		// El factoril de un numero es la multiplicacion de todos los numeros desde 1
		// hasta dicho numero

		System.out.println("Introduce un numero paraca calcular su factorial");
		num = teclado.nextInt();
		for (i = 1; i <= num; i++) {

			factorial = i * factorial;

		}
		// Fuera del bucle dividimos la suma de los numeros entre
		// La cantidad de elementos para calcular la media
		media = suma / 10;
		System.out.println("La media es : " + media);
		System.out.println("El maximo es: " + max);
		System.out.println("El minimo es: " + min);
		System.out.println("El factorial de " + num + " es " + factorial);
	}

}
