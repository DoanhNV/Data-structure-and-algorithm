package algorithm.sort.t2selection;
import static algorithm.sort.DataManager.*;

public class SelectionSorts {
	
	public static void sort(int[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			int smalleastIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[smalleastIndex]) {
					smalleastIndex = j;
				}
			}
			
			int temp = arr[i];
			arr[i] = arr[smalleastIndex];
			arr[smalleastIndex] = temp;
		}
	}
	
	public static void main(String[] args) {
		int[] ages = initData(1);
		displayData(ages);
		sort(ages);
		displayData(ages);
	}
}
