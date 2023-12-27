package problems.random;

/*
 * Given an array filled with letters and numbers, find the longest subarray with an equal number of
 * letters and numbers.
 */
import java.util.HashMap;

class EqualLettersNumbersSubArray {

  private static int[] computeDeltaArray(char[] array) {
    int[] deltas = new int[array.length];
    int delta = 0;
    for (int i = 0; i < array.length; i++) {
      if (Character.isLetter(array[i])) {
        delta++;
      } else if (Character.isDigit(array[i])) {
        delta--;
      }
      deltas[i] = delta;
    }
    return deltas;
  }

  private static int[] findLongestMatch(int[] deltas) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    map.put(0, -1);
    int[] max = new int[2];
    for (int i = 0; i < deltas.length; i++) {
      if (!map.containsKey(deltas[i])) {
        map.put(deltas[i], i);
      } else {
        int match = map.get(deltas[i]);
        int distance = i - match;
        int longest = max[1] - max[0];
        if (distance > longest) {
          max[1] = i;
          max[0] = match;
        }
      }
    }
    return max;
  }

  private static char[] extract(char[] array, int start, int end) {
    if (start > end) {
      return null;
    }
    char[] subarray = new char[end - start + 1];
    for (int i = start; i <= end; i++) {
      subarray[i - start] = array[i];
    }
    return subarray;
  }

  private static char[] findLongestSubarray(char[] array) {

    int[] deltas = computeDeltaArray(array);
    int[] match = findLongestMatch(deltas);
    return extract(array, match[0] + 1, match[1]);
  }

  private static boolean isEqual(char[] array, int start, int end) {
    int counter = 0;
    for (int i = start; i < end; i++) {
      if (Character.isLetter(array[i])) {
        counter++;
      } else if (Character.isDigit(array[i])) {
        counter--;
      }
    }
    return counter == 0;
  }

  public static void main(String[] args) {
    char b = '1';
    char a = 'a';
    char[] array = {
      a, b, a, b, a, b, b, b, b, b, a, a, a, a, a, b, a, b, a, b, b, a, a, a, a, a, a, a
    };
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println();
    char[] max = findLongestSubarray(array);
    if (max == null) {
      System.out.println("No equal subarray");
    } else {
      System.out.println(max.length);
      for (int i = 0; i < max.length; i++) {
        System.out.print(max[i] + " ");
      }
      System.out.println("\nIs Valid? " + isEqual(max, 0, max.length));
    }
  }
}
