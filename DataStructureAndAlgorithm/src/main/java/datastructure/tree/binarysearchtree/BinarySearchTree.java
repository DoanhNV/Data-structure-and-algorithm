package datastructure.tree.binarysearchtree;

import java.util.function.Consumer;

/**
 * 
 * @author DoanhNV May 11, 2019 - 5:00:15 PM
 *
 */
public class BinarySearchTree<T extends Comparable<T>> extends AbstractTree<T> {
	
	private Node<T> root;

	@Override
	public void insert(T item) {
		Node<T> newNode = new Node<T>(item, null, null);
		if (root == null) {
			root = newNode;
		} else {
			Node<T> parrent = root;
			Node<T> current = root;
			boolean isLeftChild = false;
			while (current != null) {
				parrent = current;
				if (item.compareTo(current.getData()) == -1) {
					current = current.getLeftChild();
					isLeftChild = true;
				} else {
					current = current.getRightChild();
					isLeftChild = false;
				}
			}
			
			if (isLeftChild) {
				parrent.setLeftChild(newNode);
			} else {
				parrent.setRightChild(newNode);
			}
		}
	}

	@Override
	public Node<T> find(T item) {
		Node<T> current = root;
		while (current != null) {
			int comparResult = item.compareTo(current.getData());
			if (comparResult == 0) {
				return current;
			} else if (comparResult  == -1){
				current = current.getLeftChild();
			} else {
				current = current.getRightChild();
			}
		}
		return null;
	}

	@Override
	public void delete(T item) {
		Node<T> parrent = root;
		Node<T> current = root;
		boolean isLeftChild = false;
		
		while (current != null) {
			int compareResult = current.getData().compareTo(item);
			if (compareResult == 0) {
				break;
			} 
			
			parrent = current;
			if (compareResult == -1) {
				current = current.getLeftChild();
				isLeftChild = true;
			} else {
				current = current.getRightChild();
				isLeftChild = false;
			}
		}
		
		if (current == null) {
			return;
		}

		if (current == root) {
			root = null;
		} else if (current.getLeftChild() == null && current.getRightChild() == null) {
			if (isLeftChild) {
				parrent.setLeftChild(null);
			} else {
				parrent.setRightChild(null);
			}
		} else if (current.getLeftChild() == null) {
			if (isLeftChild) {
				parrent.setLeftChild(current.getRightChild());
			} else {
				parrent.setRightChild(current.getRightChild());
			}
		} else if (current.getRightChild() == null) {
			if (isLeftChild) {
				parrent.setLeftChild(current.getLeftChild());
			} else {
				parrent.setRightChild(current.getLeftChild());
			}
		} else {
			Node<T> successor = getSuccessor(current.getRightChild());
			successor.setLeftChild(current.getLeftChild());
			if (isLeftChild) {
				parrent.setLeftChild(successor);
			} else {
				parrent.setRightChild(successor);
			}
		}
	}
	
	public Node<T> getSuccessor(Node<T> rightDeletedChild) {
		Node<T> parrent = rightDeletedChild;
		Node<T> successor = rightDeletedChild;
		
		while (successor.getLeftChild() != null) {
			parrent = successor;
			successor = successor.getLeftChild();
		}
		if (successor != rightDeletedChild) {
			parrent.setLeftChild(successor.getRightChild());
			successor.setRightChild(rightDeletedChild);
		}
		return successor;
	}

	@Override
	public void traverse(Consumer<T> consumer) {
		inOrder(root, consumer);
	}
	
	private void inOrder(Node<T> traverser, Consumer<T> consumer) {
		if (traverser != null) {
			inOrder(traverser.getLeftChild(), consumer);
			consumer.accept(traverser.getData());
			inOrder(traverser.getRightChild(), consumer);
		} 
	}

	@Override
	public String toString() {
		return "BinarySearchTree [root=" + root + "]";
	}
}
