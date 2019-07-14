package tobeorganized.stringsandarrays;

import java.util.Arrays;

public class PlusOneArray {
  public static void main(String[] args) {
    PlusOneArray pa = new PlusOneArray();
    int[] a = pa.plusOne(new int[] {9, 2, 2});
    System.out.println(Arrays.toString(a));
  }

  public int[] plusOne(int[] digits) {

    int n = digits.length;
    for (int i = n - 1; i >= 0; i--) {
      if (digits[i] < 9) {
        digits[i]++;
        return digits;
      }

      digits[i] = 0;
    }

    int[] newNumber = new int[n + 1];
    newNumber[0] = 1;

    return newNumber;
  }
}
