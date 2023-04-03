package ejercicio06;

public class Chocolatina implements Comparable <Chocolatina>{
	private String marca;

	public Chocolatina(String marca) {
		this.marca = marca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public int compareTo(Chocolatina choCom) {
		if(choCom.getMarca().equals(this.marca)) {
			return 0;
		}
		return -1;
	}

	public boolean equals (Object obj) {
		if(obj instanceof Chocolatina) {
			Chocolatina chocoCom = (Chocolatina)obj;
			if(chocoCom.getMarca().equals(this.marca)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return this.marca ;
	}
	
}



