package tobeorganized.stringsandarrays;

/**
 * Given a binary string of 0s and 1s. The task is to find the maximum difference between the number
 * of 0s and number of 1s in any sub-string of the given binary string. That is maximize ( number of
 * 0s – number of 1s ) for any sub-string in the given binary string.
 */
public class MaximumDifferenceZerosOnes {

  public static int findLength(String str, int n) {

    int current_sum = 0;
    int max_sum = 0;

    // traverse a binary string from left to right
    for (int i = 0; i < n; i++) {

      // add current value to the current_sum
      // according to the Character
      // if it's '0' add 1 else -1
      current_sum += (str.charAt(i) == '0' ? 1 : -1);

      if (current_sum < 0) current_sum = 0;

      // update maxium sum
      max_sum = Math.max(current_sum, max_sum);
    }
    // return -1 if string does not contain any zero
    // that means string contains all ones otherwise max_sum
    return max_sum == 0 ? -1 : max_sum;
  }

  public static void main(String[] args) {
    String str = "11000010001";
    int n = str.length();

    System.out.println(findLength(str, n));
  }
}
