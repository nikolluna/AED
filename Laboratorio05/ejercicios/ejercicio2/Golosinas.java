package ejercicio2;

public class Golosinas implements Comparable {
	//Atributos
	private int id;
	private String descripition;
	private float price;

	//Constructor
	public Golosinas(int id, String descripition, float price) {
		this.id = id;
		this.descripition = descripition;
		this.price = price;
	}

	//Getters y Setters
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripition() {
		return this.descripition;
	}

	public void setDescripition(String descripition) {
		this.descripition = descripition;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	//Equals
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Golosinas) {
			Golosinas goodiesComparar = (Golosinas) obj;
			return this.id == goodiesComparar.getId();
		}
		return false;
	}
	
	//CompareTo
	@Override
	public int compareTo(Object obj) {
		Golosinas goodiesComp = (Golosinas) obj;
		if (this.price == goodiesComp.getPrice())
			return 0;
		else {
			if(this.price > goodiesComp.getPrice())
				return 1;
			else
				return -1;
		}
	}
	
	//To String
	@Override
	public String toString() {
		return "ID : " + this.id + "\tDescripcion : " + this.descripition 
				+ "\tPrecio : " + this.price +"\n";
	}

}
