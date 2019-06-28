package tobeorganized.codingproblems;

class ReverseString {

  public void reverseString(char[] s) {
    int length = s.length;
    for (int i = 0; i < length / 2; i++) {
      char current = s[i];
      int otherEnd = length - i - 1;
      s[i] = s[otherEnd];
      s[otherEnd] = current;
    }
  }
}
