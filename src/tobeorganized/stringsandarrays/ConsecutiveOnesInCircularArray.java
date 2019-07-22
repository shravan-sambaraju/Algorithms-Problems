package tobeorganized.stringsandarrays;

public class ConsecutiveOnesInCircularArray {

  public static void main(String[] args) {
    int arr[] = new int[] {1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1};
    int n = arr.length;
    System.out.println(getMaxLength(arr, n));
  }

  private static int getMaxLength(int[] arr, int n) {
    int result = 0;

    for (int i = 0; i < 2 * n; i++) {
      int count = 0;
      if (arr[i % n] == 0) {
        count = 0;
      }
      if (i >= n) {
        break;
      } else {
        count++;
        result = Math.max(result, count);
      }
    }

    return result;
  }
}
