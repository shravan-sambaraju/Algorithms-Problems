package problems.bitmanipulation;

/**
 * Given two 32 bit numbers M and N and position i and j insert M into N where M starts at j and
 * ends at i
 */

import static common.utils.UtilMethods.toFullBinaryString;

public class InsertOneNumberIntoOther {

  private static int updateBits(int n, int m, int i, int j) {

    if (i >= 32 || j < i) {
      return 0;
    }

    int allOnes = ~0;
    int left = allOnes << (j + 1);
    int right = ((1 << i) - 1);
    int mask = left | right;
    int n_cleared = n & mask;
    int m_shifted = m << i;
    return n_cleared | m_shifted;
  }

  public static void main(String[] args) {
    int a = 103217;
    System.out.println(toFullBinaryString(a));
    int b = 13;
    System.out.println(toFullBinaryString(b));
    int c = updateBits(a, b, 4, 12);
    System.out.println(toFullBinaryString(c));
  }
}
