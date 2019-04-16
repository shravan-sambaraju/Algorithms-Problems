package tobeorganized.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class LongestIncreasingSubsequence {
  public static List<Integer> longest_increasing_subsequence(List<Integer> sequence) {
    int N = sequence.size();

    int[] L = new int[N + 1]; // length i, ending at index M[i] of sequence

    int[] P = new int[N]; // P[i] index comes before i index of sequence

    L[1] = 0;
    P[0] = -1;
    int maxLength = 1;
    for (int i = 1; i < N; i++) {
      int val = sequence.get(i);
      int index = justLess(L, sequence, 1, maxLength, val);
      if (index == -1) {
        // nothing less

        L[1] = i;
        P[i] = -1;
      } else {
        L[index + 1] = i;
        P[i] = L[index];
        maxLength = Math.max(maxLength, index + 1);
      }
    }

    List<Integer> result = new ArrayList<>();
    int lastIndex = L[maxLength];

    while (lastIndex != -1) {
      result.add(sequence.get(lastIndex));
      lastIndex = P[lastIndex];
    }

    Collections.reverse(result);
    return result;
  }

  public static int justLess(int[] M, List<Integer> sequence, int start, int end, int val) {
    int maxLess = -1;
    while (start <= end) {
      int mid = (start + end) >> 1;
      if (sequence.get(M[mid]) < val) {
        maxLess = mid;
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return maxLess;
  }
}
