package tobeorganized.random;

import java.util.ArrayList;
import java.util.List;

/*
 * Write a program that outputs the string representation of numbers from 1 to n. For multiples of
 * three it should output 'Fizz', for multiples of five output 'Buzz', and for multiples of both
 * three and five output 'FizzBuzz'.
 */
class FizzBuzzWithoutDivision {

  public List<String> fizzBuzz(int n) {
    List<String> ret = new ArrayList<String>(n);
    for (int i = 1, fizz = 0, buzz = 0; i <= n; i++) {
      fizz++;
      buzz++;
      if (fizz == 3 && buzz == 5) {
        ret.add("FizzBuzz");
        fizz = 0;
        buzz = 0;
      } else if (fizz == 3) {
        ret.add("Fizz");
        fizz = 0;
      } else if (buzz == 5) {
        ret.add("Buzz");
        buzz = 0;
      } else {
        ret.add(String.valueOf(i));
      }
    }
    return ret;
  }
}
