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
			current.insert(item);
		}
	}
	
	private void splitNode(Node<T> node, int indexAtParent) {
		Node<T> newRightNode;
		
		if (node == root) {
			T centerItem = (T) node.popItem(1);
			root = new Node<>(centerItem);
			root.connectChild(0, node);
			
			T rightItem = (T) node.popItem(2);
			newRightNode = new Node<>(rightItem);
			newRightNode.connectChild(0, node.disConnectChild(2));
			newRightNode.connectChild(1, node.disConnectChild(3));
			root.connectChild(1, newRightNode);
		} else {
			shiftToRightAndRaiseItem(node, indexAtParent);
		}
		node = node.parrent;
	}
	
	private void shiftToRightAndRaiseItem(Node<T> node, int indexAtParent) {
		int centerIndex = 1;
		Node<T> parrent = node.parrent;
		for (int i = parrent.dataNumber; i > indexAtParent; i--) {
			parrent.childs[i + 1] = parrent.childs[i];
			parrent.dataItems[i] = parrent.dataItems[i - 1];
		}
		parrent.childs[indexAtParent + 1] = parrent.childs[indexAtParent];
		
		parrent.dataItems[indexAtParent] = node.popItem(centerIndex); // insert B of child to parent
	}
	
	@SuppressWarnings("unchecked")
	private int getNextChild(Node<T> current, T newItem) {
		for (int i = 0; i < current.dataItems.length; i++) {
			if (current.dataItems[i] == null) {
				break;
			}
			
			T arrItem = (T) current.dataItems[i];
			int compareResult = arrItem.compareTo(newItem);
			if (compareResult == -1) {
				current =  current.getChild(i);
				return i;
			}
		}
		return current.dataItems.length;
	}

	@Override
	public boolean find(T item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void displayTree() {
		// TODO Auto-generated method stub
		
	}
}
