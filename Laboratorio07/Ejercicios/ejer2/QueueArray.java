package ejer2;

public class QueueArray<E> implements Queue<E> {
    private E[] array;
    private int front;
    private int back;
    private int size;

    public QueueArray(int capacity) {
        this.array = (E[]) new Object[capacity];
        this.front = 0;
        this.back = -1;
        this.size = 0;
    }

    public void enqueue(E x) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        back = (back + 1) % array.length;
        array[back] = x;
        size++;
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty();
        }
        E removedValue = array[front];        
        array[front] = null;
        front = (front + 1) % array.length;
        size--;
        return removedValue;
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty();
        }
        return array[front];
    }

    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty();
        }
        return array[back];
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public boolean isFull() {
        return (size == array.length);
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % array.length;
            sb.append(array[index]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

