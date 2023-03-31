package laboratorio02;

public class Principal {
	public static void main(String[] args) {
		Bolsa<Chocolatina> bolsaCho = new Bolsa<Chocolatina>(2);
		Bolsa<Golosina> bolsaGolo = new Bolsa<Golosina>(2);
		Chocolatina c = new Chocolatina("milka");
		Chocolatina c1 = new Chocolatina("milka");
		Chocolatina c2 = new Chocolatina("ferrero");
		Golosina g = new Golosina("Piruletas",3);
		Golosina g1 = new Golosina("Gominolas",4);
		Golosina g2 = new Golosina("Moras",2);
		bolsaCho.add(c);
		bolsaCho.add(c1);
		bolsaCho.add(c2);
		bolsaGolo.add(g);
		bolsaGolo.add(g1);
		bolsaGolo.add(g2);
		for (Chocolatina chocolatina : bolsaCho) {
			System.out.println(chocolatina.getMarca());
		}
		for (Golosina golosina : bolsaGolo) {
			System.out.println(golosina.toString());
		}
	}
}
