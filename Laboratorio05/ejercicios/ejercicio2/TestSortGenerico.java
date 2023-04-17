package ejercicio2;

public class TestSortGenerico {
	public static void main (String arg[]) {
		Integer[] arreglo1 = {5, 4, 1, 8, 9};
		Character[] arreglo2 = {'o', 'q', 'a', 'z', 'b'};
		String[] arreglo3 = {"Ana", "Gabriela", "Belen", "Luciana", "Adriana"};
		Golosinas[] arreglo4 = {new Golosinas(1,"MIlKY",8), 
				new Golosinas(1,"PAPAS",2) };

		System.out.println("MERGESORT");
		System.out.println("Integer");
		GenericSort.mergeSort(arreglo1,0,arreglo1.length-1);
		showArray(arreglo1);
		System.out.println("Character");
		GenericSort.mergeSort(arreglo2,0,arreglo2.length-1);
		showArray(arreglo2);
		System.out.println("String");
		GenericSort.mergeSort(arreglo3,0,arreglo3.length-1);
		showArray(arreglo3);
		System.out.println("Golosinas");
		GenericSort.mergeSort(arreglo4,0,arreglo4.length-1);
		showArray(arreglo4);
	
	}
	public static<T> void showArray(T arr[]) {
		for (T element : arr) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
}
