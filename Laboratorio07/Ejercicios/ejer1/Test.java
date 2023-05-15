package ejer1;

public class Test {

	public static void main(String[] args) throws ExceptionIsEmpty, ExceptionIsFull {
		StackList<Integer> stack1 = new StackList<>(3);
		stack1.push(4);
		stack1.push(8);
		stack1.push(2);
		System.out.println(stack1);
		System.out.println("top "+stack1.top());
		System.out.println("pop");
		stack1.pop();
		System.out.println(stack1);
		System.out.println("push 5");
		stack1.push(5);
		System.out.println(stack1);
		System.out.println("push 9");
		stack1.push(9);
		System.out.println(stack1);
	}
}
