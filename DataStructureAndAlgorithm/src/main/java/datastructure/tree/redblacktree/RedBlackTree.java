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
			Node<T> grandParent = root;
			Node<T> parent = root;
			Node<T> current = root;
			boolean isLeft = false;
			
			while (current != null) {
				grandParent = parent;
				parent = current;
				
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
			}
			
			if (isLeft) {
				parent.leftChild = newNode;
			} else {
				parent.rightChild = newNode;
			}
		}
	}
	
	private void flipColor(Node<T> parrent, Node<T> leftChild, Node<T> rightChild) {
		parrent.isBlack = false;
		parrent.leftChild.isBlack = true;
		parrent.rightChild.isBlack = true;
	}
}
