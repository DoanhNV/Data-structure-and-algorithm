package datastructure.singlelinkedlist;

import java.util.function.Consumer;

/**
 * 
 * @author DoanhNV Apr 14, 2019 - 7:41:20 PM
 *
 */
public class LinkedList<T>  implements List<T> {

	private Link<T> first;
	
	public boolean isEmpty() {
		return first == null;
	}

	public void addFirst(T t) {
		Link<T> newLink = new Link<>(t, first);
		first = newLink;
	}
	
	public void add(T t) {
		Link<T> newLink = new Link<T>(t, null);
		if (isEmpty()) {
			first = newLink;
			return;
		}
		
		Link<T> current = first;
		while (current != null && current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(newLink);
	}
	
	public T getFirstValue() {
		return first != null ? first.getValue() : null;
	}
	
	public Link<T> find(T t) {
		Link<T> current = first;
		while (current != null) {
			if (current.getValue().equals(t)) {
				return current;
			}
			current = current.getNext();
		}
		return null;
	}
	
	public Link<T> update(T findValue, T updateValue) {
		Link<T> current = first;
		Link<T> previous = null;
		
		if (!isEmpty()) {
			while (!current.getValue().equals(findValue) && current.getNext() != null) {
				previous = current;
				current = current.getNext();
			}

			if (current.getValue().equals(findValue)) {
				Link<T> updateLink = new Link<>(updateValue, current.getNext());
				if (previous != null) {
					previous.setNext(updateLink);
				} else {
					first = updateLink;
				}
				return updateLink;
			}
		}
		
		return null;
	}
	
	public boolean remove(T t) {
		Link<T> current = first;
		Link<T> previous = null;
		
		if (!isEmpty()) {
			while (current != null) {
				if (current.getValue().equals(t)) {
					if (previous != null) {
						previous.setNext(current.getNext());
					} else {
						first = null;
					}
					return true;
				}
				previous = current;
				current = current.getNext();
			}
		}
		
		return false;
	}
	
	public void displayList() {
		System.out.print("Value: ");
		if (!isEmpty()) {
			Link<T> current = first;
			while (current != null) {
				current.displayLink();
				current = current.getNext();
			}
		}
		System.out.println();
	}
	
	public Link<T> getFirst() {
		return first;
	}

	public void setFirst(Link<T> first) {
		this.first = first;
	}

	@Override
	public void foreach(Consumer<T> consumer) {
		Link<T> current = first;
		while (current != null) {
			consumer.accept(current.getValue());
			current = current.getNext();
		}
	}
}
