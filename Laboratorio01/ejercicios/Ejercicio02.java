package ejercicios;

import javax.swing.JOptionPane;

public class Ejercicio02 {
	public static void main(String[] args) {

        String texto =  JOptionPane.showInputDialog(null, 
        				"Introduce tus datos", 
        				"Datos del personal", 
        			    JOptionPane.INFORMATION_MESSAGE);

        String cadenaResultando = "  ";

        //Mientras no este vacio la cadena continua
        while (!texto.isEmpty()){
            
            //Concatenamos el texto
            cadenaResultando += texto;

            //Reintroducimos denuevo una cadena
            texto = JOptionPane.showInputDialog(null, 
            									"Introduce tu edad y una cadena vacia para terminar", 
            									"Datos del personal", 
            									JOptionPane.INFORMATION_MESSAGE);
        }

        JOptionPane.showConfirmDialog(null, cadenaResultando, "¿Desea guardar su información?", 
        		JOptionPane.YES_NO_OPTION);
        
        String respuesta = cadenaResultando.toUpperCase();
        JOptionPane.showMessageDialog(null, respuesta, "Datos del personal", JOptionPane.INFORMATION_MESSAGE);
  
    }
}




