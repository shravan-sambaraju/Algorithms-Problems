package tobeorganized.stringsandarrays;

import java.util.Arrays;

public class MoveZeroesToLeft {
  static void move_zeros_to_left_in_array(int[] A) {
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

  public static void main(String[] args) {
    int[] v = new int[] {1, 10, -1, 11, 5, 0, -7, 0, 25, -35};
    System.out.println("Original Array: " + Arrays.toString(v));
    move_zeros_to_left_in_array(v);
    for (int i = 0; i < v.length; i++) {
      System.out.print(v[i] + ", ");
    }
  }
}
