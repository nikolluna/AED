package ejer2;

public class Test {
	public static void main(String [] args) throws ExceptionIsEmpty {
		QueueArray<Integer> cola = new QueueArray<>(3) ;
		cola.enqueue(1);
		cola.enqueue(2);
		cola.enqueue(3);
		System.out.println(cola);
		System.out.println("back "+cola.back());
		System.out.println("front "+cola.front());
		System.out.println("dequeue "+cola.dequeue());
		System.out.println(cola);
		System.out.println("front "+cola.front());
		System.out.println("back "+cola.back());
		System.out.println("enqueue 3");
		cola.enqueue(3);
		System.out.println(cola);
		System.out.println("enqueue 4");
		cola.enqueue(4);
	}
}
