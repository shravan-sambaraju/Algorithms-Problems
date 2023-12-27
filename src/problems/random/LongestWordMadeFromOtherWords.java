package problems.random;

/*
 * Given a list of words, write a program to find the longest word made of other words in the list.
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

import static common.utils.UtilMethods.createGiantArray;

class LongestWordMadeFromOtherWords {

  private static String printLongestWord(String arr[]) {
    HashMap<String, Boolean> map = new HashMap<String, Boolean>();
    for (String str : arr) {
      map.put(str, true);
    }
    LongestWordMadeFromOtherWords lw = new LongestWordMadeFromOtherWords();
    Arrays.sort(arr, lw.new LengthComparator()); // Sort by length
    for (String s : arr) {
      if (canBuildWord(s, true, map)) {
        System.out.println(s);
        return s;
      }
    }
    return "";
  }

  private static boolean canBuildWord(
      String str, boolean isOriginalWord, HashMap<String, Boolean> map) {
    if (map.containsKey(str) && !isOriginalWord) {
      return map.get(str);
    }
    for (int i = 1; i < str.length(); i++) {
      String left = str.substring(0, i);
      String right = str.substring(i);
      if (map.containsKey(left) && map.get(left) == true && canBuildWord(right, false, map)) {
        return true;
      }
    }
    map.put(str, false);
    return false;
  }

  public static void main(String[] args) {
    String[] arr = createGiantArray();
    printLongestWord(arr);
  }

  private class LengthComparator implements Comparator<String> {
    public int compare(String o1, String o2) {
      if (o1.length() < o2.length()) {
        return 1;
      }
      if (o1.length() > o2.length()) {
        return -1;
      }
      return 0;
    }
  }
}
