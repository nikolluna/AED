package actividad08;

public class EntryData<E> {
	private  E data;
	private  float prioridad;
	
	public EntryData (E data, float prioridad) {
		this.data = data;
		this.prioridad = prioridad;
	}
	
	public String toString() {
		return ""+this.data;
	}
	public int compareTo(EntryData<E> c) {
		if (this.prioridad > c.prioridad) {
			return 1;
		}
		else {
			if(this.prioridad == c.prioridad ) {
				return 0;
			}
			return -1;
		}
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public float getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(float prioridad) {
		this.prioridad = prioridad;
	}
	
}
