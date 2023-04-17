package act5;

public class TestSort {
	public static void main (String arg[]) {
		int[] arreglo1 = {5, 3, 1, 4, 2};
		int[] arreglo2 = {7, 8, 5, 1, 10, 0, 6, 3};
		int[] arreglo3 = {1, 7, 3, 15, 26, 6, 17, 2};
		
		System.out.println("PRUEBA1 SELECTIONSORT");
		Sort.selectionSort(arreglo1);
		showArray(arreglo1);
		
		System.out.println("PRUEBA2 SELECTIONSORT");
		Sort.selectionSort(arreglo2);
		showArray(arreglo2);
		
		System.out.println("PRUEBA3 SELECTIONSORT");
		Sort.selectionSort(arreglo3);
		showArray(arreglo3);
	}
	public static void showArray(int arr[]) {
		for (int element : arr) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
}
