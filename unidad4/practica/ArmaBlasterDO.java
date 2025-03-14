package unidad4.practica;

public class ArmaBlasterDO {
	/****************************
	 * VARIABLES
	 ****************************/
	private int id;
	private String nombre;
	private int puntosRecarga;
	private int danio;

	/****************************
	 * CONSTRUCTORES
	 ****************************/
	public ArmaBlasterDO(int id, String nombre, int puntosRecarga, int danio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.puntosRecarga = puntosRecarga;
		this.danio = danio;
	}

	public ArmaBlasterDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/****************************
	 * GETTERS AND SETTERS
	 ****************************/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntosRecarga() {
		return puntosRecarga;
	}

	public void setPuntosRecarga(int puntosRecarga) {
		this.puntosRecarga = puntosRecarga;
	}

	public int getDanio() {
		return danio;
	}

	public void setDanio(int danio) {
		this.danio = danio;
	}

	/****************************
	 * TO STRING
	 ****************************/
	@Override
	public String toString() {
		return "ArmaBlasterDO [id=" + id + ", nombre=" + nombre + ", puntosRecarga=" + puntosRecarga + ", danio="
				+ danio + "]";
	}

}
