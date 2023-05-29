package laboratorio09;

public class AVLTree<E extends Comparable<E>> extends BSTree<E> {
	class NodeAVL extends Node {
		protected int bf;

        public NodeAVL(E data) {
            this(data, null, null);
        }

        public NodeAVL(E data, Node left, Node right) {
            super(data, left, right);
            this.bf = 0;
        }

        public String toString() {
            return super.toString() + " (" + bf + ")";
        }
	}
	private boolean height; // indicador de cambio de altura
	
	public void insert(E data) throws ItemDuplicated {
		this.height = false;
		setRoot(insertRec(data,(NodeAVL)getRoot()));
	}
	public NodeAVL insertRec(E x, NodeAVL node) throws ItemDuplicated {
		NodeAVL fat = node;
		if (node == null) {
			this.height = true;
			fat = new NodeAVL(x);
		}
		else {
			int resC = node.data.compareTo(x);
			if(resC == 0)throw new ItemDuplicated(x+" ya se encuentra en el arbol...");
			if(resC < 0) {
				fat.right = insertRec(x, (NodeAVL)node.right);
				if(this.height)
					switch(fat.bf) {
					case -1: 
						fat.bf = 0;
						this.height = false;
						break;
					case 0:
						fat.bf = 1;
						this.height = true;
						break;
					case 1: //bf = 2
						fat = balanceToLeft(fat);
						this.height = false;
						break;

				}
			}
			else {
			    fat.left = insertRec(x, (NodeAVL) node.left);
			    if (this.height) {
			        switch (fat.bf) {
			            case 1:
			                fat.bf = 0;
			                this.height = false;
			                break;
			            case 0:
			                fat.bf = -1;
			                this.height = true;
			                break;
			            case -1: // bf = -2
			                fat = balanceToRight(fat);
			                this.height = false;
			                break;
			        }
			    }
			}
		}
		return fat;
	}
	
	private NodeAVL balanceToLeft(NodeAVL node) {
		NodeAVL hijo = (NodeAVL) node.right;
		if(hijo == null) {
			return node;
		}
		switch (hijo.bf) {
		case 1:
			node.bf = 0;
			hijo.bf = 0;
			node = rotateSL(node);
			break;
		case -1:
			NodeAVL nieto = (NodeAVL) hijo.left;
			switch (nieto.bf) {
			case -1:
				node.bf = 0;
				hijo.bf = 1;
				break;
			case 0:
				node.bf = 0;
				hijo.bf = 0;
				break;
			case 1:
				node.bf = 1;
				hijo.bf = 0;
				break;
			}
			nieto.bf = 0;
			node.right = rotateSR(hijo);
			node = rotateSL(node);
		}
		return node;
	}
	
	private NodeAVL balanceToRight(NodeAVL node) {
	    NodeAVL hijo = (NodeAVL) node.left;
	    switch (hijo.bf) {
	        case -1:
	            node.bf = 0;
	            hijo.bf = 0;
	            node = rotateSR(node);
	            break;
	        case 1:
	            NodeAVL nieto = (NodeAVL) hijo.right;
	            switch (nieto.bf) {
	                case 1:
	                    node.bf = 0;
	                    hijo.bf = -1;
	                    break;
	                case 0:
	                    node.bf = 0;
	                    hijo.bf = 0;
	                    break;
	                case -1:
	                    node.bf = -1;
	                    hijo.bf = 0;
	                    break;
	            }
	            nieto.bf = 0;
	            node.left = rotateSL(hijo);
	            node = rotateSR(node);
	    }
	    return node;
	}
	
	private NodeAVL rotateSL(NodeAVL node){
		NodeAVL p = (NodeAVL)node.right;
		node.right = p.left;
		p.left = node;
		node = p;
		return node;
	}
	
	private NodeAVL rotateSR(NodeAVL node) {
	    NodeAVL p = (NodeAVL) node.left;
	    node.left = p.right;
	    p.right = node;
	    node = p;
	    return node;
	}
	
	public void remove(E x) throws ItemNoFound {
	    this.height = false;
	    setRoot(removeRec(x, (NodeAVL) getRoot()));
	}

	protected NodeAVL removeRec(E x, NodeAVL actual) throws ItemNoFound {
	    if (actual == null) {
	        throw new ItemNoFound("El dato " + x + " no se encontró");
	    }

	    int resC = actual.data.compareTo(x);
	    if (resC < 0) {
	        actual.right = removeRec(x, (NodeAVL) actual.right);
	        if (this.height) {
	            actual = balanceToLeft(actual);
	        }
	    } else if (resC > 0) {
	        actual.left = removeRec(x, (NodeAVL) actual.left);
	        if (this.height) {
	            actual = balanceToRight(actual);
	        }
	    } else {
	        // Caso 1 el nodo es hoja 
	        if (actual.left == null && actual.right == null) {
	            actual = null;
	            this.height = true;
	        }
	        // Caso 2 el nodo tiene un hijo
	        else if (actual.left == null) {
	            actual = (NodeAVL) actual.right;
	            this.height = true;
	        } else if (actual.right == null) {
	            actual = (NodeAVL) actual.left;
	            this.height = true;
	        }
	        // Caso 3 el nodo tiene dos hijos
	        else {
	            NodeAVL minNode =  (AVLTree<E>.NodeAVL) findMin((NodeAVL) actual.right);
	            actual.data = minNode.data;
	            actual.right = removeRec(minNode.data, (NodeAVL) actual.right);
	            if (this.height) {
	                actual = balanceToLeft(actual);
	            }
	        }
	    }
	    return actual;
	}

}

