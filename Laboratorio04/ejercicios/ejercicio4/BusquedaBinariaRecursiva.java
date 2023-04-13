package ejercicio4;

public class BusquedaBinariaRecursiva {

    public static void main(String[] args) {
        int[] arreglo = {1, 3, 4, 5, 6, 8, 9, 11, 12};
        int elementoBuscado = 8;
        int indiceEncontrado = busquedaBinariaRecursiva(arreglo, elementoBuscado, 0, arreglo.length - 1);
        if (indiceEncontrado == -1) {
            System.out.println("El elemento no se encuentra en el arreglo.");
        } else {
            System.out.println("El elemento se encuentra en el índice " + indiceEncontrado + " del arreglo.");
        }
    }

    public static int busquedaBinariaRecursiva(int[] arreglo, int elementoBuscado, int inicio, int fin) {
        if (inicio > fin) {
            return -1;
        }
        int medio = (inicio + fin) / 2;
        if (arreglo[medio] == elementoBuscado) {
            return medio;
        } else if (arreglo[medio] > elementoBuscado) {
            return busquedaBinariaRecursiva(arreglo, elementoBuscado, inicio, medio - 1);
        } else {
            return busquedaBinariaRecursiva(arreglo, elementoBuscado, medio + 1, fin);
        }
    }
}