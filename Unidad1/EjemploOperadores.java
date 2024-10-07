package Unidad1;

public class EjemploOperadores {
	public static void main (String[] args ) {
		
		int numAlumnosDAW = 56;
		int numAlumnosAsir = 32;
		int numAlumnosCETI = 19;
		int numAlumnosFPB = 19;
		int numAlumnosSMR = 70;
		
		
		//Para sumar se usal el +
		
		int sumaAlumnos = numAlumnosDAW + numAlumnosAsir ;
		
		
		//Para incrementar el valor le suma a el mismo + lo que toque
		sumaAlumnos = sumaAlumnos +numAlumnosFPB + numAlumnosSMR;
		
		//El operador += incrementa el valor de la variable situada a la izquierda
		// Con el valor que este a la derecha
		sumaAlumnos = sumaAlumnos += numAlumnosCETI;
		
		//Este operador sirve para restar a la variable
		sumaAlumnos = sumaAlumnos - 67;
		
		//Le suma uno a la variable
		sumaAlumnos++;
		
		//Le resta uno a la variable
		sumaAlumnos--;
		
		System.out.println("Los alumnos de informatica totales son: " + sumaAlumnos);
		
		
	}
}
