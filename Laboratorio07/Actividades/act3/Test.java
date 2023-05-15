package act3;

public class Test {
	public static void main(String [] args) throws ExceptionIsEmpty {
		PriorityQueueLinkSort<Integer,Double> cola = new PriorityQueueLinkSort<>() ;
		cola.enqueue(3,1.8);
		cola.enqueue(2,1.0);
		cola.enqueue(1,0.5);
		cola.enqueue(9,8.5);
		System.out.println(cola);
		System.out.println("back "+cola.back());
		System.out.println("front "+cola.front());
		System.out.println("deque " +cola.dequeue());
		System.out.println(cola);
		System.out.println("back "+cola.back());
		System.out.println("front "+cola.front());
	}
}
