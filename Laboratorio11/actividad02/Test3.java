package actividad02;

public class Test3 {
    public static void main(String[] args) {
        System.out.println("Prueba cuadratica");
    	HashC<String> hashTable = new HashC<>(6);

        hashTable.insertQuadraticProbing(1, "Registro1");
        hashTable.insertQuadraticProbing(2, "Registro2");
        hashTable.insertQuadraticProbing(3, "Registro3");
        hashTable.insertQuadraticProbing(12, "Registro4");
        System.out.println(hashTable.toString());
        
        System.out.println("Prueba Método por pliegue aplicando suma");
    	HashC<String> hashTable2 = new HashC<>(6);
        hashTable2.insertFoldingHash(1, "Registro1");
        hashTable2.insertFoldingHash(7, "Registro2");
        hashTable2.insertFoldingHash(13, "Registro3");
        System.out.println(hashTable2.toString());
        

    }
}

