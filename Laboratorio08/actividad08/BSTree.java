package actividad08;
import java.util.Stack;

public class BSTree<E extends Comparable<E>> {
	
	private Node<EntryData<E>> root;

	public BSTree() {
		this.root = null;
	}
	
	public void insert(EntryData<E> x) throws ItemDuplicated {
		this.root = insertRec(x, this.root);
		
	}
	protected Node<EntryData<E>> insertRec(EntryData<E> x, Node<EntryData<E>> actual) throws ItemDuplicated {
		Node<EntryData<E>> res = actual;
		if (actual == null) {
			res = new Node<EntryData<E>>(x);
		} else { // buscamos el lugar para inserción
			int resC = actual.getData().compareTo(x);
			if (resC == 0)
				throw new ItemDuplicated(x + "esta duplcado");
			if (resC < 0)
				res.right = insertRec(x, actual.right);
			else
				res.left = insertRec(x, actual.left);
		}
		return res;
	}

	
	public E search(EntryData<E> x)  {
		Node<EntryData<E>> res = searchRec(x, this.root);
		if (res == null) {
			System.out.println("El dato " + x + "no esta");
			return null;
		}
		return res.data.getData();
	}

	protected Node<EntryData<E>> searchRec(EntryData<E> x, Node<EntryData<E>> n) {
		if (n == null)
			return null;
		else {
			int resC = n.data.compareTo(x);
			if (resC < 0)
				return searchRec(x, n.right);
			else if (resC > 0)
				return searchRec(x, n.left);
			else
				return n;
		}
	}
	
	public void remove(EntryData<E> x) throws ItemNoFound {
	    this.root = removeRec(x, this.root);
	}

	protected Node<EntryData<E>> removeRec(EntryData<E> x, Node<EntryData<E>> actual) throws ItemNoFound {
	    if (actual == null) {
	        throw new ItemNoFound("El dato " + x + " no se encontró");
	    }

	    int resC = actual.data.compareTo(x);
	    if (resC < 0) {
	        actual.right = removeRec(x, actual.right);
	    } else if (resC > 0) {
	        actual.left = removeRec(x, actual.left);
	    } else {
	        // Caso 1: El nodo es una hoja
	        if (actual.left == null && actual.right == null) {
	            actual = null;
	        }
	        // Caso 2: El nodo tiene un hijo
	        else if (actual.left == null) {
	            actual = actual.right;
	        } else if (actual.right == null) {
	            actual = actual.left;
	        }
	        // Caso 3: El nodo tiene dos hijos
	        else {
	            Node<EntryData<E>> minNode = findMin(actual.right);
	            actual.data = minNode.data;
	            actual.right = removeRec(minNode.data, actual.right);
	        }
	    }

	    return actual;
	}

	protected Node<EntryData<E>> findMin(Node<EntryData<E>> actual) {
	    while (actual.left != null) {
	        actual = actual.left;
	    }
	    return actual;
	}
	
	public String postOrden() {
		if (this.root != null)
			return postOrden(this.root);
		else
			return "*";
	}

	protected String postOrden(Node<EntryData<E>> actual){
		String res = "";
		if (actual.left != null) res += postOrden(actual.left);
		if (actual.right != null) res += postOrden(actual.right);
		return res + actual.data.toString() + ", ";
	}
	
	public String preOrden() {
	    if (this.root != null)
	        return preOrden(this.root);
	    else
	        return "*";
	}

	protected String preOrden(Node<EntryData<E>> actual) {
	    String res = actual.data.toString() + ", ";
	    if (actual.left != null)
	        res += preOrden(actual.left);
	    if (actual.right != null)
	        res += preOrden(actual.right);
	    return res;
	}
	
	public String inOrden() {
	    if (this.root != null)
	        return inOrden(this.root);
	    else
	        return "*";
	}

	protected String inOrden(Node<EntryData<E>> actual) {
	    String res = "";
	    if (actual.left != null)
	        res += inOrden(actual.left);
	    res += actual.data.toString() + ", ";
	    if (actual.right != null)
	        res += inOrden(actual.right);
	    return res;
	}

