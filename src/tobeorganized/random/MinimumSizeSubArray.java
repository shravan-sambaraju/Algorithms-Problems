package tobeorganized.random;

/*
 * Given an array of positive integers nums and a positive integer s, return the minimal length of
 * a contiguous subarray of which the sum is greater than or equal to s. If there is no such
 * subarray, return 0 instead.
 */
class MinimumSizeSubArray {

  public int minSubArrayLen(int s, int[] a) {
    if (a == null || a.length == 0) return 0;

    int start = 0, end = 0, sum = 0, min = Integer.MAX_VALUE;
    while (end < a.length) {
      sum += a[end++];
      while (sum >= s) {
        min = Math.min(min, end - start);
        sum -= a[start++];
      }
    }

    return min == Integer.MAX_VALUE ? 0 : min;
  }
}
