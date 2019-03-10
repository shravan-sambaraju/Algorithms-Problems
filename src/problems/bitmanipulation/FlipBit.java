package problems.bitmanipulation;

/**
 * Given an integer and you can flip exactly one bit from a 0 to a 1. find the length of longest
 * sequence of 1s we can create
 */
public class FlipBit {

  private static int flipBit(int a) {
    if (~a == 0) {
      return Integer.BYTES * 8;
    }
    int currentLength = 0;
    int previousLength = 0;
    int maxLength = 1;
    while (a != 0) {
      if ((a & 1) == 1) {
        currentLength++;
      } else if ((a & 1) == 0) {
        previousLength = (a & 2) == 0 ? 0 : currentLength;
        currentLength = 0;
      }
      maxLength = Math.max(previousLength + currentLength + 1, maxLength);
      a >>>= 1;
    }
    return maxLength;
  }

  public static void main(String[] args) {
    int[][] cases = {
      {-1, 32}, {Integer.MAX_VALUE, 32}, {-10, 31}, {0, 1}, {1, 2}, {15, 5}, {1775, 8}
    };
    for (int[] c : cases) {
      int x = flipBit(c[0]);
      boolean r = (c[1] == x);
      System.out.println(c[0] + ": " + x + ", " + c[1] + " " + r);
    }
  }
}
