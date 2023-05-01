package act2;

public class TestList {
	public static void main (String[] args) {
		ListArray<Integer> lista1 = new ListArray<>();
		System.out.println("INGRESANDO AL FINAL");
		lista1.insertLast(1);
		lista1.insertLast(2);
		imprimir(lista1);
		System.out.println("INGRESANDO AL INICIO");
		lista1.insertFirst(0);
		imprimir(lista1);
		System.out.println("LONGITUD DE LA LISTA");
		System.out.println(lista1.lenght());
		System.out.println("EL NUMERO 3 SE ENCUENTRA EN EL ARREGLO");
		System.out.println(lista1.search(3) == -1 ? "NO": "SI");
		System.out.println("QUITAMOS EL NUMERO 2");
		lista1.remove(2);
		imprimir(lista1);
		System.out.println("DESTRUIMOS LA LISTA");
		lista1.destroyList();
		System.out.println("LA LISTA ESTA VACIA ?");
		System.out.println(lista1.isEmptyList() == true ? "SI" : "NO");
	}
	public static<T> void imprimir( ListArray<T> lista) {
		T[] arrAux = lista.getArray();
		
		for(int i=0; i < arrAux.length; i++) {
			System.out.print(arrAux[i]+ " ");
		}
		System.out.println();
	}
}
