package tobeorganized.random;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class MaxElementInKSlidingWindow {

  // brute force
  private static void printKMax(int[] array, int n, int k) {
    int j, max;

    for (int i = 0; i <= n - k; i++) {
      max = array[i];
      for (j = 1; j < k; j++) {
        if (array[i + j] > max) {
          max = array[i + j];
        }
      }
      System.out.println(max);
    }
  }

  // using queue
  public static int[] maxSlidingWindow(int[] a, int k) {
    if (a == null || k <= 0) {
      return new int[0];
    }
    int n = a.length;
    int[] r = new int[n - k + 1];
    int ri = 0;

    Deque<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < a.length; i++) {

      while (!q.isEmpty() && q.peek() < i - k + 1) {
        q.poll();
      }

      while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
        q.pollLast();
      }

      q.offer(i);
      if (i >= k - 1) {
        r[ri++] = a[q.peek()];
      }
    }
    return r;
  }

  public static void main(String args[]) {
    int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int k = 3;
    printKMax(arr, arr.length, k);
    System.out.println(Arrays.toString(maxSlidingWindow(arr, 3)));
  }
}
