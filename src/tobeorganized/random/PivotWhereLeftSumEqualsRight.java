package tobeorganized.random;

/*
 * Given an array of integers nums, calculate the pivot index of this array. The pivot index is the
 * index where the sum of all the numbers strictly to the left of the index is equal to the sum of
 * all the numbers strictly to the index's right.
 */
class PivotWhereLeftSumEqualsRight {

  public static int findPivot(int[] nums) {
    int rightSum = 0;
    int leftSum = 0;
    if (nums.length == 0) {
      return -1;
    }
    for (int element : nums) {
      rightSum += element;
    }
    for (int i = 0; i < nums.length; i++) {
      rightSum -= nums[i];
      if (leftSum == rightSum) {
        return i;
      }
      leftSum += nums[i];
    }
    return -1;
  }

  public static void main(String[] args) {}
}
