package datastructure.tree.redblacktree;

import java.util.Stack;
import java.util.function.Consumer;

import datastructure.tree.binarysearchtree.BinarySearchTree;

/**
 * 
 * @author DoanhNV May 19, 2019 - 11:08:27 PM
 *
 */
public class RedBlackTree<T extends Comparable<T>> extends BinarySearchTree<T> {

	private Node<T> root;
	
	@Override
	public void insert(T data) {
		Node<T> newNode = new Node<T>(data);
		
		if(root == null) {
			newNode.isBlack = true;
			root = newNode;
		} else {
			Node<T> grandParent = null;
			Node<T> parent = null;
			Node<T> current = root;
			boolean isLeftOldestMan = false;
			boolean isLeftParrent = false;
			boolean isLeft = false;
			boolean isLeaf = false;
			
			while (!isLeaf) {
				if (current.isBlack 
						&& current.leftChild != null && !current.leftChild.isBlack
							&& current.rightChild != null && !current.rightChild.isBlack) {
					flipColor(current, current.leftChild, current.rightChild);
				}
				
				boolean isDuplicateRedNode = parent != null && !parent.isBlack && !current.isBlack;
				if (isDuplicateRedNode) {
					Node<T> raseChild = parent;
					if (isLeftParrent) {
						if (!isLeft) {
							rotateLeft(grandParent, parent, current, isLeftParrent, false);
							raseChild = current; // if parrent is reindexed
						}
						rotateRight(grandParent, grandParent, raseChild, isLeftParrent, true);
					} else {
						if (isLeft) {
							rotateRight(grandParent, parent, current, isLeftParrent, false);
							raseChild = current;
						}
						rotateLeft(grandParent, grandParent, raseChild, isLeftParrent, true);
					}
				}
				
				isLeftOldestMan = isLeftParrent;
				isLeftParrent = isLeft;
				
				int compareResult = data.compareTo(current.data);
				if (compareResult < 0 ) {
					if (current.leftChild != null) {
						grandParent = parent;
						parent = current;
						current = current.leftChild;
					} else {
						isLeaf = true;
					}
					isLeft = true;
				} else {
					if (current.rightChild != null) {
						grandParent = parent;
						parent = current;
						current = current.rightChild;
					} else {
						isLeaf = true;
					}
					isLeft = false;
				}
			}
			
			if (isLeft) {
				current.leftChild = newNode;
			} else {
				current.rightChild = newNode;
			}
			
			if (!current.isBlack) {
				Node<T> raiseChild = current;
				if (isLeftParrent) {
					if (!isLeft) {
						rotateLeft(parent, current, newNode, isLeftParrent, false);
						raiseChild = newNode;
					}
					rotateRight(grandParent, parent, raiseChild, isLeftOldestMan, false);
				} else {
					if (isLeft) {
						rotateRight(parent, current, newNode, isLeftParrent, false);
						raiseChild = newNode;
					}
					rotateLeft(grandParent, parent, raiseChild, isLeftOldestMan, false);
				}
			} 
			this.displayTree();
		}
	}
	
	private void flipColor(Node<T> parent, Node<T> leftChild, Node<T> rightChild) {
		if (parent != root) {
			parent.isBlack = false;
		}
		parent.leftChild.isBlack = true;
		parent.rightChild.isBlack = true;
	}
	
	private void rotateRight(Node<T> grandParent, Node<T> parent, Node<T> child, boolean isLeftParrent, boolean isRootBalancing) {
		parent.leftChild = child.rightChild;
		child.rightChild = parent;
		
		boolean parrentColor = parent.isBlack;
		parent.isBlack = child.isBlack;
		child.isBlack = parrentColor;
		
		if (isRootBalancing) {
			root = child;
			root.isBlack = true;
			return;
		} else {
			Node<T> tempNode = child;
			child = parent; // reindex child cursor
			parent = tempNode; // reindex parent cursor
		}
		
		if (isLeftParrent) {
			grandParent.leftChild = parent;
		} else {
			grandParent.rightChild = parent;
		}
	}

	private void rotateLeft(Node<T> grandParrent, Node<T> parrent, Node<T> child, boolean isLeftParrent, boolean isRootBalancing) {
		parrent.rightChild = child.leftChild;
		child.leftChild = parrent;
		boolean parrentColor = parrent.isBlack;
		parrent.isBlack = child.isBlack;
		child.isBlack = parrentColor;
		
		if (isRootBalancing) {
			root = child;
			root.isBlack = true;
			return;
		} else {
			Node<T> tempNode = child;
			child = parrent; // reindex child cursor
			parrent = tempNode; // reindex parrent cursor
		}
		if (isLeftParrent) {
			grandParrent.leftChild = parrent;
		} else {
			grandParrent.rightChild = parrent;
		}
	}
	
	@Override
	public void traverse(Consumer<T> consumer) {
		inOrder(root, consumer);
	}
	
	private void inOrder(Node<T> traverser, Consumer<T> consumer) {
		if (traverser != null) {
			inOrder(traverser.leftChild, consumer);
			consumer.accept(traverser.data);
			inOrder(traverser.rightChild, consumer);
		} 
	}
	
	
	// function copy from binary search tree
	public void displayTree()
	{
		Stack<Node<T>> globalStack = new Stack<>();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println("......................................................");
		while (isRowEmpty == false) {
			Stack<Node<T>> localStack = new Stack<>();
			isRowEmpty = true;
			for (int j = 0; j < nBlanks; j++)
				System.out.print(" ");
			while (globalStack.isEmpty() == false) {
				Node<T> temp = (Node<T>) globalStack.pop();
				if (temp != null) {
					String color = temp.isBlack ? "b" : "r";
					System.out.print(temp.data + color);
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);
					if (temp.leftChild != null || temp.rightChild != null)
						isRowEmpty = false;
				} else {
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for (int j = 0; j < nBlanks * 2 - 2; j++)
					System.out.print(" ");
			} // end while globalStack not empty
			System.out.println();
			nBlanks /= 2;
			while (localStack.isEmpty() == false)
				globalStack.push(localStack.pop());
		} // end while isRowEmpty is false
		System.out.println("......................................................");
	} // end displayTree()
	
}
