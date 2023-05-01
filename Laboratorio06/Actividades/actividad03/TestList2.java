package act3;

import act2.ListArray;

public class TestList2 {

	public static void main(String[] args) {
		ListLinked<Person> lista = new ListLinked<Person>();
		ListArray<Person> lista2 = new ListArray<Person>();

		Person p1 = new Person("Percy","Diaz",19);
		Person p2 = new Person("Nikol","Luna",17);
		Person p3 = new Person("Samantha","Apaza",18);
		Person p4 = new Person("Rodrigo","Mechan",20);
		lista.insertFirst(p1);
		lista.insertFirst(p2);
		lista.insertLast(p3);
		lista.insertLast(p4);
		System.out.println("USANDO LISTLINKED");
		lista.mostrarLista();
		System.out.println("ELIMINAR A PERCY");
		lista.remove(p1);
		lista.mostrarLista();
		
		System.out.println();
		lista2.insertFirst(p1);
		lista2.insertFirst(p2);
		lista2.insertLast(p3);
		lista2.insertLast(p4);
		System.out.println("LISTARRAY");
		imprimir(lista2);
		System.out.println("ELIMINAR A PERCY");
		lista2.remove(p1);
		imprimir(lista2);

	}
	public static<T> void imprimir( ListArray<T> lista) {
		T[] arrAux = lista.getArray();
		
		for(int i=0; i < arrAux.length; i++) {
			System.out.print(arrAux[i]+ " ");
		}
		System.out.println();
	}
}
