package tobeorganized.strings;

import java.util.Arrays;

public class MoveZerosToEnd {
  public static void main(String[] args) {

    MoveZerosToEnd mv = new MoveZerosToEnd();
    int[] array = new int[] {0, 0, 9, 2, 2};
    mv.moveZeroes(array);
    System.out.println(Arrays.toString(array));
  }

  public void moveZeroes(int[] nums) {
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
}
