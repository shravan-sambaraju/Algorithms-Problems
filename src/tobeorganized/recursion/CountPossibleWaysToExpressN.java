package tobeorganized.recursion;

public class CountPossibleWaysToExpressN {

  public static void main(String[] args) {
    CountPossibleWaysToExpressN en = new CountPossibleWaysToExpressN();
    System.out.println(en.countWays(4));
    System.out.println(en.countWaysBottomUp(4));
    System.out.println(en.countWays(5));
    System.out.println(en.countWaysBottomUp(5));
    System.out.println(en.countWays(6));
    System.out.println(en.countWaysBottomUp(6));
  }

  public int countWays(int n) {
    int dp[] = new int[n + 1];
    return countWaysRecursive(dp, n);
  }

  public int countWaysRecursive(int[] dp, int n) {
    if (n == 0)
      return 1; // base case, we don't need to subtract any thing, so there is only one way

    if (n == 1) return 1; // we can take subtract 1 to be left with zero, and that is the only way

    if (n == 2) return 1; // we can subtract 1 twice to get zero and that is the only way

    if (n == 3) return 2; // '3' can be expressed as {1,1,1}, {3}

    if (dp[n] == 0) {
      // if we subtract 1, we are left with 'n-1'
      int subtract1 = countWays(n - 1);
      // if we subtract 3, we are left with 'n-3'
      int subtract3 = countWays(n - 3);
      // if we subtract 4, we are left with 'n-4'
      int subtract4 = countWays(n - 4);
      dp[n] = subtract1 + subtract3 + subtract4;
    }

    return dp[n];
  }

  public int countWaysBottomUp(int n) {
    int dp[] = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 1;
    dp[3] = 2;

    for (int i = 4; i <= n; i++) dp[i] = dp[i - 1] + dp[i - 3] + dp[i - 4];

    return dp[n];
  }
}
