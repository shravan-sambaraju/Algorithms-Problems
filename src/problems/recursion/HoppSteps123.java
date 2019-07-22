package problems.recursion;

/** Count number of ways of Hopp Steps 123 */
class HoppSteps123 {

  // (Time Complexity - O(N), Space complexity - O(N))
  private static int countWays(int n) {
    int dp[] = new int[n + 1];
    return CountWaysRecursive(dp, n);
  }

  public static int CountWaysRecursive(int[] dp, int n) {
    if (n == 0) return 1;

    if (n == 1) return 1;

    if (n == 2) return 2;

    if (dp[n] == 0) {

      int take1Step = CountWaysRecursive(dp, n - 1);
      int take2Step = CountWaysRecursive(dp, n - 2);
      int take3Step = CountWaysRecursive(dp, n - 3);
      dp[n] = take1Step + take2Step + take3Step;
    }

    return dp[n];
  }

  // (Time Complexity - O(N), Space complexity - O(N))
  public static int CountWaysBottomUp(int n) {
    int dp[] = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i <= n; i++) dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];

    return dp[n];
  }

  public static void main(String[] args) {
    System.out.println(countWays(10));
    System.out.println(CountWaysBottomUp(10));
  }
}
