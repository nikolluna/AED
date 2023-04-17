package act6;

public class TestSort {
	public static void main (String arg[]) {
		int[] arreglo1 = {5, 7, 1, 8, 2};
		int[] arreglo2 = {9, 8, 7, 1, 12, 0, 6, 3};
		int[] arreglo3 = {1, 5, 3, 12, 16, 6, 8, 2};
		
		System.out.println("PRUEBA1 SHELLSORT");
		Sort.shellSort(arreglo1);
		showArray(arreglo1);
		
		System.out.println("PRUEBA2 SHELLSORT");
		Sort.shellSort(arreglo2);
		showArray(arreglo2);
		
		System.out.println("PRUEBA3 SHELLSORT");
		Sort.shellSort(arreglo3);
		showArray(arreglo3);
	}
	public static void showArray(int arr[]) {
		for (int element : arr) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
}
