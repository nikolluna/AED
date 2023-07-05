package Listas;

public class Node<T> {
    private T data;
    private Node<T> next; // siguiente

    public Node(T data, Node <T> next){
        this.data=data;
        this.next= next;
    }
    public Node(T data){
        this(data, null);
    //     Tipo T, Nde <T>     ==> valores
    }
    public T getData(){
        return  this.data;
    }
    public void setData(T data){
        this.data=data;
    }
    public Node<T> getNext() {
        return next;
    }
    public void setNext(Node<T> next){
        this.next=next;
    }
    @Override
    public String toString(){
        return  this.data.toString();
    }
}
