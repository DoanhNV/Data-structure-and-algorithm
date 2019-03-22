package datastructure.queue;

public class DStack {

	private Integer[] stack;
	private int elementNumber;
	
	public DStack(int elementNumber) {
		stack = new Integer[elementNumber];
	}
	
	
	public boolean add(int item) {
		if (isNotFull()) {
			stack[elementNumber] = item;
			elementNumber++;
			return true;
		}
		throw new RuntimeException("Add fail");
	}
	
	public Integer push(int item) {
		if (isNotFull()) {
			stack[elementNumber] = item;
			elementNumber++;
		}
		return item;
	}
	
	public Integer pop() {
		Integer item = null;
		if (hasItem()) {
			item = stack[elementNumber - 1];
			elementNumber--;
		}
		return item;
	}
	
	public Integer peek() {
		Integer item = null;
		if (hasItem()) {
			item = stack[elementNumber - 1];
		}
		return item;
	}
	
	public void displayAll() {
		String result = "";
		for (int i = 0; i < elementNumber; i++) {
			result += stack[i] + ",";
		}
		
		if (!result.isEmpty()) {
			result = result.substring(0, result.length() - 1);
		}
		System.out.println(result);
	}
	
	private boolean hasItem() {
		return elementNumber != 0;
	}
	
	private boolean isNotFull() {
		return elementNumber != stack.length;
	}
}
