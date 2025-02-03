package Unidad3;

import java.util.Scanner;

public class Mundo {

	public static final char TIERRA = 'T';
	public static final char BOSQUE = 'B';
	public static final char MONTANA = 'M';

	public static final char TIPO_JUGADOR = 'J';
	public static final char TIPO_ENEMIGO = 'E';

	// El juego tendrá únicamente un enemigo y un jugador
	public Enemigo enemigo;
	public Personaje jugador;

	// Variables para guardar el terreno pisado por los personajes
	private char tierraJ = 'J';
	private char tierraE = 'E';

	// El mapa sera un array de dos dimensiones de string
	private char[][] mapa = { { 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M' },
			{ 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M' }, { 'T', 'T', 'T', 'T', 'M', 'M', 'M', 'M', 'M', 'M' },
			{ 'T', 'T', 'T', 'T', 'B', 'B', 'B', 'B', 'B', 'B' }, { 'T', 'T', 'T', 'T', 'B', 'B', 'B', 'B', 'B', 'B' },
			{ 'M', 'T', 'T', 'T', 'B', 'B', 'B', 'B', 'B', 'B' }, { 'M', 'M', 'M', 'M', 'B', 'B', 'B', 'B', 'B', 'B' },
			{ 'M', 'M', 'M', 'M', 'B', 'B', 'B', 'B', 'B', 'B' }, { 'M', 'M', 'M', 'M', 'M', 'B', 'B', 'B', 'B', 'M' },
			{ 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M' } };

	public void mostrarMapa() {
		// Recorremos todas las filas del mapa (cada fila es un subarray)
		for (int i = 0; i < mapa.length; i++) {
			// Recorremos cada fila o subarray desde 0 hasta la longitud de ese subarray
			for (int j = 0; j < mapa[i].length; j++) {
				System.out.print(mapa[i][j] + " ");
			}
			// Una vez hemos dibujado la fila completa hay que pasar a la siguiente linea
			System.out.println();
		}
	}

	/**
	 * Esta funcion posiciona en el mapa a el jugador o el enemigo
	 * 
	 * @param tipo es el tipo de elemento que va a poscionar en el mapa
	 */
	public void posicionarPersonajes(int tipo) {

		// Generamos aleatoriamente dos posiciones
		int posY = (int) (Math.random() * mapa.length);
		int posX = (int) (Math.random() * mapa.length);
		boolean enemigoCerca = false;

		// si es un enemigo lo colocamos del tiron y finalizamos
		if (tipo == Mundo.TIPO_ENEMIGO) {
			// Guardamos la tierra para poder volver a dibujarla despues
			this.tierraE = mapa[posY][posX];
			// Posicionamos al enemigo
			mapa[posY][posX] = Mundo.TIPO_ENEMIGO;
			// Le damos esa posicion al enemigo
			this.enemigo.setPosX(posX);
			this.enemigo.setPosY(posY);
			return;
		}

		// Comprobamos que no hay enemigos cerca
		enemigoCerca = enemigoCerca(posY, posX);

		// Mientras el enemigo este cerca hay que seguir cambiando de posicion
		while (enemigoCerca) {
			// Creo nuevas coordenadas
			posY = (int) (Math.random() * mapa.length);
			posX = (int) (Math.random() * mapa.length);

			// Hay que presuponer que no hay enemigos en la costa
			// en las nuevas posiciones generadas
			enemigoCerca = enemigoCerca(posY, posX);
		}

		// Si llegamos aqui implica que no hay enemigos cerca
		// Ponemos el jugador en la posicion indicada
		// Guardamos la tierra que va a ser sobreescrita por el jugador
		this.tierraJ = mapa[posY][posX];
		mapa[posY][posX] = Mundo.TIPO_JUGADOR;
		// Le damos esa posicion al enemigo
		this.jugador.setPosX(posX);
		this.jugador.setPosY(posY);
		return;

	}

	/**
	 * Comprueba si el enemigo esta cerca de la poscion indicada
	 * 
	 * @param posX
	 * @param posY
	 * @return
	 */
	public boolean enemigoCerca(int posX, int posY) {
		boolean enemigoCerca = false;

		// Comprobamos que no hay enemigos cerca
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {

				if ((posY + i) > 0 && (posX + j) > 0 && mapa[posY + i][posX + j] == Mundo.TIPO_ENEMIGO)
					enemigoCerca = true;
			}
		}

		return enemigoCerca;
	}

	/**
	 * Mueve al enemigo hacia la posicion del jugador y si lo tiene cerca acaba con
	 * el y finaliza el juego devolviendo true
	 * 
	 * @return cierto si tiene al jugador cerca
	 */
	public boolean moverEnemigo() {

		// Sobreescribimos la posicion actual del jugador por la tierra que habia pisado
		this.mapa[enemigo.getPosY()][enemigo.getPosX()] = this.tierraE;

		// Si la distancia horizontal es mayor que la vertical
		// Entre las posiciones de los personajes, el enemigo se mueve horizontalmente
		if (Math.abs(enemigo.getPosX() - jugador.getPosX()) > Math.abs(enemigo.getPosY() - jugador.getPosY())) {
			// Si la posicion X del enemigo es inferior a la del jugador me voy pa la
			// derecha
			if (enemigo.getPosX() < jugador.getPosX())
				enemigo.setPosX(enemigo.getPosX() + 1);
			else
				enemigo.setPosX(enemigo.getPosX() - 1);
		} else // En caso de que nos movamos verticalmente
		{
			// Si la posicion Y del enemigo es inferior a la del jugador me voy pabajo
			if (enemigo.getPosY() < jugador.getPosY())
				enemigo.setPosY(enemigo.getPosY() + 1);
			else
				enemigo.setPosY(enemigo.getPosY() - 1);
		}

		// Guardamos primero la tierra sobre la cual se va a mover el ENEMIGO
		tierraE = mapa[enemigo.getPosY()][enemigo.getPosX()];
		// Ponemos al ENEMIGO en la nueva posicion
		this.mapa[enemigo.getPosY()][enemigo.getPosX()] = this.TIPO_ENEMIGO;

		// Comprobamos si ha pillado al enemigo
		return enemigoCerca(jugador.getPosY(), jugador.getPosX());
	}

	/**
	 * Constructor del Mundo Crea al jugador y al enemigo y los posiciona en el mapa
	 */

	public void moverJugador(Scanner teclado) {
		// leemos un caracter de teclado
		char movimiento = teclado.next().toLowerCase().charAt(0);

		// Sobreescribimos la posicion actual del jugador por la tierra que habia pisado
		this.mapa[jugador.getPosY()][jugador.getPosX()] = this.tierraJ;

		switch (movimiento) {
		case 'w':
			// Quiere ir para arriba si ya esta arriba no nos movemos
			if (jugador.getPosY() > 0)
				jugador.setPosY(jugador.getPosY() - 1);
			break;

		case 's':
			// Quiere ir para abajo si ya esta abajo no nos movemos
			if (jugador.getPosY() < 9)
				jugador.setPosY(jugador.getPosY() + 1);
			break;

		case 'a':
			// Quiere ir para la izquierda si ya esta a la izquierda del todo no hacemos
			// nada
			if (jugador.getPosX() > 0)
				jugador.setPosX(jugador.getPosX() - 1);
			break;

		case 'd':
			// Quiere ir para abajo si ya esta abajo no nos movemos
			if (jugador.getPosX() < 9)
				jugador.setPosX(jugador.getPosX() + 1);
			break;
		}

		// Guardamos primero la tierra sobre la cual se va a mover el jugador
		tierraJ = mapa[jugador.getPosY()][jugador.getPosX()];
		// Ponemos al jugador en la nueva posicion
		this.mapa[jugador.getPosY()][jugador.getPosX()] = this.TIPO_JUGADOR;
	}

	public Mundo() {

		this.jugador = new Personaje();
		jugador.setClase(Personaje.CLASE_MAGO);
		this.enemigo = new Enemigo(3, 23, 1, 5, 1, 23, 0, 350, 15, Enemigo.BOSQUE_OSCURO);

		// Posicionamos al enemigo
		posicionarPersonajes(TIPO_ENEMIGO);
		posicionarPersonajes(TIPO_JUGADOR);

	}

	public void iniciarMundo() {
		// TODO Auto-generated method stub
		boolean juegoFinalizado = false;
		Scanner teclado = new Scanner(System.in);

		// El juego se finalizará cuando el enemigo atrape al personaje
		while (!juegoFinalizado) {
			// Mostramos el mapa
			this.mostrarMapa();

			this.moverJugador(teclado);

			juegoFinalizado = this.moverEnemigo();

		}

		this.mostrarMapa();
		System.out.println("HAS MUERTO!!!!");

		teclado.close();
	}

}