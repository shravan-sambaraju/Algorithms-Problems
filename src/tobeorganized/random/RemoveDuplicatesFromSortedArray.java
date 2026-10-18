package tobeorganized.random;

/*
 * Given a sorted array nums, remove the duplicates in-place such that each element appears only
 * once and returns the new length.
 */
class RemoveDuplicatesFromSortedArray {

  public int removeDuplicates(int[] nums) {

    if (nums.length == 0 || nums == null) {
      return 0;
    }

    int length = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[i - 1]) {
        nums[length] = nums[i];
        length++;
      }
    }

    return length;
  }
}
