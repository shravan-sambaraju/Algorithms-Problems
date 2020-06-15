package tobeorganized.recursion;

class Fibonacci {

  // (Time Complexity - O(N), Space complexity - O(N))
  private static int calculateFibonacci(int n) {
    int[] memoize = new int[n + 1];
    return calculateFibonacciRecursive(memoize, n);
  }

  public static int calculateFibonacciRecursive(int[] memoize, int n) {
    if (n < 2) {
      return n;
    }

    if (memoize[n] != 0) {
      return memoize[n];
    }
    memoize[n] =
        calculateFibonacciRecursive(memoize, n - 1) + calculateFibonacciRecursive(memoize, n - 2);
    return memoize[n];
  }

  public static int calculateFibonacciBottomUpSpaceOptimized(int n) {
    if (n < 2) return n;
    int n1 = 0, n2 = 1, temp;
    for (int i = 2; i <= n; i++) {
      temp = n1 + n2;
      n1 = n2;
      n2 = temp;
    }
    return n2;
  }

  // (Time Complexity - O(N), Space complexity - O(N))
  public static int calculateFibonacciBottomUp(int n) {
    int dp[] = new int[n + 1];

    // base cases
    dp[0] = 0;
    dp[1] = 1;

    for (int i = 2; i <= n; i++)
      dp[i] = dp[i - 1] + dp[i - 2];

    return dp[n];
  }

  public static void main(String[] args) {
    System.out.println(calculateFibonacci(6));
    System.out.println(calculateFibonacciBottomUp(6));
  }
}
