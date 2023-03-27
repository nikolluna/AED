package actividades;

public class CambioLetrasApp {

	public static void main(String[] args) {
		String cadena = "La lluvia en sevilla es una maravilla";

        //Haciendo uso de este metodo, no se modifica el String principal.
        System.out.println(cadena.replace('a', 'e'));
	}
}


