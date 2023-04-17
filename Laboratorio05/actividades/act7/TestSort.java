package act7;

public class TestSort {
	public static void main (String arg[]) {
		int[] arreglo1 = {5, 4, 1, 8, 9};
		int[] arreglo2 = {9, 16, 7, 8, 12, 5, 6, 3};
		int[] arreglo3 = {1, 0, 3, 15, 5, 6, 8, 2};
		
		System.out.println("PRUEBA1 QUICKSORT");
		Sort.quickSort(arreglo1,0,arreglo1.length-1);
		showArray(arreglo1);
		
		System.out.println("PRUEBA2 QUICKSORT");
		Sort.quickSort(arreglo2,0,arreglo2.length-1);
		showArray(arreglo2);
		
		System.out.println("PRUEBA3 QUICKSORT");
		Sort.quickSort(arreglo3,0,arreglo2.length-1);
		showArray(arreglo3);
	}
	public static void showArray(int arr[]) {
		for (int element : arr) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
}
