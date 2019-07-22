package tobeorganized.stringsandarrays;

public class FindFirstMissingPositive {

  public static int firstMissingPositive(int[] nums) {
    int n = nums.length;
    if (n == 0) return 1;
    int k = partition(nums) + 1;
    int temp = 0;
    int first_missing_Index = k;
    for (int i = 0; i < k; i++) {
      temp = Math.abs(nums[i]);
      if (temp <= k) nums[temp - 1] = (nums[temp - 1] < 0) ? nums[temp - 1] : -nums[temp - 1];
    }
    for (int i = 0; i < k; i++) {
      if (nums[i] > 0) {
        first_missing_Index = i;
        break;
      }
    }
    return first_missing_Index + 1;
  }

  public static int partition(int[] nums) {
    int n = nums.length;
    int q = -1;
    for (int i = 0; i < n; i++) {
      if (nums[i] > 0) {
        q++;
        swap(nums, q, i);
      }
    }
    return q;
  }

  public static void swap(int[] nums, int i, int j) {
    if (i != j) {
      nums[i] ^= nums[j];
      nums[j] ^= nums[i];
      nums[i] ^= nums[j];
    }
  }

  public static void main(String[] args) {
      int[] array = {7,8,9,11,12};
      int[] array2 = {3,4,-1,1};
    System.out.println(firstMissingPositive(array));
    System.out.println(firstMissingPositive(array2));
  }
}
