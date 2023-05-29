package laboratorio09;

public class TestEjercicio2 {

	public static void main(String[] args) throws ItemDuplicated, ItemNoFound {
		AVLTree<Integer> arbol1 = new AVLTree<Integer>();
		arbol1.insert(50);
		arbol1.insert(40);
		arbol1.insert(60);
		arbol1.insert(30);
		arbol1.remove(60);
		
		System.out.println(arbol1);
	}

}
