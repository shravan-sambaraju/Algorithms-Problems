package tobeorganized.recursion;

public class CutRodLengthsForMaxProfit {

  public static void main(String[] args) {
    CutRodLengthsForMaxProfit rc = new CutRodLengthsForMaxProfit();
    int[] lengths = {1, 2, 3, 4, 5};
    int[] prices = {2, 6, 7, 10, 13};
    int maxProfit = rc.solveRodCutting(lengths, prices, 5);
    System.out.println(maxProfit);
  }

  // (Time Complexity - O(N*C), Space complexity - O(N*C))
  public int solveRodCutting(int[] lengths, int[] prices, int n) {
    // base checks
    if (n <= 0 || prices.length == 0 || prices.length != lengths.length) return 0;

    int lengthCount = lengths.length;
    int[][] dp = new int[lengthCount][n + 1];

    // process all rod lengths for all prices
    for (int i = 0; i < lengthCount; i++) {
      for (int len = 0; len <= n; len++) {
        int p1 = 0, p2 = 0;
        if (lengths[i] <= len) p1 = prices[i] + dp[i][len - lengths[i]];
        if (i > 0) p2 = dp[i - 1][len];
        dp[i][len] = Math.max(p1, p2);
      }
    }

    // maximum price will be at the bottom-right corner.
    return dp[lengthCount - 1][n];
  }
}
