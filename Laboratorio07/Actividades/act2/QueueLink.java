package act2;

public class QueueLink<E> implements Queue<E> {
	private Node<E> first;
	private Node<E> last;

	public QueueLink() {
		this.first = null;
		this.last = null;
	}
	
	public void enqueue(E x) {
		Node<E> aux = new Node<E>(x);
		if (this.isEmpty()) {
			this.first = aux;
		}
		else
			this.last.setNext(aux);
		this.last = aux;
	}

	public E dequeue() throws ExceptionIsEmpty {
	    if (isEmpty()) {
	        throw new ExceptionIsEmpty();
	    }
	    E removedValue = first.getData();
	    first = first.getNext();
	    if (first == null) {
	        last = null;
	    }
	    return removedValue;
	}


	public E front() throws ExceptionIsEmpty {
	    if (isEmpty()) {
	        throw new ExceptionIsEmpty();
	    }
	    return first.getData();
	}

	public E back() throws ExceptionIsEmpty {
	    if (isEmpty()) {
	        throw new ExceptionIsEmpty();
	    }
	    return last.getData();
	}

	public boolean isEmpty() {
		return (first == null);
	}

	public String toString() {
	    if (isEmpty()) {
	        return "[]";
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    sb.append("[");
	    Node<E> current = first;
	    while (current != null) {
	        sb.append(current.getData());
	        if (current.getNext() != null) {
	            sb.append(", ");
	        }
	        current = current.getNext();
	    }
	    sb.append("]");
	    return sb.toString();
	}
}
