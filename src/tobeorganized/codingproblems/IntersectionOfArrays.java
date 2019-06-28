package tobeorganized.codingproblems;

import java.util.HashSet;
import java.util.Set;

class IntersectionOfArrays {

  public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> set = new HashSet<Integer>();
    Set<Integer> intersection = new HashSet<Integer>();
    for (int num : nums1) {
      set.add(num);
    }
    for (int number : nums2) {
      if (set.contains(number)) {
        intersection.add(number);
      }
    }

    int[] result = new int[intersection.size()];
    int i = 0;
    for (Integer num : intersection) {
      result[i++] = num;
    }
    return result;
  }
}
