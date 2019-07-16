package tobeorganized.recursion;

class LongestPalindromicSubsequence {

  public static void main(String[] args) {

    LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
    System.out.println(lps.lpsRecursive("abdbca"));
    System.out.println(lps.lpsRecursive("cddpd"));
    System.out.println(lps.lpsRecursive("pqr"));
    System.out.println(lps.lpsBottomUp("abdbca"));
    System.out.println(lps.lpsBottomUp("cddpd"));
    System.out.println(lps.lpsBottomUp("pqr"));
  }

  int lpsRecursive(String st) {
    Integer[][] dp = new Integer[st.length()][st.length()];
    return lpsRecursive(st, dp, 0, st.length() - 1);
  }

  int lpsRecursive(String st, Integer[][] dp, int start, int end) {
    if (start > end) {
      return 0;
    }
    if (start == end) {
      return 1;
    }
    if (dp[start][end] == null) {
      if (st.charAt(start) == st.charAt(end)) {
        dp[start][end] = 2 + lpsRecursive(st, dp, start + 1, end - 1);
      } else {
        int c1 = lpsRecursive(st, dp, start + 1, end);
        int c2 = lpsRecursive(st, dp, start, end - 1);
        dp[start][end] = Math.max(c1, c2);
      }
    }

    return dp[start][end];
  }

  int lpsBottomUp(String st) {
    int[][] dp = new int[st.length()][st.length()];
    for (int i = 0; i < st.length(); i++) {
      dp[i][i] = 1;
    }
    for (int start = st.length() - 1; start >= 0; start--) {
      for (int end = start + 1; end < st.length(); end++) {
        if (st.charAt(start) == st.charAt(end)) {
          dp[start][end] = 2 + dp[start + 1][end - 1];
        } else {
          dp[start][end] = Math.max(dp[start + 1][end], dp[start][end - 1]);
        }
      }
    }

    return dp[0][st.length() - 1];
  }
}
