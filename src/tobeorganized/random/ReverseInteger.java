package tobeorganized.random;

/*
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the
 * value to go outside the signed 32-bit integer range, then return 0.
 */
public class ReverseInteger {
  public int reverse(int x) {
    int result = 0;

    while (x != 0) {
      int tail = x % 10;
      int newResult = result * 10 + tail;
      if ((newResult - tail) / 10 != result) {
        return 0;
      }
      result = newResult;
      x = x / 10;
    }

    return result;
  }
}
