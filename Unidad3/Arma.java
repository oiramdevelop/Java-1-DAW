package Unidad3;

/**
 * La clase arma sirve para guardar las caracteristicas La podran llevar los
 * personajes del juego
 */
public class Arma {

	/**********************************************
	 * VARIABLES MIEMBRO DE LA CLASE
	 * 
	 **********************************************/

	// Nombre del arma , es importante elegir que de miedo al enemigo
	public String nombre = "";

	// Descripcion del arma
	private String descripcion = "";

	// Efecto que inflinge
	private int efecto = 0;

	private int ataqueFisico = 0;
	private int ataqueMagico = 0;
	private double peso = 0;
	private int clasePermitida[];

	/********************************************
	 * CONSTRUCTORES DE LA CLASE
	 **********************************************/

	public Arma() {
		System.out.println("se ha creado un Arma");
		this.peso = (int) (Math.random() * 5);
		this.ataqueFisico = (int) ((Math.random() * 18) + 2);
		this.efecto = (int) (Math.random() * 5);
		this.descripcion = "Arma por defecto , no hace pupa";

	}

	/**
	 * Constructor que recibe todo los datos del objeto y los asigna a las variables
	 * miembro
	 * 
	 * @param nombre
	 * @param descripcion
	 * @param efecto
	 * @param ataqueFisico
	 * @param ataqueMagico
	 * @param peso
	 */

	public Arma(String nombre, String descripcion, int efecto, int ataqueFisico, int ataqueMagico, double peso) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.efecto = efecto;
		this.ataqueFisico = ataqueFisico;
		this.ataqueMagico = ataqueMagico;
		this.peso = peso;

	}

	/********************************************
	 * GETTERS Y SETTER DE LA CLASE
	 **********************************************/

	public String getNombre() {
		return this.getNombre();
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String valorDescripcion) {
		this.descripcion = valorDescripcion;

	}
}
