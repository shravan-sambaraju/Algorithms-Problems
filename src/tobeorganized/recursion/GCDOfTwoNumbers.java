package tobeorganized.recursion;

public class GCDOfTwoNumbers {

  public static long findGCD(long x, long y) {
    if (x > y) {
      return findGCD(y, x);
    } else if (x == 0) {
      return y;
    } else if ((x & 1) == 0 && (y & 1) == 0) {
      return findGCD(x >>> 1, y >>> 1) << 1;
    } else if ((x & 1) == 0 && (y & 1) != 0) {
      return findGCD(x >>> 1, y);
    } else if ((x & 1) != 0 && (y & 1) == 0) {
      return findGCD(x, y >>> 1);
    }
    return findGCD(x, y - x);
  }

  public static void main(String[] args) {
    System.out.println(findGCD(98, 56));
  }
}
