package tobeorganized.codingproblems;

class MaximumSubArray {

  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    long runSum = Integer.MIN_VALUE, result = Integer.MIN_VALUE;
    for (int num : nums) {
      runSum = Math.max(num, runSum + num);
      result = Math.max(result, runSum);
    }
    return (int) result;
  }
}
