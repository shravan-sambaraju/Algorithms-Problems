package tobeorganized.random;

/*
 * Given an array of integers, rearrange the array such that every second element is greater than
 * its left and right elements (i.e., arr[0] <= arr[1] >= arr[2] <= arr[3] >= arr[4] ...).
 */
class RearrangeArray {

  public static void rearrange(int[] array) {
    for (int i = 1; i < array.length; i++) {
      if (((i % 2) == 0 && array[i - 1] < array[i]) || ((i % 2) != 0 && array[i - 1] > array[i])) {
        int temp = array[i - 1];
        array[i - 1] = array[i];
        array[i] = temp;
      }
    }
  }

  public static void main(String[] args) {}
}
