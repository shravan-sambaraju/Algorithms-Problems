package tobeorganized.recursion;

import java.util.ArrayList;
import java.util.List;

public class GeneratePalindromicDecomposition {

  public static List<List<String>> palindromicDecompositions(String text) {
    List<List<String>> result = new ArrayList<>();
    directedPalindromicDecompositions(text, 0, new ArrayList<String>(), result);
    return result;
  }

  private static void directedPalindromicDecompositions(
      String text, int offset, ArrayList<String> partialPartition, List<List<String>> result) {
    if (offset == text.length()) {
      result.add(new ArrayList<>(partialPartition));
      return;
    }
    for (int i = offset + 1; i <= text.length(); i++) {
      String prefix = text.substring(offset, i);
      if (isPalindrome(prefix)) {
        partialPartition.add(prefix);
        directedPalindromicDecompositions(text, i, partialPartition, result);
        partialPartition.remove(partialPartition.size() - 1);
      }
    }
  }

  private static boolean isPalindrome(String prefix) {
    for (int i = 0, j = prefix.length() - 1; i < j; i++, j--) {
      if (prefix.charAt(i) != prefix.charAt(j)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(palindromicDecompositions("0204451881").toString());
  }
}
