package PracticasExamenRecuperacion;

public class Empleado {
		
		/***
		 * VARIABLES
		 */
		public static final int PUESTO_JEFE = 0;
		public static final int PUESTO_RRHH = 1;
		public static final int PUESTO_ADMIN = 2;
		public static final int PUESTO_VENTAS = 3;

		protected int id;
		private String nombre;
		private int edad;
		private double ingresos;
		public int puesto;
		
		
		/***
		 * CONSTRUCTORES
		 */
		public Empleado() {
			super();
			this.id = (int) (Math.random() * 1000);
			this.nombre = "";
			this.edad = (int) (Math.random() * 50) + 18;
			this.ingresos = (int) (Math.random() * 2000);
			this.puesto = (int) (Math.random() * 4);
			// TODO Auto-generated constructor stub
		}

		public Empleado(int id, String nombre, int edad, double ingresos, int puesto) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.edad = edad;
			this.ingresos = ingresos;
			this.puesto = puesto;
		}

		
		/***
		 * GETTERS AND SETTERS
		 */
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

		public int getEdad() {
			return edad;
		}

		public void setEdad(int edad) {
			this.edad = edad;
		}

		public double getIngresos() {
			return ingresos;
		}

		public void setIngresos(double ingresos) {
			this.ingresos = ingresos;
		}
		
		/***
		 * TO STRING
		 */
		@Override
		public String toString() {
			return "Empleado:\n************************************************" + "id=" + id + "\n nombre=" + nombre
					+ "\n edad=" + edad + "\n ingresos=" + ingresos + "\n puesto=" + puesto
					+ "\n*************************************************************";
		}

	}


