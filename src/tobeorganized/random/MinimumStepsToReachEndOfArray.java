package tobeorganized.random;

/*
 * Given an array of non-negative integers where each element represents the maximum number of
 * steps that can be made forward from that element, determine if you can reach the last index and
 * find the minimum number of jumps required to reach the end of the array.
 */
class MinimumStepsToReachEndOfArray {

  // can reach end of array
  public static boolean canReachEnd(int[] maxAdvanceSteps) {

    int furthestReachSoFar = 0, lastIndex = maxAdvanceSteps.length - 1;
    for (int i = 0; i <= furthestReachSoFar && furthestReachSoFar < lastIndex; ++i) {
      furthestReachSoFar = Math.max(furthestReachSoFar, i + maxAdvanceSteps[i]);
    }
    return furthestReachSoFar >= lastIndex;
  }

  // minimum jumps to reach end of array
  public int jump(int[] A) {
    int jumps = 0, curEnd = 0, curFarthest = 0;
    for (int i = 0; i < A.length - 1; i++) {
      curFarthest = Math.max(curFarthest, i + A[i]);
      if (i == curEnd) {
        jumps++;
        curEnd = curFarthest;
      }
    }
    return jumps;
  }

  public static void main(String[] args) {}
}
