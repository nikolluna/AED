package Ejercicios.Ejer_2;
import Listas.Node;
import graphlink.Edge;
import graphlink.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

import Ejercicios.Hash.HashA;
import Ejercicios.Queue.ExceptionIsEmpty;
import Ejercicios.Queue.PriorityQueueLinked;
import Ejercicios.Queue.QueueArray;
import Listas.ListLikend;

public class GraphLink <E extends Comparable <E>>{
    private ListLikend<Vertex<E>> listVertex;

    public GraphLink(){
        listVertex = new ListLikend<Vertex<E>>();
    }
    ///// Ejercicio 2 
    //A)
    public void insertEdgeWeight(E dataRefOri, E dataRefDes, int weight) {
        Vertex<E> refOri = this.SearchNode(dataRefOri);
        Vertex<E> refDes = this.SearchNode(dataRefDes);
        if (refOri != null && refDes != null) {
            refOri.getListAdj().insertFirst(new Edge<E>(refDes, weight));
        } else {
            System.out.println("Uno o ambos vértices no existen");
        }
    }

    ///// Ejercicio 1
    public void bfs(Vertex<E> startVertex) {
        HashA<Vertex<E>> visited = new HashA<>(100); 
        QueueArray<Vertex<E>> queue = new QueueArray<>(100);
        queue.enqueue(startVertex);
        
        while (!queue.isEmpty()) {
            Vertex<E> currentVertex = queue.dequeue();
            System.out.println("Visitando vértice: " + currentVertex.getData());

            for (Edge<E> edge : currentVertex.getListAdj()) {
                if (visited.search(edge.getRefDes().hashCode()) == null) {
                    queue.enqueue(edge.getRefDes());
                    visited.insert(edge.getRefDes().hashCode(), edge.getRefDes());
                }
            }
        }
    }

    public ArrayList<E> bfsPath(E startData, E endData) {
        Vertex<E> startVertex = SearchNode(startData);
        Vertex<E> endVertex = SearchNode(endData);
        if(startVertex == null || endVertex == null) return null;

        HashA<Vertex<E>> visited = new HashA<>(100); 
        QueueArray<Vertex<E>> queue = new QueueArray<>(100); 
        HashMap<Vertex<E>, Vertex<E>> path = new HashMap<>();
        
        queue.enqueue(startVertex);
        Vertex<E> currentVertex ;
        while (!queue.isEmpty()) {
            currentVertex = queue.dequeue();

            if (currentVertex.equals(endVertex)) {
                ArrayList<E> resultPath = new ArrayList<>();
                while (currentVertex != null) {
                    resultPath.add(0, currentVertex.getData()); 
                    currentVertex = path.get(currentVertex);
                }
                return resultPath;
            }

            for (Edge<E> edge : currentVertex.getListAdj()) {
                if (visited.search(edge.getRefDes().hashCode()) == null) {
                    queue.enqueue(edge.getRefDes());
                    visited.insert(edge.getRefDes().hashCode(), edge.getRefDes());
                    path.put(edge.getRefDes(), currentVertex);
                }
            }
        }
        return null;
    }
    /*
    for (int i =0; i<currentVertex.getListAdj().length() ; i++) {
                Edge<E> edge= currentVertex.getListAdj().getNode(endData);
     */

    //////////
    public Vertex<E> SearchNode(E data){
        return this.listVertex.getNode(new Vertex<E>(data));
    }
    private void initLabel(){
        Node<Vertex<E>> nodeVer = this.listVertex.getFirst();
        for( ; nodeVer != null ; nodeVer = nodeVer.getNext()){
            Vertex<E> v = nodeVer.getData();
            v.setLabel(0);
            Node<Edge<E>> nodeEdge = v.getListAdj().getFirst();
            for(; nodeEdge != null ; nodeEdge = nodeEdge.getNext()){
                Edge<E> e= nodeEdge.getData();
                e.setLabel(0);
            }
        }
    }
    public void dfs(E data){
        Vertex<E> v = SearchNode(data);
        if(v== null)
            return ;
        initLabel();
        dfs(v);
    }


    private Vertex<E> opposite(Edge<E> e){
        return e.getRefDes();
    } 
    private void dfs(Vertex<E> vert){
        vert.setLabel(1);
        Node<Edge<E>> nodeEdge = vert.listAdj.getFirst();
        for(; nodeEdge != null ; nodeEdge= nodeEdge.getNext()){
            Edge<E> e= nodeEdge.getData();
            e.setLabel(0); 
            if(e.getLabel()== 0){
                Vertex<E> w= opposite(e);
                if(w.getLabel() == 0){
                    e.setLabel(1);
                    dfs(w);
                }else{
                    e.setLabel(2);
                }

            }
        }
    }

    public void insertVertex(E data){
        Vertex<E> v = new Vertex<E>(data);
        if(this.listVertex.searchh(v)){
            System.out.println("vertice ya fue insertado reviamnete..");
        } else{
            this.listVertex.insertFirst(v);
        }
    }
    
    public void insertEdge(E dataOri, E dataDest){
        Vertex<E> verOri= this.listVertex.getNode(new Vertex<E> (dataOri));
        Vertex<E> verDes= this.listVertex.getNode(new Vertex<E> (dataDest));
        if(verOri == null || verDes == null)
            System.out.println("alGUNO DE LOS VERTICES NO EXISTE");
        else{
            Edge<E> ori= new Edge<>(verOri);
            Edge<E> des= new Edge<>(verDes);
            if(verOri.listAdj.search(des) != -1)
                System.out.println("ya fue insetada previamente ....");
            else
                verOri.listAdj.insertFirst(des);
                verOri.listAdj.insertFirst(ori); 
        }
    }

    public boolean searchVertex(E Data){
        Vertex<E> v= this.listVertex.getNode(new Vertex<E>(Data));
        if(v == null){
            System.out.println("Vertice no existente");
            return false;
        }
        return true;
    }

    public boolean searchEdge(E Data , E D){
        if(this.searchVertex(Data)  && this.searchVertex(D)){
            Vertex<E> verOri = this.listVertex.getNode(new Vertex<E> (Data));
            Vertex<E> verDis = this.listVertex.getNode(new Vertex<E> (D));
            // verificaremos por el metodo searchh del metodo  searchh  
            //                                              ref
            return verOri.listAdj.searchh( new Edge<E>(verDis));
        }
        return false;
    }
    
    public void removeVertex(E data){
        Vertex<E> v = new Vertex<E>(data);
        if(!this.listVertex.searchh(v)) {
            System.out.println("El vértice no existe...");
            return;
        }
        for (Node<Vertex<E>> node = this.listVertex.getFirst(); node != null; node = node.getNext()) 
            node.getData().getListAdj().removeNode(new Edge<E>(v));
        this.listVertex.removeNode(v);
    }

    public void removeEdge(E datarOri, E dataDest) {
        Vertex<E> verOri= this.listVertex.getNode(new Vertex<E> (datarOri));
        Vertex<E> verDes= this.listVertex.getNode(new Vertex<E> (dataDest));

        if(verOri == null || verDes == null) {
            System.out.println("Al menos uno de los vértices no existe...");
            return;
        }
        Edge<E> e = new Edge<E>(verDes);
        if(verOri.getListAdj().search(e) == -1) 
            System.out.println("La arista no existe...");
        else 
            verOri.getListAdj().removeNode(e);
    }

    
    public String toString(){
        return this.listVertex.toString();
    }
}