package tobeorganized.random;

class MaxElementInKSlidingWindow {

  private static void printKMax(int[] array, int n, int k) {
    int j, max;

    for (int i = 0; i <= n - k; i++) {
      max = array[i];
      for (j = 1; j < k; j++) {
        if (array[i + j] > max) {
          max = array[i + j];
        }
      }
      System.out.println(max);
    }
  }

  public static void main(String args[]) {
    int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int k = 3;
    printKMax(arr, arr.length, k);
  }
}
