package tobeorganized.random;

class SearchInSortedRotatedArray {

  public static int searchWithDuplicates(int[] arr, int key) {
    int start = 0, end = arr.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (arr[mid] == key) return mid;

      // the only difference from the previous solution,
      // if numbers at indexes start, mid, and end are same, we can't choose a side
      // the best we can do, is to skip one number from both ends as key != arr[mid]
      if ((arr[start] == arr[mid]) && (arr[end] == arr[mid])) {
        ++start;
        --end;
      } else if (arr[start] <= arr[mid]) { // left side is sorted in ascending order
        if (key >= arr[start] && key < arr[mid]) {
          end = mid - 1;
        } else { // key > arr[mid]
          start = mid + 1;
        }
      } else { // right side is sorted in ascending order
        if (key > arr[mid] && key <= arr[end]) {
          start = mid + 1;
        } else {
          end = mid - 1;
        }
      }
    }

    // we are not able to find the element in the given array
    return -1;
  }

  public static int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) return -1;
    int l = 0, r = nums.length - 1, m = 0;
    // find out the index of the smallest element.
    while (l < r) {
      m = (l + r) / 2;
      if (nums[m] > nums[r]) {
        l = m + 1;
      } else {
        r = m;
      }
    }

    // since we now know the start, find out if the target is to left or right of start in the
    // array.
    int s = l;
    l = 0;
    r = nums.length - 1;
    if (target >= nums[s] && target <= nums[r]) {
      l = s;
    } else {
      r = s;
    }
    // the regular search.
    while (l <= r) {
      m = (l + r) / 2;
      if (nums[m] == target) return m;
      else if (nums[m] > target) r = m - 1;
      else l = m + 1;
    }

    return -1;
  }

  public static void main(String[] args) {
    System.out.println(SearchInSortedRotatedArray.searchWithDuplicates(new int[] {3, 3, 7, 3}, 7));
  }
}
