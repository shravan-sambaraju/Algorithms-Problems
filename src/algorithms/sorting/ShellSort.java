package algorithms.sorting;

/** Java implementation of shell sort */

import static common.utils.UtilMethods.intArrayToString;

class ShellSort {

  public static void main(String args[]) {
    int arr[] = {12, 34, 54, 2, 3};
    System.out.println("Array before sorting");
    System.out.println(intArrayToString(arr));
    ShellSort ob = new ShellSort();
    ob.sort(arr);
    System.out.println("Array after sorting");
    System.out.println(intArrayToString(arr));
  }

  private int sort(int arr[]) {
    int n = arr.length;
    for (int gap = n / 2; gap > 0; gap /= 2) {
      for (int i = gap; i < n; i += 1) {
        int temp = arr[i];
        int j;
        for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
          arr[j] = arr[j - gap];
        }
        arr[j] = temp;
      }
    }
    return 0;
  }
}
