package tobeorganized.recursion;

import java.util.HashMap;
import java.util.Map;

public class MaximumSumIncreasingSubSequence {

  public static void main(String[] args) {
    MaximumSumIncreasingSubSequence msis = new MaximumSumIncreasingSubSequence();
    int[] nums = {4, 1, 2, 6, 10, 1, 12};
    System.out.println(msis.findMSIS(nums));
    System.out.println(msis.findMSISBottomup(nums));
    nums = new int[] {-4, 10, 3, 7, 15};
    System.out.println(msis.findMSIS(nums));
    System.out.println(msis.findMSISBottomup(nums));
    nums = new int[] {1, 3, 8, 4, 14, 6, 14, 1, 9, 4, 13, 3, 11, 17, 29};
    System.out.println(msis.findMSIS(nums));
    System.out.println(msis.findMSISBottomup(nums));
  }

  public int findMSIS(int[] nums) {
    Map<String, Integer> dp = new HashMap<>();
    return findMSISRecursive(dp, nums, 0, -1, 0);
  }

  private int findMSISRecursive(
      Map<String, Integer> dp, int[] nums, int currentIndex, int previousIndex, int sum) {
    if (currentIndex == nums.length) return sum;

    String subProblemKey = currentIndex + "-" + previousIndex + "-" + sum;
    if (!dp.containsKey(subProblemKey)) {
      // include nums[currentIndex] if it is larger than the last included number
      int s1 = sum;
      if (previousIndex == -1 || nums[currentIndex] > nums[previousIndex])
        s1 = findMSISRecursive(dp, nums, currentIndex + 1, currentIndex, sum + nums[currentIndex]);

      // excluding the number at currentIndex
      int s2 = findMSISRecursive(dp, nums, currentIndex + 1, previousIndex, sum);
      dp.put(subProblemKey, Math.max(s1, s2));
    }

    return dp.get(subProblemKey);
  }

  public int findMSISBottomup(int[] nums) {
    int[] dp = new int[nums.length];
    dp[0] = nums[0];

    int maxSum = nums[0];
    for (int i = 1; i < nums.length; i++) {
      dp[i] = nums[i];
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j] && dp[i] < dp[j] + nums[i]) dp[i] = dp[j] + nums[i];
      }
      maxSum = Math.max(maxSum, dp[i]);
    }

    return maxSum;
  }
}
