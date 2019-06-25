package tobeorganized.random;

import java.util.HashMap;
import java.util.Map;

class MaximumSizeSubArraySumEqualsK {
  public int maxSubArrayLen(int[] nums, int k) {
    if (nums.length == 0 || nums == null) {
      return 0;
    }
    int sum = 0, max = 0;
    Map<Integer, Integer> result = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      sum = sum + nums[i];
      if (sum == k) {
        max = Math.max(max, i + 1);
      } else if (result.containsKey(sum - k)) {
        max = Math.max(max, i - result.get(sum - k));
      }
      if (!result.containsKey(sum)) {
        result.put(sum, i);
      }
    }
    return max;
  }
}
