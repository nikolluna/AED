package laboratorio09;

public class Test {
	public static void main(String[] args) throws ItemDuplicated, ItemNoFound {
		AVLTree<Integer> arbol = new AVLTree<Integer>();
		arbol.insert(50);
		arbol.insert(25);
		arbol.insert(12);
		arbol.insert(6);
		arbol.insert(3);
		arbol.insert(70);
		arbol.insert(80);
		arbol.insert(90);
		arbol.insert(100);
		arbol.insert(1);
		arbol.insert(2);
		arbol.insert(4);
		arbol.insert(75);
		arbol.insert(95);
		System.out.println(arbol);

	}
}
