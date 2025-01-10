package Unidad3;

public class EjemploUsoObjeto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Hemos creado una clase denominada Personaje Las variables de una clase se
		 * denominan objetos Para crear un objeto utilizamos la palabra reservada new La
		 * clsae es fichero java donde declaramos las variables y funcione que los
		 * objetos puesden utilizar Un objeto es como una variable de esa clase que
		 * puede guardar datos y ejecutar las funciones
		 */
		// Creamos un arma
		// Para poder usar un objeta primero hay que crearlo
		// Se utiliza la palabra reservada new para indicar que lo creamos
		// Cuando lo creamos realmente se llama a una funcion de la clase arma
		// que se denomina con
		Arma arcoGelido = new Arma();

		arcoGelido.nombre = "FrozenLettherarrowgo";

		Arma lanzaPicas = new Arma("lanza Picas", "multiples picas a la vez", 0, 20, 0, 3);

		// Creamos un personaje con new y el nombre de la clase
		Personajes aragorn = new Personajes();
		// Para acceder a las variables mienbre de la clase se utiliza el .
		aragorn.fuerza = 13;

		System.out.println("El personaje tiene " + aragorn.inteligencia + " puntos de inteligencia");

		System.out.println("El personaje tiene " + aragorn.puntosVida + " puntos de vida");
		int golpe = 4;
		aragorn.recibirDanio(0);
		System.out.println("El personaje tiene " + aragorn.puntosVida + " puntos de vida");

		System.out.println("tirada de ataque de aragorn " + aragorn.tiradaAtaque());

		System.out.println("Descripcion del arma " + arcoGelido.getDescripcion());

	}

}
