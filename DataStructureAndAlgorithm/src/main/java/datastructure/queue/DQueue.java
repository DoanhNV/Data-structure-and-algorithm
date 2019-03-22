package datastructure.queue;

import java.util.NoSuchElementException;

public class DQueue {
	
	private Integer[] queue;
	private int elementNumber;

	public DQueue(int size) {
		this.queue = new Integer[size];
	}
	
	public boolean add(int item) {
		if (isNotFull()) {
			queue[elementNumber] = item;
			elementNumber++;
			return true;
		}
		throw new NullPointerException("Queue add fail!");
	}
	
	public boolean offer(int item) {
		if (isNotFull()) {
			queue[elementNumber] = item;
			elementNumber++;
			return true;
		}
		return false;
	}
	
	public void push(int item) {
		if (isNotFull()) {
			for (int i = elementNumber; i >0 ; i--) {
				queue[i] = queue[i-1]; 
			}
			queue[0] = item;
			elementNumber++;
		}
	}
	
	/**
	 * Exception
	 * @return
	 */
	public Integer pop() {
		if (hasElement()) {
			int item = queue[0];
			for (int i = 0; i < elementNumber; i++) {
				queue[i] = queue[i+1];
			}
			elementNumber--;
			return item;
		}
		throw new NoSuchElementException("Queue is empty");
	}
	
	/**
	 * Exeception
	 * @return
	 */
	public Integer remove() {
		if (hasElement()) {
			int item = queue[0];
			for (int i = 0; i < elementNumber; i++) {
				queue[i] = queue[i+1];
			}
			elementNumber--;
			return item;
		}
		throw new NoSuchElementException("Queue is empty");
	}
	
	/**
	 * Exception
	 * @return
	 */
	public Integer element() {
		if (hasElement()) {
			return queue[0];
		}
		throw new NoSuchElementException("Queue is empty");
	}
	
	/**
	 * NonException
	 * @return
	 */
	public Integer poll() {
		Integer item = null;
		if (hasElement()) {
			item = queue[0];
			for (int i = 0; i < elementNumber; i++) {
				queue[i] = queue[i+1];
			}
			elementNumber--;
			
		}
		return item;
	}
	
	/**
	 * NonException
	 * @return
	 */
	public Integer peek() {
		Integer item = null;
		if (hasElement()) {
			item = queue[0];
		}
		return item;
	}
	
	public void displayAll() {
		String result = "";
		for (Integer item : queue) {
			if (item != null) {
				result += item + "|";
			}
		}
		
		if (!result.isEmpty()) {
			result = result.substring(0, result.length() - 1);
		}
		System.out.println(result);
	}
	
	
	private boolean hasElement() {
		return elementNumber != 0;
	}
	
	private boolean isNotFull() { 
		return elementNumber != this.queue.length;
	}
}
