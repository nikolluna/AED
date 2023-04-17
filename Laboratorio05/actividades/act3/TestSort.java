package act3;

public class TestSort {
	public static void main (String arg[]) {
		int[] arreglo1 = {4, 7, 2, 1, 9};
		int[] arreglo2 = {6, 3, 8, 2, 9, 1, 5, 7};
		int[] arreglo3 = {3, 5, 8, 2, 9, 4, 1, 7, 6, 0};
		
		System.out.println("PRUEBA1 BUBLESORT");
		Sort.bubbleSort(arreglo1);
		showArray(arreglo1);
		
		System.out.println("PRUEBA2 BUBLESORT");
		Sort.bubbleSort(arreglo2);
		showArray(arreglo2);
		
		System.out.println("PRUEBA3 BUBLESORT");
		Sort.bubbleSort(arreglo3);
		showArray(arreglo3);
	}
	public static void showArray(int arr[]) {
		for (int element : arr) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
}
