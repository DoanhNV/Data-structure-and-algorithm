package algorithm.advance_sorting.quicksort;

/**
 * 
 * @author DoanhNV Apr 21, 2019 - 11:08:36 PM
 *
 */
public class Sorts {
	
	public static void quickSort(int left, int right, int[] array) {
		if (left >= right) {
			return;
		} else {
			int pivot = array[right];
			int partitionIndex = partitioning(left, right, pivot, array);
			quickSort(left, partitionIndex - 1, array);
			quickSort(partitionIndex + 1, right, array);
		}
	}
	
	private static int partitioning(int left, int right, int pivot, int[] array) {
		int leftBuffer = left - 1;
		int rightBuffer = right;
		while (true) {
			while (array[++leftBuffer] < pivot);
			while (rightBuffer > 1 && array[--rightBuffer] > pivot);
			if (leftBuffer >= rightBuffer) {
				break;
			} else {
				swap(array, leftBuffer, rightBuffer);
			}
		}
		swap(array, leftBuffer, right);
		return leftBuffer;
	}
	
	private static void swap(int[] array, int firstIndex, int secondIndex) {
		int temp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = temp;
	}
}
