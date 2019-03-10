package algorithms.search;

/** Java implementation of interpolation search */
class InterpolationSearch {

  private static int interpolationSearch(int[] A, int data) {
    int low = 0, high = A.length - 1, mid;
    while (A[low] <= data && A[high] >= data) {

      if (A[high] - A[low] == 0) {
        return (low + high) / 2;
      }

      mid = low + ((data - A[low]) * (high - low)) / (A[high] - A[low]);

      if (A[mid] < data) {
        low = mid + 1;
      } else if (A[mid] > data) {
        high = mid - 1;
      } else {
        return mid;
      }
    }

    if (A[low] == data) {
      return low;
    } else {
      return -1;
    }
  }

  public static void main(String args[]) {
    int A[] = {-30, -16, -9, 3, 10, 11, 18, 22, 54, 84, 105};

    for (int i = 0; i < A.length; i++) {
      System.out.print(A[i] + " ");
    }

    System.out.println();
    int data = -9;
    int result = InterpolationSearch.interpolationSearch(A, data);

    if (result == -1) {
      System.out.println("\n" + data + " element not found");
    } else {
      System.out.println("\n" + data + " elemnt found at position " + result);
    }
  }
}
