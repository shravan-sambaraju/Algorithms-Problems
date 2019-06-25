package tobeorganized.random;

import java.util.HashSet;
import java.util.Set;

class HappyNumber {

  public boolean isHappy(int n) {
    Set<Integer> loop = new HashSet<Integer>();

    int squareSum, remainder;
    while (loop.add(n)) {
      squareSum = 0;
      while (n > 0) {
        remainder = n % 10;
        squareSum += remainder * remainder;
        n /= 10;
      }
      if (squareSum == 1) {
        return true;
      } else {
        n = squareSum;
      }
    }
    return false;
  }
}
