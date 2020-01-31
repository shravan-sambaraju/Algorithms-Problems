package tobeorganized.random;

import java.util.HashMap;
import java.util.Map;

class MaximumSizeSubArraySumEqualsK {
  public int maxSubArrayLen(int[] nums, int k) {
    int maxSum = 0, windowSum;
    for (int i = 0; i <= nums.length - k; i++) {
      windowSum = 0;
      for (int j = i; j < i + k; j++) {
        windowSum += nums[j];
      }
      maxSum = Math.max(maxSum, windowSum);
    }

    return maxSum;
  }
}
