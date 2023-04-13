package ejercicio2;

public class RecorridoArrayRecursivo {
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5};
		recorrerArray(array, 0);
	}

	
	public static void recorrerArray(int[] array, int index) {
		if (index < array.length) {
			System.out.println(array[index]);
			recorrerArray(array, index + 1);
		}
	}

}
