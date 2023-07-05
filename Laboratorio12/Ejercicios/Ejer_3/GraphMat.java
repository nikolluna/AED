package Ejercicios.Ejer_3;

import java.util.ArrayList;
import java.util.List;

public class GraphMat<E> {
    private E[][] matrix;  // Representa la matriz de adyacencia
    private List<E> vertices;  // Almacena los vértices del grafo

    public GraphMat() {
        this.matrix = (E[][]) new Object[100][100]; 
        this.vertices = new ArrayList<>();
    }
    public void insertVertex(E v) {
        if(!vertices.contains(v)) 
            vertices.add(v);
    }
    public void insertEdge(E v, E z) {
        if(vertices.contains(v) && vertices.contains(z)) {
            int vIndex = vertices.indexOf(v);
            int zIndex = vertices.indexOf(z);
            matrix[vIndex][zIndex] = z;
            matrix[zIndex][vIndex] = v; // Si el grafo es no dirigido
        }
    }
    public boolean searchVertex(E v) {
        return vertices.contains(v);
    }
    public boolean searchEdge(E v, E z) {
        if(vertices.contains(v) && vertices.contains(z)) {
            int vIndex = vertices.indexOf(v);
            int zIndex = vertices.indexOf(z);
            return matrix[vIndex][zIndex] != null && matrix[zIndex][vIndex] != null;
        }
        return false;
    }
    public void dfs(E v) {
        boolean[] visited = new boolean[vertices.size()];
        dfsHelper(vertices.indexOf(v), visited);
    }
    private void dfsHelper(int v, boolean[] visited) {
        visited[v] = true;
        System.out.println(vertices.get(v));
        for(int i = 0; i < vertices.size(); i++) {
            if(matrix[v][i] != null && !visited[i]) 
                dfsHelper(i, visited);
        }
    }
}



