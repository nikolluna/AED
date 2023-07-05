package Ejercicios.Hash;

import java.util.ArrayList;

import javax.swing.text.html.parser.Element;
import Listas.Node;
import Listas.ListLikend;
public class HashA  <E extends Comparable <E>>{
    protected class Element{
        int mark;
        protected ListLikend <Register<E>> list;
        Register <E> reg;
        public Element(int mark, Register<E>  reg){
            this.list= new ListLikend<Register<E>> ();  
        }
        public String toString(){
            return this.list.toString();
        }
    }
    protected ArrayList<Element> table;
    protected int m;

    public HashA(int n){
        this.m= n;
        this.table= new ArrayList<Element>(n);
        for(int i=0; i < m; i++)
            this.table.add(new Element(0, null));
    }
    private int functionHash(int key){
        return key % m;
    }

    /////////////////////////////////////////////////////////// Ejercicio 1
    
    // Método del cuadrado
    private int quadraticHash(int key){
        int square = key * key;
        String squareStr = Integer.toString(square);
        
        if (squareStr.length() > 1) {
            int middle = squareStr.length() / 2;
            squareStr = squareStr.substring(middle - 1, middle + 2);
        }
        return Integer.parseInt(squareStr) % m;
    }
    // Método por pliegue aplicando suma
    private int foldSumHash(int key) {
        String keyStr = Integer.toString(key);
        int sum = 0;
                for (int i = 0; i < keyStr.length(); i += 2) {
            if (i + 2 <= keyStr.length())
                sum += Integer.parseInt(keyStr.substring(i, i + 2));
            else 
                sum += Integer.parseInt(keyStr.substring(i));
        }
        return sum % m;
    }
    /////////////////////////////////////////////////////////////////////

    public void insert(int key, E reg){
        int dressHash = functionHash(key);
        if(dressHash < 0)
            System.out.println("La tabla esta llena o la llave esta duplicada");
        else
            this.table.get(dressHash).list.insertFirst(new Register<E>(key, reg));
    }
    public E search(int key) {
        int dressHash = functionHash(key);
        ListLikend<Register<E>> list = table.get(dressHash).list;
        Node<Register<E>> currentNode = list.getFirst(); 
        // con respecto al nodo actual
        while (currentNode != null) {
            Register<E> currentRegister = currentNode.getData();
            if (currentRegister.getKey() == key) 
                return currentRegister.getValue();
            currentNode = currentNode.getNext();
        }
        return null;
    }

    public boolean remove(int key) {
        int dressHash = functionHash(key);
        ListLikend<Register<E>> list = table.get(dressHash).list;
        Register<E> regN = new Register<E>(key);
        if (list.search(regN) != -1) {
            list.removeNode(regN);
            return true;
        }
        return false;
    }
    
    public String toString(){
        String s = "D.Real\tD.Hash\tRegister\n";
        int i =0;
        for(Element item : table){
            s += (i++) + " -->\t";
            if(!item.list.isEmptyList())
                s+= (i-1) +"\t"+item.toString()+"\n";
            else
                s+= "Empty\n";     
        }
        return s;
    }    
}
