package ejercicio4;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Empleado {
    int codigo;
    String nombre;
    String direccion;

    public Empleado(int codigo, String nombre, String direccion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
    }
}

class HashEmpleado {
    public static int funcionHash(int codigoEmpleado, int m) {
        return codigoEmpleado % m;
    }

    public static void dispersarArchivo(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int cantidadElementos = 0;
            List<Empleado>[] tabla = null;

            while ((linea = br.readLine()) != null) {
                if (cantidadElementos == 0) {
                    linea = linea.replaceAll("[^0-9]", "");
                    cantidadElementos = Integer.parseInt(linea);
                    tabla = new List[cantidadElementos];

                    // Inicializar las listas enlazadas en cada posición de la tabla
                    for (int i = 0; i < cantidadElementos; i++) {
                        tabla[i] = new ArrayList<>();
                    }
                    continue;
                }

                String[] partes = linea.split(",");
                int codigo = Integer.parseInt(partes[0]);
                String nombre = partes[1];
                String direccion = partes[2];

                int direccionHash = funcionHash(codigo, cantidadElementos);

                // Agregar el empleado a la lista enlazada correspondiente
                tabla[direccionHash].add(new Empleado(codigo, nombre, direccion));
            }

            // Mostrar el contenido de la tabla
            for (int i = 0; i < cantidadElementos; i++) {
                System.out.println("Dirección Hash: " + i);
                System.out.println("----------------------------");
                for (Empleado empleado : tabla[i]) {
                    System.out.println("Código: " + empleado.codigo);
                    System.out.println("Nombre: " + empleado.nombre);
                    System.out.println("Dirección: " + empleado.direccion);
                    System.out.println();
                }
                System.out.println("----------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String archivo = "C://Users//diazt//eclipse-workspace//HASHOFICIAL//src//ejercicio4//EMPLEADO.TXT.txt";
        dispersarArchivo(archivo);
    }
}

