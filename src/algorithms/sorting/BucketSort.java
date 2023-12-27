package algorithms.sorting;

/* Java implementation of Bucket sort */
import java.util.Random;

import static common.utils.UtilMethods.intArrayToString;

class BucketSort {

  private static int[] sort(int[] sequence, int maxValue) {
    int[] Bucket = new int[maxValue + 1];
    int[] sorted_sequence = new int[sequence.length];

    for (int i = 0; i < sequence.length; i++) {
      Bucket[sequence[i]]++;
    }

    int outPos = 0;
    for (int i = 0; i < Bucket.length; i++) {
      for (int j = 0; j < Bucket[i]; j++) {
        sorted_sequence[outPos++] = i;
      }
    }
    return sorted_sequence;
  }

  private static int maxValue(int[] sequence) {
    int maxValue = 0;
    for (int i = 0; i < sequence.length; i++) {
      if (sequence[i] > maxValue) {
        maxValue = sequence[i];
      }
    }
    return maxValue;
  }

  public static void main(String args[]) {
    System.out.println("Sorting of randomly generated numbers using BUCKET SORT");
    Random random = new Random();
    int N = 20;
    int[] sequence = new int[N];
    for (int i = 0; i < N; i++) {
      sequence[i] = Math.abs(random.nextInt(100));
    }
    int maxValue = maxValue(sequence);
    System.out.println("\nOriginal Sequence: ");
    System.out.println(intArrayToString(sequence));
    System.out.println("\nSorted Sequence: ");
    System.out.println(intArrayToString(sort(sequence, maxValue)));
  }
}
