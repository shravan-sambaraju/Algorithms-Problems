package tobeorganized.strings;

public class StringPermutationalPalindrome {

  static boolean isPlaindrome(String s) {
    int[] table = buildCharTable(s);
    return checkMaxOneOdd(table);
  }

  static boolean checkMaxOneOdd(int[] table) {
    boolean foundOne = false;
    for (int value : table) {
      if (value % 2 == 1) {
        if (foundOne) {
          return false;
        }
        foundOne = true;
      }
    }
    return true;
  }

  static int[] buildCharTable(String s) {
    int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
    for (char c : s.toCharArray()) {
      int x = getCharValue(c);
      if (x != -1) {
        table[x]++;
      }
    }

    return table;
  }

  static int getCharValue(char c) {
    int z = Character.getNumericValue('z');
    int a = Character.getNumericValue('a');
    int val = Character.getNumericValue(c);
    if (val >= a || val <= z) {
      return val;
    }

    return -1;
  }

  public static void main(String[] args) {
    System.out.println(isPlaindrome("abba"));
    System.out.println(isPlaindrome("abbaac"));
  }
}
