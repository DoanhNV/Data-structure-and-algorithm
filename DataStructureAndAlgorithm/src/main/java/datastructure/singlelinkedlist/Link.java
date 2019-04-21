package datastructure.singlelinkedlist;
/**
 * 
 * @author DoanhNV Apr 14, 2019 - 7:42:50 PM
 *
 */
public class Link<T> {

	private T value;
	private Link<T> next;
	
	public Link(T value, Link<T> next) {
		this.value = value;
		this.next = next;
	}

	public Link<T> getNext() {
		return next;
	}

	public void setNext(Link<T> next) {
		this.next = next;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
	public void displayLink() {
		System.out.print(value + "," );
	}
}
