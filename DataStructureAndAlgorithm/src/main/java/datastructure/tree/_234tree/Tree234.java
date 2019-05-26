package datastructure.tree._234tree;

/**
 * 
 * @author DoanhNV May 26, 2019 - 3:03:12 PM
 *
 */
public class Tree234<T extends Comparable<T>>  implements AbstractTree<T> {
	
	protected Node<T> root;
	
	@Override
	public void insert(T item) {
		Node<T> newNode = new Node<>(item);

		if (root == null) {
			root = newNode; 
		} else {
			Node<T> current = root;
			int indexAtParent = 0 ;
			
			while (true) {
				if (current.isFull()) {
					splitNode(current, indexAtParent);
				} else if (current.isLeaf()) {
					break;
				} 
				indexAtParent = getNextChild(current, item);
			}
			current.insertAtLeaf(item);
		}
	}
	
	private void splitNode(Node<T> node, int indexAtParent) {
		int rightIndex = 2;
		T rightItem = (T) node.popItem(rightIndex);
		Node<T> newRightNode = new Node<>(rightItem);
		newRightNode.connectChild(0, node.disConnectChild(2));
		newRightNode.connectChild(1, node.disConnectChild(3));
		
		if (node == root) {
			T centerItem = (T) node.popItem(1);
			root = new Node<>(centerItem);
			root.connectChild(0, node);
			root.connectChild(1, newRightNode);
		} else {
			insertItemForParent(node, indexAtParent);
			node.parrent.connectChild(indexAtParent + 1, newRightNode);
		}
		node = node.parrent;
	}
	
	private void insertItemForParent(Node<T> node, int indexAtParent) {
		int centerIndex = 1;
		Node<T> parrent = node.parrent;
		for (int i = parrent.dataNumber; i > indexAtParent; i--) {
			parrent.childs[i + 1] = parrent.disConnectChild(i);
			parrent.dataItems[i] = parrent.popItem(i - 1);
		}
		parrent.dataItems[indexAtParent] = node.popItem(centerIndex); // insert center child item to parent
		parrent.dataNumber++;
	}
	
	@SuppressWarnings("unchecked")
	private int getNextChild(Node<T> current, T newItem) {
		int maxItem = 3;
		for (int i = 0; i < current.dataItems.length; i++) {
			if (current.dataItems[i] == null) {
				break;
			}
			
			T arrItem = (T) current.dataItems[i];
			int compareResult = newItem.compareTo(arrItem);
			if (compareResult == -1) {
				current =  current.getChild(i);
				return i;
			}
		}
		
		current =  current.getChild(maxItem);
		return maxItem;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean exist(T item) {
		Node<T> current = root;
		while (current != null) {
			for (int i = 0; i < current.dataNumber; i++) {
				int compareResult = item.compareTo((T) current.dataItems[i]);
				if (compareResult == 0) {
					return true;
				} else if (compareResult == -1) {
					current = current.getChild(i);
				} else if (i == current.dataNumber - 1) {
					current = current.getChild(i + 1);
				}
			}
		}
		return false;
	}

	@Override
	public void displayTree() {
		
	}
}
