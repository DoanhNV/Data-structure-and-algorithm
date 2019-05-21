package algorithm.recursive.mergesort;

/**
 * 
 * @author DoanhNV Apr 15, 2019 - 10:17:22 AM
 *
 */
public class MergeSort {
	
	public static void sort(int startLeftIndex, int endRightIndex, int[] arr) {
		
		boolean isRemainingLessThanOrEqualOne = startLeftIndex >= endRightIndex;
		if (isRemainingLessThanOrEqualOne) {
			return;
		} else {
			int endLeftIndex = startLeftIndex + (endRightIndex - startLeftIndex) / 2;
			int startRightIndex = endLeftIndex + 1;
			int markStartLeft = startLeftIndex;
			sort(startLeftIndex, endLeftIndex, arr);
			sort(startRightIndex, endRightIndex, arr);
			
			int[] sortArr = new int[endRightIndex - startLeftIndex + 1];
			int sortStartIndex = 0;
			
			while (startLeftIndex <= endLeftIndex && startRightIndex <= endRightIndex) {
				sortArr[sortStartIndex++] = arr[startLeftIndex] < arr[startRightIndex] 
													? arr[startLeftIndex++] : arr[startRightIndex++];
			}
			while (startLeftIndex <= endLeftIndex) {
				sortArr[sortStartIndex++] = arr[startLeftIndex++];
			}
			while (startRightIndex <= endRightIndex) {
				sortArr[sortStartIndex++] = arr[startRightIndex++];
			}
			
			for (int i = 0; i < sortArr.length; i++) {
				arr[markStartLeft++] = sortArr[i];
			}
		}
	}
}
