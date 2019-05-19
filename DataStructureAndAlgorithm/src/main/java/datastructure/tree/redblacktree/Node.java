package datastructure.tree.redblacktree;

/**
 * 
 * @author DoanhNV May 19, 2019 - 11:06:15 PM
 *
 */
public class Node<T> {

	protected T data;
	protected boolean isBlack;
	protected boolean isDeleted;
	protected Node<T> leftChild;
	protected Node<T> rightChild;
	
	protected Node() {}
	
	protected Node(T data) {
		this.data = data;
	}

	protected Node(T data, boolean isBlack, Node<T> leftChild, Node<T> rightChild) {
		this.data = data;
		this.isBlack = isBlack;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
}
