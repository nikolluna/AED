package graphlink;

import Ejercicios.Ejer_2.GraphLink;

public class Test_1 {
    public static void main(String[] args) {
        GraphLink <String> g1 = new GraphLink<String>();
        
        System.out.println("\t Insert Vertex");
        g1.insertVertex("Lima");
        g1.insertVertex("Arequipa");
        g1.insertVertex("Cusco");
        g1.insertVertex("Tacna");
        g1.insertVertex("Moquegua");
        g1.insertVertex("Puno");

        g1.insertVertex("X");
        g1.insertVertex("Y");
        g1.insertVertex("Z");
        g1.insertVertex("W");

        System.out.println(g1);

        
        System.out.println("\t Insert Edge");
        g1.insertEdge("Lima", "Cusco");
        g1.insertEdge("Arequipa","Tacna");
        g1.insertEdge("Tacna","Lima");
        g1.insertEdge("Cusco","Arequipa");
        g1.insertEdge("Lima","Arequipa");
        g1.insertEdge("Lima","Moquegua");
        g1.insertEdge("Arequipa","Puno");
        g1.insertEdge("Puno","Cusco");
        g1.insertEdge("Lima","Lima");

        g1.insertEdge("Y","X");
        g1.insertEdge("Z", "W");
        g1.insertEdge("Arequipa", "X");

        System.out.println(g1);

        g1.dfs("Lima");
    }
}
