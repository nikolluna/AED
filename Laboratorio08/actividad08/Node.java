package actividad08;

class Node<E> {
	protected E data;
	protected Node<E> left,right;
	
	public Node(E data) {
		this(data,null,null);
	}
	public Node(EntryData<E> data) {
		this(data.getData(),null,null);
	}
	
	public Node(E data, Node<E> left, Node<E> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public String toString() {
		return ""+this.data;
	}
	
	public E getData() {
		return data;
	}
}

