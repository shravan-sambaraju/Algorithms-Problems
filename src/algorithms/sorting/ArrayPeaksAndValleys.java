package algorithms.sorting;

/* Print Array in form of peaks and valleys */

import java.util.Arrays;

public class ArrayPeaksAndValleys {

	public static void sortValleyPeak(int[] array) {
		Arrays.sort(array);
		for (int i = 1; i < array.length; i += 2) {
			swap(array, i - 1, i);
		}
	}

	public static void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	public static void main(String[] args) {
		int[] array = { 48, 40, 31, 62, 28, 21, 64, 40, 23, 17 };
		System.out.println(arrayToString(array));
		sortValleyPeak(array);
		System.out.println(arrayToString(array));
	}

	public static String arrayToString(int[] array) {
		if (array == null)
			return "";
		return arrayToString(array, 0, array.length - 1);
	}

	public static String arrayToString(int[] array, int start, int end) {
		StringBuilder sb = new StringBuilder();
		for (int i = start; i <= end; i++) {
			int v = array[i];
			sb.append(v + ", ");
		}
		return sb.toString();
	}

}
