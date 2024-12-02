package Unidad2;

import java.util.Scanner;

public class conversorMoneda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		// Tasas de conversión
		double usdToEur = 0.93; // 1 USD = 0.93 EUR
		double usdToJpy = 135.5; // 1 USD = 135.5 JPY
		double eurToJpy = 145.5; // 1 EUR = 145.5 JPY

		// Mostrar monedas disponibles
		System.out.println("Monedas disponibles: USD, EUR, JPY");

		// Pedir al usuario los datos
		System.out.print("Introduce la cantidad a convertir: ");
		double cantidad = sc.nextDouble();

		System.out.print("Introduce la moneda de origen (USD, EUR, JPY): ");
		String origen = sc.next();

		System.out.print("Introduce la moneda de destino (USD, EUR, JPY): ");
		String destino = sc.next();

		// Inicializar la variable para el resultado
		double resultado = 0;

		// Convertir según las monedas
		if (origen.equalsIgnoreCase("USD") && destino.equalsIgnoreCase("EUR")) {
			resultado = cantidad * usdToEur;
		} else if (origen.equalsIgnoreCase("USD") && destino.equalsIgnoreCase("JPY")) {
			resultado = cantidad * usdToJpy;
		} else if (origen.equalsIgnoreCase("EUR") && destino.equalsIgnoreCase("USD")) {
			resultado = cantidad / usdToEur;
		} else if (origen.equalsIgnoreCase("EUR") && destino.equalsIgnoreCase("JPY")) {
			resultado = cantidad * eurToJpy;
		} else if (origen.equalsIgnoreCase("JPY") && destino.equalsIgnoreCase("USD")) {
			resultado = cantidad / usdToJpy;
		} else if (origen.equalsIgnoreCase("JPY") && destino.equalsIgnoreCase("EUR")) {
			resultado = cantidad / eurToJpy;
		} else if (origen.equalsIgnoreCase(destino)) {
			resultado = cantidad; // Si son iguales, no hay conversión
		} else {
			System.out.println("Moneda no válida. Por favor, inténtalo de nuevo.");
			sc.close();
			return;
		}

		// Mostrar el resultado
		System.out.println(
				cantidad + " " + origen.toUpperCase() + " equivale a " + resultado + " " + destino.toUpperCase());

		sc.close(); // Cerrar el escáner
	}
}
