package actividades02;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		Fabrica fab1= new Fabrica();
		cargarFabrica(fab1);
		
		fab1.listarInstrumentos();
		System.out.println(fab1);
		
		ArrayList <Instrumento> lista= fab1.instrumentosPorTipo(TipoInstrumento.Viento);
		for(Instrumento cualInstrumento : lista) {
			System.out.println(cualInstrumento);
		}
		
		double[] porcs = fab1.porcInstrumentosPorTipo("Segunda Sucursal");
		for(int i=0 ; i< porcs.length;i++) {
			System.out.println(porcs[i]);
		}
		
		Instrumento borrado=fab1.borrarInstrumento("122");
		System.out.println("Se borro "+ borrado);
		fab1.listarInstrumentos();
	}
	private static void cargarFabrica(Fabrica fab1) {
		Sucursal suc1= new Sucursal("Primera Sucursal");
		Sucursal suc2= new Sucursal("Segunda Sucursal");
		
		suc1.agregarInstrumento(new Instrumento("121",15.2, TipoInstrumento.Viento));
		suc1.agregarInstrumento(new Instrumento("122",20.5, TipoInstrumento.Cuerda));
		suc1.agregarInstrumento(new Instrumento("123",10.6, TipoInstrumento.Percusion));
		
		suc2.agregarInstrumento(new Instrumento("131",5.2, TipoInstrumento.Viento));
		suc2.agregarInstrumento(new Instrumento("132",29.5, TipoInstrumento.Cuerda));
		
		fab1.agregarSucursal(suc1);
		fab1.agregarSucursal(suc2);
	}
}
