package tobeorganized.random;

class LongestPalindromicSubstring {

  public static void main(String[] args) {
    LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
    System.out.println(lps.longestPalindrome("abdbca"));
    System.out.println(lps.longestPalindrome("cddpd"));
    System.out.println(lps.longestPalindrome("pqr"));
    System.out.println(lps.longestPalindromeBottomUp("abdbca"));
    System.out.println(lps.longestPalindromeBottomUp("cddpd"));
    System.out.println(lps.longestPalindromeBottomUp("pqr"));
  }

  int longestPalindrome(String s) {
    Integer[][] dp = new Integer[s.length()][s.length()];
    return longestPalindrome(s, dp, 0, s.length() - 1);
  }

  int longestPalindrome(String s, Integer[][] dp, int start, int end) {
    if (start > end) {
      return 0;
    }
    if (start == end) {
      return 1;
    }
    if (dp[start][end] == null) {
      int c1 = 0;
      if (s.charAt(start) == s.charAt(end)) {
        int remainLength = end - start - 1;
        if (remainLength == longestPalindrome(s, dp, start + 1, end - 1)) {
          c1 = remainLength + 2;
        }
      }
      int c2 = longestPalindrome(s, dp, start + 1, end);
      int c3 = longestPalindrome(s, dp, start, end - 1);
      dp[start][end] = Math.max(c1, Math.max(c2, c3));
    }
    return dp[start][end];
  }

  int longestPalindromeBottomUp(String s) {
    boolean[][] dp = new boolean[s.length()][s.length()];
    for (int i = 0; i < s.length(); i++) {
      dp[i][i] = true;
    }
    int maxLength = 1;
    for (int start = s.length() - 1; start >= 0; start--) {
      for (int end = start + 1; end < s.length(); end++) {
        if (s.charAt(start) == s.charAt(end)) {
          // if it's a two character string or if the remaining string is a palindrome too
          if (end - start == 1 || dp[start + 1][end - 1]) {
            dp[start][end] = true;
            maxLength = Math.max(maxLength, end - start + 1);
          }
        }
      }
    }
    return maxLength;
  }
}
