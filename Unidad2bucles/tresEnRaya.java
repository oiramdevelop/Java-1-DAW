package Unidad2bucles;

import java.util.Scanner;

public class tresEnRaya {
    public static void main(String[] args) {

        char tablero[][] = { { '_', '_', '_' }, { '_', '_', '_' }, { '_', '_', '_' } };

        String ganador = ""; // Aquí será el jugador ganador si lo hay
        Scanner teclado = new Scanner(System.in);
        String jugadaX = "";
        String jugadaO = "";
        int jugadaXPosx = 0;
        int jugadaXPosy = 0;
        int jugadaOPosx = 0;
        int jugadaOPosy = 0;

        // Mientras no haya un ganador le vamos pidiendo que pongan fichas
        while (ganador.equals("")) {

            // Mostramos por pantalla el tablero
            System.out.println("Tablero actual:");
            for (int i = 0; i < tablero.length; i++) {
                for (int j = 0; j < tablero[i].length; j++)
                    System.out.print(tablero[i][j] + " ");
                System.out.println();
            }

            // TURNO JUGADOR X
            do {
                // Turnos jugador 1 (X)
                System.out.println("Jugador X: Posición a poner tu ficha (xy): ");
                jugadaX = teclado.next();

                // Asignamos las posiciones a sus variables
                jugadaXPosx = Character.getNumericValue(jugadaX.charAt(0));
                jugadaXPosy = Character.getNumericValue(jugadaX.charAt(1));
            } while (jugadaXPosy < 0 || jugadaXPosy > 2 || jugadaXPosx < 0 || jugadaXPosx > 2 || tablero[jugadaXPosy][jugadaXPosx] != '_');

            // Posicionamos la ficha en su lugar
            tablero[jugadaXPosy][jugadaXPosx] = 'X';

            // Comprobamos si el jugador X ha ganado
            for (int i = 0; i < 3; i++) {
                if (tablero[i][0] == 'X' && tablero[i][1] == 'X' && tablero[i][2] == 'X') {
                    ganador = "Jugador X";
                    break;
                }
                if (tablero[0][i] == 'X' && tablero[1][i] == 'X' && tablero[2][i] == 'X') {
                    ganador = "Jugador X";
                    break;
                }
            }

            if (tablero[0][0] == 'X' && tablero[1][1] == 'X' && tablero[2][2] == 'X') {
                ganador = "Jugador X";
            }
            if (tablero[0][2] == 'X' && tablero[1][1] == 'X' && tablero[2][0] == 'X') {
                ganador = "Jugador X";
            }

            if (!ganador.equals("")) {
                break; // Si hay ganador, termina el juego
            }

            // TURNO JUGADOR O
            do {
                // Turnos jugador 2 (O)
                System.out.println("Jugador O: Posición a poner tu ficha (xy): ");
                jugadaO = teclado.next();

                // Asignamos las posiciones a sus variables
                jugadaOPosx = Character.getNumericValue(jugadaO.charAt(0));
                jugadaOPosy = Character.getNumericValue(jugadaO.charAt(1));
            } while (jugadaOPosy < 0 || jugadaOPosy > 2 || jugadaOPosx < 0 || jugadaOPosx > 2 || tablero[jugadaOPosy][jugadaOPosx] != '_');

            // Posicionamos la ficha en su lugar
            tablero[jugadaOPosy][jugadaOPosx] = 'O';

            // Comprobamos si el jugador O ha ganado
            for (int i = 0; i < 3; i++) {
                if (tablero[i][0] == 'O' && tablero[i][1] == 'O' && tablero[i][2] == 'O') {
                    ganador = "Jugador O";
                    break;
                }
                if (tablero[0][i] == 'O' && tablero[1][i] == 'O' && tablero[2][i] == 'O') {
                    ganador = "Jugador O";
                    break;
                }
            }

            if (tablero[0][0] == 'O' && tablero[1][1] == 'O' && tablero[2][2] == 'O') {
                ganador = "Jugador O";
            }
            if (tablero[0][2] == 'O' && tablero[1][1] == 'O' && tablero[2][0] == 'O') {
                ganador = "Jugador O";
            }
        }

        // Imprimir el tablero final
        System.out.println("Tablero final:");
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++)
                System.out.print(tablero[i][j] + " ");
            System.out.println();
        }

        // Mostrar el ganador
        System.out.println("¡" + ganador + " ha ganado!");
        teclado.close();
    }
}
