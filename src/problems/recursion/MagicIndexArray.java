package problems.recursion;

/*
 * A magic index in an array A[e... n-1] is defined to be an index such that A[ i] = i. Given a
 * sorted array of distinct integers, write a method to find a magic index
 */
class MagicIndexArray {

  private static int magicFastUnsorted(int[] array, int start, int end) {
    if (end < start) {
      return -1;
    }
    int midIndex = (start + end) / 2;
    int midValue = array[midIndex];
    if (midValue == midIndex) {
      return midIndex;
    }
    int leftIndex = Math.min(midIndex - 1, midValue);
    int left = magicFastUnsorted(array, start, leftIndex);
    if (left >= 0) {
      return left;
    }
    int rightIndex = Math.max(midIndex + 1, midValue);
    int right = magicFastUnsorted(array, rightIndex, end);
    return right;
  }

  private static int magicFastUnsorted(int[] array) {
    return magicFastUnsorted(array, 0, array.length - 1);
  }

  private static int magicSlowSorted(int[] array) {
    for (int i = 0; i < array.length; i++) {
      if (array[i] == i) {
        return i;
      }
    }
    return -1;
  }

  private static int magicFastSorted(int[] array, int start, int end) {
    if (end < start) {
      return -1;
    }
    int mid = (start + end) / 2;
    if (array[mid] == mid) {
      return mid;
    } else if (array[mid] > mid) {
      return magicFastSorted(array, start, mid - 1);
    } else {
      return magicFastSorted(array, mid + 1, end);
    }
  }

  private static int magicFastSorted(int[] array) {
    return magicFastSorted(array, 0, array.length - 1);
  }

  public static void main(String[] args) {

    int a[] = new int[5];
    a[0] = 1;
    a[1] = 2;
    a[2] = 2;
    a[3] = 4;
    a[4] = 5;

    int a2[] = new int[5];
    a[0] = 4;
    a[1] = 1;
    a[2] = 3;
    a[3] = 7;
    a[4] = 8;

    System.out.println(magicFastUnsorted(a2));
    System.out.println(magicFastSorted(a));
    System.out.println(magicSlowSorted(a));
    System.out.println(magicSlowSorted(a2));
  }
}
