package actividades02;

public class Instrumento {
	
	private String ID;
	private double precio;
	private TipoInstrumento tipo;
	
	public Instrumento(String ID,double precio,TipoInstrumento tipo) {
		this.ID=ID;
		this.precio=precio;
		this.tipo=tipo;
	}
	
	public void settID(String ID) {
		this.ID=ID;
	}

	public String getID() {
		return this.ID;
	}

	public TipoInstrumento getTipo() {
		return this.tipo;
	}

	public void setTipo(TipoInstrumento tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Instrumento [ID=" + this.ID + ", precio=" + this.precio + ", tipo=" + this.tipo + "]";
	}

}


