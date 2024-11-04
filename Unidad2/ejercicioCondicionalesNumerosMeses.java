package Unidad2;

import java.util.Scanner;

public class ejercicioCondicionalesNumerosMeses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner teclado = new Scanner(System.in);

		int numMes = 0;

		System.out.println(
				"Dime el numero del mes que quieres saber cuanto ha pasado o queda ( Enero = 1, Febrero =  2 ...");
		numMes = teclado.nextInt();
		teclado.close();

		switch (numMes) {
		case 1:
			System.out.println("Ha pasado 10 meses desde enero ");
			break;
		case 2:
			System.out.println("Ha pasado 9 meses desde febrero ");
			break;
		case 3:
			System.out.println("Ha pasado 8 meses desde marzo ");
			break;
		case 4:
			System.out.println("Ha pasado 7 meses desde abril  ");
			break;
		case 5:
			System.out.println("Ha pasado 6 meses desde mayo ");
			break;
		case 6:
			System.out.println("Ha pasado 5 meses desde junio ");
			break;
		case 7:
			System.out.println("Ha pasado 4 meses desde julio");
			break;
		case 8:
			System.out.println("Ha pasado 3 meses desde agosto ");
			break;
		case 9:
			System.out.println("Ha pasado 2 meses desde septiembre ");
			break;
		case 10:
			System.out.println("Ha pasado 1 meses desde octubre ");
			break;
		case 11:
			System.out.println("Ha pasado 0 meses , es nuestro mes actual Noviembre ");
			break;
		case 12:
			System.out.println("Queda 1 mes  para diciembre ");
			break;

		}

	}

}
