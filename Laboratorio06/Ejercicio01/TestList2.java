package Ejercicio01;

public class TestList2 {

	public static void main(String[] args) {
		OrderListLinked<Person> lista = new OrderListLinked<Person>();
		
		Person p1 = new Person("Percy","Diaz",19);
		Person p2 = new Person("Nikol","Luna",17);
		Person p3 = new Person("Samantha","Apaza",18);
		Person p4 = new Person("Rodrigo","Mechan",20);
		lista.insertar(p1);
		lista.insertar(p2);
		lista.insertar(p3);
		lista.insertar(p4);
		lista.mostrarLista();
		System.out.println("ELIMINAR A PERCY");
		lista.remove(p1);
		lista.mostrarLista();
		System.out.println("ESTA A NIKOL ? ");
		System.out.println(lista.searchB(p2)== true ? "SI" : "NO");
	}
}
