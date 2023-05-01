package act2;

public class ListArray<T> implements TDAList<T> {
	private T lista[];
	private int tamano;
	
	public ListArray(int tamano) {
		this.tamano = tamano; 
		this.lista = (T[]) new Object[this.tamano];
	}
	
	public ListArray() {
		this.lista = null;
	}
	
	public T[] getArray() {
		return this.lista;
	}
	
	@Override
	public boolean isEmptyList() {
		return this.lista == null;
	}

	@Override
	public int lenght() {
		return this.tamano;
	}

	@Override
	public void destroyList() {
		this.lista = null;
		tamano = 0;
	}

	@Override
	public int search(T x) {
		int pos = 0;
		for(T e : lista) {
			if (e != null) {
				if(e.equals(x)) {
					return pos; 
				}
			}
			pos++;
		}
		return -1;
	}

	@Override
	public void insertFirst(T x) {
		T[] aux = (T[]) new Object[tamano+1] ;
		for(int i = tamano; i > 0; i--) {
				aux[i] = lista[i-1];
		}
		aux[0] = x;	
		this.lista = aux;
		this.tamano = tamano+1;
	}

	@Override
	public void insertLast(T x) {
		T[] aux = (T[]) new Object[tamano+1];
		for(int i=0; i < tamano; i++) {
			aux[i] = lista[i];
		}
		aux[tamano] = x;
		this.lista = aux;
		this.tamano += 1;
		
	}

	@Override
	public void remove(T x) {
		int pos = search(x);
		lista[pos] = null;
		if(pos != -1) {
			T[] aux = (T[]) new Object[tamano-1];
			int posAux = 0;
			for (T e : this.lista) {
				if(e != null) {
					aux[posAux] = e;
					posAux++;
				}
			}
			this.lista = aux;
			this.tamano = tamano-1;
		}else {
			System.out.println("El elemento no se encuentra");
		}
	}
}