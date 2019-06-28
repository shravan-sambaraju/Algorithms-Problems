package tobeorganized.random;

public class MaxStealWithoutConsecutive {

  public static void main(String[] args) {
    MaxStealWithoutConsecutive ht = new MaxStealWithoutConsecutive();
    int[] wealth = {2, 5, 1, 3, 6, 2, 4};
    System.out.println(ht.findMaxSteal(wealth));
    System.out.println(ht.findMaxStealBottomUp(wealth));
    wealth = new int[] {2, 10, 14, 8, 1};
    System.out.println(ht.findMaxSteal(wealth));
    System.out.println(ht.findMaxStealBottomUp(wealth));
  }

  public int findMaxSteal(int[] wealth) {
    int dp[] = new int[wealth.length];
    return findMaxStealRecursive(dp, wealth, 0);
  }

  private int findMaxStealRecursive(int[] dp, int[] wealth, int currentIndex) {
    if (currentIndex >= wealth.length) return 0;

    if (dp[currentIndex] == 0) {
      // steal from current house and skip one to steal next
      int stealCurrent = wealth[currentIndex] + findMaxStealRecursive(dp, wealth, currentIndex + 2);
      // skip current house to steel from the adjacent house
      int skipCurrent = findMaxStealRecursive(dp, wealth, currentIndex + 1);

      dp[currentIndex] = Math.max(stealCurrent, skipCurrent);
    }
    return dp[currentIndex];
  }

  public int findMaxStealBottomUp(int[] wealth) {
    if (wealth.length == 0) return 0;
    int dp[] = new int[wealth.length + 1]; // '+1' to handle the zero house
    dp[0] = 0; // if there are no houses, the thief can't steal anything
    dp[1] = wealth[0]; // only one house, so the thief have to steal from it

    // please note that dp[] has one extra element to handle zero house
    for (int i = 1; i < wealth.length; i++) dp[i + 1] = Math.max(wealth[i] + dp[i - 1], dp[i]);

    return dp[wealth.length];
  }
}
