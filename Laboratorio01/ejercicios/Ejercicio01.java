 package ejercicios;

import java.util.Scanner;

public class Ejercicio01 {
	public static void main(String[] args){
		Scanner sn = new Scanner(System.in);
		System.out.println("Escribe una asignatura");
		String curs = sn.next();

		Cursos cur = Cursos.valueOf(curs.toUpperCase());

		switch (cur) {
			case AED:
			case ESTADISTICA:
			case SIA:
			case REDESII:
			case ADS:
				System.out.println("Este curso " + cur.name().toLowerCase() + " es de 5 semestre");
				break;
			case PROGRAMACIONIII:
			case TALLER:
				System.out.println("Este curso " + cur + " no es de quinto semestre");
				break;
		}
	}
	
	public enum Cursos {
		AED, 
		ESTADISTICA, 
		PROGRAMACIONIII, 
		SIA, 
		REDESII, 
		TALLER, 
		ADS;
	}
}


