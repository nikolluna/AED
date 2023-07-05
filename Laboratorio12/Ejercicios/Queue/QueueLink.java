package Ejercicios.Queue;
import Listas.Node;
import java.util.function.ToDoubleBiFunction;


public class QueueLink<E> implements Queue <E> {
    private Node <E> first ;
    private Node<E>  last;
    public QueueLink (){
        this.first=null;
        this.last= null;
    }
    @Override
    public void enqueue(E x) {
        Node <E> aux= new Node<E>(x);
        if(isEmpty()){
            this.last= this.first= aux;
        } else{
            this.last.setNext(aux);
        } 
        this.last=aux;
    }
    @Override
    public E dequeue() throws ExceptionIsEmpty {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dequeue'");
    }

    @Override
    public E front() throws ExceptionIsEmpty {
        if(isEmpty())
            throw new ExceptionIsEmpty("Queue is empty ..");
        return this.first.getData();
    }
    @Override
    public E back() throws ExceptionIsEmpty {
        if(isEmpty())
            throw new ExceptionIsEmpty("Queue is empty ..");
        return this.last.getData();
    }
    @Override
    public boolean isEmpty() {
        return first==null;
    }
    
    @Override
    public void destroyQueue() {
    
    }
    

    public Node<E> getFirst() {
        return first;
    }
    public void setFirst(Node<E> first) {
        this.first = first;
    }
    public Node<E> getLast() {
        return last;
    }
    public void setLast(Node<E> last) {
        this.last = last;
    }
    @Override
    public void enqueue() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'enqueue'");
    }
    
    @Override
    public String toString() {
        String str="";
        for(Node <E>  aux = this.first; aux != null; aux= aux.getNext()){
            str+= aux.toString()+" ,";
        }
        return str;
    }

}
