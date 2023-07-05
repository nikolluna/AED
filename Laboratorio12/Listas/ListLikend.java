package Listas;

public class  ListLikend <T> implements TDAList <T>{
    protected Node <T> first; /// cabecera
    protected int count; // contador

    public ListLikend (){
        this.first= null;
        this.count=0;
    }
    @Override
    public boolean isEmptyList() {
        return this.first== null;
    }
    @Override
    public int length() {
        return this.count;
    }
    @Override
    public void destroyList() {
        if(this.count >= 0  ){
            while( first != null)
                first=this.first.getNext();
        }
        count= 0;
    }

    public boolean searchh(T x) {
        int index=0;
        Node<T> aux= this.first;

        while( aux != null  && !aux.getData().equals(x)){
            aux = aux.getNext();
            index ++;
        }
        // es caso de que aux sea diferente quiere decir que es igual
        // al elemento x, en caso contrario no existe el elemento
        if(aux !=null)
            return true;
        return false;
    }

    public int search(T x) {
        int index=0;
        Node<T> aux= this.first;

        while( aux != null  && !aux.getData().equals(x)){
            aux = aux.getNext();
            index ++;
        }
        // es caso de que aux sea diferente quiere decir que es igual
        // al elemento x, en caso contrario no existe el elemento
        if(aux !=null)
            return index;
        return -1;
    }
    @Override
    public void insertFirst(T x) {
        this.first= new Node<T>(x, this.first);
        count++;
    }
    @Override
    public void insertLast(T x) {
        if(isEmptyList()){
            insertFirst(x);
        } else{
            Node<T> aux= this.first;
            while(aux.getNext()!= null)
                aux=aux.getNext();
            aux.setNext(new Node<T>(x));
            count++;
        }
    }
    public T getNode(T x){
        if (this.first == null) 
            return null;
        for (Node<T>aux = this.first; aux !=null ; aux = aux.getNext()){
            if (aux.getData().equals(x))
                return aux.getData();
        }
        return null;
    } 

    public Node<T> getFirst() {
        return first;
    }
    public void setFirst(Node<T> first) {
        this.first = first;
    }
    @Override
    public void removeNode(T x) {
        Node<T> aux = first;
        Node<T> prev_aux = null;
        for(int i=0 ; i<length() ; i++ ){
            if(aux.getData().equals(x)){
                if (prev_aux == null) {
                    first = aux.getNext();
                    // El nodo a eliminar es el primero del Array
                } else {
                    prev_aux.setNext(aux.getNext());
                    // El nodo a eliminar no es el primero del Array
                }
                System.out.println("se elimino con exito");
                count --;
                return;
            }
            prev_aux = aux;
            aux = aux.getNext();
        }    
    }
    public String toString() {
        String str="";
        Node<T> aux = this.first;
        for( ; aux != null ; aux = aux.getNext())
            str+= aux.toString()+", ";
        return str;
    }
}
