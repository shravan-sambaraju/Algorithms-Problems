package tobeorganized.recursion;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support
 * for '.' and '*' where '.' Matches any single character and '*' Matches zero or more of the
 * preceding element.
 */
public class RegularExpressionPatternMatching {
  public static boolean isMatchDp(String s, String p) {

    if (s == null || p == null) {
      return false;
    }
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[0][0] = true;
    for (int i = 0; i < p.length(); i++) {
      if (p.charAt(i) == '*' && dp[0][i - 1]) {
        dp[0][i + 1] = true;
      }
    }
    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j < p.length(); j++) {
        if (p.charAt(j) == '.') {
          dp[i + 1][j + 1] = dp[i][j];
        }
        if (p.charAt(j) == s.charAt(i)) {
          dp[i + 1][j + 1] = dp[i][j];
        }
        if (p.charAt(j) == '*') {
          if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
            dp[i + 1][j + 1] = dp[i + 1][j - 1];
          } else {
            dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
          }
        }
      }
    }
    return dp[s.length()][p.length()];
  }

  public static boolean isMatchIterative(String text, String pattern) {
    if (text.isEmpty() && pattern.isEmpty()) {
      return true;
    }

    if (!text.isEmpty() && pattern.isEmpty()) {
      return false;
    }

    if (pattern.length() > 1 && pattern.charAt(1) == '*') {

      String remainingPattern = pattern.substring(2);
      String remainingText = text;

      for (int i = 0; i < text.length() + 1; ++i) {
        if (isMatchIterative(remainingText, remainingPattern)) {
          return true;
        }

        if (remainingText.isEmpty()) {
          return false;
        }

        if (pattern.charAt(0) != '.' && remainingText.charAt(0) != pattern.charAt(0)) {
          return false;
        }

        remainingText = remainingText.substring(1);
      }
    }

    if (text.isEmpty() || pattern.isEmpty()) {
      return false;
    }

    if (pattern.charAt(0) == '.' || pattern.charAt(0) == text.charAt(0)) {
      String remainingText = "";
      if (text.length() >= 2) {
        remainingText = text.substring(1);
      }

      String remainingPattern = "";
      if (pattern.length() >= 2) {
        remainingPattern = pattern.substring(1);
      }

      return isMatchIterative(remainingText, remainingPattern);
    }

    return false;
  }

  public boolean isMatch(String text, String pattern) {
    if (pattern.isEmpty()) return text.isEmpty();
    boolean first_match =
        (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

    if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
      return (isMatch(text, pattern.substring(2))
          || (first_match && isMatch(text.substring(1), pattern)));
    } else {
      return first_match && isMatch(text.substring(1), pattern.substring(1));
    }
  }

  public static void main(String[] args) {
    System.out.println(isMatchDp("aa", "a"));
    System.out.println(isMatchDp("aa", "a*"));
    System.out.println(isMatchIterative("fabbbc", ".ab*c"));
  }
}
