package tobeorganized.random;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestSubStringWithBalancedParanthesis {

  public static int longestMatchingParanthesis(String s) {
    int maxLength = 0, end = -1;
    Deque<Integer> leftIndex = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        leftIndex.addFirst(i);
      } else if (leftIndex.isEmpty()) {
        end = i;
      } else {
        leftIndex.removeFirst();
        int start = leftIndex.isEmpty() ? end : leftIndex.peekFirst();
        maxLength = Math.max(maxLength, i - start);
      }
    }

    return maxLength;
  }

  // constant space

  private static int longestMatchingParenthesesConstantSpace(String s) {
    return Math.max(
        parseFromSide(s, '(', 0, s.length(), 1), parseFromSide(s, ')', s.length() - 1, -1, -1));
  }

  private static int parseFromSide(String s, char paren, int begin, int end, int dir) {
    int maxLength = 0, numParensSoFar = 0, length = 0;
    for (int i = begin; i != end; i += dir) {
      if (s.charAt(i) == paren) {
        ++numParensSoFar;
        ++length;
      } else { // s.charAt(i) != paren
        if (numParensSoFar <= 0) {
          numParensSoFar = length = 0;
        } else {
          --numParensSoFar;
          ++length;
          if (numParensSoFar == 0) {
            maxLength = Math.max(maxLength, length);
          }
        }
      }
    }
    return maxLength;
  }

  public static void main(String[] args) {}
}
