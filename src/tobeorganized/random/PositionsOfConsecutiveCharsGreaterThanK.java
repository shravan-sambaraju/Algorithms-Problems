package tobeorganized.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * In a string s of lowercase letters, these letters form consecutive groups of the same character.
 * A group is considered large if it has 3 or more characters. Return the intervals [start, end] of
 * every large group sorted in increasing order by start index.
 */
class PositionsOfConsecutiveCharsGreaterThanK {

  public static List<List<Integer>> largeGroupPositions(String str) {
    List<List<Integer>> ans = new ArrayList<>();
    int start = 0;
    for (int i = 1; i <= str.length(); i++) {
      if (i == str.length() || str.charAt(i) != str.charAt(i - 1)) {
        if (i - start >= 3) {
          ans.add(Arrays.asList(start, i - 1));
        }
        start = i;
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    System.out.println(largeGroupPositions("abbxxxxzzy").toString());
  }
}
