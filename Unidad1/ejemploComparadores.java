package Unidad1;

public class ejemploComparadores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int edad=18;
		String nombre  = "Emiliano";
		float nota = 4.9f;
		int numModSup = 99;
		boolean traeBebida = true;
		int numAcompa = 2;
		boolean zapatillas = true ;
		//Al principio no puede entrar nadie
		boolean puedeEntrarGad =false;
		
		
		
		System.out.println("El alumno puede entrar a la graduacion");
		
		//El alumno puede entrar en el acti de graducacion final de fp si y solo si 
		// es mayor de edad. 
		// ha aprobado 8 modulos o mas
		// no trae zapatilla deportivas
		// trae menos de 3 acompañantes
		
		
		//El operador es cierto si el numero a la izquierda es mayor que el de la derecha 
		//Estrictamente , si son iguales es falso
		System.out.println("Es mayor que 18?"+ (edad>18));
		System.out.println("Es mayor o igual que 18?" + (edad>=18));
		
		System.out.println("El alumno esta suspenso?" + (nota<5));
		
		
		//Combinamos todoas las condiciones con el operador logico y (&&)
		
		boolean puedeEntrarGrad = edad>18 && numModSup>=8 && traeBebida ==true && zapatillas !=true;
		
	}

}
