package tobeorganized.random;

/*
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that
 * single one.
 */
class FindElementNotRepeatedTwice {

  public int singleNumber(int[] nums) {

    int number = 0;
    for (int num : nums) {
      number ^= num;
    }
    return number;
  }
}
