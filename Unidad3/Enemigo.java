package Unidad3;

public class Enemigo extends Personaje {

	public static final String BOSQUE_OSCURO = "Bosque Oscuro";
	public static final String RUINAS_ROJAS = "Ruinas Rojas";
	public static final String PLAGA_VERDE = "Plaga Verde";

	private int pExperiencia;
	private int dinero;
	private String faccion;

	public Enemigo() {
		super();
		// TODO Auto-generated constructor stub
		// Generamos la experiencia dependiendo del nivel, cada nivel son 100 puntos
		// extras de experiencia
		// y un extra aleatorio que sera mas alto dependiendo del nivel
		int rangoExperiencia = this.nivel * 20;
		int numFaccion = (int) (Math.random() * 3);
		this.pExperiencia = this.getNivel() * 100 + (int) (Math.random() * rangoExperiencia);

		this.dinero = (this.getNivel() * 100 + (int) (Math.random() * rangoExperiencia)) / 4;

		// dependiendo del numero de faccion asignamos el enemigo a un facción o otra
		switch (numFaccion) {
		case 0:
			this.faccion = this.BOSQUE_OSCURO;
			break;
		case 1:
			this.faccion = this.RUINAS_ROJAS;
			break;
		case 2:
			this.faccion = this.PLAGA_VERDE;
			break;
		}

	}

	/**
	 * Contructor que recibe todos los valores de un enemigo y se los asigna
	 * 
	 * @param nivel
	 * @param fuerza
	 * @param inteligencia
	 * @param carisma
	 * @param clase
	 * @param puntosVida
	 * @param puntosPoder
	 * @param pExperiencia
	 * @param dinero
	 * @param faccion      (BOSQUE_OSCURO, RUINAS_ROJAS, PLAGA_VERDE)
	 */
	public Enemigo(int nivel, int fuerza, int inteligencia, int carisma, int clase, int puntosVida, int puntosPoder,
			int pExperiencia, int dinero, String faccion) {

		// llamamos al constructor de personaje con los datos de la parte del padre
		super(nivel, fuerza, inteligencia, carisma, clase, puntosVida, puntosPoder);

		// Y los datos especificos de enemigo los asigno
		this.pExperiencia = pExperiencia;
		this.dinero = dinero;
		this.faccion = faccion;
	}

	public int getpExperiencia() {
		return pExperiencia;
	}

	public void setpExperiencia(int pExperiencia) {
		this.pExperiencia = pExperiencia;
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	public String getFaccion() {
		return faccion;
	}

	public void setFaccion(String faccion) {
		this.faccion = faccion;
	}

	// @Override sirve para sobreescribir en una clase hijo una función que tiene el
	// padre
	// Y queremos modificar
	@Override
	public String toString() {
		// Para utilizar las funciones que heredamos del padre utilizamos la palabra
		// reservada
		// super
		return super.toString() + " Enemigo [pExperiencia=" + pExperiencia + ", dinero=" + dinero + ", faccion="
				+ faccion + ", clase=" + clase + "]";
	}

}