package ejercicio01;

public class Golosina implements Comparable <Golosina>{
	private String nombre;
	private double peso;

	public Golosina(String nombre, double peso) {
		this.nombre = nombre;
		this.peso = peso;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public int compareTo(Golosina goloCom) {
		if(goloCom.getNombre().equals(this.nombre)&&
			goloCom.getPeso()==this.peso){
			return 0;
		}
		return -1;
	}
	public boolean equals(Object obj) {
		if(obj instanceof Golosina) {
			Golosina goloCom = (Golosina)obj;
			if(goloCom.getNombre().equals(this.nombre)&&
					goloCom.getPeso()==this.peso) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return  this.nombre + " - "+ this.peso ;
	}
}


