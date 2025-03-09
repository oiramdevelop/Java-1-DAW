package PracticasExamenRecuperacion;

/**
 * Esta clase es una clase hija de Empleado que hereda todas sus variables y funciones y además tiene sus atributos miembro:

gastoTarjeta
consejo
sede

 */
public class Jefe extends Empleado {

	private double gastoTarjeta;
	private String consejo;
	private String sede;

	public Jefe(int id, String nombre, int edad, double ingresos, int puesto, double gastoTarjeta, String consejo,
			String sede) {
		//llamamos al constructor de la clase padre que recibe todos las variables miembro
		super(id, nombre, edad, ingresos, puesto);

		this.gastoTarjeta = gastoTarjeta;
		this.consejo = consejo;
		this.sede = sede;
	}

	public Jefe() {
		super();

		this.gastoTarjeta = 0;
		this.consejo = "";
		this.sede = "";
		// TODO Auto-generated constructor stub
	}

	public double getGastoTarjeta() {
		return gastoTarjeta;
	}

	public void setGastoTarjeta(double gastoTarjeta) {
		this.gastoTarjeta = gastoTarjeta;
	}

	public String getConsejo() {
		return consejo;
	}

	public void setConsejo(String consejo) {
		this.consejo = consejo;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	@Override
	public String toString() {
		return "Jefe\n ******************************************************\n gastoTarjeta=" + gastoTarjeta
				+ ", consejo=" + consejo + ", sede=" + sede + "]";
	}

}