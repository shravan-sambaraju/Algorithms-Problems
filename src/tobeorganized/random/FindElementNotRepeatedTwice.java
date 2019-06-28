package tobeorganized.random;

class FindElementNotRepeatedTwice {

  public int singleNumber(int[] nums) {

    int number = 0;
    for (int num : nums) {
      number ^= num;
    }
    return number;
  }
}
