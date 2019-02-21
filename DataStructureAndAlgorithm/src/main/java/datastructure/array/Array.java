package datastructure.array;

public class Array {
	
	int[] arrs;
	int nElement;
	int bufferSize = 10;
	
	public Array(int initSize) {
		arrs = new int[initSize];
	}
	
	public void insert(int element) {
		if (nElement < arrs.length) {
			arrs[nElement] = element;
			nElement++;
			return;
		}

		int[] arrTmp = new int[arrs.length + bufferSize];
		for (int i = 0; i < arrs.length; i++) {
			arrTmp[i] = arrs[i];
		}
		arrs = arrTmp;
		arrs[nElement] = element;
		nElement++;
	}
	
	public void insert(int... elements) {
		int numberNewElement = elements.length;

		int[] arrTmp = new int[arrs.length + numberNewElement];
		for (int i = 0; i < arrs.length; i++) {
			arrTmp[i] = arrs[i];
		}
		arrs = arrTmp;
		
		for (int i = 0; i < elements.length; i++) {
			arrs[nElement] = elements[i];
			nElement++;
		}
	}
	
	public void update(int oldValue, int newValue) {
		int index = search(oldValue);
		arrs[index] = newValue;
	}
	
	public void delete(int element) {
		int index = search(element);
		if (index == -1) {
			return;
		}
		
		for (int i = index; i < arrs.length -1; i++) {
			arrs[i] = arrs[i+1]; 
		}
		nElement--;
	}
	
	public int search(int element) {
		int index = -1;
		for (int i = 0; i < arrs.length - 1; i++) {
			index = element == arrs[i] ? i : index;
		}
		return index;
	}
	
	public void display() {
		String result = "[";
		for (int i : arrs) {
			if (i != arrs.length -1 ) {
				result += i;
			} else {
				result += i + "";
			}
		}
		result += "]";
		System.out.println(result);
	}
}
