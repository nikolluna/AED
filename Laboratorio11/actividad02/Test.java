package actividad02;

public class Test {
    public static void main(String[] args) {
        HashC<String> hashTable = new HashC<>(11);

        hashTable.insert(34, "Registro1");
        hashTable.insert(3, "Registro2");
        hashTable.insert(7, "Registro3");
        hashTable.insert(30, "Registro4");
        hashTable.insert(11, "Registro5");
        hashTable.insert(8, "Registro6");
        hashTable.insert(7, "Registro7");
        hashTable.insert(23, "Registro8");
        hashTable.insert(41, "Registro9");
        hashTable.insert(16, "Registro10");
        hashTable.insert(34, "Registro11");

        System.out.println(hashTable.toString());
    }
}
