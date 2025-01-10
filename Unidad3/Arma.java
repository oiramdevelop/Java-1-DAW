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
	private int peso = 0;
	private int clasePermitida[];

	/********************************************
	 * CONSTRUCTORES DE LA CLASE
	 **********************************************/

	public Arma() {
		System.out.println("se ha creado un Arma");
		this.peso = (int) (Math.random() * 5);
		this.ataqueFisico = (int) ((Math.random() * 18) + 2);

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
