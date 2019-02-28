package algorithm.sort.t3insertion;

import static algorithm.sort.DataManager.*;

public class InsertionSorts {
	
	public static void sort(int[] arr) {
		
		for (int i = 1; i < arr.length; i++) {
			int markedIndex = i;
			int temp = arr[markedIndex];
			
			while(markedIndex > 0 && arr[markedIndex-1] > temp) {
				arr[markedIndex] = arr[markedIndex-1]; 
				--markedIndex;
			}
			
			arr[markedIndex] = temp;
		}
	} 
	
	public static void main(String[] args) {
		int[] ages = initData(10);
		displayData(ages);
		sort(ages);
		displayData(ages);
	}
}
