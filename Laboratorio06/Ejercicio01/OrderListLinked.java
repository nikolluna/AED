package Ejercicio01;

public class OrderListLinked<T extends Comparable<T>> extends ListLinked<T> {	
	
	public OrderListLinked() {
		super();
	}
	
	public boolean searchB(T item) {
		Node<T> aux = super.getHead();
		while(aux != null && aux.getData().compareTo(item)<0) {
			aux = aux.getNext();
		}
		if(aux != null) {
			return aux.getData().equals(item);
		}
		return false;
	}
	
	public void insertar(T ele) {
		Node<T> aux = super.getHead();
		Node<T> cond = null;
		T data;
		
		this.insertLast(ele);
		while(aux != null) {
			cond = aux.getNext();
			while(cond != null) {
				if(aux.getData().compareTo(cond.getData()) > 0) {
					data = aux.getData();
					aux.setData(cond.getData());
					cond.setData(data);
				}
				cond = cond.getNext();
			}
			aux = aux.getNext();
		}
	}
	public void remove(T ele) {
		Node<T> aux = super.getHead();
		if(aux == null) {
			System.out.println("La Lista esta vacia");
		}
		else {
			if(super.getHead().getData().equals(ele)){
				super.setHead(aux.getNext());
			}
			else {
				while(aux !=null && aux.getNext()!=null) {
					if(aux.getNext().getData().equals(ele)) {
						Node<T> BorrarNodo = aux.getNext();
						aux.setNext(aux.getNext().getNext());
						BorrarNodo.setNext(null);
					}
					aux = aux.getNext();
				}
			}
		}
	}
}
