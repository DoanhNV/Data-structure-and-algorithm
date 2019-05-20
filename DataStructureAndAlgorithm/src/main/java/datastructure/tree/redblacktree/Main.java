package datastructure.tree.redblacktree;

/**
 * 
 * @author DoanhNV May 20, 2019 - 11:17:51 PM
 *
 */
public class Main {
	
	public static void main(String[] args) {
		RedBlackTree<Integer> tree = new RedBlackTree<Integer>();
		tree.insert(50);
		tree.insert(25);
		tree.insert(75);
		tree.insert(12);
		tree.insert(30);
		tree.insert(35);
		tree.insert(28);
		tree.insert(26);
		tree.insert(34);
		//tree.insert(33);
		tree.displayTree();
	}
}
