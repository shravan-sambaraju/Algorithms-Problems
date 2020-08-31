package tobeorganized.random;

class MaxProfitStockMultipleTransactions {

  public int maxProfit(int[] prices) {
    int total = 0;
    for (int i = 0; i < prices.length - 1; i++) {
      if (prices[i + 1] > prices[i]) total += prices[i + 1] - prices[i];
    }

    return total;
  }

  public int maxProfitPeakValley(int[] prices) {
    if (prices == null || prices.length < 2) {
      return 0;
    }

    int i = 0;
    int peak = prices[0];
    int valley = prices[0];
    int maxProfit = 0;
    while (i < prices.length - 1) {
      while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
        i++;
      }
      valley = prices[i];
      while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
        i++;
      }
      peak = prices[i];
      maxProfit += peak - valley;
    }
    return maxProfit;
  }
}
