package act3;

public class ListLinked<T> implements TDAList<T> {
	private Node<T> head;
	private Node<T> fin;
	private int cont;
	
	public ListLinked() {
		this.head = null;
		this.fin =null;
		this.cont = 0;
	}


	@Override
	public boolean isEmptyList() {
		return (this.head == null);
	}


	@Override
	public int lenght() {
		return cont;
	}


	@Override
	public void destroyList() {
		this.head = null;
		this.fin = null;
		this.cont = 0;
	}


	@Override
	public int search(T x) {
		int pos=0;
		Node<T> aux = this.head;
		while(aux != null) {
			if(aux.getData().equals(x)) {
				return pos;
			}
			aux = aux.getNext();
			pos++;

		}
		return -1;
	}


	@Override
	public void insertFirst(T x) {
		if(isEmptyList()) {
			head = new Node<T>(x, head);
			fin = head;
		}
		else {
			head = new Node<T>(x, head);

		}
		this.cont ++;
	}


	@Override
	public void insertLast(T x) {
		if(isEmptyList()) {
			
			head = new Node<T>(x);
			fin  = head;
			
		}
		else {
			Node<T> nodoAdd = new Node<> (x);
			this.fin.setNext(nodoAdd);
			fin = fin.getNext();
		}
		this.cont ++;
	}


	@Override
	public void remove(T x) {
		if(!isEmptyList()) {
			if(head == fin && x == head.getData()) {
				head = null;
				fin = null;
			}
			else {
				if(x == head.getData()) {
					head = head.getNext();
				}
				else {
					Node<T> anterior, temporal;
					anterior = head;
					temporal = head.getNext();
					int cont =0;
					while(temporal!=null && !temporal.getData().equals(x)) {
						anterior = anterior.getNext();
						temporal = temporal.getNext();
						cont++;

					}
					if(temporal!=null) {						
						Node<T> tempSiguiente = temporal.getNext();
						anterior.setNext(tempSiguiente);						
						if(temporal.equals(fin)) {
							fin = anterior;
						}
					}
					
				}
			}
		}
	}
	
	public Node<T> get(int index) {
		int cont = 0;
		Node temp = this.head;
		while(cont < index) {
			temp = temp.getNext();
			cont++;
		}
		return temp;
		
	}
	public void mostrarLista() {
		Node<T> aux = this.head;
		while(aux!=null) {
			System.out.print("["+aux.getData()+"]--->");
			aux = aux.getNext();
		}
		System.out.println();
	}

	
}
