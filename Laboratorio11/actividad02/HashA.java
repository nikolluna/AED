package actividad02;

import java.util.ArrayList;

public class HashA<E extends Comparable<E>> {

    protected class Element {
        ArrayList<Register<E>> chain;

        public Element() {
            chain = new ArrayList<>();
        }
    }

    protected ArrayList<Element> table;
    protected int m;

    public HashA(int n) {
        this.m = n;

        table = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            table.add(new Element());
        }
    }

    private int functionHash(int key) {
        return key % m;
    }

    public void insert(int key, E reg) {
        int hash = functionHash(key);
        Register<E> newReg = new Register<>(key, reg);
        table.get(hash).chain.add(newReg);
    }

    public E search(int key) {
        int hash = functionHash(key);
        ArrayList<Register<E>> chain = table.get(hash).chain;
        for (Register<E> reg : chain) {
            if (reg.key == key) {
                return reg.value;
            }
        }
        return null;
    }

    public String toString() {
        String s = "D.Hash\tRegister\n";
        for (int i = 0; i < m; i++) {
            s += i + " -->\t";
            ArrayList<Register<E>> chain = table.get(i).chain;
            if (chain.isEmpty()) {
                s += "empty\n";
            } else {
                for (Register<E> reg : chain) {
                    s += reg + " -> ";
                }
                s += "null\n";
            }
        }
        return s;
    }
}
