package Ejercicios.Hash;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class HashC  <E extends Comparable <E>>{
    protected class Element{
        int mark;
        Register <E> reg;
        public Element(int mark, Register<E>  reg){
            this.mark = mark;
            this.reg= reg;
        }
    }
    protected ArrayList<Element> table;
    protected int m;
    public HashC(int n){
        this.m= n;
        this.table= new ArrayList<Element>(m);
        for(int i=0; i < m; i++)
            this.table.add(new Element(0, null));
    }


    /////////////////////////////////// Ejericio 1
    private int quadraticProbing (int dressHash, int key, int attempt){
        Register<E> regN= new Register<E>(key);
        int posInit= dressHash;
        do{
            if(this.table.get(dressHash).mark ==0)
                return dressHash;
            if(this.table.get(dressHash).mark == 1 && this.table.get(dressHash).reg.equals(regN))
                return -2;
            else
                dressHash= (dressHash + attempt * attempt) % m;
            attempt++;
        } while(dressHash != posInit);
        return -1;
    }

    public void insert(int key, E reg){
        int dressHash = functionHash(key);
        int attempt = 1;
        dressHash= quadraticProbing(dressHash, key, attempt);
        if(dressHash < 0)
            System.out.println("La tabla esta llena o la llave esta duplicada");
        else
            this.table.set(dressHash, new Element(1, new Register<E>(key, reg)));
    }

    
    ////////////////////////////////////
    private int functionHash(int key){
        return key % m;
    }
    private int linearProbing (int dressHash, int key){
        Register<E> regN= new Register<E>(key);
        int posInit= dressHash;
        do{
            // mark es la marca que indica si esta disponible y se inserta
            if(this.table.get(dressHash).mark ==0)
                return dressHash;
            if(this.table.get(dressHash).mark == 1 && this.table.get(dressHash).reg.equals(regN))
                return -2;
            else
                dressHash= (dressHash+1) % m;
        } while(dressHash != posInit);
        return -1;
    }
    

    public E search(int key) {
        int dressHash = functionHash(key);
        Register<E> regN = new Register<E>(key);
        int posInit = dressHash;
        do {
            if (table.get(dressHash).mark == 1 && table.get(dressHash).reg.equals(regN))
                return table.get(dressHash).reg.getValue();
            else 
                dressHash = (dressHash + 1) % m;
        } while (dressHash != posInit);
        return null;
    }
    public boolean remove(int key) {
        int dressHash = functionHash(key);
        Register<E> regN = new Register<E>(key);
        int posInit = dressHash;
        do {
            if (table.get(dressHash).mark == 1 && table.get(dressHash).reg.equals(regN)) {
                table.get(dressHash).mark = -1;  // se resta ma
                table.get(dressHash).reg = null; // marca indicando que ah sido removido
                return true;
            } else {
                dressHash = (dressHash + 1) % m; // caso contrario 
            }
        } while (dressHash != posInit);
        return false;
    }

    public String toString(){
        String s = "D.Real\tD.Hash\tRegister\n";
        int i =0;
        for(Element item : table){
            s += (i++) + " -->\t";
            if(item.mark==1)
                s+= functionHash(item.reg.getKey())+ "\t"+item.reg+"\n";
            else
                s+= "Empty\n";     
        }
        return s;
    }   
}
