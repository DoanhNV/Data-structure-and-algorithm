package datastructure.tree.binarysearchtree;

public class MainApp {
	
	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.insert(5);
		tree.insert(3);
		tree.insert(6);
		tree.insert(17);
		tree.insert(5);
		tree.insert(0);
		tree.insert(22);
		tree.traverse(item -> System.out.print(item + ","));
	}
}
