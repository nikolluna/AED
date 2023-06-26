package ejercicio3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HashEmpleado {

    public static int obtenerValorM(int cantidadElementos) {
        int m = cantidadElementos + (int) Math.ceil(cantidadElementos * 0.4);
        while (!esPrimo(m)) {
            m++;
        }
        return m;
    }

    public static boolean esPrimo(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int funcionHash(int codigoEmpleado, int m) {
        return codigoEmpleado % m;
    }

    public static void dispersarArchivo(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int cantidadElementos = 0;
            int m = 0;
            Empleado[] tabla = null;
            while ((linea = br.readLine()) != null) {
                if (cantidadElementos == 0) {
                    linea = linea.replaceAll("[^0-9]", "");
                    cantidadElementos = Integer.parseInt(linea);
                    m = obtenerValorM(cantidadElementos);
                    tabla = new Empleado[m];
                    continue;
                }
                String[] partes = linea.split(",");
                int codigo = Integer.parseInt(partes[0]);
                String nombre = partes[1];
                String direccion = partes[2];

                int direccionHash = funcionHash(codigo, m);

                if (tabla[direccionHash] == null) {
                    tabla[direccionHash] = new Empleado(codigo, nombre, direccion, direccionHash, 0);
                } else {
                    int i = 1;
                    while (tabla[(direccionHash + i * i) % m] != null) {
                        i++;
                    }
                    int direccionReal = (direccionHash + i * i) % m;
                    tabla[direccionReal] = new Empleado(codigo, nombre, direccion, direccionHash, i);
                }
            }
            imprimirTabla(tabla);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void imprimirTabla(Empleado[] tabla) {
        System.out.println("Tabla dispersada:");
        System.out.println("Código\tNombre\tDirección\tDirección Hash\tLongitud de Búsqueda");
        for (Empleado empleado : tabla) {
            if (empleado != null) {
                System.out.println(empleado.getCodigo() + "\t" + empleado.getNombre() + "\t" + empleado.getDireccion()
                        + "\t" + empleado.getDireccionHash() + "\t\t" + empleado.getLongitudBusqueda());
            }
        }
    }

    public static void main(String[] args) {
        String archivoEmpleados = "C:/Users/diazt/eclipse-workspace/HASHOFICIAL/src/ejercicio3/EMPLEADO.TXT.txt";
        dispersarArchivo(archivoEmpleados);
    }
}

class Empleado {
    private int codigo;
    private String nombre;
    private String direccion;
    private int direccionHash;
    private int longitudBusqueda;

    public Empleado(int codigo, String nombre, String direccion, int direccionHash, int longitudBusqueda) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.direccionHash = direccionHash;
        this.longitudBusqueda = longitudBusqueda;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getDireccionHash() {
        return direccionHash;
    }

    public int getLongitudBusqueda() {
        return longitudBusqueda;
    }
}