package Unidad2bucles;

import java.util.Scanner;

public class conversorMonedas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		// Declarar las tasas de conversión
		double tasaUsdToEur = 0.93; // 1 USD = 0.93 EUR
		double tasaUsdToJpy = 135.5; // 1 USD = 135.5 JPY
		double tasaEurToJpy = 145.5; // 1 EUR = 145.5 JPY

		System.out.println("Monedas disponibles: USD, EUR, JPY.");

		// Entrada: Cantidad, moneda origen y destino
		System.out.print("Introduce la cantidad a convertir: ");
		double cantidad = sc.nextDouble();

		System.out.print("Introduce la moneda de origen (USD, EUR, JPY): ");
		String monedaOrigen = sc.next().toUpperCase();

		System.out.print("Introduce la moneda de destino (USD, EUR, JPY): ");
		String monedaDestino = sc.next().toUpperCase();

		double resultado = 0;
		if (monedaOrigen.equals("USD") && monedaDestino.equals("EUR")) {
			resultado = cantidad * tasaUsdToEur;
		} else if (monedaOrigen.equals("USD") && monedaDestino.equals("JPY")) {
			resultado = cantidad * tasaUsdToJpy;
		} else if (monedaOrigen.equals("EUR") && monedaDestino.equals("USD")) {
			resultado = cantidad / tasaUsdToEur;
		} else if (monedaOrigen.equals("EUR") && monedaDestino.equals("JPY")) {
			resultado = cantidad * tasaEurToJpy;
		} else if (monedaOrigen.equals("JPY") && monedaDestino.equals("USD")) {
			resultado = cantidad / tasaUsdToJpy;
		} else if (monedaOrigen.equals("JPY") && monedaDestino.equals("EUR")) {
			resultado = cantidad / tasaEurToJpy;
		} else if (monedaOrigen.equals(monedaDestino)) {
			resultado = cantidad;
		} else {
			System.out.println("Moneda no válida. Inténtalo de nuevo.");
			sc.close();
			return;
		}

		// Salida: resultado
		System.out.printf("%.2f %s equivale a %.2f %s.\n", cantidad, monedaOrigen, resultado, monedaDestino);
		sc.close();

	}

}
