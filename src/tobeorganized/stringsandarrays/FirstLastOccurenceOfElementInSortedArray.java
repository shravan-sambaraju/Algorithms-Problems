package tobeorganized.stringsandarrays;

import java.util.Arrays;

// maximum and minimum index

public class FirstLastOccurenceOfElementInSortedArray {

  public static int[] searchRange(int[] nums, int target) {
    int[] result = new int[2];
    result[0] = findFirst(nums, target);
    result[1] = findLast(nums, target);
    return result;
  }

  private static int findFirst(int[] nums, int target) {
    int idx = -1;
    int start = 0;
    int end = nums.length - 1;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (nums[mid] >= target) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
      if (nums[mid] == target) idx = mid;
    }
    return idx;
  }

  private static int findLast(int[] nums, int target) {
    int idx = -1;
    int start = 0;
    int end = nums.length - 1;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (nums[mid] <= target) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
      if (nums[mid] == target) idx = mid;
    }
    return idx;
  }

  public static int[] searchRangeRecursion(int[] nums, int target) {
    int[] result = new int[2];
    if (nums == null || nums.length == 0) {
      return result;
    }
    result[0] = binarySearchHelper(nums, 0, nums.length - 1, target, true);
    result[1] = binarySearchHelper(nums, 0, nums.length - 1, target, false);
    return result;
  }

  private static int binarySearchHelper(
      int[] nums, int low, int high, int target, Boolean findFirst) {
    if (low > high) {
      return -1;
    }
    int mid = low + (high - low) / 2;
    if (findFirst) {
      if ((mid == 0 || nums[mid - 1] < target) && nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        return binarySearchHelper(nums, mid + 1, high, target, findFirst);
      } else {
        return binarySearchHelper(nums, low, mid - 1, target, findFirst);
      }
    } else {
      if ((mid == nums.length - 1 || nums[mid + 1] > target) && nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) {
        return binarySearchHelper(nums, low, mid - 1, target, findFirst);
      } else {
        return binarySearchHelper(nums, mid + 1, high, target, findFirst);
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8)));
    System.out.println(Arrays.toString(searchRange(new int[] {5, 7, 7, 8, 10}, 6)));
    System.out.println(Arrays.toString(searchRangeRecursion(new int[] {5, 7, 7, 8, 8, 10}, 8)));
    System.out.println(Arrays.toString(searchRangeRecursion(new int[] {5, 7, 7, 8, 10}, 6)));
  }
}
