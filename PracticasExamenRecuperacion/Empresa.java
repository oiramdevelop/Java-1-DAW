package PracticasExamenRecuperacion;



import java.util.Arrays;

/**
 * Identificador, puede tener números y letras
Nombre
Dirección
tipo
web
ingresosAnuales
gastosEmpleados 
Array de Empleados

 */
public class Empresa {

	private String id;
	private String nombre;
	private String direccion;
	private String tipo;
	public String web;
	private double ingresosAnuales;
	private double gastosEmpleados;
	private Empleado[] listaEmpleados;

	public Empresa() {
		super();
		// TODO Auto-generated constructor stub
		this.id = "";
		this.nombre = "";
		this.direccion = "";
		this.tipo = "";
		this.web = "";
		this.ingresosAnuales = (int) (Math.random() * 1000);
		this.gastosEmpleados = (int) (Math.random() * 1000);
		this.listaEmpleados = new Empleado[20];

	}

	public Empresa(String id, String nombre, String direccion, String tipo, String web, double ingresosAnuales,
			double gastosEmpleados, Empleado[] listaEmpleados) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.tipo = tipo;
		this.web = web;
		this.ingresosAnuales = ingresosAnuales;
		this.gastosEmpleados = gastosEmpleados;
		this.listaEmpleados = listaEmpleados;
	}

	/************************
	 * 	FUNCIONES
	 ************************/

	/**
	 * int numEmpleados(): Devolverá la cantidad de empleados de 
	 * la empresa, es decir la longitud del array de Empleados.(1 punto)
	 * @return
	 */
	public int numEmpleados() {
		return this.listaEmpleados.length;
	}

	/*
	 * Empleado empleadoMasCaro(int puesto) devolverá 
	 * el empleado que más cobra dentro del tipo introducido. 
	 * Si se introduce -1 en puesto, 
	 * devolverá el que más cobra de todos (2 puntos).
	 */
	Empleado empleadoMasCaro(int puesto) {

		Empleado empleadoMaxSueldo = new Empleado();

		//Primero comprobamos si hay que recorrer todos los empleados o solo los del puesto
		if (puesto == -1) {
			double sueldoMax = Double.MIN_VALUE;

			for (Empleado empleado : this.listaEmpleados) {
				//Si el sueldo del empleado actual es mayor que el maximo
				//este empleado es el empleado que mas cobra
				if (empleado.getIngresos() > sueldoMax) {
					sueldoMax = empleado.getIngresos();
					empleadoMaxSueldo = empleado;
				}
			}

		} else {
			//En caso de que haya tipo, hay que buscar solo entre los 
			//Empleados de ese tipo
			double sueldoMax = Double.MIN_VALUE;

			for (Empleado empleado : this.listaEmpleados) {
				//Si el sueldo del empleado actual es mayor que el maximo
				//Y es del tipo seleccionado
				//este empleado es el empleado que mas cobra
				if (empleado.puesto == puesto && empleado.getIngresos() > sueldoMax) {
					sueldoMax = empleado.getIngresos();
					empleadoMaxSueldo = empleado;
				}
			}

		}

		return empleadoMaxSueldo;
	}

	/*
	 * boolean asignarJefeEquipo(String nombre) Buscará en el array de empleados 
	 * el que tenga el nombre introducido cómo parámetro. Si no existe se devolverá falso. 
	 * Si existe y su puesto ya es “jefe de equipo” también devolverá falso. 
	 * En caso de que no sea jefe de equipo le asignara ese puesto y devolverá true.(2 puntos)
	 */

	public boolean asignarJefeEquipo(String nombre) {

		//Recorremos buscando el empleado con el nombre que recibimos
		for (int i = 0; i < this.listaEmpleados.length; i++) {
			if (this.listaEmpleados[i].getNombre().equals(nombre)) {
				if (this.listaEmpleados[i].puesto == Empleado.PUESTO_JEFE) {
					return false;
				} else {
					//Si el empleado con el nombre a buscar no es jefe
					//Le asignamos de puesto jefe y devolvemos true
					this.listaEmpleados[i].puesto = Empleado.PUESTO_JEFE;
					return true;
				}
			}
		}

		return false;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getIngresosAnuales() {
		return ingresosAnuales;
	}

	public void setIngresosAnuales(double ingresosAnuales) {
		this.ingresosAnuales = ingresosAnuales;
	}

	public double getGastosEmpleados() {
		return gastosEmpleados;
	}

	public void setGastosEmpleados(double gastosEmpleados) {
		this.gastosEmpleados = gastosEmpleados;
	}

	public Empleado[] getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(Empleado[] listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", tipo=" + tipo + ", web="
				+ web + ", ingresosAnuales=" + ingresosAnuales + ", gastosEmpleados=" + gastosEmpleados
				+ ", listaEmpleados=" + Arrays.toString(listaEmpleados) + "]";
	}

}