package Unidad3;

public class EjemploUsoPersonaje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Hemos creado una clase denominada Personaje Las variables de una clase se
		 * denominan objetos Para crear un objeto utilizamos la palabra reservada new La
		 * clase es el fichero java donde declaramos las variables y funciones que los
		 * objetos pueden utilizar Un objeto es como una variable de esa clase que puede
		 * guardar datos y ejecutar las funciones
		 */
		// Creamos un arma
		// Para poder usar un objeto primero hay que crearlo
		// Se utiliza la palabra reserva new para indicar que lo creamos
		// Cuando lo creamos realmente se llama a una funcion de la clase arma
		// que se denomina contructor
		Arma arcoGelido = new Arma();

		Arma lanzaPicas = new Arma("lanza Picas", "multiples picas a la vez", 0, 20, 0, 3);

		String nombre = "pepe";

		// Creamos un personaje con new y el nombre de la clase
		Personaje aragorn = new Personaje();

		aragorn.setClase(Personaje.CLASE_GUERRERO);

		Enemigo slimeVerde = new Enemigo();

		Enemigo orcoOscuro = new Enemigo(3, 23, 1, 5, 1, 23, 0, 350, 15, Enemigo.BOSQUE_OSCURO);

		// añadimos las armas a aragorn
		aragorn.addArma(arcoGelido);
		aragorn.addArma(lanzaPicas);

		// Para acceder a las variables miembro de la clase se utiliza el .
		aragorn.setFuerza(13);

		System.out.println("El personaje tiene " + aragorn.getInteligencia() + " puntos de inteligencia");

		System.out.println("El arma principal de Aragorn es " + aragorn.armaPrincipal());

		System.out.println("El personaje tiene " + aragorn.getPuntosVida() + " puntos de vida");
		int golpe = 4;
		aragorn.recibirDanio(golpe);

		System.out.println("El personaje tiene " + aragorn.getPuntosVida() + " puntos de vida");

		System.out.println("Tirada de ataque de aragorn: " + aragorn.tiradaAtaque());

		System.out.println("Descripcion del arma: " + arcoGelido.getDescripcion());

		arcoGelido.setDescripcion("Congela los higadillos");

		System.out.println("Descripcion del arma: " + arcoGelido.getDescripcion());

		System.out.println("Datos del arma " + arcoGelido);

		System.out.println("Datos del Slime " + slimeVerde);

		System.out.println("Datos del Slime " + orcoOscuro);

	}

}