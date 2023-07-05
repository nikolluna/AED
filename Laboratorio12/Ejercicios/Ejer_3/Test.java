package Ejercicios.Ejer_3;

public class Test {
    public static void main(String[] args) {
        GraphMat<String> graph = new GraphMat<>();

        // Insertando vertices
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");

        // Insertando aristas
        graph.insertEdge("A", "B");
        graph.insertEdge("B", "C");
        graph.insertEdge("C", "D");
        graph.insertEdge("D", "A");

        // Buscando vertices y aristas
        System.out.println(graph.searchVertex("A")); // Debería imprimir: true
        System.out.println(graph.searchVertex("E")); // Debería imprimir: false
        System.out.println(graph.searchEdge("A", "B")); // Debería imprimir: true
        System.out.println(graph.searchEdge("A", "C")); // Debería imprimir: false

        // DFS desde "A"
        graph.dfs("A"); // Debería imprimir: A B C D
    }
}
