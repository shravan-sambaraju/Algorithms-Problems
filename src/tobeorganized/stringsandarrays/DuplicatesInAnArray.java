package tobeorganized.stringsandarrays;

import java.util.ArrayList;
import java.util.List;

/*
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and
 * others appear once. Find all the elements that appear twice in this array. Could you do it
 * without extra space and in O(n) runtime?
 */
public class DuplicatesInAnArray {

  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < nums.length; ++i) {
      int index = Math.abs(nums[i]) - 1;
      if (nums[index] < 0) res.add(Math.abs(index + 1));
      nums[index] = -nums[index];
    }
    return res;
  }
}
