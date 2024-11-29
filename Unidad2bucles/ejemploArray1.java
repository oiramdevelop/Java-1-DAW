package Unidad2bucles;

public class ejemploArray1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Para definir un array hay que poner [] despues
		double listaAltura[] = { 200, 185, 190, 230, 170, 180, 200 };
		String listaNombre[] = { "davi,david1,emeldi,emerrrrdi,talo,leyton,tupare,mimare,vivu,javi" };
		// tenemos despues la cantidad de jugadores
		int cantidadJugadores = 10;

		// Generamos las alturas entre 150 y 230
		for (int i = 0; i < 10; i++) {

			// Vamos rellenando el array con las alturas aleatorias
			double altura = 150 + (Math.random() * 80.0);

			// Ponemos la altura generada dentro de la posicion i del array

			listaAltura[i] = altura;

			System.out.println("Altura del jugador actual " + i + ":" + altura);
		}
		System.out.println("Lista altura :\n" + listaAltura.toString());
		// Para definir el tamaño de un array utilizamos nwe
		// el tipo de dato y las posisiciones que va a tener
		// listaAltura = new double[cantidadJugadores];
		listaNombre = new String[cantidadJugadores];

		// Para asignar valores a una posicion en particular de un array utilizamos [ ]
		// con el
		// numero de la posicion en la que queremos guardar el dato
		listaNombre[2] = "Juanjo";

		System.out.println("Nombre Jugador 2 : " + listaNombre[2] + "Altura Jugador 2: " + listaAltura[2]);

		// Sacar la media de las alturas de lops jugadores
		double mediaAltura = 0;
		int i = 0;
		// Mientras no lleguemos al utlimo elemento sumando
		// con length podemos saber la cantidad de elementos que hay alamacenados en
		// este array
		while (i < 10) {
			// vamos suamndo cada altura en la variable que definimos
			mediaAltura = mediaAltura + listaAltura[i];
			// pasamos al siguiente elemento
			i++;
		}
		System.out.println("La media de las alturas es " + (mediaAltura / listaAltura.length));

	}

}
