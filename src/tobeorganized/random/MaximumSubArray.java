package tobeorganized.random;

class MaximumSubArray {

  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    long runSum = Integer.MIN_VALUE, result = Integer.MIN_VALUE;
    for (int num : nums) {
      runSum = Math.max(num, runSum + num);
      result = Math.max(result, runSum);
    }
    return (int) result;
  }

  static void maxSubArraySum(int a[], int size) {
    int maxSoFar = Integer.MIN_VALUE, maxEndHere = 0, start = 0, end = 0, s = 0;

    for (int i = 0; i < size; i++) {
      maxEndHere += a[i];

      if (maxSoFar < maxEndHere) {
        maxSoFar = maxEndHere;
        start = s;
        end = i;
      }

      if (maxEndHere < 0) {
        maxEndHere = 0;
        s = i + 1;
      }
    }
    System.out.println("Maximum contiguous sum is " + maxSoFar);
    System.out.println("Starting index " + start);
    System.out.println("Ending index " + end);
  }
}
