package tobeorganized.strings;

import java.util.Scanner;

class FibbonacciSeries {

  public static int fibonacci(int n) {
    // Complete the function.
    int[] fib = new int[2];
    fib[0] = 0;
    fib[1] = 1;
    for (int i = 2; i <= n; ++i) {
      fib[i % 2] = fib[0] + fib[1];
    }
    return fib[n % 2];
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    scanner.close();
    System.out.println(fibonacci(n));
  }
}
