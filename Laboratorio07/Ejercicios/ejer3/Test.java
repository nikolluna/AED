package ejer3;

public class Test {
	public static void main(String [] args) throws ExceptionIsEmpty {
		
		PriorityQueueLinked<Integer,String> colas = new PriorityQueueLinked<>(4) ;
		colas.enqueue(3,"C");
		colas.enqueue(12,"A");
		colas.enqueue(7,"B");
		colas.enqueue(5,"B");
		colas.enqueue(4,"A");
		
		System.out.println(colas);
		System.out.println("Front "+colas.front());
		System.out.println("Back "+colas.back());

	}
}
