package tobeorganized.random;

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
