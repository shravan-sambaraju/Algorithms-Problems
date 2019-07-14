package tobeorganized.random;

class CheckIfTwoGivenStringsAreIsomorphic {

  public static boolean isIsomorphic(String s, String t) {
    if (s == null || t == null || s.length() != t.length()) {
      return false;
    }
    int n = s.length();
    int[] m1 = new int[256];
    int[] m2 = new int[256];
    for (int i = 0; i < n; i++) {
      char c1 = s.charAt(i);
      char c2 = t.charAt(i);
      if (m1[c1] != m2[c2]) {
        return false;
      }
      m1[c1] = i + 1;
      m2[c2] = i + 1;
    }
    return true;
  }

  public static void main(String[] args) {

    System.out.println(isIsomorphic("egg", "odd"));
    System.out.println(isIsomorphic("foo", "bar"));
  }
}
