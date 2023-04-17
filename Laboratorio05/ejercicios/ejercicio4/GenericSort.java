package ejercicio4;

import java.util.Arrays;

public class GenericSort {
	
	public static<T extends Comparable<T>> void bubbleSort(T a[]) {
		boolean fl = true;
		int pass = 0;
		int n = a.length;
		for (pass = 0; pass < n - 1 & fl; pass++) {
			//bucle externo controla la cantidad de pasadas
			fl = false;
			for(int  j = 0; j < n-pass-1; j++) {
				//elementos desordeados, es necesario intercambio
				if(a[j].compareTo(a[j+1]) >= 1) {
					fl = true;
					T aux = a[j];
					a[j] = a[j+1];
					a[j+1] = aux;
				}
			}
		}
	}
	
	public static<T extends Comparable<T>> void insertionSort (T a[]) {
		int i, j;
		T aux;

		for (i = 1; i < a.length; i++) {
		//el indice j explora sublista ala-1]..a[0]
		//buscando posicion correcta del elemento destion, para asignarlo en alj]
		j=i;
		aux = a[i];
		//se localiza el punto de hh an explorando hacia atras.
		while (j > 0 && (aux.compareTo(a[j-1])) <= -1) {
			a[j] = a[j-1];
			j--;
		}
		a[j] = aux;
		}
	}
	
	public static<T extends Comparable<T>> void selectionSort(T a[]) {
		int min;

		for (int i = 0; i < a.length - 1; i++) {
			min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[min].compareTo(a[j]) >= 1)
					min = j;

			}
			T aux = a[min];
			a[min] = a[i];
			a[i] = aux;
		}
	}
		
	public static<T extends Comparable<T>> void shellSort (T a[]) {
		int interval = a.length / 2;
		int i, j;
		T aux;
		
		while (interval > 0) {
			for (i = interval; i < a.length; i++) {
				j =i;
				aux = a[i];
				while ((j >= interval) && (a[j-interval].compareTo(aux)>=1)) {
					a[j] = a[j-interval];
					j = j - interval;
				}
				a[j] = aux;
			}	
			interval = interval / 2;
		}
	}
	
	public static<T extends Comparable<T>> void quickSort(T a[], int l, int r) {
		int i = l;
		int j = r;

		T pivot = a[(l + r) / 2];

		do {
			while (a[i].compareTo(pivot) <= -1)
				i++;
			while (pivot.compareTo(a[j]) <= -1)
				j--;
			if (i <= j) {
				if (i != j) {
					T aux = a[i];
					a[i] = a[j];
					a[j] = aux;
				}
				i++;
				j--;
			}
		} while (i <= j);

		if (l < j) {
			quickSort(a, l, j);

		}
		if (i < r) {
			quickSort(a, i, r);
		}
	}
	
	public static<T extends Comparable<T>> void mergeSort(T[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private static<T extends Comparable<T>> void merge(T[] arr, int start, int mid, int end) {
        T[] temp = Arrays.copyOfRange(arr, start, end + 1);
        int i = 0, j = mid - start + 1, k = start;
        while (i <= mid - start && j <= end - start) {
            if (temp[i].compareTo(temp[j]) <= 0) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }
        while (i <= mid - start) {
            arr[k++] = temp[i++];
        }
        while (j <= end - start) {
            arr[k++] = temp[j++];
        }
    }
    
    public static <T extends Comparable<T>> void brickSort(T[] arr) {
        int n = arr.length;
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 1; i < n - 1; i += 2) {
                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    swap(arr, i, i + 1);
                    swapped = true;
                }
            }
            for (int i = 0; i < n - 1; i += 2) {
                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    swap(arr, i, i + 1);
                    swapped = true;
                }
            }
        }
    }
    
   	private static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
   		T temp = arr[i];
   		arr[i] = arr[j];
   		arr[j] = temp;
   	}
   	public static <T extends Comparable<T>> void shakerSort(T[] arr) {
   		int n = arr.length;
   		boolean swapped;
   		do {
   			swapped = false;
   			for (int i = 0; i < n - 1; i++) {
   				if (arr[i].compareTo(arr[i + 1]) > 0) {
   					swap(arr, i, i + 1);
   					swapped = true;
   				}
   			}
   			if (!swapped) {
   				break;
   			}
   			swapped = false;
   			for (int i = n - 2; i >= 0; i--) {
   				if (arr[i].compareTo(arr[i + 1]) > 0) {
   					swap(arr, i, i + 1);
   					swapped = true;
   				}
   			}
   		} while (swapped);
   	}
}

