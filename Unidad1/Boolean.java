package Unidad1;

import java.util.Scanner;

public class Boolean {
	public static void main(String arg[]) {
		// Comentario de una linea 
		
		String nombre = " ";
		int edad = 23;
		float sueldo = 3333;
		char sexo = 'f';
		
		String dni = "465654534L";
		
		String numeroEmpleado = "9377373828LLKÑLKLK";
		
		String vram = "35689TB";
		
		// Los bolean nos indican si es true o false dependiendo de la variable/s anterior
		boolean esHombre=true;
		
		
		boolean esMayorEdad = (edad>=18);
	
		
		
		//Generamos un numero aleatorio entre 1 y 30
		int numeroAlumnoAgraciado = (int) (Math.random()*30+1);
		
		
		
		
		//Creamos un objeto de tipo Scanner llamado teclado 
		Scanner teclado= new Scanner(System.in);
		
		
		System.out.println("CUal es tu nombre ?");
		
		//Leemos el nombre del teclado.
		nombre = teclado.next();
		
	
		
		
		System.out.println("Cuantos años tienes");
		//Leeemos un entero que es la edad de teclado 
		//Para eso utilizamos nextint
		edad = teclado.nextInt();
		
		esMayorEdad= (edad>=18);
		

		
		System.out.println("Este alumnoe es mayor de edad? " + esMayorEdad );
		
		
		//Leemos el sueldo
		System.out.println("Cuanto cobras picha ??");
		
		//Leemos un float utilizamos nextFloat()
		sueldo = teclado.nextFloat();
		
		//Leemos el sexo
		System.out.println("Que sexe ere??");
		sexo = teclado.next().charAt(0);
		
		System.out.print("El nombre es " + nombre);
		System.out.print(" su edad es " + edad);
		System.out.print(" su sueldo es " + sueldo);
		System.out.print(" su sexe es " + sexo);
		
		
		teclado.close();
	}
}
