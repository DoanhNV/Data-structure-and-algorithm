package algorithm.sort;

import java.util.Random;

public class DataManager {
	
	public static int[] initData(int length) {
		int[] ages = new int[length];
		Random random = new Random();
		for (int i = 0; i < ages.length; i++) {
			int number = random.nextInt(length);
			ages[i] = number;
		}
		return ages;
	}

	public static void displayData(int[] arr) {
		String elements = "";
		for (int i = 0; i < arr.length - 1; i++) {
			elements += arr[i] + ",";
		}

		if (arr.length != 0) {
			elements += arr[arr.length - 1];
		}
		System.out.println(elements);
	}
}
