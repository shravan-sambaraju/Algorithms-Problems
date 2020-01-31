package tobeorganized.stringsandarrays;

import java.util.Arrays;

public class MoveZeroes {
  static void moveZeroesToLeftOrStart(int[] A) {
    if (A == null) {
      return;
    }

    int write_index = A.length - 1;
    int read_index = A.length - 1;

    while (read_index >= 0) {
      if (A[read_index] != 0) {
        A[write_index] = A[read_index];
        write_index--;
      }

      read_index--;
    }

    while (write_index >= 0) {
      A[write_index] = 0;
      write_index--;
    }
  }

  public static void moveZeroesToRightOrEnd(int[] nums) {
    int pos = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        if (i != pos) {
          nums[pos] = nums[i];
          nums[i] = 0;
        }
        pos++;
      }
    }
  }

  public static void main(String[] args) {
    int[] v = new int[] {1, 10, -1, 11, 5, 0, -7, 0, 25, -35};
    System.out.println("Original Array: " + Arrays.toString(v));
    moveZeroesToLeftOrStart(v);
    System.out.println(Arrays.toString(v));
    System.out.println("");
    moveZeroesToRightOrEnd(v);
    System.out.println(Arrays.toString(v));
  }
}
