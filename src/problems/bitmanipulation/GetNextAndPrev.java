package problems.bitmanipulation;

/**
 * Given positive Integer print next smallest and next largest numbers that have same number of 1
 * bits
 */

public class GetNextAndPrev {

  private static int getNextArith(int n) {
    int c = n;
    int c0 = 0;
    int c1 = 0;
    while (((c & 1) == 0) && (c != 0)) {
      c0++;
      c >>= 1;
    }

    while ((c & 1) == 1) {
      c1++;
      c >>= 1;
    }

    if (c0 + c1 == 31 || c0 + c1 == 0) {
      return -1;
    }
    return n + (1 << c0) + (1 << (c1 - 1)) - 1;
  }

  private static int getPrevArith(int n) {
    int temp = n;
    int c0 = 0;
    int c1 = 0;
    while (((temp & 1) == 1) && (temp != 0)) {
      c1++;
      temp >>= 1;
    }
    if (temp == 0) {
      return -1;
    }
    while ((temp & 1) == 0 && (temp != 0)) {
      c0++;
      temp >>= 1;
    }
    return n - (1 << c1) - (1 << (c0 - 1)) + 1;
  }

  private static void binPrint(int i) {
    System.out.println(i + ": " + Integer.toBinaryString(i));
  }

  public static void main(String[] args) {
    int i = 13948;
    int p1 = getPrevArith(i);
    int n1 = getNextArith(i);
    binPrint(p1);
    binPrint(n1);
  }
}
