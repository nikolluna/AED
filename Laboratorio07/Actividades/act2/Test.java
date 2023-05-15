package act2;

public class Test {
	public static void main(String [] args) throws ExceptionIsEmpty {
		QueueLink<Integer> cola = new QueueLink<>() ;
		cola.enqueue(1);
		cola.enqueue(2);
		cola.enqueue(3);
		System.out.println(cola);
		System.out.println("back "+cola.back());
		System.out.println("front "+cola.front());
		System.out.println("dequeue"+cola.dequeue());
		System.out.println(cola);
		System.out.println("front "+cola.front());
		System.out.println("back "+cola.back());
	}
}
