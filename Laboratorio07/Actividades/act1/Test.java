package act1;

public class Test {

	public static void main(String[] args) throws ExceptionIsEmpty, ExceptionIsFull {
		StackArray<Integer> stack1 = new StackArray<>(3);
		stack1.push(4);
		stack1.push(8);
		stack1.push(2);
		System.out.println(stack1);
		System.out.println("TOP : "+stack1.top());
		System.out.println("POP");
		stack1.pop();
		System.out.println(stack1);
		System.out.println("PUSH 2");
		stack1.push(2);
		System.out.println(stack1);
		System.out.println("PUSH 1");
		stack1.push(1);

	}

}
