package ejercicio01;

public class TestGen {
	public static void main(String args[]) {

		String[] v = { "Perez", "Sanchez", "Rodriguez" };
		Integer[] w = { 12, 34, 56 };
		System.out.println(exist(v, "Sanchez"));
		System.out.println(exist(w, 34));
		//System.out.println(exist(w, "Sanchez"));
		
		//Probando con arreglos que almacenar objetos Golosina y Chocolatina
		
		Golosina [] arrGolosina = {new Golosina("Bubbalo",350),
    			new Golosina("Fini",620), new Golosina("Mogul",450)};
		
		Chocolatina [] arrChocolatina  = {new Chocolatina("milka"), 
    			new Chocolatina("Ferrero")};
  
    	System.out.println(exist(arrGolosina,new Golosina("Bubbalo",350)));
    	System.out.println(exist(arrGolosina,new Golosina("Chichiste",200)));
    	
    	System.out.println(exist(arrChocolatina,new Chocolatina("Ferrero")));
    	System.out.println(exist(arrChocolatina,new Chocolatina("Cua cua")));
	}
	static <T extends Comparable<T>> String exist(T[] y, T x) {
		for (int i = 0; i < y.length; i++) {
			if (y[i].equals(x)) {
				return x + "--> Si existe";
			}
		}
		return "No existe";
	}
	static <T extends Comparable<T>> boolean igualArrays(T[] x, T[] y) {
		if (x.length != y.length)
			return false;
		for (int i = 0; i < x.length; i++)
			if (!x[i].equals(y[i]))
				return false; 
		return true; 
	}
}


