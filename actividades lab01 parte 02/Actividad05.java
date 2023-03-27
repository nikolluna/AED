package actividades;

import javax.swing.JOptionPane;

public class Actividad05 {
	public static void main(String[] args) {

		String texto = JOptionPane.showInputDialog(null, "Inserta una frase", 
						"Inserción",JOptionPane.INFORMATION_MESSAGE);

		// Almacena el texto final
		String texto_sin_espacios = "";

		char caracterActual;

		// recorre el Array
		for (int i = 0; i < texto.length(); i++) {
			caracterActual = texto.charAt(i);

			// Cuando es un espacio vacio, no lo copia a la nueva cadena
			if (caracterActual != ' ') {
				texto_sin_espacios += String.valueOf(caracterActual);
			}
		}
		JOptionPane.showMessageDialog(null, "La frase sin espacios es: " + 
										texto_sin_espacios, "Resultado",
				JOptionPane.INFORMATION_MESSAGE);
	}
}



