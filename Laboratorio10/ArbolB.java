package B_Tree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vical
 */
public class ArbolB {
    NodoArbolB root;
    int t;

    //Constructor
    public ArbolB(int t) {
        this.t = t;
        root = new NodoArbolB(t);
    }

    
    //Busca el valor ingresado y muestra el contenido del nodo que contiene el valor
    public void buscarNodoPorClave(int num) {
        NodoArbolB temp = search(root, num);

        if (temp == null) {
            System.out.println("No se ha encontrado un nodo con el valor ingresado");
        } else {
            print(temp);
        }
    }

    //Search
    private NodoArbolB search(NodoArbolB actual, int key) {
        int i = 0;//se empieza a buscar siempre en la primera posicion

        //Incrementa el indice mientras el valor de la clave del nodo sea menor
        while (i < actual.n && key > actual.key[i]) {
            i++;
        }

        //Si la clave es igual, entonces retornamos el nodo
        if (i < actual.n && key == actual.key[i]) {
            return actual;
        }

        //Si llegamos hasta aqui, entonces hay que buscar los hijos
        //Se revisa primero si tiene hijos
        if (actual.leaf) {
            return null;
        } else {
            //Si tiene hijos, hace una llamada recursiva
            return search(actual.child[i], key);
        }
    }

    public void insertar(int key) {
        NodoArbolB r = root;

        //Si el nodo esta lleno lo debe separar antes de insertar
        if (r.n == ((2 * t) - 1)) {
            NodoArbolB s = new NodoArbolB(t);
            root = s;
            s.leaf = false;
            s.n = 0;
            s.child[0] = r;
            split(s, 0, r);
            nonFullInsert(s, key);
        } else {
            nonFullInsert(r, key);
        }
    }
 // Caso cuando la raiz se divide
    // x =          | | | | | |
    //             /
    //      |10|20|30|40|50|
    // i = 0
    // y = |10|20|30|40|50|
    private void split(NodoArbolB x, int i, NodoArbolB y) {
        //Nodo temporal que sera el hijo i + 1 de x
        NodoArbolB z = new NodoArbolB(t);
        z.leaf = y.leaf;
        z.n = (t - 1);

        //Copia las ultimas (t - 1) claves del nodo y al inicio del nodo z      // z = |40|50| | | |
        for (int j = 0; j < (t - 1); j++) {
            z.key[j] = y.key[(j + t)];
        }

        //Si no es hoja hay que reasignar los nodos hijos
        if (!y.leaf) {
            for (int k = 0; k < t; k++) {
                z.child[k] = y.child[(k + t)];
            }
        }

        //nuevo tamanio de y                                                    // x =            | | | | | |
        y.n = (t - 1);                                                          //               /   \
                                                                                //  |10|20| | | |
        //Mueve los hijos de x para darle espacio a z
        for (int j = x.n; j > i; j--) {
            x.child[(j + 1)] = x.child[j];
        }
        //Reasigna el hijo (i+1) de x                                           // x =            | | | | | |
        x.child[(i + 1)] = z;                                                   //               /   \
                                                                                //  |10|20| | | |     |40|50| | | |
        //Mueve las claves de x
        for (int j = x.n; j > i; j--) {
            x.key[(j + 1)] = x.key[j];
        }

        //Agrega la clave situada en la mediana                                 // x =            |30| | | | |
        x.key[i] = y.key[(t - 1)];                                              //               /    \
        x.n++;                                                                  //  |10|20| | | |      |40|50| | | |
    }
    private void nonFullInsert(NodoArbolB x, int key) {
        //Si es una hoja
        if (x.leaf) {
            int i = x.n; //cantidad de valores del nodo
            //busca la posicion i donde asignar el valor
            while (i >= 1 && key < x.key[i - 1]) {
                x.key[i] = x.key[i - 1];//Desplaza los valores mayores a key
                i--;
            }

            x.key[i] = key;//asigna el valor al nodo
            x.n++; //aumenta la cantidad de elementos del nodo
        } else {
            int j = 0;
            //Busca la posicion del hijo
            while (j < x.n && key > x.key[j]) {
                j++;
            }

            //Si el nodo hijo esta lleno lo separa
            if (x.child[j].n == (2 * t - 1)) {
                split(x, j, x.child[j]);

                if (key > x.key[j]) {
                    j++;
                }
            }

            nonFullInsert(x.child[j], key);
        }
    }

