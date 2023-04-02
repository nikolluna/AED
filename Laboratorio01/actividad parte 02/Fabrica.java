package actividades02;

import java.util.ArrayList;

public class Fabrica {
	private ArrayList<Sucursal> sucursales;
	
	public Fabrica() {
		this.sucursales= new ArrayList<>();
	}
	
	public void listarInstrumentos() {
		for(Sucursal cualSucursal : sucursales) {
			System.out.println(cualSucursal.getNombre());
			cualSucursal.listarInstrumentos();
		}
	}

	public ArrayList<Instrumento> instrumentosPorTipo(TipoInstrumento tipo) {
		ArrayList<Instrumento> instEncontrados = new ArrayList<>();
		for(Sucursal cualSucursal : sucursales) {
			instEncontrados.addAll(cualSucursal.instrumentosPorTipo(tipo));
		}
		return instEncontrados;	
	}
	
	public Instrumento borrarInstrumento(String ID){
		Instrumento borrado= null;
		int i=0 ;
		while(i<sucursales.size() && borrado==null ) {
			borrado=sucursales.get(i).borrarInstrumento(ID);
			i++;
		}
		return borrado;
	}
	
	public double[] porcInstrumentosPorTipo(String nombreSuc) {
		double [] porcentajes= new double [TipoInstrumento.values().length];
		Sucursal sucEncontrada = buscarSucursal(nombreSuc);
		
		if(sucEncontrada != null) {
			porcentajes=sucEncontrada.porcInstrumentosPorTipo();
					
		}
		return porcentajes;
	}
	
	public Sucursal buscarSucursal(String nombreSuc) {
		int i=0;
		Sucursal sucEncontrada= null;
		while(i<sucursales.size() && !this.sucursales.get(i).getNombre().equals(nombreSuc)) {
			i++;
		}
		
		if(i<sucursales.size()) {
			sucEncontrada= this.sucursales.get(i);
		}
		return sucEncontrada;
	}
	
	public void agregarSucursal(Sucursal sucursal1) {
		this.sucursales.add(sucursal1);
	}
	
}


