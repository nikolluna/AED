package actividades02;

import java.util.ArrayList;

public class Sucursal {
	private ArrayList<Instrumento> instrumentos;
	private String nombre;
	
	public Sucursal(String nombre){
		this.nombre=nombre;
		this.instrumentos= new ArrayList<>();
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	public void agregarInstrumento(Instrumento Instru1) {
		this.instrumentos.add(Instru1);
	}
	public void listarInstrumentos() {
		for(Instrumento cualInstru : instrumentos) {
			System.out.println(cualInstru);
		}
	}
	public ArrayList<Instrumento> instrumentosPorTipo(TipoInstrumento tipo) {
		ArrayList<Instrumento> instEncontrados = new ArrayList<>();
		for(Instrumento cualInstrumento : instrumentos) {
			if(cualInstrumento.getTipo()== tipo) {
				instEncontrados.add(cualInstrumento);
			}
		}
		return instEncontrados;
	}
	
	public Instrumento borrarInstrumento(String ID){
		//buscarInstrumentoPorID
		//Si existe, borrarlo
		Instrumento instPorBorrar = buscarInstrumento(ID);
		this.instrumentos.remove(instPorBorrar);
		
		return instPorBorrar;
	}
	
	public Instrumento buscarInstrumento(String ID) {
		int i=0;
		Instrumento instEncontrado= null;
		while(i<instrumentos.size() && !this.instrumentos.get(i).getID().equals(ID)) {
			i++;
		}
		
		if(i<instrumentos.size()) {
			instEncontrado= this.instrumentos.get(i);
		}
		return instEncontrado;
	}
	
	public double[] porcInstrumentosPorTipo() {
		final int CANT_INSTRUMENTOS= TipoInstrumento.values().length;
		double[] porcentajes = new double [CANT_INSTRUMENTOS] ;
		for(Instrumento instrumento : instrumentos) {
			porcentajes[instrumento.getTipo().ordinal()]++;
		}
		absolutoPorcentaje(porcentajes);
		return porcentajes;
	}
	
	private void absolutoPorcentaje(double[] porcentajes) {
		for(int i=0 ; i < porcentajes.length ; i++) {
			porcentajes[i]= porcentajes[i]*100/instrumentos.size();
		}
	}
}