	public String toString() {
		return "INORDEN "+inOrden() +"\n" + "PREORDEN "+preOrden()+"\n"+"POSTORDEN "+postOrden();
	}

	public int countNonLeafNodes() {
	    return countNonLeafNodes(this.root);
	}

	protected int countNonLeafNodes(Node<EntryData<E>> actual) {
	    if (actual == null || (actual.left == null && actual.right == null)) {
	        return 0;
	    } else {
	        return 1 + countNonLeafNodes(actual.left) + countNonLeafNodes(actual.right);
	    }
	}

	public Node<EntryData<E>> getRoot() {
		return root;
	}

	public void setRoot(Node<EntryData<E>> root) {
		this.root = root;
	}

	protected Node<EntryData<E>> searchNode(EntryData<E> x, Node<EntryData<E>> actual) {
	    if (actual == null) {
	        return null;
	    } else {
	        int resC = actual.data.compareTo(x);
	        if (resC < 0) {
	            return searchNode(x, actual.right);
	        } else if (resC > 0) {
	            return searchNode(x, actual.left);
	        } else {
	            return actual;
	        }
	    }
	}
	
	public int getNodeHeight(EntryData<E> x) {
	    Node<EntryData<E>> node = searchNode(x, this.root);
	    if (node == null) {
	        return -1; // Indica que el nodo no existe en el árbol
	    }
	    return getNodeHeight(node);
	}

	protected int getNodeHeight(Node<EntryData<E>> node) {
	    return calculateNodeHeight(node) - 1;
	}

	protected int calculateNodeHeight(Node<EntryData<E>> actual) {
	    if (actual == null) {
	        return 0;
	    } else {
	        int leftHeight = calculateNodeHeight(actual.left);
	        int rightHeight = calculateNodeHeight(actual.right);
	        return 1 + Math.max(leftHeight, rightHeight);
	    }
	}
	
	public void preOrderIterative() {
	    if (this.root == null) {
	        return;
	    }

	    Stack<Node<EntryData<E>>> stack = new Stack<>();
	    stack.push(this.root);

	    while (!stack.isEmpty()) {
	        Node<EntryData<E>> current = stack.pop();
	        System.out.print(current.data.toString() + ", ");

	        if (current.right != null) {
	            stack.push(current.right);
	        }
	        if (current.left != null) {
	            stack.push(current.left);
	        }
	    }
	}
	
	public int calculateArea() {
	    int leafCount = countLeaves(this.root);
	    int height = calculateTreeHeight(this.root);
	    return leafCount * height;
	}

	protected int countLeaves(Node<EntryData<E>> actual) {
	    if (actual == null) {
	        return 0;
	    } else if (actual.left == null && actual.right == null) {
	        return 1;
	    } else {
	        return countLeaves(actual.left) + countLeaves(actual.right);
	    }
	}

	protected int calculateTreeHeight(Node<EntryData<E>> actual) {
	    if (actual == null) {
	        return 0;
	    } else {
	        int leftHeight = calculateTreeHeight(actual.left);
	        int rightHeight = calculateTreeHeight(actual.right);
	        return 1 + Math.max(leftHeight, rightHeight);
	    }
	}
	
	public Node<EntryData<E>> getMinimumNode() {
	    if (this.root == null) {
	        return null; // El árbol está vacío
	    }

	    Node<EntryData<E>> current = this.root;
	    while (current.left != null) {
	        current = current.left;
	    }

	    return current;
	}
	
	public Node<EntryData<E>> getMaximumNode() {
	    if (this.root == null) {
	        return null; // El árbol está vacío
	    }

	    Node<EntryData<E>> current = this.root;
	    while (current.right != null) {
	        current = current.right;
	    }

	    return current;
	}
	
	public void parenthesize() {
	    if (this.root != null) {
	        parenthesize(this.root, 0);
	    }
	}

	protected void parenthesize(Node<EntryData<E>> node, int level) {
	    if (node != null) {
	        for (int i = 0; i < level; i++) {
	            System.out.print(" ");
	        }
	        
	        System.out.println(node.data.toString()+"(");

	        parenthesize(node.left, level + 1);
	        parenthesize(node.right, level + 1);

	    }
	}
	
}
