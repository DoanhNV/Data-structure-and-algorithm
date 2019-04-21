package algorithm.advance_sorting.shellsort;

import java.util.Random;

/**
 * 
 * @author DoanhNV Apr 15, 2019 - 11:02:29 AM
 *
 */
public class Main {
	
	public static void main(String[] args) {
		int[] numbers  = new int[15];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = new Random().nextInt(20);
		}
		for (int i : numbers) {
			System.out.print(i + ",");
		}
		System.out.println();
		
		Sorts.shellSort(numbers.length, numbers);
		
		for (int i : numbers) {
			System.out.print(i + ",");
		}
	}
}
