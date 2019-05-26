package datastructure.tree._234tree;

/**
 * 
 * @author DoanhNV May 26, 2019 - 2:57:00 PM
 *
 */
public class Node<T extends Comparable<T>> {

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
		childNumber++;
	}
	
	protected Node<T> disConnectChild(int index) {
		Node<T> child = childs[index]; 
		childs[index] = null;
		childNumber--;
		return child;
	}
	
	@SuppressWarnings("unchecked")
	protected T popItem(int index) {
		Object item = dataItems[index];
		dataItems[index] = null;
		dataNumber--;
		return (T) item;
	}
	
	/**
	 * leaf not full
	 * 
	 * @author DoanhNV May 26, 2019 - 7:59:12 PM 
	 * @param newItem
	 *
	 */
	@SuppressWarnings("unchecked")
	protected void insertAtLeaf(T newItem) {
		int i;
		for (i = 2; i >= 0; i--) {
			if (dataItems[i] != null) {
				Object objectItem = dataItems[i];
				T dataItem = (T) objectItem;
				
				int compareResult = newItem.compareTo(dataItem);
				if (compareResult == -1) {
					dataItems[i + 1] = this.popItem(i);
				} else {
					i++;
					break;
				}
			}
		}
		dataItems[i] = newItem;
		dataNumber++;
	}
}
