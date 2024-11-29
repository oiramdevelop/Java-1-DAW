package Unidad2bucles;

public class tresEnRaya {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char tablero[][] = { { '_', '_', '_', }, // [] el primero es la (y) y la segunda [] es la (x)
				{ '_', '_', '_', }, { '_', '_', '_', } };

		String ganador = " ";

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
			// Turnos jugador 1
			System.out.println("Jugador 1 :posicion a poner tu ficha: (xy) ");
		}

	}

}
