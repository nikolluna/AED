package actividades;

import java.util.Scanner;

public class Actividad09 {
	public static void main(String[] args) {

		// Scanner para leer
		Scanner sc = new Scanner(System.in);

		// Pedimos las palabras
		System.out.println("Escribe la palabra 1");
		String palabra1 = sc.next();

		System.out.println("Escribe la palabra 2");
		String palabra2 = sc.next();

		// Comparamos mediante el método equals
		// Con equalsIgnoreCase, no considera las mayusculas

		if (palabra1.equals(palabra2)) {
			System.out.println("Las palabras son iguales");
		} else {
			System.out.println("Las palabras no son iguales");
		}
	}
}


