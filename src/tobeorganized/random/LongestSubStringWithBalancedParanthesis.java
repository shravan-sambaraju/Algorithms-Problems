package tobeorganized.random;

public class LongestSubStringWithBalancedParanthesis {

  public int longestValidParentheses(String s) {
    int ans = 0;
    int[] dp = new int[s.length()];
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ')'
          && i - 1 >= 0) { // read dp[i-1] to get index of "(" related to ")" in this position
        int checkLeftIndex = i - dp[i - 1] - 1;
        if (checkLeftIndex >= 0 && s.charAt(checkLeftIndex) == '(') {
          dp[i] = dp[i - 1] + 2; // case "(( ))" , dp = {0,0,2,2+2}
          if (checkLeftIndex - 1 >= 0) {
            dp[i] += dp[checkLeftIndex - 1]; // Case"() (())", dp = {0,2,0,0,2,2+2+2}
          }
          ans = Math.max(ans, dp[i]);
        }
      }
    }
    return ans;
  }

  // constant space

  public int longestValidParenthesesConstantSpace(String s) {
    int left = 0, right = 0, maxlength = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        left++;
      } else {
        right++;
      }
      if (left == right) {
        maxlength = Math.max(maxlength, 2 * right);
      } else if (right >= left) {
        left = right = 0;
      }
    }
    left = right = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == '(') {
        left++;
      } else {
        right++;
      }
      if (left == right) {
        maxlength = Math.max(maxlength, 2 * left);
      } else if (left >= right) {
        left = right = 0;
      }
    }
    return maxlength;
  }

  public static void main(String[] args) {}
}
