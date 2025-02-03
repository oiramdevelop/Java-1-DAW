package Unidad3;

import java.util.ArrayList;

public class Personaje {

	// Variables miembro de la clase
	// Todos los objetos que creemos las tendrán

	// Las variables miembro y las funciones de una clase
	// Pueden ser
	// public publicas
	// private privadas
	// protected protegidas, solo las clases hijas pueden usarlas

	public static final int CLASE_GUERRERO = 0;
	public static final int CLASE_MAGO = 1;
	public static final int CLASE_LADRON = 2;
	public static final int CLASE_CABALLERIA = 3;
	public static final int CLASE_CLERIGO = 4;
	public static final int CLASE_PALADIN = 5;

	// Por defecto si no ponemos nada las variables son publicas
	protected int nivel;
	private int fuerza;
	private int inteligencia;
	private int carisma;
	public int clase;
	// Si las ponemos privadas no serán accesibles directamente desde el objeto
	private int puntosVida;
	private int puntosPoder;

	private int posX;
	private int posY;

	// int listaNumeros[] = new int[10];

	// Para definir un arraylist hay que decir el tipo de objeto que va a almacenar
	// entre <>
	// Al contrario que con un array normal, no hace falta definir el tamaño, segun
	// añadimos elementos al arraylist va haciendose mas grande
	private ArrayList<Arma> armas = new ArrayList<Arma>();

	// ArrayList<Integer> listaNumeros = new ArrayList<Integer>();

	/**
	 * Constructor principal vacio
	 */
	public Personaje() {

		System.out.println("Generando el personaje...");

		// Utilizamos this para señalar que la variable es miembro de la clase
		// por si hubiera otra variable con el mismo nombre
		this.fuerza = (int) (Math.random() * 20);
		this.inteligencia = (int) (Math.random() * 20);
		this.carisma = (int) (Math.random() * 20);
		this.puntosVida = (int) (Math.random() * 20);
		this.puntosPoder = (int) (Math.random() * 20);
		this.nivel = (int) (Math.random() * 20);

	}

	/**
	 * Constructor que recibe todos los valores del objeto y los asigna a las
	 * variables miembro
	 * 
	 * @param fuerza
	 * @param inteligencia
	 * @param carisma
	 * @param clase
	 * @param puntosVida
	 * @param puntosPoder
	 */
	public Personaje(int nivel, int fuerza, int inteligencia, int carisma, int clase, int puntosVida, int puntosPoder) {
		super();
		this.nivel = nivel;
		this.fuerza = fuerza;
		this.inteligencia = inteligencia;
		this.carisma = carisma;
		this.clase = clase;
		this.puntosVida = puntosVida;
		this.puntosPoder = puntosPoder;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	/**
	 * Esta funcion ejecuta una tirada de ataque que se calcula con un dado de 20
	 * mas la fuerza
	 * 
	 * @return
	 */
	public int tiradaAtaque() {

		// Ejecutamos la tirada de ataque
		return this.fuerza + (int) (Math.random() * 21);
	}

	// Funciones

	// Las funciones al declararse deben de definir si son
	// publicas/privadas/protegidas
	// y el tipo de dato que devuelven
	// En este caso no quiero que devuelva nada asi que pongo void
	public void recibirDanio(int danio) {
		this.puntosVida = this.puntosVida - danio;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	public int getCarisma() {
		return carisma;
	}

	public void setCarisma(int carisma) {
		this.carisma = carisma;
	}

	public int getClase() {
		return clase;
	}

	public void setClase(int clase) {
		this.clase = clase;
	}

	public int getPuntosVida() {
		return puntosVida;
	}

	public void setPuntosVida(int puntosVida) {
		this.puntosVida = puntosVida;
	}

	public int getPuntosPoder() {
		return puntosPoder;
	}

	public void setPuntosPoder(int puntosPoder) {
		this.puntosPoder = puntosPoder;
	}

	public ArrayList<Arma> getArmas() {
		return armas;
	}

	public void setArmas(ArrayList<Arma> armas) {
		this.armas = armas;
	}

	/**
	 * Recibe un arma y la añade a la lista de armas del personaje
	 * 
	 * @param armaRecibida objeto de tipo arma que añade al personaje
	 */
	public void addArma(Arma armaRecibida) {
		// añadimos con add el arma recibida
		// En la ultima posicion del arraylist de armas
		this.armas.add(armaRecibida);
	}

	/**
	 * La función devuelve la primera arma de la lista de armas que se supone la
	 * principal Si la lista de armas esta vacia devuelve null
	 * 
	 * @return Devuelve el arma principal del personaje o null si no tiene armas
	 */
	public Arma armaPrincipal() {

		// Solo cogemos el arma de la posicion 0 si en la lista de armas
		// hay al menos 1 arma
		if (armas.size() >= 1)
			return this.armas.get(0);

		return null;
	}

	@Override
	public String toString() {
		return "Personaje [nivel=" + nivel + ",fuerza=" + fuerza + ", inteligencia=" + inteligencia + ", carisma="
				+ carisma + ", clase=" + clase + ", puntosVida=" + puntosVida + ", puntosPoder=" + puntosPoder
				+ ", armas=" + armas + "]";
	}

}