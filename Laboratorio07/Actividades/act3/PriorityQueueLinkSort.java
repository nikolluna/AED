package act3;

class PriorityQueueLinkSort<E, P extends Comparable> implements PriorityQueue<E, P> {
	class EntryNode {
		E data;
		P priority;

		EntryNode(E data, P priority) {
			this.data = data;
			this.priority = priority;
		}
	}

	private Node<EntryNode> first;
	private Node<EntryNode> last;

	public PriorityQueueLinkSort() {
		this.first = null;
		this.last = null;
	}
	
	public void enqueue(E x, P p) {
		EntryNode dataPrio = new EntryNode(x,p);
		Node<EntryNode> add = new Node<EntryNode>(dataPrio);
		if(this.first == null) {
			this.first = add;
			this.last = this.first;
		}
		else {
			Node<EntryNode> act = this.first;
			Node<EntryNode> pre = null;
			while(act!= null && p.compareTo(act.getData().priority) > 0) {
				pre = act;
				act = act.getNext();
			}
			if(act == null) {
				this.last.setNext(add);
				this.last = add;
			}
			if(pre == null) {
				Node<EntryNode> aux = this.first;
				this.first = add;
				add.setNext(aux);
			}
			else {
				pre.setNext(new Node<EntryNode> (dataPrio,act));
			}
		}
	}

	
	public E dequeue() throws ExceptionIsEmpty {
		if (isEmpty())
			throw new ExceptionIsEmpty();
		E aux = this.first.getData().data;
		this.first = this.first.getNext();
		if (this.first == null)
			this.last = null;
		return aux;
	}

	public E back() throws ExceptionIsEmpty {
	    if (isEmpty()) {
	        throw new ExceptionIsEmpty();
	    }
	    return this.last.getData().data;
	}

	
	public E front() throws ExceptionIsEmpty {
	    if (isEmpty()) {
	        throw new ExceptionIsEmpty();
	    }
	    return this.first.getData().data;
	}


// include here your code }
	public boolean isEmpty() {
	    return this.first == null;
	}

// Elements must be included in the string as they are located in the list
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("[");
	    Node<EntryNode> current = this.first;
	    while (current != null) {
	        sb.append(current.getData().data);
	        if (current.getNext() != null) {
	            sb.append(", ");
	        }
	        current = current.getNext();
	    }
	    sb.append("]");
	    return sb.toString();
	}

}