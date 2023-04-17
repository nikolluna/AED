package act3;

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
}

