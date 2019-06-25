package tobeorganized.random;

class MinimumStepsToReachEndOfArray {

  public static boolean canReachEnd(int[] maxAdvanceSteps) {

    int furthestReachSoFar = 0, lastIndex = maxAdvanceSteps.length - 1;
    for (int i = 0; i <= furthestReachSoFar && furthestReachSoFar < lastIndex; ++i) {
      furthestReachSoFar = Math.max(furthestReachSoFar, i + maxAdvanceSteps[i]);
    }
    return furthestReachSoFar >= lastIndex;
  }

  public static void main(String[] args) {}
}
