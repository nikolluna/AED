package ejercicio3;

public class TestSortGenerico {
	public static void main (String arg[]) {
		Integer[] arreglo1 = {5, 4, 1, 8, 9};
		Character[] arreglo2 = {'o', 'q', 'a', 'z', 'b'};
		String[] arreglo3 = {"Ana", "Gabriela", "Belen", "Luciana", "Adriana"};
		Golosinas[] arreglo4 = {new Golosinas(1,"MIlKY",8), 
				new Golosinas(1,"PAPAS",2) };

		System.out.println("BRICKSORT");
		System.out.println("Integer");
		GenericSort.brickSort(arreglo1);
		showArray(arreglo1);
		System.out.println("Character");
		GenericSort.brickSort(arreglo2);
		showArray(arreglo2);
		System.out.println("String");
		GenericSort.brickSort(arreglo3);
		showArray(arreglo3);
		System.out.println("Golosinas");
		GenericSort.brickSort(arreglo4);
		showArray(arreglo4);
	
	}
	public static<T> void showArray(T arr[]) {
		for (T element : arr) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
}
