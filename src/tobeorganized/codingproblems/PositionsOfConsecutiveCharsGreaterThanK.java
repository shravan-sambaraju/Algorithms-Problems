package tobeorganized.codingproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
