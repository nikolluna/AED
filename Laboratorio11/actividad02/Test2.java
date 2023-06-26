package actividad02;

public class Test2 {
    public static void main(String[] args) {
        // Crear tabla hash con HashA
        HashA<String> hashTableA = new HashA<>(7);

        // Insertar claves y registros
        hashTableA.insert(34, "Registro1");
        hashTableA.insert(3, "Registro2");
        hashTableA.insert(7, "Registro3");
        hashTableA.insert(30, "Registro4");
        hashTableA.insert(11, "Registro5");
        hashTableA.insert(8, "Registro6");
        hashTableA.insert(7, "Registro7");
        hashTableA.insert(23, "Registro8");
        hashTableA.insert(41, "Registro9");
        hashTableA.insert(16, "Registro10");
        hashTableA.insert(34, "Registro11");

        // Mostrar contenido de la tabla hash y las listas
        System.out.println("Contenido de la tabla hash A:");
        System.out.println(hashTableA.toString());

        // Buscar un registro en la tabla hash A
        int keyToSearch = 7;
        String foundValue = hashTableA.search(keyToSearch);
        System.out.println("Valor encontrado para la clave " + keyToSearch + ": " + foundValue);
    }
}
