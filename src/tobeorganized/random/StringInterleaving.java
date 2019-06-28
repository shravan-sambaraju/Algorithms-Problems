package tobeorganized.random;

import java.util.HashMap;
import java.util.Map;

public class StringInterleaving {

  public static void main(String[] args) {
    StringInterleaving si = new StringInterleaving();
    System.out.println(si.findSI("abd", "cef", "abcdef"));
    System.out.println(si.findSIBottomUp("abd", "cef", "abcdef"));
    System.out.println(si.findSI("abd", "cef", "adcbef"));
    System.out.println(si.findSIBottomUp("abd", "cef", "adcbef"));
    System.out.println(si.findSI("abc", "def", "abdccf"));
    System.out.println(si.findSIBottomUp("abc", "def", "abdccf"));
    System.out.println(si.findSI("abcdef", "mnop", "mnaobcdepf"));
    System.out.println(si.findSIBottomUp("abcdef", "mnop", "mnaobcdepf"));
  }

  public Boolean findSI(String m, String n, String p) {
    Map<String, Boolean> dp = new HashMap<>();
    return findSIRecursive(dp, m, n, p, 0, 0, 0);
  }

  private boolean findSIRecursive(
      Map<String, Boolean> dp, String m, String n, String p, int mIndex, int nIndex, int pIndex) {

    // if we have reached the end of the all the strings
    if (mIndex == m.length() && nIndex == n.length() && pIndex == p.length()) return true;

    // if we have reached the end of 'p' but 'm' or 'n' still has some characters left
    if (pIndex == p.length()) return false;

    String subProblemKey = mIndex + "-" + nIndex + "-" + pIndex;
    if (!dp.containsKey(subProblemKey)) {
      boolean b1 = false, b2 = false;
      if (mIndex < m.length() && m.charAt(mIndex) == p.charAt(pIndex))
        b1 = findSIRecursive(dp, m, n, p, mIndex + 1, nIndex, pIndex + 1);

      if (nIndex < n.length() && n.charAt(nIndex) == p.charAt(pIndex))
        b2 = findSIRecursive(dp, m, n, p, mIndex, nIndex + 1, pIndex + 1);

      dp.put(subProblemKey, b1 || b2);
    }

    return dp.get(subProblemKey);
  }

  public Boolean findSIBottomUp(String m, String n, String p) {
    // dp[mIndex][nIndex] will be storing the result of string interleaving
    // up to p[0..mIndex+nIndex-1]
    boolean[][] dp = new boolean[m.length() + 1][n.length() + 1];

    // for the empty pattern, we have one matching
    if (m.length() + n.length() != p.length()) return false;

    for (int mIndex = 0; mIndex <= m.length(); mIndex++) {
      for (int nIndex = 0; nIndex <= n.length(); nIndex++) {
        // if 'm' and 'n' are empty, then 'p' must have been empty too.
        if (mIndex == 0 && nIndex == 0) dp[mIndex][nIndex] = true;
        // if 'm' is empty, we need to check the interleaving with 'n' only
        else if (mIndex == 0 && n.charAt(nIndex - 1) == p.charAt(mIndex + nIndex - 1))
          dp[mIndex][nIndex] = dp[mIndex][nIndex - 1];
        // if 'n' is empty, we need to check the interleaving with 'm' only
        else if (nIndex == 0 && m.charAt(mIndex - 1) == p.charAt(mIndex + nIndex - 1))
          dp[mIndex][nIndex] = dp[mIndex - 1][nIndex];
        else {
          // if the letter of 'm' and 'p' match, we take whatever is matched till mIndex-1
          if (mIndex > 0 && m.charAt(mIndex - 1) == p.charAt(mIndex + nIndex - 1))
            dp[mIndex][nIndex] = dp[mIndex - 1][nIndex];
          // if the letter of 'n' and 'p' match, we take whatever is matched till nIndex-1 too
          // note the '|=', this is required when we have common letters
          if (nIndex > 0 && n.charAt(nIndex - 1) == p.charAt(mIndex + nIndex - 1))
            dp[mIndex][nIndex] |= dp[mIndex][nIndex - 1];
        }
      }
    }
    return dp[m.length()][n.length()];
  }
}
