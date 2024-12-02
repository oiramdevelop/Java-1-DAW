package Unidad2bucles;

import java.util.Scanner;

public class tresEnRaya {

	public static void main(String[] args) {

		char tablero[][] = { { '_', '_', '_', }, // [] el primero es la (y) y la segunda [] es la (x)
				{ '_', '_', '_', }, { '_', '_', '_', } };

		String ganador = " ";
		Scanner teclado = new Scanner(System.in);
		String jugadaX = "";
		String jugadaO = "";
		int jugadaXPosx = 0;
		int jugadaXPosy = 0;
		int jugadaOPosx = 0;
		int jugadaOPosy = 0;
		int cantX = 0;
		int cantO = 0;

		// Mientras no haya un ganador le vamos pidiendo que pongan fichas
		while (ganador.equals("")) {

			// Mostramos por pantalla el tablero
			for (int i = 0; i < tablero.length; i++) {
				// Dibujo cada fila del tablero
				for (int j = 0; j < tablero[i].length; j++)
					System.out.print(tablero[i][j]);

				// Despues de cada fila doy un enter
				System.out.println();
			}
			// TURNO JUGADOR X
			do {
				// Turnos jugador 1
				System.out.println("Jugador 1 :posicion a poner tu ficha: (xy) ");
				jugadaX = teclado.next();

				// Asignamos las posiciones a sus ariables
				// Se usa la funcion integer.parseInt
				// Asignamos las posicione a sus variables
				jugadaXPosx = Character.getNumericValue(jugadaX.charAt(0));
				jugadaXPosy = Character.getNumericValue(jugadaX.charAt(1));
			} while (jugadaXPosy < 0 || jugadaXPosy > 2 || jugadaXPosx < 0 || jugadaXPosx > 2);
			{

				// Posicionamos la ficha en su lugar
				tablero[jugadaXPosy][jugadaXPosx] = 'X';
			}

			// TURNO JUGADOR O
			do {
				// Turnos jugador O
				System.out.println("Jugador 1 :posicion a poner tu ficha: (xy) ");
				jugadaO = teclado.next();

				// Asignamos las posiciones a sus ariables
				// Se usa la funcion integer.parseInt
				// Asignamos las posicione a sus variables
				jugadaOPosx = Character.getNumericValue(jugadaO.charAt(0));
				jugadaOPosy = Character.getNumericValue(jugadaO.charAt(1));
			} while (jugadaOPosy < 0 || jugadaOPosy > 2 || jugadaOPosx < 0 || jugadaOPosx > 2);
			{

				// Posicionamos la ficha en su lugar
				tablero[jugadaOPosy][jugadaOPosx] = 'X';
			}

			// COMPROBACIONES TABLERO

			// Primero comprobamos las
			// Recorremos las filas
			// para cada fila
			for (int y = 0; y <= 2; y++) {
				// Reseteamos la cantidad de X encontradas para cada fila
				cantX = 0;
				for (int x = 0; x <= 20; x++) {
					// Vamos contando las X de cada fila
					if (tablero[x][y] == 'X')
						cantX++;
				}
				// Si hay tres X ha ganado jugadorX
				if (cantX == 3)
					ganador = "JugadorX";
			}
			for (int x = 0; x <= 2; x++) {
				// reseteamos la cantidad de O para cada fila
				cantO = 0;
				for (int y = 0; y <= 2; y++) {
					if (tablero[x][y] == 'X')
						cantO++;

				}
				if (cantO == 3)
					ganador = "jugadorX";
			}

			// Comprobamos las diagonales
			if (tablero[0][0] == 'X' && tablero[1][1] == 'X' && tablero[2][2] == 'X')
				ganador = "Jugador X";
			if (tablero[0][2] == 'X' && tablero[1][1] == 'X' && tablero[2][0] == 'X')
				ganador = "Jugador X";

		}
		teclado.close();
	}

}
