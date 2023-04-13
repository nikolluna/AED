package ejercicio3;

public class RecorridoArrayRecursivo {
    
	public static void main(String[] args) {
		String[] array = {"a", "b", "c", "d", "e"};
        String elemento = "c";
        int indice = busquedaBinariaRecursiva(array, elemento, 0, array.length - 1);
        if (indice == -1) {
            System.out.println("Elemento no encontrado");
        } else {
            System.out.println("El elemento " + elemento + " se encuentra en la posicion " + indice);
        }
    }

    public static int busquedaBinariaRecursiva(String[] array, String elemento, int inicio, int fin) {
        if (inicio > fin) {
            return -1;
        }
        int medio = (inicio + fin) / 2;
        if (array[medio].compareTo(elemento) == 0) {
            return medio;
        }
        else if (array[medio].compareTo(elemento) < 0) {
            return busquedaBinariaRecursiva(array, elemento, medio + 1, fin);
        }
        else {
            return busquedaBinariaRecursiva(array, elemento, inicio, medio - 1);
        }
    }
    
}
