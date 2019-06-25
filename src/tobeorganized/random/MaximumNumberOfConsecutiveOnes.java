package tobeorganized.random;

class MaximumNumberOfConsecutiveOnes {

  public int findMaxConsecutiveOnes(int[] nums) {
    int max = 0, maxCurrent = 0;
    for (int n : nums) {
      max = Math.max(max, maxCurrent = n == 0 ? 0 : maxCurrent + 1);
    }
    return max;
  }
}
