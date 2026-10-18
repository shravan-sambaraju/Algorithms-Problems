package tobeorganized.random;

import java.util.HashSet;
import java.util.Set;

/*
 * Write an algorithm to determine if a number n is happy. A happy number is a number defined by
 * repeatedly replacing the number by the sum of the squares of its digits until the number equals
 * 1, or it loops endlessly in a cycle which does not include 1.
 */
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
