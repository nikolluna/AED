package graphlink;
import Listas.ListLikend;
public class Vertex<E extends Comparable<E>> implements Comparable <Vertex<E>> {
    private E data;
    public ListLikend <Edge<E>> listAdj; 
    private int label ; /// 0 inexplorado || 1 visitado  ==> Arista

    public Vertex (E data){
        this.data= data;
        this.listAdj= new ListLikend<Edge<E>>();   
    }
    public ListLikend<Edge<E>> getListAdj() {
        return listAdj;
    }
    public void setListAdj(ListLikend<Edge<E>> listAdj) {
        this.listAdj = listAdj;
    }
    
    public int getLabel() {
        return label;
    }
    public void setLabel(int label) {
        this.label = label;
    }
    public E getData(){
        return this.data;
    }
    public boolean search(E v){
        return false;
    }
    public boolean equals (Object o){
        if(o instanceof Vertex<?>){
            Vertex<E> v = (Vertex<E> ) o;
            return this.data.equals(v.data);
        }
        return false;
    }
    public String toString(){
        return this.data+" ---> "+this.listAdj.toString();
    }
    public int compareTo(Vertex<E> refDest) {
        return 0;
    }
}

