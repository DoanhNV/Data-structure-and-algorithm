package algorithm.advance_sorting.shellsort;

/**
 * 
 * @author DoanhNV Apr 21, 2019 - 4:22:20 PM
 *
 */
public class Sorts {
	
	public static void shellSort(int size, int[] array) {
		
		//int h = 1;
		//while (h < size / 3)
		//	h = 3*h + 1;
		int h = size / 2;
		
		while (h > 0) {
			for (int  i = h; i < size; i++) {
				int gapIndex = i; 
				while (gapIndex >= 0  && gapIndex - h >= 0 && array[gapIndex] < array[gapIndex - h]) {
					int temp = array[gapIndex];
					array[gapIndex] = array[gapIndex - h];
					array[gapIndex - h] = temp;
					gapIndex -= h;
				}
			}
			//h = (h-1) / 3;
			h = h / 2;
		}
	}
}
