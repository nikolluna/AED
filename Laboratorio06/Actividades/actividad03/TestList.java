package act3;

public class TestList {
	
	public static <T> void main (String[] args) {
		ListLinked<String> lista1 = new ListLinked<>();
		System.out.println("ANTES DE INGRESAR");
		System.out.println("La lista esta vacia ?");
		System.out.println(lista1.isEmptyList() == true ? "SI": "NO");
		System.out.println("DESPUES DE INGRESAR");
		lista1.insertFirst("Juan");
		lista1.insertFirst("Ana");
		lista1.insertFirst("Maria");
		lista1.insertLast("Pedro");
		System.out.println("La lista esta vacia ?");
		System.out.println(lista1.isEmptyList() == true ? "SI": "NO "
				+ "tiene una longitud de " + lista1.lenght());
		lista1.mostrarLista();
		System.out.println("BUSCANDO a Ana");
		System.out.println(lista1.search("Ana") == -1 ? 
				"NO SE ENCUENTRA EN LA LISTA" : "Esta en la posicion "+lista1.search("Ana"));
		lista1.remove("Juan");
		System.out.println("ELIMINANDO A JUAN");
		lista1.mostrarLista();
		System.out.println("DESTUIR LISTA");
		lista1.destroyList();
		lista1.mostrarLista();
	}

}
