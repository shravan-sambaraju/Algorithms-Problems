package tobeorganized.random;

class ReverseString {

  public static void reverseString(char[] s) {
    int length = s.length;
    for (int i = 0; i < length / 2; i++) {
      char current = s[i];
      int otherEnd = length - i - 1;
      s[i] = s[otherEnd];
      s[otherEnd] = current;
    }
  }

  public static void main(String[] args) {

  }
}
