package tobeorganized.codingproblems;

public class SubsequencePatternMatching {

  public static void main(String[] args) {
    SubsequencePatternMatching spm = new SubsequencePatternMatching();
    System.out.println(spm.findSPMCount("baxmx", "ax"));
    System.out.println(spm.findSPMCountBottomUp("baxmx", "ax"));
    System.out.println(spm.findSPMCount("tomorrow", "tor"));
    System.out.println(spm.findSPMCountBottomUp("tomorrow", "tor"));
  }

  public int findSPMCount(String str, String pat) {
    Integer[][] dp = new Integer[str.length()][pat.length()];
    return findSPMCountRecursive(dp, str, pat, 0, 0);
  }

  private int findSPMCountRecursive(
      Integer[][] dp, String str, String pat, int strIndex, int patIndex) {

    // if we have reached the end of the pattern
    if (patIndex == pat.length()) return 1;

    // if we have reached the end of the string but pattern has still some characters left
    if (strIndex == str.length()) return 0;

    if (dp[strIndex][patIndex] == null) {
      int c1 = 0;
      if (str.charAt(strIndex) == pat.charAt(patIndex))
        c1 = findSPMCountRecursive(dp, str, pat, strIndex + 1, patIndex + 1);
      int c2 = findSPMCountRecursive(dp, str, pat, strIndex + 1, patIndex);
      dp[strIndex][patIndex] = c1 + c2;
    }

    return dp[strIndex][patIndex];
  }

  public int findSPMCountBottomUp(String str, String pat) {
    // every empty pattern has one match
    if (pat.length() == 0) return 1;

    if (str.length() == 0 || pat.length() > str.length()) return 0;

    // dp[strIndex][patIndex] will be storing the count of SPM up to
    // str[0..strIndex-1][0..patIndex-1]
    int[][] dp = new int[str.length() + 1][pat.length() + 1];

    // for the empty pattern, we have one matching
    for (int i = 0; i <= str.length(); i++) dp[i][0] = 1;

    for (int strIndex = 1; strIndex <= str.length(); strIndex++) {
      for (int patIndex = 1; patIndex <= pat.length(); patIndex++) {
        if (str.charAt(strIndex - 1) == pat.charAt(patIndex - 1))
          dp[strIndex][patIndex] = dp[strIndex - 1][patIndex - 1];
        dp[strIndex][patIndex] += dp[strIndex - 1][patIndex];
      }
    }

    return dp[str.length()][pat.length()];
  }
}
