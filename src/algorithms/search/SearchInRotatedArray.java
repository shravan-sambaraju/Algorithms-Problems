package algorithms.search;

/* Java implementation to search in rotated array */

class SearchInRotatedArray {

  private static int search(int a[], int x) {
    return search(a, 0, a.length - 1, x);
  }

  private static int search(int a[], int left, int right, int x) {
    int mid = (left + right) / 2;

    if (x == a[mid]) {
      return mid;
    }

    if (right < left) {
      return -1;
    }

    if (a[left] < a[mid]) {

      if (x >= a[left] && x < a[mid]) {
        return search(a, left, mid - 1, x);
      } else {
        return search(a, mid + 1, right, x);
      }

    } else if (a[mid] < a[left]) {

      if (x > a[mid] && x <= a[right]) {
        return search(a, mid + 1, right, x);
      } else {
        return search(a, left, mid - 1, x);
      }

    } else if (a[left] == a[mid]) {

      if (a[mid] != a[right]) {
        return search(a, mid + 1, right, x);
      } else {
        int result = search(a, left, mid - 1, x);
        if (result == -1) {
          return search(a, mid + 1, right, x);
        } else {
          return result;
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] a = {2, 3, 1, 2, 2, 2, 2, 2, 2, 2};
    System.out.println(search(a, 2));
    System.out.println(search(a, 3));
    System.out.println(search(a, 4));
    System.out.println(search(a, 1));
    System.out.println(search(a, 8));
  }
}
