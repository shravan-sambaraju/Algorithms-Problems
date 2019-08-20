package problems.stringsandarrays;

/** Print Array in form of peaks and valleys */
import common.utils.UtilMethods;

import java.util.Arrays;

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
