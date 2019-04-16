package tobeorganized.random;

public class ArrayPivotLeftSumEqualsRightSum {

  public int pivotIndex(int[] nums) {
    int leftsum = 0, rightsum = 0;
    if (nums.length == 0) {
      return -1;
    }
    for (int num : nums) {
      rightsum += num;
    }
    for (int i = 0; i < nums.length; i++) {
      rightsum -= nums[i];
      if (leftsum == rightsum) {
        return i;
      }
      leftsum += nums[i];
    }
    return -1;
  }
}