    public void showBTree() {
        print(root);
    }

    //Print en preorder
    private void print(NodoArbolB n) {
        n.imprimir();

        //Si no es hoja
        if (!n.leaf) {
            //recorre los nodos para saber si tiene hijos
            for (int j = 0; j <= n.n; j++) {
                if (n.child[j] != null) {
                    System.out.println();
                    print(n.child[j]);
                }
            }
        }
    }
    public void eliminar(int key) {
        eliminar(root, key);

        // Si la raíz quedó vacía después de la eliminación, se actualiza la raíz
        if (root.n == 0) {
            if (root.leaf) {
                root = null;
            } else {
                root = root.child[0];
            }
        }
    }

    private void eliminar(NodoArbolB nodo, int key) {
        int indice = buscarIndice(nodo, key);

        // Si la clave está presente en el nodo actual
        if (indice < nodo.n && nodo.key[indice] == key) {
            if (nodo.leaf) {
                eliminarDeHoja(nodo, indice);
            } else {
                eliminarDeNoHoja(nodo, indice);
            }
        } else {
            if (nodo.leaf) {
                System.out.println("La clave " + key + " no existe en el árbol.");
                return;
            }

            boolean esUltimoHijo = (indice == nodo.n);

            // Si el hijo donde se supone que debe estar la clave tiene menos claves mínimas,
            // se rellena el hijo antes de continuar la eliminación
            if (nodo.child[indice].n < t) {
                rellenar(nodo, indice);
            }

            // Si el último hijo fue fusionado, se debe eliminar la clave del hijo anterior
            if (esUltimoHijo && indice > nodo.n) {
                eliminar(nodo.child[indice - 1], key);
            } else {
                eliminar(nodo.child[indice], key);
            }
        }
    }

    private int buscarIndice(NodoArbolB nodo, int key) {
        int indice = 0;
        while (indice < nodo.n && key > nodo.key[indice]) {
            indice++;
        }
        return indice;
    }

    private void eliminarDeHoja(NodoArbolB nodo, int indice) {
        for (int i = indice + 1; i < nodo.n; i++) {
            nodo.key[i - 1] = nodo.key[i];
        }
        nodo.n--;
    }

