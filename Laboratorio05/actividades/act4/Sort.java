package act4;

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
}

