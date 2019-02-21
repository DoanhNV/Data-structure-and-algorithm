package datastructure.array;

public class Main1 {
	
	public static void main(String[] args) {
		Array arr = new Array(5);
		
		for (int i = 0; i < 5; i++) {
			arr.insert(i);
		}
		
		arr.display();
		arr.delete(10);
		arr.insert(10, 20, 30, 40, 50);
		arr.display();
	}
}
