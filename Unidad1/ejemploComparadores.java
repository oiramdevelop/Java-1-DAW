package Unidad1;

public class ejemploComparadores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int edad=18;
		String nombre  = "Emiliano";
		float nota = 4.9f;
		int numModSup = 5;
		boolean traeBebida = true;
		int numAcompa = 2;
		boolean lleva_Zapatillas = true ;
		//Al principio no puede entrar nadie
		boolean puedeEntrarGrad =false;
		boolean moduloAprob = false;
		boolean becaTransp = false;
		float rentaFam = 200000f;
		int numeroFam = 4 ;
		boolean empadronadoZonaFam = true;
		boolean victimaTerro = false;
		boolean victimaMaltra = false;
		
		
		
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
		puedeEntrarGrad = edad>18 && numModSup>=8 && traeBebida ==true && lleva_Zapatillas !=true;
		
		
		
		//Aprueba el modulo si es mayor de 17 años, y cumple de las siguientes condiciones
		// La nota media es mayor de cuatro medio 4.5 o tiene mas de 6 modulos aprobados
		moduloAprob = edad>17 && nota>4.5 || numModSup > 6;
		
		//El alumno consigue la beca de transporte si cumple que su renta familiar es inferior a 20mil  euros
		// la familia tiene entre 3 y 6 personas , y no esta empadronado en otra provincia o cumple que es victima de 
		// terrorismo o de maltrato
		
		//nota 1 : El operador ! (no) niega (resultado contrario) la condicion le sigue
		// nota 2: Para comparar 
		becaTransp = rentaFam <20000 && (numeroFam >= 3 && numeroFam <=6) && (empadronadoZonaFam == true  || victimaTerro == true || victimaMaltra == true );
		
		
		System.out.println("Se le da la beca ?" +  becaTransp );
		System.out.println("Ha aprobado el grado?" + moduloAprob);
	}

}
