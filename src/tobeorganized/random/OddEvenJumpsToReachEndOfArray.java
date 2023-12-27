package tobeorganized.random;

import java.util.TreeMap;

/*
 * You are given an integer array A. From some starting index, you can make a series of jumps. The
 * (1st, 3rd, 5th, ...) jumps in the series are called odd numbered jumps, and the (2nd, 4th, 6th,
 * ...) jumps in the series are called even numbered jumps.
 *
 * <p>You may from index i jump forward to index j (with i < j) in the following way:
 *
 * <p>During odd numbered jumps (ie. jumps 1, 3, 5, ...), you jump to the index j such that A[i] <=
 * A[j] and A[j] is the smallest possible value. If there are multiple such indexes j, you can only
 * jump to the smallest such index j. During even numbered jumps (ie. jumps 2, 4, 6, ...), you jump
 * to the index j such that A[i] >= A[j] and A[j] is the largest possible value. If there are
 * multiple such indexes j, you can only jump to the smallest such index j. (It may be the case that
 * for some index i, there are no legal jumps.) A starting index is good if, starting from that
 * index, you can reach the end of the array (index A.length - 1) by jumping some number of times
 * (possibly 0 or more than once.)
 *
 * <p>Return the number of good starting indexes.
 */
public class OddEvenJumpsToReachEndOfArray {
  public static int oddEvenJumps(int[] array) {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    int N = array.length;
    if (N <= 1) {
      return N;
    }
    boolean[] odd = new boolean[N];
    boolean[] even = new boolean[N];

    odd[N - 1] = true;
    even[N - 1] = true;
    map.put(array[N - 1], N - 1);
    for (int i = N - 2; i >= 0; i--) {
      int val = array[i];
      if (map.containsKey(val)) {
        odd[i] = even[map.get(val)];
        even[i] = odd[map.get(val)];
      } else {
        Integer lower = map.lowerKey(val);
        Integer higher = map.higherKey(val);
        if (higher != null) {
          odd[i] = even[map.get(higher)];
        }
        if (lower != null) {
          even[i] = odd[map.get(lower)];
        }
      }
      map.put(val, i);
    }
    int ans = 0;
    for (boolean bol : odd) {
      if (bol) {
        ans++;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(oddEvenJumps(new int[] {2, 3, 1, 1, 4}));
    System.out.println(oddEvenJumps(new int[] {10, 13, 12, 14, 15}));
  }
}
