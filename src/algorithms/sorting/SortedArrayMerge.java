package algorithms.sorting;

/* Merge two sorted arrays into a single array */

import static common.utils.UtilMethods.intArrayToString;

class SortedArrayMerge {

  private static void merge(int[] a, int[] b, int lastA, int lastB) {
    int indexMerged = lastB + lastA - 1;
    int indexA = lastA - 1;
    int indexB = lastB - 1;
    while (indexB >= 0) {
      if (indexA >= 0 && a[indexA] > b[indexB]) {
        a[indexMerged] = a[indexA];
        indexA--;
      } else {
        a[indexMerged] = b[indexB];
        indexB--;
      }
      indexMerged--;
    }
  }

  public static void main(String[] args) {
    int[] a = {2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0};
    int[] b = {1, 4, 7, 6, 7, 7};
    merge(a, b, 8, 6);
    System.out.println(intArrayToString(a));
  }
}
