package graphlink;

public class Edge<E extends Comparable <E> > implements Comparable <Edge<E>> {
    private Vertex<E> refDest;
    private int weight; // peso de la arista
    private int label; // 

    public Edge(Vertex<E> refDest){
        this(refDest , -1);
    }
    public Edge(Vertex<E> refDest , int weight){
        this.refDest=refDest;
        this.weight=weight;
    }
    public Vertex<E> getRefDes(){
        return this.refDest;
    }
    public void setRefDes(Vertex<E> refDes){
        this.refDest= refDes;
    }
    public int getLabel() {
        return label;
    }
    public void setLabel(int label) {
        this.label = label;
    }
    public int compareTo(Edge<E> o) {
        //if(this.refDest  o.getRefDes())
        //    return 1;
        //if(this.refDest.compareTo(o.refDest) == -   1)
        //    return -1;
        return 0;
    }
    public boolean equals(Object o ){
        if(o instanceof Edge<?>){
            Edge<E> e= (Edge<E>) o;
            return this.refDest.equals(e.refDest);
        }
        return false;
    }
    public String toString(){
        if(this.weight > -1 )
            return refDest.getData()+ "  ["+this.weight+"]";
        else
            return refDest.getData()+", ";
    }
}