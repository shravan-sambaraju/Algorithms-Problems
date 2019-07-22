package problems.random;

/** Find pairs in array whose sum is k */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class PairInArrayEqualsTargetSum {

  static int arr[] = new int[] {1, 5, 7, -1, 5};

  private static ArrayList<Pair> printPairSums(int[] array, int sum) {
    ArrayList<Pair> result = new ArrayList<Pair>();
    Arrays.sort(array);
    int first = 0;
    int last = array.length - 1;
    while (first < last) {
      int s = array[first] + array[last];
      if (s == sum) {
        PairInArrayEqualsTargetSum pair = new PairInArrayEqualsTargetSum();
        result.add(pair.new Pair(array[first], array[last]));
        ++first;
        --last;
      } else {
        if (s < sum) {
          ++first;
        } else {
          --last;
        }
      }
    }
    return result;
  }

  static int getPairsCount(int n, int sum) {
    HashMap<Integer, Integer> hm = new HashMap<>();

    for (int i = 0; i < n; i++) {

      if (!hm.containsKey(arr[i])) hm.put(arr[i], 0);

      hm.put(arr[i], hm.get(arr[i]) + 1);
    }
    int twice_count = 0;

    for (int i = 0; i < n; i++) {
      if (hm.get(sum - arr[i]) != null) twice_count += hm.get(sum - arr[i]);

      if (sum - arr[i] == arr[i]) twice_count--;
    }

    return twice_count / 2;
  }

  public static void main(String[] args) {
    int[] test = {9, 3, 6, 5, 7, 7, -1, 13, 14, -2, 12, 0};
    ArrayList<Pair> pairs = printPairSums(test, 12);
    for (Pair p : pairs) {
      System.out.println(p.toString());
    }

    int sum = 6;
    System.out.println("Count of pairs is " + getPairsCount(arr.length, sum));
  }

  private class Pair {
    private int first;
    private int second;

    public Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }

    @Override
    public String toString() {
      return "(" + first + ", " + second + ")";
    }
  }
}
