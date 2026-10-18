package tobeorganized.random;

/*
 * In a given integer array nums, there is always exactly one largest element. Find whether the
 * largest element in the array is at least twice as much as every other number in the array. If it
 * is, return the index of the largest element, or return -1 otherwise.
 */
public class LargestNumberTwiceOthersInArray {
  public int dominantIndex(int[] nums) {
    int max = -1, index = -1, second = -1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > max) {
        second = max;
        max = nums[i];
        index = i;
      } else if (nums[i] > second) second = nums[i];
    }
    return second * 2 <= max ? index : -1;
  }
}
