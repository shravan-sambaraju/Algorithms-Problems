package tobeorganized.stringsandarrays;

// Given an array which consists of non-negative integers and an integer m, you can split the array
// into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these
// m subarrays and return sum.
public class SplitArrayToMHavingMinimumLargestSum {
  public static int splitArray(int[] nums, int m) {
    int max = 0;
    long sum = 0;
    for (int num : nums) {
      max = Math.max(max, num);
      sum += num;
    }
    long l = max, r = sum;
    while (l <= r) {
      long mid = l + (r - l) / 2;
      if (valid(mid, nums, m)) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    if (m == 1) {
      return (int) sum;
    }

    return (int) l;
  }

  private static boolean valid(long mid, int[] nums, int m) {
    int count = 1;
    int total = 0;
    for (int num : nums) {
      total += num;
      if (total > mid) {
        total = num;
        count++;
        if (count > m) {
          return false;
        }
      }
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(splitArray(new int[] {7, 2, 5, 10, 8}, 2));
  }
}
