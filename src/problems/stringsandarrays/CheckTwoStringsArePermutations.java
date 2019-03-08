package problems.stringsandarrays;

/* Check if given strings are permutations of each other */

import java.util.Arrays;

class CheckTwoStringsArePermutations {

  private static String sort(String s) {
    char[] content = s.toCharArray();
    Arrays.sort(content);
    return new String(content);
  }

  private static boolean isPermutation(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    return sort(s).equals(sort(t));
  }

  ////// second approach

  private static boolean isPermutation2(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int[] letters = new int[128];
    char[] s_array = s.toCharArray();
    for (char c : s_array) {
      letters[c]++;
    }

    for (int i = 0; i < t.length(); i++) {
      int c = (int) t.charAt(i);
      letters[c]--;
      if (letters[c] < 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String args[]) {

    System.out.println(isPermutation("abc", "bca"));
    System.out.println(isPermutation("abc", "bcd"));
    System.out.println(isPermutation2("abc", "bca"));
    System.out.println(isPermutation2("abc", "bbc"));
    System.out.println(isPermutation2("abc", "bcd"));
  }
}
