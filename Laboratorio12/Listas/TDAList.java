package Listas;

public interface TDAList <E> {
    boolean isEmptyList();
    int length();
    void destroyList();
    //int search(E x); // E es un identificador
    void insertFirst(E x);
    void insertLast(E x);
    void removeNode(E x);
}

