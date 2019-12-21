package problems.random;

/** Perform arithematic operations using addition */
import static common.utils.UtilMethods.randomIntInRange;;

class ArithematicOperationsUsingAddition {

  private static int negate(int a) {
    int neg = 0;
    int newSign = a < 0 ? 1 : -1;
    while (a != 0) {
      neg += newSign;
      a += newSign;
    }
    return neg;
  }

  private static int negateOptimized(int a) {
    int neg = 0;
    int newSign = a < 0 ? 1 : -1;
    int delta = newSign;
    while (a != 0) {
      boolean differentSigns = (a + delta > 0) != (a > 0);
      if (a + delta != 0 && differentSigns) {
        delta = newSign;
      }
      neg += delta;
      a += delta;
      delta += delta;
    }
    return neg;
  }

  private static int minus(int a, int b) {
    return a + negate(b);
  }

  private static int abs(int a) {
    if (a < 0) {
      return negateOptimized(a);
    } else {
      return a;
    }
  }

  private static int multiply(int a, int b) {
    if (a < b) {
      return multiply(b, a);
    }
    int sum = 0;
    for (int i = abs(b); i > 0; i = minus(i, 1)) {
      sum += a;
    }
    if (b < 0) {
      sum = negateOptimized(sum);
    }
    return sum;
  }

  private static int divide(int a, int b) throws java.lang.ArithmeticException {
    if (b == 0) {
      throw new java.lang.ArithmeticException("ERROR: Divide by zero.");
    }
    int absa = abs(a);
    int absb = abs(b);

    int product = 0;
    int x = 0;
    while (product + absb <= absa) {
      product += absb;
      x++;
    }

    if ((a < 0 && b < 0) || (a > 0 && b > 0)) {
      return x;
    } else {
      return negateOptimized(x);
    }
  }

  public static void main(String[] args) {
    int minRange = -100;
    int maxRange = 100;
    int cycles = 100;

    for (int i = 0; i < cycles; i++) {
      int a = randomIntInRange(minRange, maxRange);
      int b = randomIntInRange(minRange, maxRange);
      int ans = minus(a, b);
      if (ans != a - b) {
        System.out.println("ERROR");
      }
      System.out.println(a + " - " + b + " = " + ans);
    }
    for (int i = 0; i < cycles; i++) {
      int a = randomIntInRange(minRange, maxRange);
      int b = randomIntInRange(minRange, maxRange);
      int ans = multiply(a, b);
      if (ans != a * b) {
        System.out.println("ERROR");
      }
      System.out.println(a + " * " + b + " = " + ans);
    }
    for (int i = 0; i < cycles; i++) {
      int a = randomIntInRange(minRange, maxRange);
      int b = randomIntInRange(minRange, maxRange);
      System.out.print(a + " / " + b + " = ");
      int ans = divide(a, b);
      if (ans != a / b) {
        System.out.println("ERROR");
      }
      System.out.println(ans);
    }
  }
}
