package Ejercicios.Queue;
import Listas.Node;
import java.rmi.server.ExportException;

//import javafx.scene.web.WebHistory.Entry;
//                             E= Data , P= Prioridad
public class PriorityQueueLinked <E, INTEGER> implements PriorityQueue <E,INTEGER>{
    //                  P siempre sera de tipo INTEGER
    private QueueLink<E> [] arr_QueLink;
    //private int tope; // tope
    
    public PriorityQueueLinked(int n ){
        // Inicializacion del Array
        this.arr_QueLink=  new QueueLink[n];
        // llenaremos el array con la cantidad
        for(int i =0; i<n ; i++){
            arr_QueLink[i]=new QueueLink<E>();
        }
    }
    @Override
    public void enqueue(E x, Integer r) {
        if( r> -1 && r<arr_QueLink.length){
            arr_QueLink[r] .enqueue(x);
        }else{
            System.out.println("Prioridad Fuera de rango");
        }
    }
    
    @Override
    public E dequeue() throws ExceptionIsEmpty {
        QueueLink<E> aux_arr= new QueueLink<E>();
        if(!isEmpty()){
            // retornara el elemenco con mayor prioridad en este caso el 
            // primero en caso de estar vacio pasara al siguiente
            for(int i=0; i<arr_QueLink.length ; i++){
                if(arr_QueLink[i].isEmpty()){
                    aux_arr= arr_QueLink[i];
                    arr_QueLink[i]= new QueueLink<E>(); // 
                    return aux_arr.getFirst().getData();

                }
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        for(int i=0; i<arr_QueLink.length ; i++){
            if (arr_QueLink[i]!= null )
                return false;
        }
        return true;
    }
    
    @Override
    public E front() throws ExceptionIsEmpty {        
        if(!isEmpty()){
            // retornara el elemenco con mayor prioridad en este caso el 
            // primero en caso de estar vacio pasara al siguiente
            for(int i=0; i<arr_QueLink.length ; i++){
                if(! arr_QueLink[i].isEmpty()){
                    return arr_QueLink[i].getFirst().getData();
                }
            }
        }
        return null;
    }
    @Override
    public E back() throws ExceptionIsEmpty{
        if(!isEmpty()){
            // retornara el elemenco con mayor prioridad en este caso el 
            // primero en caso de estar vacio pasara al siguiente
            for(int i=arr_QueLink.length; i>0 ; i--){
                if(! arr_QueLink[i].isEmpty())
                    return arr_QueLink[i].getFirst().getData();
            }
        }
        return null;
        
    }

    @Override
    public String toString() {
        String str="";
        for(int i=0; i<arr_QueLink.length; i++){
            for(Node<E> aux= arr_QueLink[i].getFirst(); aux != null ; aux=aux.getNext()){
                str+= aux.toString()+" ,";
            }
        }
        return str;
    }
}
