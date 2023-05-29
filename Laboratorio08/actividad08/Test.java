package actividad08;

public class Test {
	public static void main(String[] args) throws ItemDuplicated, ItemNoFound {
		BSTree<String> arbol3 = new BSTree<>();
		arbol3.insert(new EntryData<>("Sales",2));
		arbol3.insert(new EntryData<>("Domestic",1));
		arbol3.insert(new EntryData<>("International",4));
		arbol3.insert(new EntryData<>("Canada S.America",3));
		arbol3.insert(new EntryData<>("Overseas",6));
		arbol3.insert(new EntryData<>("Africa Europe",5));
		arbol3.insert(new EntryData<>("Asia Australia",7));

		System.out.println("parenthesize");
		arbol3.parenthesize(arbol3.getRoot(), arbol3.getNodeHeight(arbol3.getRoot()));
	
	}
	
    public static boolean checkSameArea(BSTree<?> tree1, BSTree<?> tree2) {
        int area1 = tree1.calculateArea();
        int area2 = tree2.calculateArea();

        return area1 == area2;
    }
}