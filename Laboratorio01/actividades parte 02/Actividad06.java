package actividades;

import javax.swing.JOptionPane;

public class Actividad06 {
	public static void main(String[] args) {

        String texto =  JOptionPane.showInputDialog(null, 
        				"Introduce un texto cadena vacia para terminar", 
        				"Introducir texto", 
        			    JOptionPane.INFORMATION_MESSAGE);

        String cadenaResultando = "";

        //Mientras no este vacio la cadena continua
        while (!texto.isEmpty()){
            
            //Concatenamos el texto
            cadenaResultando += texto;

            //Reintroducimos denuevo una cadena
            texto = JOptionPane.showInputDialog(null, 
            									"Introduce un texto, cadena vacia para terminar", 
            									"Introducir texto", 
            									JOptionPane.INFORMATION_MESSAGE);
        }

        JOptionPane.showMessageDialog(null, cadenaResultando, "Resultado", 
        								JOptionPane.INFORMATION_MESSAGE);
    }
}



