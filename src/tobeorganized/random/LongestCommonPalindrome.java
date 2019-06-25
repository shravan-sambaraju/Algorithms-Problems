package tobeorganized.random;

class LongestCommonPalindrome {

  public static void main(String[] args) {
    LongestCommonPalindrome lcs = new LongestCommonPalindrome();
    System.out.println(lcs.longestCommonPalindrome("abdca", "cbda"));
    System.out.println(lcs.longestCommonPalindrome("passport", "ppsspt"));
    System.out.println(lcs.longestCommonPalindromeBottomUp("abdca", "cbda"));
    System.out.println(lcs.longestCommonPalindromeBottomUp("passport", "ppsspt"));
  }

  int longestCommonPalindrome(String s1, String s2) {
    int maxLength = Math.max(s1.length(), s2.length());
    Integer[][][] dp = new Integer[s1.length()][s2.length()][maxLength];
    return longestCommonPalindrome(dp, s1, s2, 0, 0, 0);
  }

  public int longestCommonPalindrome(
      Integer[][][] dp, String s1, String s2, int i1, int i2, int count) {
    if (i1 == s1.length() || i2 == s2.length()) {
      return count;
    }
    if (dp[i1][i2][count] == null) {
      int c1 = count;
      if (s1.charAt(i1) == s2.charAt(i2)) {
        c1 = longestCommonPalindrome(dp, s1, s2, i1 + 1, i2 + 1, count + 1);
      }
      int c2 = longestCommonPalindrome(dp, s1, s2, i1 + 1, i2, 0);
      int c3 = longestCommonPalindrome(dp, s1, s2, i1, i2 + 1, 0);
      dp[i1][i2][count] = Math.max(c1, Math.max(c2, c3));
    }
    return dp[i1][i2][count];
  }

  int longestCommonPalindromeBottomUp(String s1, String s2) {
    int[][] dp = new int[s1.length() + 1][s2.length() + 1];
    int maxLength = 0;
    for (int i = 1; i < s1.length(); i++) {
      for (int j = 1; j < s2.length(); j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
          maxLength = Math.max(maxLength, dp[i][j]);
        }
      }
    }

    return maxLength;
  }
}
