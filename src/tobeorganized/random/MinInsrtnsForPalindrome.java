package tobeorganized.random;

class MinInsrtnsForPalindrome {

  private static int countInsertions(char[] str, int l, int h) {
    if (l > h) {
      return Integer.MAX_VALUE;
    }
    if (l == h) {
      return 0;
    }
    if (l == h - 1) {
      return (str[l] == str[h]) ? 0 : 1;
    }
    return (str[l] == str[h])
        ? countInsertions(str, l + 1, h - 1)
        : (Integer.min(countInsertions(str, l, h - 1), countInsertions(str, l + 1, h)) + 1);
  }

  public static void main(String args[]) {
    String str = "geeks";
    System.out.println(countInsertions(str.toCharArray(), 0, str.length() - 1));
  }
}
