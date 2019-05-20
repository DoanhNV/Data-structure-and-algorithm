package datastructure.tree.redblacktree;

/**
 * 
 * @author DoanhNV May 19, 2019 - 11:08:27 PM
 *
 */
public class RedBlackTree<T extends Comparable<T>> {

	private Node<T> root;
	
	public void insert(T data) {
		Node<T> newNode = new Node<T>(data);
		
		if(root == null) {
			newNode.isBlack = true;
			root = newNode;
		} else {
			Node<T> parrentOfGrandParrent = null;
			Node<T> grandParent = null;
			Node<T> parent = null;
			Node<T> current = root;
			boolean isLeftParrentOfGrandParrent = false;
			boolean isLeftParrent = false;
			boolean isLeft = false;
			boolean isLeaf = false;
			
			while (current != null && !isLeaf) {
				parrentOfGrandParrent = grandParent;
				grandParent = parent;
				parent = current;
				isLeftParrentOfGrandParrent = isLeftParrent;
				isLeftParrent = isLeft;
				
				if (parent.isBlack 
						&& parent.leftChild != null && !parent.leftChild.isBlack
							&& parent.rightChild != null && !parent.rightChild.isBlack) {
					flipColor(parent, parent.leftChild, parent.rightChild);
				}
				
				int compareResult = current.data.compareTo(newNode.data);
				if (compareResult < 0 ) {
					current = current.leftChild;
					isLeft = true;
				} else {
					current = current.rightChild;
					isLeft = false;
				}
				
				if (current == null) {
					isLeaf = true;
					if (isLeft) {
						parent.leftChild = newNode;
					} else {
						parent.rightChild = newNode;
					}
				}
				
				boolean isDuplicateRedNode = grandParent != null && !grandParent.isBlack && !parent.isBlack;
				if (isDuplicateRedNode) {
					if (isLeftParrent) {
						if (isLeft) {
							rotateRight(root, grandParent, parent, isLeftParrent);
						} else {
							rotateLeft(parrentOfGrandParrent, grandParent, parent, isLeftParrent);
							rotateRight(root, grandParent, parent, isLeftParrent);
						}
					} else {
						if (!isLeft) {
							rotateLeft(root, grandParent, parent, isLeftParrent);
						} else {
							rotateRight(parrentOfGrandParrent, grandParent, parent, isLeftParrent);
							rotateLeft(root, grandParent, parent, isLeftParrent);
						}
					}
				}
			}
			
			if (!parent.isBlack) {
				parrentOfGrandParrent = parrentOfGrandParrent == null ? root : parrentOfGrandParrent;
				if (isLeftParrentOfGrandParrent) {
					if (isLeftParrent) {
						rotateRight(parrentOfGrandParrent, grandParent, parent, isLeftParrentOfGrandParrent);
					} else {
						rotateLeft(grandParent, parent, newNode, isLeftParrentOfGrandParrent);
						rotateRight(parrentOfGrandParrent, grandParent, newNode, isLeftParrentOfGrandParrent);
					}
				} else {
					if (!isLeftParrent) {
						rotateLeft(parrentOfGrandParrent, grandParent, parent, isLeftParrentOfGrandParrent);
					} else {
						rotateRight(grandParent, parent, newNode, isLeftParrentOfGrandParrent);
						rotateLeft(parrentOfGrandParrent, grandParent, newNode, isLeftParrentOfGrandParrent);
					}
				}
			} 
		}
	}
	
	private void flipColor(Node<T> parrent, Node<T> leftChild, Node<T> rightChild) {
		if (parrent != root) {
			parrent.isBlack = false;
		}
		parrent.leftChild.isBlack = true;
		parrent.rightChild.isBlack = true;
	}
	
	private void rotateRight(Node<T> grandParrent, Node<T> parrent, Node<T> child, boolean isLeftParrent) {
		parrent.leftChild = child.rightChild;
		child.rightChild = parrent;
		boolean parrentColor = parrent.isBlack;
		parrent.isBlack = child.isBlack;
		child.isBlack = parrentColor;
		
		if (grandParrent == root) {
			root = child;
			root.isBlack = true;
			return;
		}
		if (isLeftParrent) {
			grandParrent.leftChild = child;
		} else {
			grandParrent.rightChild = child;
		}
	}
	
	private void rotateLeft(Node<T> grandParrent, Node<T> parrent, Node<T> child, boolean isLeftParrent) {
		parrent.rightChild = child.leftChild;
		child.leftChild = parrent;
		boolean parrentColor = parrent.isBlack;
		parrent.isBlack = child.isBlack;
		child.isBlack = parrentColor;
		
		if (grandParrent == root) {
			root = child;
			root.isBlack = true;
			return;
		}
		if (isLeftParrent) {
			grandParrent.leftChild = child;
		} else {
			grandParrent.rightChild = child;
		}
	}
}
