package Ejercicio01;

public class TestList {
	
	public static <T> void main (String[] args) {
		OrderListLinked<Integer> lista1 = new OrderListLinked<>();
		System.out.println("ANTES DE INGRESAR");
		System.out.println("La lista esta vacia ?");
		System.out.println(lista1.isEmptyList() == true ? "SI": "NO");
		System.out.println("DESPUES DE INGRESAR");
		lista1.insertar(7);
		lista1.insertar(2);
		lista1.insertar(9);
		lista1.insertar(4);
		lista1.insertar(5);

		System.out.println("La lista esta vacia ?");
		System.out.println(lista1.isEmptyList() == true ? "SI": "NO "
				+ "tiene una longitud de " + lista1.lenght());
		lista1.mostrarLista();
		
		System.out.println("BUSCANDO 10");
		System.out.println(lista1.searchB(10) == false ? 
				"NO SE ENCUENTRA EN LA LISTA" : "SI SE ENCUENTRA EN LA LISTA");
		lista1.remove(4);
		System.out.println("ELIMINANDO A 4");
		lista1.mostrarLista();
		System.out.println("DESTUIR LISTA");
		lista1.destroyList();
		lista1.mostrarLista();
		
	}

}
