package ejercicio1;

public class TestSortGenerico {
	public static void main (String arg[]) {
		Integer[] arreglo1 = {5, 4, 1, 8, 9};
		Character[] arreglo2 = {'o', 'q', 'a', 'z', 'b'};
		String[] arreglo3 = {"Ana", "Gabriela", "Belen", "Luciana", "Adriana"};
		Golosinas[] arreglo4 = {new Golosinas(1,"MIlKY",8), 
				new Golosinas(1,"PAPAS",2) };

		System.out.println("BUBLESORT");
		System.out.println("Integer");
		GenericSort.bubbleSort(arreglo1);
		showArray(arreglo1);
		System.out.println("Character");
		GenericSort.bubbleSort(arreglo2);
		showArray(arreglo2);
		System.out.println("String");
		GenericSort.bubbleSort(arreglo3);
		showArray(arreglo3);
		System.out.println("Golosinas");
		GenericSort.bubbleSort(arreglo4);
		showArray(arreglo4);
		
		System.out.println("INSERTIONSORT");
		System.out.println("Integer");
		GenericSort.insertionSort(arreglo1);
		showArray(arreglo1);
		System.out.println("Character");
		GenericSort.insertionSort(arreglo2);
		showArray(arreglo2);
		System.out.println("String");
		GenericSort.insertionSort(arreglo3);
		showArray(arreglo3);
		System.out.println("Golosinas");
		GenericSort.insertionSort(arreglo4);
		showArray(arreglo4);
		
		System.out.println("SELECTIONSORT");
		System.out.println("Integer");
		GenericSort.selectionSort(arreglo1);
		showArray(arreglo1);
		System.out.println("Character");
		GenericSort.selectionSort(arreglo2);
		showArray(arreglo2);
		System.out.println("String");
		GenericSort.selectionSort(arreglo3);
		showArray(arreglo3);
		System.out.println("Golosinas");
		GenericSort.selectionSort(arreglo4);
		showArray(arreglo4);
		
		System.out.println("SHELLSORT");
		System.out.println("Integer");
		GenericSort.shellSort(arreglo1);
		showArray(arreglo1);
		System.out.println("Character");
		GenericSort.shellSort(arreglo2);
		showArray(arreglo2);
		System.out.println("String");
		GenericSort.shellSort(arreglo3);
		showArray(arreglo3);
		System.out.println("Golosinas");
		GenericSort.shellSort(arreglo4);
		showArray(arreglo4);
		
		System.out.println("QUICKSORT");
		System.out.println("Integer");
		GenericSort.quickSort(arreglo1,0,arreglo1.length-1);
		showArray(arreglo1);
		System.out.println("Character");
		GenericSort.quickSort(arreglo2,0,arreglo2.length-1);
		showArray(arreglo2);
		System.out.println("String");
		GenericSort.quickSort(arreglo3,0,arreglo3.length-1);
		showArray(arreglo3);
		System.out.println("Golosinas");
		GenericSort.quickSort(arreglo4,0,arreglo4.length-1);
		showArray(arreglo4);

		
	}
	public static<T> void showArray(T arr[]) {
		for (T element : arr) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
}
