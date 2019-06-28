package tobeorganized.random;

import java.util.Arrays;

public class DutchFlagProblem {

  public static void sortDutchFlag(int[] array) {
    int low = 0, high = array.length - 1, mid = 0, temp = 0;
    while (mid <= high) {
      switch (array[mid]) {
        case 0:
          temp = array[low];
          array[low] = array[mid];
          array[mid] = temp;
          low++;
          mid++;
          break;

        case 1:
          mid++;
          break;

        case 2:
          temp = array[mid];
          array[mid] = array[high];
          array[high] = temp;
          high--;
          break;
      }
    }
  }

  public static void main(String[] args) {
    int[] array = {1, 2, 0, 0, 0, 1, 2, 0, 0, 1, 2};
    sortDutchFlag(array);
    System.out.println(Arrays.toString(array));
  }
}
