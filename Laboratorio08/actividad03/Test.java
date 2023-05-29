package actividad03;

public class Test {
	public static void main(String[] args) throws ItemDuplicated, ItemNoFound {
		BSTree<Integer> arbol = new BSTree<Integer>();
		arbol.insert(4);
		arbol.insert(1);
		arbol.insert(5);
		arbol.insert(2);
		arbol.insert(3);
		arbol.insert(10);
		System.out.println(arbol);
		
		System.out.println("Eliminando una Hoja (10)");
		arbol.remove(10);
		System.out.println("Eliminando una Raiz con un Hijo (2)");
		arbol.remove(2);
		System.out.println("Eliminando una Raiz con dos Hijos (4)");
		arbol.remove(4);
		System.out.println(arbol);
		
		System.out.println("NO HOJAS");
		System.out.println(arbol.countNonLeafNodes());
		
		System.out.println("ALTURA");
		System.out.println(arbol.getNodeHeight(5));
		
		System.out.println("PREORDEN ITERATIVO");
		arbol.preOrderIterative();
		System.out.println();
		
		System.out.println("CALCULAR EL AREA NIVEL* HOJAS");
		System.out.println(arbol.calculateArea());
		
		BSTree<Integer> arbol2 = new BSTree<Integer>();
		arbol2.insert(5);
		arbol2.insert(1);
		arbol2.insert(3);

		System.out.println("SI SON IGUALES LAS AREAS");
		System.out.println(checkSameArea(arbol,arbol2));
		
		System.out.println("MINIMO VALOR");
		System.out.println(arbol.getMinimumNode());
	
		System.out.println("MAXIMO VALOR");
		System.out.println(arbol.getMaximumNode());
		
	
	}
	
    public static boolean checkSameArea(BSTree<?> tree1, BSTree<?> tree2) {
        int area1 = tree1.calculateArea();
        int area2 = tree2.calculateArea();

        return area1 == area2;
    }
}
