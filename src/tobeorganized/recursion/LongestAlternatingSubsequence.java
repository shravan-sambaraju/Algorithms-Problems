package tobeorganized.recursion;

public class LongestAlternatingSubsequence {

  public static void main(String[] args) {
    LongestAlternatingSubsequence las = new LongestAlternatingSubsequence();
    int[] nums = {1, 2, 3, 4};
    System.out.println(las.findLASLength(nums));
    System.out.println(las.findLASLengthBottomUp(nums));
    nums = new int[] {3, 2, 1, 4};
    System.out.println(las.findLASLength(nums));
    System.out.println(las.findLASLengthBottomUp(nums));
    nums = new int[] {1, 3, 2, 4};
    System.out.println(las.findLASLength(nums));
    System.out.println(las.findLASLengthBottomUp(nums));
  }

  public int findLASLength(int[] nums) {
    Integer[][][] dp = new Integer[nums.length][nums.length][2];
    return Math.max(
        findLASLengthRecursive(dp, nums, -1, 0, true),
        findLASLengthRecursive(dp, nums, -1, 0, false));
  }

  private int findLASLengthRecursive(
      Integer[][][] dp, int[] nums, int previousIndex, int currentIndex, boolean isAsc) {

    if (currentIndex == nums.length) return 0;

    if (dp[previousIndex + 1][currentIndex][isAsc ? 1 : 0] == null) {
      int c1 = 0;
      // if ascending, the next element should be bigger
      if (isAsc) {
        if (previousIndex == -1 || nums[previousIndex] < nums[currentIndex])
          c1 = 1 + this.findLASLengthRecursive(dp, nums, currentIndex, currentIndex + 1, !isAsc);
      } else { // if descending, the next element should be smaller
        if (previousIndex == -1 || nums[previousIndex] > nums[currentIndex])
          c1 = 1 + this.findLASLengthRecursive(dp, nums, currentIndex, currentIndex + 1, !isAsc);
      }
      // skip the current element
      int c2 = this.findLASLengthRecursive(dp, nums, previousIndex, currentIndex + 1, isAsc);
      dp[previousIndex + 1][currentIndex][isAsc ? 1 : 0] = Math.max(c1, c2);
    }

    return dp[previousIndex + 1][currentIndex][isAsc ? 1 : 0];
  }

  public int findLASLengthBottomUp(int[] nums) {
    if (nums.length == 0) return 0;
    // dp[i][0] = stores the LAS ending at 'i' such that the last two elements are in ascending
    // order
    // dp[i][1] = stores the LAS ending at 'i' such that the last two elements are in descending
    // order
    int[][] dp = new int[nums.length][2];
    int maxLength = 1;
    for (int i = 0; i < nums.length; i++) {
      // every single element can be considered as LAS of length 1
      dp[i][0] = dp[i][1] = 1;
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          // if nums[i] is BIGGER than nums[j] then we will consider the LAS ending at 'j' where the
          // last two elements were in DESCENDING order
          dp[i][0] = Math.max(dp[i][0], 1 + dp[j][1]);
          maxLength = Math.max(maxLength, dp[i][0]);
        } else if (nums[i] != nums[j]) { // if the numbers are equal don't do anything
          // if nums[i] is SMALLER than nums[j] then we will consider the LAS ending at 'j' where
          // the
          // last two elements were in ASCENDING order
          dp[i][1] = Math.max(dp[i][1], 1 + dp[j][0]);
          maxLength = Math.max(maxLength, dp[i][1]);
        }
      }
    }
    return maxLength;
  }
}
