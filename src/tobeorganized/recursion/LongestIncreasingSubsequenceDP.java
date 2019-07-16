package tobeorganized.recursion;

class LongestIncreasingSubsequenceDP {

  public static void main(String[] args) {
    LongestIncreasingSubsequenceDP lis = new LongestIncreasingSubsequenceDP();
    int[] nums = {4, 2, 3, 6, 10, 1, 12};
    System.out.println(lis.longestIncreasingSubsequence(nums));
    System.out.println(lis.longestIncreasingSubsequenceBottomUp(nums));
    nums = new int[] {-4, 10, 3, 7, 15};
    System.out.println(lis.longestIncreasingSubsequence(nums));
    System.out.println(lis.longestIncreasingSubsequenceBottomUp(nums));
  }

  int longestIncreasingSubsequence(int[] nums) {
    Integer[][] dp = new Integer[nums.length][nums.length + 1];
    return longestIncreasingSubsequence(dp, nums, 0, -1);
  }

  int longestIncreasingSubsequence(Integer[][] dp, int[] nums, int current, int previous) {
    if (current == nums.length) {
      return 0;
    }
    if (dp[current][previous + 1] == null) {
      int c1 = 0;
      if (previous == -1 || nums[current] > nums[previous]) {
        c1 = 1 + longestIncreasingSubsequence(dp, nums, current + 1, current);
      }
      int c2 = longestIncreasingSubsequence(dp, nums, current + 1, previous);
      dp[current][previous + 1] = Math.max(c1, c2);
    }

    return dp[current][previous + 1];
  }

  int longestIncreasingSubsequenceBottomUp(int[] nums) {
    int[] dp = new int[nums.length];
    dp[0] = 1;

    int maxLength = 1;
    for (int i = 1; i < nums.length; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++)
        if (nums[i] > nums[j] && dp[i] <= dp[j]) {
          dp[i] = dp[j] + 1;
          maxLength = Math.max(maxLength, dp[i]);
        }
    }
    return maxLength;
  }
}
