package datastructure.tree._234tree;

/**
 * 
 * @author DoanhNV May 26, 2019 - 3:03:33 PM
 *
 */
public interface AbstractTree<T extends Comparable<T>>  {
	void insert(T item);
	boolean exist(T item);
	void displayTree();
}
