package Unidad3;

public class Personajes {

	// Variables miembro de la clase
	// Todos los objetos que creemos las tendrán

	// Por defecto si no ponemos nada las variables son publicas
	// Pueden ser
	/*
	 * public publicas private privada protected protegidas, solo las clases hijas
	 * pueden usarlas
	 */
	public int fuerza;
	public int inteligencia;
	public int carisma;
	private int clase;

	// Si las ponemos privadas no serán accesibles directamente desde el objeto
	public int puntosVida;
	private int puntosPoder;

	/*
	 * Constructor principal
	 */
	public Personajes() {
		System.out.println("Generando el personaje...");

		// utilizamoss this para señalar que la variable es miembro de la clase
		// por si hubiera otra variable con el mismo nombre
		this.fuerza = (int) (Math.random() * 20);
		this.inteligencia = (int) (Math.random() * 20);
		this.carisma = (int) (Math.random() * 20);
		this.puntosVida = (int) (Math.random() * 20);
		this.puntosPoder = (int) (Math.random() * 20);
	}

	/*
	 * Esta funcion ejecuta una tirada de ataque que se calcula con un dado de 20
	 * mas la fuerza
	 */
	public int tiradaAtaque() {
		// Ejecutamos la tirada de ataque
		return this.fuerza + (int) (Math.random() * 21);
	}
	// Funciones

	// Las fuciones al decclarse deben de fenir si son publicas/privadas/protegidas
	// y el tipo de dato que devuelven
	// En estrecaso no quiero que devuelca nada asi que pondgo void

	public void recibirDanio(int danio) {
		this.puntosVida = this.puntosVida - danio;
	}

}
