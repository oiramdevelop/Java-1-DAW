package Unidad2;

public class ejemploCondicionales2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Escribe un programa que lea una nota y os diga
		// si es un insuficiente, sufiente , suficinete , bien , notable, sobresaaliente
		// o matricula
		float nota = (float) (Math.random() * 10);

		System.out.println("Tu nota es " + nota);

		if (nota < 5) {
			System.out.println("Has suspendido");
			System.out.println("Lo siento picha gg");

		} else {
			// si estamos dentro implica que la nota es mayour o igual a 5
			// si ademas es menor de 6 implica es un suficente

			if (nota < 6) {
				System.out.println("Has aprobado raspado picha");
				System.out.println("Suficiente pichon");
			} else {
				if (nota < 7) {
					System.out.println("Has aprobado picha");
					System.out.println("Un bien pichon");

				} else {
					if (nota < 9) {
						System.out.println("Has aprobado con notita picha");
						System.out.println("Un notable pichon");
					} else {

						if (nota < 10) {
							System.out.println("Has aprobado con notita picha");
							System.out.println("Un Sobresaliente pichon");
						} else {
							if (nota < 11) {
								System.out.println("Has aprobado con notaza picha");
								System.out.println("Matricual cabron");
							}
						}
					}
				}
			}

		}

	}

}
