package tobeorganized.random;

/*
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1,
 * n] inclusive, there is only one repeated number in nums. Return this repeated number.
 */
class FindTheDuplicateNumber {

  public int findDuplicate(int[] nums) {
    int low = 1, high = nums.length - 1;
    while (low < high) {
      int mid = (int) (low + (high - low)) / 2;
      int count = 0;
      for (int a : nums) {
        if (a <= mid) {
          count++;
        }
      }
      if (count > mid) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }
}
