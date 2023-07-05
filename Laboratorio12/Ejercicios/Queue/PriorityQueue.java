package Ejercicios.Queue;


public interface PriorityQueue <E,INTEGER>{
    void enqueue (E x, Integer r);
    E dequeue() throws ExceptionIsEmpty;
    E front() throws ExceptionIsEmpty;
    E back() throws ExceptionIsEmpty;
    boolean isEmpty();
}