    private void eliminarDeNoHoja(NodoArbolB nodo, int indice) {
        int clave = nodo.key[indice];

        // Si el hijo izquierdo tiene al menos t claves, se encuentra el predecesor
        // más grande (mayor clave menor a la clave a eliminar) en ese subárbol
        if (nodo.child[indice].n >= t) {
            int predecesor = obtenerPredecesor(nodo.child[indice]);
            nodo.key[indice] = predecesor;
            eliminar(nodo.child[indice], predecesor);
        }
        // Si el hijo derecho tiene al menos t claves, se encuentra el sucesor
        // más pequeño (menor clave mayor a la clave a eliminar) en ese subárbol
        else if (nodo.child[indice + 1].n >= t) {
            int sucesor = obtenerSucesor(nodo.child[indice + 1]);
            nodo.key[indice] = sucesor;
            eliminar(nodo.child[indice + 1], sucesor);
        }
        // Si ambos hijos tienen menos de t claves, se fusionan en un solo hijo
        else {
            fusionar(nodo, indice);
            eliminar(nodo.child[indice], clave);
        }
    }
        private int obtenerPredecesor(NodoArbolB nodo) {
            // Recorre el subárbol más a la derecha para encontrar el predecesor
            NodoArbolB actual = nodo;
            while (!actual.leaf) {
                actual = actual.child[actual.n];
            }
            return actual.key[actual.n - 1];
        }
        private int obtenerSucesor(NodoArbolB nodo) {
            // Recorre el subárbol más a la izquierda para encontrar el sucesor
            NodoArbolB actual = nodo;
            while (!actual.leaf) {
                actual = actual.child[0];
            }
            return actual.key[0];
        }
        private void fusionar(NodoArbolB padre, int indiceHijoIzquierdo, NodoArbolB hijoIzquierdo, NodoArbolB hijoDerecho) {
            // Mueve la clave del padre al hijo izquierdo
            hijoIzquierdo.key[t - 1] = padre.key[indiceHijoIzquierdo];

            // Copia las claves del hijo derecho al hijo izquierdo
            for (int i = 0; i < hijoDerecho.n; i++) {
                hijoIzquierdo.key[i + t] = hijoDerecho.key[i];
            }

            // Si no son nodos hoja, también se copian los hijos
            if (!hijoDerecho.leaf) {
                for (int i = 0; i <= hijoDerecho.n; i++) {
                    hijoIzquierdo.child[i + t] = hijoDerecho.child[i];
                }
            }

            // Mueve las claves y los hijos restantes en el padre
            for (int i = indiceHijoIzquierdo + 1; i < padre.n; i++) {
                padre.key[i - 1] = padre.key[i];
            }
            for (int i = indiceHijoIzquierdo + 2; i <= padre.n; i++) {
                padre.child[i - 1] = padre.child[i];
            }

            // Actualiza el número de claves en el hijo izquierdo
            hijoIzquierdo.n += hijoDerecho.n + 1;
            padre.n--;

            // Libera la memoria ocupada por el hijo derecho
            hijoDerecho = null;
        }
        private void fusionar(NodoArbolB nodo, int indice) {
            // Obtener el nodo hijo izquierdo y el nodo hijo derecho
            NodoArbolB hijoIzquierdo = nodo.child[indice];
            NodoArbolB hijoDerecho = nodo.child[indice + 1];

            // Mover la clave del nodo al hijo izquierdo
            hijoIzquierdo.key[t - 1] = nodo.key[indice];

            // Copiar las claves del hijo derecho al hijo izquierdo
            for (int i = 0; i < hijoDerecho.n; i++) {
                hijoIzquierdo.key[i + t] = hijoDerecho.key[i];
            }

            // Si no son nodos hoja, también copiar los hijos
            if (!hijoDerecho.leaf) {
                for (int i = 0; i <= hijoDerecho.n; i++) {
                    hijoIzquierdo.child[i + t] = hijoDerecho.child[i];
                }
            }

            // Mover las claves y los hijos restantes en el nodo
            for (int i = indice + 1; i < nodo.n; i++) {
                nodo.key[i - 1] = nodo.key[i];
            }
            for (int i = indice + 2; i <= nodo.n; i++) {
                nodo.child[i - 1] = nodo.child[i];
            }

            // Actualizar el número de claves en el hijo izquierdo
            hijoIzquierdo.n += hijoDerecho.n + 1;
            nodo.n--;

            // Liberar la memoria ocupada por el hijo derecho
            hijoDerecho = null;
        }
        private void rellenar(NodoArbolB nodo, int indice) {
            // Verificar si el nodo hijo izquierdo tiene claves suficientes para prestar
            if (indice != 0 && nodo.child[indice - 1].n >= t) {
                prestarDelAnterior(nodo, indice);
            }
            // Verificar si el nodo hijo derecho tiene claves suficientes para prestar
            else if (indice != nodo.n && nodo.child[indice + 1].n >= t) {
                prestarDelSiguiente(nodo, indice);
            }
            // Ambos hijos no tienen suficientes claves, fusionar el nodo hijo con uno de sus hermanos
            else {
                if (indice != nodo.n) {
                    fusionar(nodo, indice);
                } else {
                    fusionar(nodo, indice - 1);
                }
            }
        }
        private void prestarDelAnterior(NodoArbolB nodo, int indice) {
            // Nodo hijo actual y nodo hermano izquierdo
            NodoArbolB hijoActual = nodo.child[indice];
            NodoArbolB hermanoIzquierdo = nodo.child[indice - 1];

            // Mover la clave del nodo padre al nodo hijo actual
            hijoActual.key[0] = nodo.key[indice - 1];

            // Mover la clave del hermano izquierdo al nodo padre
            nodo.key[indice - 1] = hermanoIzquierdo.key[hermanoIzquierdo.n - 1];

            // Mover los hijos del hermano izquierdo al nodo hijo actual
            if (!hijoActual.leaf) {
                for (int i = hijoActual.n; i >= 0; i--) {
                    hijoActual.child[i + 1] = hijoActual.child[i];
                }
                hijoActual.child[0] = hermanoIzquierdo.child[hermanoIzquierdo.n];
            }

            // Ajustar el número de claves en el nodo hijo actual y el hermano izquierdo
            hijoActual.n++;
            hermanoIzquierdo.n--;
        }
        private void prestarDelSiguiente(NodoArbolB nodo, int indice) {
            // Nodo hijo actual y nodo hermano derecho
            NodoArbolB hijoActual = nodo.child[indice];
            NodoArbolB hermanoDerecho = nodo.child[indice + 1];

            // Mover la clave del nodo padre al nodo hijo actual
            hijoActual.key[hijoActual.n] = nodo.key[indice];

            // Mover la clave del hermano derecho al nodo padre
            nodo.key[indice] = hermanoDerecho.key[0];

            // Mover los hijos del hermano derecho al nodo hijo actual
            if (!hijoActual.leaf) {
                hijoActual.child[hijoActual.n + 1] = hermanoDerecho.child[0];
            }

            // Mover las claves restantes del hermano derecho hacia la izquierda
            for (int i = 1; i < hermanoDerecho.n; i++) {
                hermanoDerecho.key[i - 1] = hermanoDerecho.key[i];
            }

            // Mover los hijos restantes del hermano derecho hacia la izquierda
            if (!hermanoDerecho.leaf) {
                for (int i = 1; i <= hermanoDerecho.n; i++) {
                    hermanoDerecho.child[i - 1] = hermanoDerecho.child[i];
                }
            }

            // Ajustar el número de claves en el nodo hijo actual y el hermano derecho
            hijoActual.n++;
            hermanoDerecho.n--;
        }
        public ArrayList<Integer> obtenerCaminoRecorrido(int key) {
        	ArrayList<Integer> camino = new ArrayList<>();
            obtenerCaminoRecorrido(root, key, camino);
            return camino;
        }

