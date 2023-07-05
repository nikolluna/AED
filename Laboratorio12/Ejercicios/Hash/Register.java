package Ejercicios.Hash;

public class Register <E> implements Comparable<Register<E>>{
    protected int key;
    protected E value;

    public Register(int key, E value){
        this.key= key;
        this.value= value;
    }
    public Register(int key){
        this(key, null);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Register other = (Register) obj;
        if (key != other.key)
            return false;
        return true;
    }
    public int compareTo(Register<E> r){
        return this.key - r.key;
    }
    public int getKey() {
        return key;
    }
    public void setKey(int key) {
        this.key = key;
    }
    public E getValue() {
        return value;
    }
    public void setValue(E value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return " [key: " + key + ", value: " + value + "]";
    }
}
