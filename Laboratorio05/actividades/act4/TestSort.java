package act4;

public class TestSort {
	public static void main (String arg[]) {
		int[] arreglo1 = {3, 6, 1, 0, 8};
		int[] arreglo2 = {7, 4, 9, 3, 10, 2, 6, 8};
		int[] arreglo3 = {5, 7, 9, 4, 11, 6, 3, 2};
		
		System.out.println("PRUEBA1 INSERTIONSORT");
		Sort.insertionSort(arreglo1);
		showArray(arreglo1);
		
		System.out.println("PRUEBA2 INSERTIONSORT");
		Sort.insertionSort(arreglo2);
		showArray(arreglo2);
		
		System.out.println("PRUEBA3 INSERTIONSORT");
		Sort.insertionSort(arreglo3);
		showArray(arreglo3);
	}
	public static void showArray(int arr[]) {
		for (int element : arr) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
}
