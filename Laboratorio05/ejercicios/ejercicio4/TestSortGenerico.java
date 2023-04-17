package ejercicio4;

public class TestSortGenerico {
	public static void main (String arg[]) {
		Integer[] arreglo1 = {5, 4, 1, 8, 9};
		Character[] arreglo2 = {'o', 'q', 'a', 'z', 'b'};
		String[] arreglo3 = {"Ana", "Gabriela", "Belen", "Luciana", "Adriana"};
		Golosinas[] arreglo4 = {new Golosinas(1,"MIlKY",8), 
				new Golosinas(1,"PAPAS",2) };

		System.out.println("SHAKERSORT");
		System.out.println("Integer");
		GenericSort.shakerSort(arreglo1);
		showArray(arreglo1);
		System.out.println("Character");
		GenericSort.shakerSort(arreglo2);
		showArray(arreglo2);
		System.out.println("String");
		GenericSort.shakerSort(arreglo3);
		showArray(arreglo3);
		System.out.println("Golosinas");
		GenericSort.shakerSort(arreglo4);
		showArray(arreglo4);
	
	}
	public static<T> void showArray(T arr[]) {
		for (T element : arr) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
}
