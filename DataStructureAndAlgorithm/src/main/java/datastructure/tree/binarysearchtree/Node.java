package datastructure.tree.binarysearchtree;

/**
 * 
 * @author DoanhNV May 11, 2019 - 5:00:19 PM
 *
 */
public class Node<T extends Comparable<T>> {
	
	private T data;
	private Node<T> leftChild;
	private Node<T> rightChild;

	public Node() {}

	public Node(T data, Node<T> leftChild, Node<T> rightChild) {
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node<T> leftChild) {
		this.leftChild = leftChild;
	}

	public Node<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node<T> rightChild) {
		this.rightChild = rightChild;
	}
	
	public void displayNode() {
		System.out.print(data);
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", leftChild=" + leftChild + ", rightChild=" + rightChild + "]";
	}
}
