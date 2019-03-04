package algorithms.search;

/* Java implementation of binary search */

class BinarySearch {

  private static boolean contains(int[] a, int b) {
    if (a.length == 0) {
      return false;
    }
    int low = 0;
    int high = a.length - 1;
    System.out.println(high);

    while (low <= high) {
      int middle = (low + high) / 2;
      if (b > a[middle]) {
        low = middle + 1;
      } else if (b < a[middle]) {
        high = middle - 1;
      } else {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[] input = {24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12};
    int a = 2;
    System.out.println(contains(input, a));
  }
}
