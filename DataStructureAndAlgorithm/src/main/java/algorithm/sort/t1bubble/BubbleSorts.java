package algorithm.sort.t1bubble;

import static algorithm.sort.DataManager.*;

public class BubbleSorts {
	
	public static void sort(int[] arr) {
		
		int lastUnsortIndex = arr.length - 1;
		
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < lastUnsortIndex; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			lastUnsortIndex--;
		}
	}
	
	public static void main(String[] args) {
		int[] ages = initData(10);
		displayData(ages);
		sort(ages);
		displayData(ages);
	}
}
