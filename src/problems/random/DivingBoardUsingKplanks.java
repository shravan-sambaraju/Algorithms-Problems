package problems.random;

/*
 * You are building a diving board by placing a bunch of planks of wood end-to-end. There are two
 * types of planks, one of length shorter and one of length longer. You must use exactly K planks of
 * wood.Write a method to generate all possible lengths for the diving board.
 */
import java.util.HashSet;

class DivingBoardUsingKplanks {
  private static int counter = 0;

  private static HashSet<Integer> allLengths(int k, int shorter, int longer) {
    counter++;
    HashSet<Integer> lengths = new HashSet<Integer>();
    for (int nShorter = 0; nShorter <= k; nShorter++) {
      int nLonger = k - nShorter;
      int length = nShorter * shorter + nLonger * longer;
      lengths.add(length);
    }
    return lengths;
  }

  public static void main(String[] args) {
    HashSet<Integer> lengths = allLengths(12, 1, 3);
    System.out.println(lengths.toString());
  }
}
