package act7;

public class Sort {
	
	public static void bubbleSort(int a[]) {
		boolean fl = true;
		int pass = 0;
		int n = a.length;
		for (pass = 0; pass < n - 1 & fl; pass++) {
			//bucle externo controla la cantidad de pasadas
			fl = false;
			for(int  j = 0; j < n-pass-1; j++) {
				//elementos desordeados, es necesario intercambio
				if(a[j]>a[j+1]) {
					fl = true;
					int aux = a[j];
					a[j] = a[j+1];
					a[j+1] = aux;
				}
			}
		}
	}
	
	public static void insertionSort (int a[]) {
		int i, j, aux;

		for (i = 1; i < a.length; i++) {
		//el indice j explora sublista ala-1]..a[0]
		//buscando posicion correcta del elemento destion, para asignarlo en alj]
		j=i;
		aux = a[i];
		//se localiza el punto de hh an explorando hacia atras.
		while (j > 0 && aux < a[j-1]) {
			a[j] = a[j-1];
			j--;
		}
		a[j] = aux;
		}
	}
	
	public static void selectionSort(int a[]) {
		int min;

		for (int i = 0; i < a.length - 1; i++) {
			min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[min] > a[j])
					min = j;

			}
			int aux = a[min];
			a[min] = a[i];
			a[i] = aux;
		}
	}
		
	public static void shellSort (int a[]) {
		int interval = a.length / 2;
		int i, j, aux;
		
		while (interval > 0) {
			for (i = interval; i < a.length; i++) {
				j =i;
				aux = a[i];
				while ((j >= interval) && (a[j-interval] > aux)) {
					a[j] = a[j-interval];
					j = j - interval;
				}
				a[j] = aux;
			}	
			interval = interval / 2;
		}
	}
	
	public static void quickSort(int a[], int l, int r) {
		int i = l;
		int j = r;

		int pivot = a[(l + r) / 2];

		do {
			while (a[i] < pivot)
				i++;
			while (pivot < a[j])
				j--;
			if (i <= j) {
				if (i != j) {
					int aux = a[i];
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
}

