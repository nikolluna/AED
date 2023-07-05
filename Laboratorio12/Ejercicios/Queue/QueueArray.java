package Ejercicios.Queue;



public class QueueArray <E> implements Queue<E> {
    private E[] array;
    private int tope;// index
    
    private int frontal;
    private int prev;

    public QueueArray (int size){
        this.array=  (E[]) new Object[size];
        this.tope=-1;
        this.frontal= 0;
        this.prev=-1;
    }
    @Override
    public void enqueue(E x) {
        if(!isFull()){
            tope++;
            this.array[tope]=x;
        } else{
            System.out.println("Array full");
        }
    }

    @Override
    public E dequeue() throws ExceptionIsEmpty {
        E aux=null;
        if(!isFull()){
            aux= array[frontal];
            frontal= frontal+1 % array.length;
            tope --;
        }
        return aux; 
    }
    @Override
    public boolean isEmpty() {
        return array[0]== null;
    }
    public boolean isFull(){
        if(tope < array.length)
            return false;
        return true;
    }

    @Override
    public E front() throws ExceptionIsEmpty {
        if(!isEmpty())
            return array[frontal];
                        //  0
        return null;
    }

    @Override
    public E back() throws ExceptionIsEmpty {
        if(!isEmpty())
            return array[tope];
        return null;
    }

    @Override
    public void destroyQueue() {
        E[] newArr= (E[]) new Object[this.array.length];
        array=newArr;
        frontal=0;
        prev=-1;
        tope=-1;
    }

    @Override
    public String toString() {
        String str="";
        for (int i =0; i <= tope; i++){
            str += this.array[i]+", ";
        }
        return str;
    }
    @Override
    public void enqueue() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'enqueue'");
    }
}
