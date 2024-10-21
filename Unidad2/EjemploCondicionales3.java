package Unidad2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class EjemploCondicionales3 {
	public static void main(String[] args) {
		/*
		 * Vamos a comprobar si un alumno ha sacado el carnet de conducir. Para ello,
		 * leerá de teclado los siguientes datos: edad, numFallosExamen, tasaPagada,
		 * fechaExamenTeorico, numGolpes, soborno. El programa deberá comprobar si tiene
		 * derecho al carnet. Para ello, deberá tener más de 18 años, menos de 4 fallos
		 * en el examen y la tasa pagada. En caso de no cumplirlo, se le pedirá la fecha
		 * del examen. En todo caso, también tiene el carnet si ha regalado un jamón.
		 */

		Scanner teclado = new Scanner(System.in); // Inicializamos el objeto Scanner

		int edad = 0;
		int numFallosEx = 0;
		boolean tasaPagada = false;
		String sTasaPagada = "";
		LocalDate fechaExamen;
		int numGolpes = 0;
		boolean jamon = false; // Asumimos que no ha regalado un jamón
		String sFechaExamen = "";

		if (jamon) {
			System.out.println("¡Felicidades! Tienes el carnet porque regalaste un jamón.");
		} else {
			System.out.println("¿Cuál es tu edad?");
			edad = teclado.nextInt();
			System.out.println("¿Cuántas preguntas fallaste en el teórico?");
			numFallosEx = teclado.nextInt();
			System.out.println("¿Has pagado las tasas? S/N");

			// Leemos como String si hemos pagado la tasa
			sTasaPagada = teclado.next();

			// Operador ternario para determinar si la tasa está pagada
			tasaPagada = sTasaPagada.equalsIgnoreCase("S");

			System.out.println("Tasa pagada: " + tasaPagada);

			if (edad >= 18 && numFallosEx < 4 && tasaPagada) {
				System.out.println("Introduce la fecha del examen (dd/MM/yyyy)");
				// Creamos el formato en el cual se va a interpretar la fecha
				sFechaExamen = teclado.next();

				// El parse cambia el String de tipo de dato a fecha utilizando el formato que
				// hemos definido antes
				DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				fechaExamen = LocalDate.parse(sFechaExamen, formateador);

				// Nos pregunta el número de golpes que hemos dado en el práctico
				System.out.println("¿Cuántos golpes pegaste en el práctico?");
				numGolpes = teclado.nextInt();

				// Fecha actual
				LocalDate hoy = LocalDate.now();

				// Última comprobación: menos de dos golpes y fecha anterior a la actual
				if (numGolpes < 2 && fechaExamen.isBefore(hoy)) {
					System.out.println("¡Felicidades! Tienes derecho al carnet de conducir.");
				} else {
					System.out.println("No tienes derecho al carnet de conducir.");
				}
			} else {
				System.out.println("No tienes derecho al carnet de conducir.");
			}

			teclado.close();
		}
	}
}
