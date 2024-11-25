package Unidad2;

import java.util.Scanner;

public class Dado {

    public static void main(String[] args) {
        // Variables para los dados de cada jugador
        int p1dado1 = (int) (Math.random() * 6) + 1;
        int p1dado2 = (int) (Math.random() * 6) + 1;
        int p2dado1 = (int) (Math.random() * 6) + 1;
        int p2dado2 = (int) (Math.random() * 6) + 1;

        String jugador1;
        String jugador2;

        Scanner teclado = new Scanner(System.in);

        // Pedimos los nombres de los jugadores
        System.out.println("Dime tu nombre, jugador 1:");
        jugador1 = teclado.next();
        System.out.println("Dime tu nombre, jugador 2:");
        jugador2 = teclado.next();

        teclado.close();

        // Mostrar las tiradas de los dados
        System.out.println(jugador1 + " ha sacado " + p1dado1 + " y " + p1dado2);
        System.out.println(jugador2 + " ha sacado " + p2dado1 + " y " + p2dado2);

        // Evaluar los resultados usando prioridad y suma
        int prioridad1 = 1; // Sin pareja
        if (p1dado1 == p1dado2) {
            if (p1dado1 == 6) {
                prioridad1 = 3; // Pareja de seises
            } else {
                prioridad1 = 2; // Pareja menor
            }
        }

        int prioridad2 = 1; // Sin pareja
        if (p2dado1 == p2dado2) {
            if (p2dado1 == 6) {
                prioridad2 = 3; // Pareja de seises
            } else {
                prioridad2 = 2; // Pareja menor
            }
        }

        // Decidir el ganador comparando prioridades
        String ganador = null;
        if (prioridad1 > prioridad2) {
            ganador = jugador1;
        } else if (prioridad2 > prioridad1) {
            ganador = jugador2;
        } else { 
            int suma1 = p1dado1 + p1dado2;
            int suma2 = p2dado1 + p2dado2;

            if (suma1 > suma2) {
                ganador = jugador1;
            } else if (suma2 > suma1) {
                ganador = jugador2;
            }
        }

        // Mostrar el resultado final
        if (ganador == null) { // Null indica un empate
            System.out.println("¡Es un empate!");
        } else {
            System.out.println("El ganador es: " + ganador);
        }
    }
}
