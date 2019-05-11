package datastructure.tree.binarysearchtree;

import java.util.function.Consumer;

/**
 * 
 * @author DoanhNV May 11, 2019 - 5:08:23 PM
 *
 */
public abstract class AbstractTree<T extends Comparable<T>> {
	
	public abstract void insert(T item);
	
	public abstract Node<T> find(T item);
	
	public abstract void delete(T item);
	
	public abstract void traverse(Consumer<T> consumer);
}
