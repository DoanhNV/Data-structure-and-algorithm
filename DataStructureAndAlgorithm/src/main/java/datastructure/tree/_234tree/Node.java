package datastructure.tree._234tree;

/**
 * 
 * @author DoanhNV May 26, 2019 - 2:57:00 PM
 *
 */
public class Node<T> {

	protected Object[] dataItems = new Object[3];
	@SuppressWarnings("unchecked")
	protected Node<T>[] childs = new Node[4];
	
	protected Node<T> parrent;
	protected int childNumber;
	protected int dataNumber;
	
	public Node() {}

	public Node(T data) {
		dataItems[0] = data;
		dataNumber++;
	}
	
	protected boolean isLeaf() {
		return childNumber == 0;
	}
	
	protected boolean isFull() {
		return dataItems[2] != null;
	}
	
	protected Node<T> getChild(int index) {
		return childs[index];
	}
	
	protected void connectChild(int index, Node<T> child) {
		childs[index] = child;
	}
	
	protected Node<T> disConnectChild(int index) {
		Node<T> child = childs[index]; 
		childs[index] = null;
		return child;
	}
	
	@SuppressWarnings("unchecked")
	protected T popItem(int index) {
		Object item = dataItems[index];
		dataItems[index] = null;
		return (T) item;
	}
	
	protected void insert(T item) {
		
	}
}
