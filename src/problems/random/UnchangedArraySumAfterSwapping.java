package problems.random;

/** FInd unchanged array sum after swapping */
import java.util.Arrays;

class UnchangedArraySumAfterSwapping {

  private static int sum(int[] array) {
    int s = 0;
    for (int a : array) {
      s += a;
    }
    return s;
  }

  private static Integer getTarget(int[] array1, int[] array2) {
    int sum1 = sum(array1);
    int sum2 = sum(array2);

    if ((sum1 - sum2) % 2 != 0) {
      return null;
    }
    return (sum1 - sum2) / 2;
  }

  private static int[] findSwapValues(int[] array1, int[] array2) {
    Integer target = getTarget(array1, array2);
    if (target == null) {
      return null;
    }
    return findDifference(array1, array2, target);
  }

  private static int[] findDifference(int[] array1, int[] array2, int target) {
    Arrays.sort(array1);
    Arrays.sort(array2);

    int a = 0;
    int b = 0;

    while (a < array1.length && b < array2.length) {
      int difference = array1[a] - array2[b];
      if (difference == target) {
        int[] values = {array1[a], array2[b]};
        return values;
      } else if (difference < target) {
        a++;
      } else {
        b++;
      }
    }

    return null;
  }

  public static void main(String[] args) {
    int[] array1 = {1, 1, 1, 2, 2, 4};
    int[] array2 = {3, 3, 3, 6};
    int[] swaps = findSwapValues(array1, array2);
    if (swaps == null) {
      System.out.println("null");
    } else {
      System.out.println(swaps[0] + " " + swaps[1]);
    }
  }
}
