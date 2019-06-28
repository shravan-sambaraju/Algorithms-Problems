package tobeorganized.codingproblems;

class MaximumProductSubArray {

  public static void main(String[] args) {}

  public int maxProduct(int[] nums) {
    int n = nums.length;
    int[] f = new int[2];
    f[0] = f[1] = nums[0];
    int max = f[0];
    for (int i = 1; i < n; ++i) {
      int[] ff = new int[2];
      if (nums[i] == 0) {
        ff[0] = ff[1] = 0;
      } else if (nums[i] > 0) {
        ff[0] = Math.max(nums[i], f[0] * nums[i]);
        ff[1] = Math.min(nums[i], f[1] * nums[i]);
      } else {
        ff[0] = Math.max(nums[i], f[1] * nums[i]);
        ff[1] = Math.min(nums[i], f[0] * nums[i]);
      }
      max = Math.max(max, ff[0]);
      f = ff;
    }
    return max;
  }
}
