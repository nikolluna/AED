package actividad02;

import java.util.ArrayList;

public class HashC<E extends Comparable<E>> {

    protected class Element {
        int mark;
        Register<E> reg;

        public Element(int mark, Register<E> reg) {
            this.mark = mark;
            this.reg = reg;
        }
    }

    protected ArrayList<Element> table;
    protected int m;

    public HashC(int n) {
        this.m = getClosestPrime(n); // calcular el primo cercano a n y asignarlo a m

        this.table = new ArrayList<Element>(m);
        for (int i = 0; i < m; i++)
            this.table.add(new Element(0, null));
    }

    private int getClosestPrime(int n) {
        while (!isPrime(n)) {
            n++;
        }
        return n;
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int functionHash(int key) {
        return key % m;
    }

    private int linearProbing(int dressHash, int key) {
        int i = 1;
        int hash = (dressHash + i) % m;
        while (table.get(hash).mark == 1 && table.get(hash).reg.key != key) {
            i++;
            hash = (dressHash + i) % m;
        }
        return hash;
    }

    public void insert(int key, E reg) {
        int hash = functionHash(key);
        if (table.get(hash).mark != 1) {
            table.set(hash, new Element(1, new Register<>(key, reg)));
        } else {
            int dressHash = hash;
            hash = linearProbing(dressHash, key);
            table.set(hash, new Element(1, new Register<>(key, reg)));
        }
    }

    private int quadraticProbing(int dressHash, int key) {
        int i = 1;
        int hash = (dressHash + i * i) % m;
        while (table.get(hash).mark == 1 && table.get(hash).reg.key != key) {
            i++;
            hash = (dressHash + i * i) % m;
        }
        return hash;
    }
    
    public void insertQuadraticProbing(int key, E reg) {
        int hash = functionHash(key);
        if (table.get(hash).mark != 1) {
            table.set(hash, new Element(1, new Register<>(key, reg)));
        } else {
            int dressHash = hash;
            hash = quadraticProbing(dressHash, key);
            table.set(hash, new Element(1, new Register<>(key, reg)));
        }
    }
    
    private int foldingHash(int dressHash, int key) {
        String keyStr = String.valueOf(key);
        int hash = dressHash;
        int segmentSize = Math.max(1, keyStr.length() / 3);

        for (int i = 0; i < keyStr.length(); i += segmentSize) {
            String segment = keyStr.substring(i, Math.min(i + segmentSize, keyStr.length()));
            int segmentValue = Integer.parseInt(segment);
            hash = (hash + segmentValue) % m;
        }

        return hash;
    }
    public void insertFoldingHash(int key, E reg) {
        int hash = functionHash(key);
        if (table.get(hash).mark != 1) {
            table.set(hash, new Element(1, new Register<>(key, reg)));
        } else {
            int dressHash = hash;
            hash = foldingHash(dressHash, key);
            table.set(hash, new Element(1, new Register<>(key, reg)));
        }
    }

    public E search(int key) {
        int hash = functionHash(key);
        int dressHash = hash;
        int i = 1;
        while (table.get(hash).mark == 1 && table.get(hash).reg.key != key) {
            hash = (dressHash + i) % m;
            i++;
            if (hash == dressHash) {
                break;
            }
        }
        if (table.get(hash).mark == 1 && table.get(hash).reg.key == key) {
            return table.get(hash).reg.value;
        } else {
            return null;
        }
    }

    public String toString() {
        String s = "D.Real\tD.Hash\tRegister\n";
        int i = 0;
        for (Element item : table) {
            s += (i++) + " -->\t";
            if (item.mark == 1)
                s += functionHash(item.reg.key) + "\t" + item.reg + "\n";
            else
                s += "empty\n";
        }
        return s;
    }
}



