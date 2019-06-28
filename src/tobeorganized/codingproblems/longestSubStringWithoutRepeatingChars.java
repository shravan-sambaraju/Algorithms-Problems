package tobeorganized.codingproblems;

import java.util.HashSet;
import java.util.Set;

class longestSubStringWithoutRepeatingChars {

  public int lengthOfLongestSubstring(String s) {
    Set<Character> set = new HashSet<Character>();
    int maxLength = 0;
    int i = 0, j = 0;
    while (j < s.length()) {
      if (!set.contains(s.charAt(j))) {
        set.add(s.charAt(j));
        j++;
        maxLength = Math.max(maxLength, j - i);
      } else {
        set.remove(s.charAt(i));
        i++;
      }
    }
    return maxLength;
  }
}
