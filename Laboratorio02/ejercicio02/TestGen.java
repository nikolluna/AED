package ejercicio02;

public class TestGen {
	public static void main(String args[]) {
		Bolsa<Chocolatina> bolsaCho = new Bolsa<Chocolatina>(2);
		Chocolatina c = new Chocolatina("milka");
		Chocolatina c1 = new Chocolatina("milka");
		Chocolatina c2 = new Chocolatina("ferrero");
		bolsaCho.add(c);
		bolsaCho.add(c1);
		bolsaCho.add(c2);
		
		System.out.print("Bolsa de Chocolatina\n");
		mostrarBolsa(bolsaCho);
		
		Bolsa<Golosina> bolsaGolo = new Bolsa<Golosina>(2);
		Golosina g = new Golosina("Piruletas",3);
		Golosina g1 = new Golosina("Gominolas",4);
		Golosina g2 = new Golosina("Moras",2);
		bolsaGolo.add(g);
		bolsaGolo.add(g1);
		bolsaGolo.add(g2);
		
		System.out.print("\nBolsa de Golosina\n");
		mostrarBolsa(bolsaGolo);

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
	public static <T> void mostrarBolsa(Bolsa<T> bolsa) {
		for(T elem : bolsa) {
			System.out.println(elem);
		}
	}
}


