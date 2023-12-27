package problems.stringsandarrays;

/* Check unique characters in string */
class CheckUniqueCharactersInString {

  // with using extra data structure

  private static boolean isUnique(String s) {
    if (s.length() > 128) {
      return false;
    }
    boolean[] char_set = new boolean[128];
    for (int i = 0; i < s.length(); i++) {
      int val = s.charAt(i);
      if (char_set[val]) {
        return false;
      }
      char_set[val] = true;
    }
    return true;
  }

  private static boolean isUnique2(String s) {
    int checker = 0;
    for (int i = 0; i < s.length(); i++) {
      int value = s.charAt(i) - 'a';
      if ((checker & (1 << value)) > 0) {
        return false;
      }
      checker |= (1 << value);
    }
    return true;
  }

  public static void main(String args[]) {
    System.out.println(isUnique("why"));
    System.out.println(isUnique("whyy"));
    System.out.println(isUnique2("why"));
    System.out.println(isUnique2("whyy"));
  }
}
