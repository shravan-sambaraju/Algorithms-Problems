package problems.stringsandarrays;

import common.utils.UtilMethods;
import java.util.Arrays;

/*
 * In an array of integers, a 'peak' is an element which is greater than or equal to the adjacent
 * integers and a 'valley' is an element which is less than or equal to the adjacent integers.
 * Given an array of integers, sort the array into an alternating sequence of peaks and valleys.
 */
class ArrayPeaksAndValleys {

  private static void sortValleyPeak(int[] array) {
    Arrays.sort(array);
    for (int i = 1; i < array.length; i += 2) {
      swap(array, i - 1, i);
    }
  }

  private static void swap(int[] array, int left, int right) {
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }

  public static void main(String[] args) {
    int[] array = {48, 40, 31, 62, 28, 21, 64, 40, 23, 17};
    System.out.println(UtilMethods.intArrayToString(array));
    sortValleyPeak(array);
    System.out.println(UtilMethods.intArrayToString(array));
  }
}