        private boolean obtenerCaminoRecorrido(NodoArbolB nodo, int key, ArrayList<Integer> camino) {
            int i = 0;
            while (i < nodo.n && key > nodo.key[i]) {
                i++;
            }

            if (i < nodo.n && key == nodo.key[i]) {
                camino.add(nodo.key[i]);
                return true;
            }

            if (nodo.leaf) {
                return false;
            } else {
                boolean encontrado = obtenerCaminoRecorrido(nodo.child[i], key, camino);
                if (encontrado) {
                    camino.add(nodo.key[i]);
                    return true;
                } else {
                    return false;
                }
            }
        }
        
        public int ObtenerValorMaximo() {
        	if (root == null) {
        		System.out.println("El árbol está vacío");
        	}
        	NodoArbolB nodoActual = root;
        	while (!nodoActual.leaf) {
        		nodoActual = nodoActual.child[nodoActual.n];
        	}
        	return nodoActual.key[nodoActual.n - 1];
       }
       
        public void ObtenerNodoMinimoRaiz() {
            if (root == null) {
                System.out.println("El árbol está vacío");
            }
            NodoArbolB nodoActual = root;
            while (!nodoActual.esHoja()) {
                nodoActual = nodoActual.child[0];
            }
            print(nodoActual);
        }        
}


