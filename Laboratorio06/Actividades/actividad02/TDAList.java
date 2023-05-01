package act2;

public interface TDAList<T> {
	boolean isEmptyList(); //determina si la lista esta vacia
	int lenght(); //determina la cantidad(longitud) de elementos que hay en lista
	void destroyList(); //elimina los elementos de la lista dejándola vacía
	int search(T x); // verifica si el elemento x esta o no esta en la lista, si esta retorna su posición
	void insertFirst(T x); //inserta el nuevo elemento x al inicio de la lista
	void insertLast(T x); // inserta el nuevo elemento x al final de la lista
	void remove(T x); //elimina el elemento x de la lista
	
}

