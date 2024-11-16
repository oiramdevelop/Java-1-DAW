package Unidad2;

import java.util.Scanner;

public class ejercicioAeropuertoBoleto {

	public static void main(String[] args) {
		/*
		 * Program que determine el precio de un boleto de avion basado en varios parametros
		 *  edad del pasajero, tipo de pasajero (económico, ejecutivo, primera clase, premium), 
		 *  número de millas acumuladas, si es temporada alta o baja, y si es miembro de un programa de lealtad, además del precio base
		 *  Condiciones 
		 *  mas de 18 años y temporada baja =  - 10% listo 
		 *  no estar entre 30 y  60 , +1000 millas acumuladas  = - 15%
		 *  Miembro programa lealtad , primera clase y cumple = -20%
		 *  Miembro clase ejecutiva, temporada alta y si es afiliado al programa de lealtad o ha realizado 5000 millas = -25%
		 *  menos de 6 años o mayor 80 años o premium = no billete
		 */
		int edad= 0;
		String tipoPasajero = " ";
		int millas = 0;
		String temporada = " ";
		char miembroProgramaLealtad = 'N' ;
		double precioBase = 300.55;
		double descuento1 = 0.10;
		
		
		
		Scanner teclado = new Scanner(System.in);
		
		//Pedimos que nos diga la edad y la guaradamos
		System.out.println("Dime tu edad");
		edad = teclado.nextInt();
		
		//Pedimos que nos diga que tipo de Pasejero (económico, ejecutivo, primera clase, premium)
		//lo guardamos
		System.out.println("¿Que tipo de pasaejero es ?(económico, ejecutivo, primera clase, premium)");
		tipoPasajero = teclado.next();
		
		//Pedimos que nos diga cuantas millas tiene acumuladas y la guardamo 
		System.out.println("¿Cuantas millas tienes acumuladas? (Ponga  el numero solo)");
		millas = teclado.nextInt();
		
		//Pedimos que ponga la temporada actual que es y la guardamo
		System.out.println("¿Que temporada es ? ");
		temporada = teclado.next();
		
		//Le preguntamos que si es miembro del programa y lo guardamo
		System.out.println("¿Perteneces al programa de Lealtada ?(S/N)");
		miembroProgramaLealtad = teclado.next().charAt(0);
		
		//Primer descuento
		
		if (edad == 18 && temporada.equals("Baja") ||  temporada.equals("baja")) {
			 System.out.println("Obtienes un descuento del 10%");
			 precioBase = precioBase -precioBase * descuento1;
			 System.out.println("Tu entrada cuesta " + precioBase);
		}
		else if (edad > 30 && edad > 60 && millas >1000) {
			
		}
		
		
		
		
		
		
		
		
	}

}
