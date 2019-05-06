package problems.recursion;

/** find number of ways you can change coin denomination */
class CoinChange {

  public static void main(String[] args) {
    CoinChange cc = new CoinChange();
    int[] denoms = {25, 10, 5, 1};
    int ways = cc.countChange(denoms, 100000);
    System.out.println(ways);
    int[] denominations = {1, 2, 3};
    System.out.println(cc.countChange(denominations, 5));
    System.out.println(cc.countChangeBottomUp(denominations, 5));

    int[] denominations1 = {1, 2, 3};
    System.out.println(cc.minimumCoinsChange(denominations1, 5));
    System.out.println(cc.minimumCoinsChangeBottomUp(denominations1, 5));
    System.out.println(cc.minimumCoinsChange(denominations1, 11));
    System.out.println(cc.minimumCoinsChangeBottomUp(denominations1, 11));
    System.out.println(cc.minimumCoinsChange(denominations1, 7));
    System.out.println(cc.minimumCoinsChangeBottomUp(denominations1, 7));
  }

  public int countChange(int[] denominations, int total) {
    Integer[][] dp = new Integer[denominations.length][total + 1];
    return this.countChangeRecursive(dp, denominations, total, 0);
  }

  private int countChangeRecursive(
      Integer[][] dp, int[] denominations, int total, int currentIndex) {
    // base checks
    if (total == 0) return 1;

    if (denominations.length == 0 || currentIndex >= denominations.length) return 0;

    // if we have already processed a similar sub-problem, return the result from memory
    if (dp[currentIndex][total] != null) return dp[currentIndex][total];

    // recursive call after selecting the coin at the currentIndex
    // if the number at currentIndex exceeds the total, we shouldn't process this
    int sum1 = 0;
    if (denominations[currentIndex] <= total)
      sum1 =
          countChangeRecursive(
              dp, denominations, total - denominations[currentIndex], currentIndex);

    // recursive call after excluding the number at the currentIndex
    int sum2 = countChangeRecursive(dp, denominations, total, currentIndex + 1);

    dp[currentIndex][total] = sum1 + sum2;
    return dp[currentIndex][total];
  }

  public int countChangeBottomUp(int[] denominations, int total) {
    int n = denominations.length;
    int[][] dp = new int[n][total + 1];

    // populate the total=0 columns, as we will always have an empty set for zero toal
    for (int i = 0; i < n; i++) dp[i][0] = 1;

    // process all sub-arrays for all capacities
    for (int i = 0; i < n; i++) {
      for (int t = 1; t <= total; t++) {
        if (i > 0) dp[i][t] = dp[i - 1][t];
        if (t >= denominations[i]) dp[i][t] += dp[i][t - denominations[i]];
      }
    }

    // total combinations will be at the bottom-right corner.
    return dp[n - 1][total];
  }

  public int minimumCoinsChange(int[] denominations, int total) {
    int result = this.minimumCoinsRecursive(denominations, total, 0);
    return (result == Integer.MAX_VALUE ? -1 : result);
  }

  private int minimumCoinsRecursive(int[] denominations, int total, int currentIndex) {
    // base check
    if (total == 0) return 0;

    if (denominations.length == 0 || currentIndex >= denominations.length) return Integer.MAX_VALUE;

    // recursive call after selecting the coin at the currentIndex
    // if the coin at currentIndex exceeds the total, we shouldn't process this
    int count1 = Integer.MAX_VALUE;
    if (denominations[currentIndex] <= total) {
      int res =
          minimumCoinsRecursive(denominations, total - denominations[currentIndex], currentIndex);
      if (res != Integer.MAX_VALUE) {
        count1 = res + 1;
      }
    }

    // recursive call after excluding the coin at the currentIndex
    int count2 = minimumCoinsRecursive(denominations, total, currentIndex + 1);

    return Math.min(count1, count2);
  }

  public int minimumCoinsChangeBottomUp(int[] denominations, int total) {
    int n = denominations.length;
    int[][] dp = new int[n][total + 1];

    for (int i = 0; i < n; i++) for (int j = 0; j <= total; j++) dp[i][j] = Integer.MAX_VALUE;

    // populate the total=0 columns, as we don't need any coin to make zero total
    for (int i = 0; i < n; i++) dp[i][0] = 0;

    for (int i = 0; i < n; i++) {
      for (int t = 1; t <= total; t++) {
        if (i > 0) dp[i][t] = dp[i - 1][t]; // exclude the coin
        if (t >= denominations[i]) {
          if (dp[i][t - denominations[i]] != Integer.MAX_VALUE)
            dp[i][t] = Math.min(dp[i][t], dp[i][t - denominations[i]] + 1); // include the coin
        }
      }
    }

    // total combinations will be at the bottom-right corner.
    return (dp[n - 1][total] == Integer.MAX_VALUE ? -1 : dp[n - 1][total]);
  }
}
