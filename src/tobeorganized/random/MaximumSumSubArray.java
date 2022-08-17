package tobeorganized.random;

class MaximumSumSubArray {

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
    int finalMax = Integer.MIN_VALUE, tempMax = 0, start = 0, end = 0, interimstart = 0;

    for (int i = 0; i < size; i++) {
      tempMax += a[i];

      if (finalMax < tempMax) {
        finalMax = tempMax;
        start = interimstart;
        end = i;
      }

      if (tempMax < 0) {
        tempMax = 0;
        interimstart = i + 1;
      }
    }
    System.out.println("Maximum contiguous sum is " + finalMax);
    System.out.println("Starting index " + start);
    System.out.println("Ending index " + end);
  }
}
