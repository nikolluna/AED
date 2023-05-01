package Ejercicio02s2;

class Main {
	// Envoltorio sobre la clase `Node`
	static class NodeWrapper {
		public Node node;

		NodeWrapper(Node node) {
			this.node = node;
		}
	}
	// Método recursivo para verificar si una lista enlazada de caracteres dada es un
	//palíndromo
	public static boolean isPalindrome(NodeWrapper left, Node right) {
		// Caso base
		if (right == null) {
			return true;
		}
		// Devuelve falso en el primer desajuste
		if (!isPalindrome(left, right.next)) {
			return false;
		}
		// Copiar el hijo izquierdo
		Node prev_left = left.node;
		// Avanzar el hijo izquierdo al siguiente nodo.
		// Este cambio se reflejaría en las llamadas recursivos principales.
		left.node = left.node.next;
		// Para que la lista enlazada sea un palíndromo, el carácter de la izquierda
		// el nodo debe coincidir con el caracter del nodo derecho
		return (prev_left.data == right.data);
	}

	public static void main(String[] args) {
		Node head = new Node('A');
		head.next = new Node('B');
		head.next.next = new Node('C');
		head.next.next.next = new Node('A');
		head.next.next.next.next = new Node('B');
		// Ajustar nodo, para que su referencia pueda cambiarse dentro de
		//`isPalindrome()`
		NodeWrapper left = new NodeWrapper(head);
		if (isPalindrome(left, head)) {
			System.out.println("Linked List Es palindrome.");
		} else {
			System.out.println("Linked List No es palindrome.");
		}
	}
}
