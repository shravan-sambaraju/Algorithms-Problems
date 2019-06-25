package tobeorganized.random;

class LongestCommonSubSequence {

  public static void main(String[] args) {
    LongestCommonSubSequence lcs = new LongestCommonSubSequence();
    System.out.println(lcs.longestCommonSubSequence("abdca", "cbda"));
    System.out.println(lcs.longestCommonSubSequence("passport", "ppsspt"));
    System.out.println(lcs.longestCommonSubSequenceBottomUp("abdca", "cbda"));
    System.out.println(lcs.longestCommonSubSequenceBottomUp("passport", "ppsspt"));
  }

  int longestCommonSubSequence(String s1, String s2) {
    int maxLength = Math.max(s1.length(), s2.length());
    Integer[][] dp = new Integer[s1.length()][s2.length()];
    return longestCommonSubSequence(dp, s1, s2, 0, 0);
  }

  int longestCommonSubSequence(Integer[][] dp, String s1, String s2, int i1, int i2) {
    if (i1 == s1.length() || i2 == s2.length()) {
      return 0;
    }
    if (dp[i1][i2] == null) {
      if (s1.charAt(i1) == s2.charAt(i2)) {
        dp[i1][i2] = 1 + longestCommonSubSequence(dp, s1, s2, i1 + 1, i2 + 1);
      } else {
        int c1 = longestCommonSubSequence(dp, s1, s2, i1 + 1, i2);
        int c2 = longestCommonSubSequence(dp, s1, s2, i1, i2 + 1);
        dp[i1][i2] = Math.max(c1, c2);
      }
    }
    return dp[i1][i2];
  }

  int longestCommonSubSequenceBottomUp(String s1, String s2) {
    int[][] dp = new int[s1.length() + 1][s2.length() + 1];
    int maxLength = 0;
    for (int i = 1; i <= s1.length(); i++) {
      for (int j = 1; j <= s2.length(); j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
        maxLength = Math.max(maxLength, dp[i][j]);
      }
    }
    return maxLength;
  }
}
