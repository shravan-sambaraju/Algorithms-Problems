package tobeorganized.random;

/*
 * Write a function that reverses a string. The input string is given as an array of characters
 * char[]. Do this by modifying the input array in-place with O(1) extra memory.
 */
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

  public static void main(String[] args) {}
}
