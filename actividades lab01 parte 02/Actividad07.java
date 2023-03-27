package actividades;

import javax.swing.JOptionPane;

public class Actividad07 {
	public static void main(String[] args){
        String texto = JOptionPane.showInputDialog(null, "Porfavor introduce una frase", 
        		       "Introducción", JOptionPane.INFORMATION_MESSAGE);
        
        String cadenaResultante;

        boolean isMayus;

        int eleccion = JOptionPane.showConfirmDialog(null, "¿Quieres que se pase a mayusculas?", "Eleccion",
                JOptionPane.YES_NO_OPTION);

        isMayus = (eleccion == JOptionPane.YES_OPTION);

        //Segun lo escogido se transformara a mayuscula o minuscula
        if (isMayus) {
            cadenaResultante = texto.toUpperCase();
        } else {
            cadenaResultante = texto.toLowerCase();
        }

        //Mostramos la nueva cadena
        JOptionPane.showMessageDialog(null, cadenaResultante, "Resultado", JOptionPane.INFORMATION_MESSAGE);
    }
}

