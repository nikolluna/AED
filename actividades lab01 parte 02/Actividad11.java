package actividades;

import java.util.Scanner;

public class Actividad11 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		//Hace que podamos escribir espacios en la frase y coja todo el String
		sc.useDelimiter("\n");

		System.out.println("Escribe una frase");
		String frase = sc.next();

		// Divide la frase en palabras
		String palabras[] = frase.split(" ");

		for (int i = 0; i < palabras.length; i++) {
			System.out.println(palabras[i]);
		}
	}
}


