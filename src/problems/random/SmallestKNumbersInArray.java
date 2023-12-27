package problems.random;

/* Design an algorithm to find the smallest K numbers in an array. */
import java.util.Comparator;
import java.util.PriorityQueue;

import static common.utils.UtilMethods.intArrayToString;

class SmallestKNumbersInArray {

  private static int[] smallestK(int[] array, int k) {
    if (k <= 0 || k > array.length) {
      throw new IllegalArgumentException();
    }

    PriorityQueue<Integer> heap = getKMaxHeap(array, k);
    return heapToIntArray(heap);
  }

  private static int[] heapToIntArray(PriorityQueue<Integer> heap) {
    int[] array = new int[heap.size()];
    while (!heap.isEmpty()) {
      array[heap.size() - 1] = heap.poll();
    }
    return array;
  }

  private static PriorityQueue<Integer> getKMaxHeap(int[] array, int k) {
    PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, new MaxHeapComparator());
    for (int a : array) {
      if (heap.size() < k) {
        heap.add(a);
      } else if (a < heap.peek()) {
        heap.poll();
        heap.add(a);
      }
    }
    return heap;
  }

  public static void main(String[] args) {
    int[] array = {1, 5, 2, 9, -1, 11, 6, 13, 15};
    int[] smallest = smallestK(array, 3);
    System.out.println(intArrayToString(smallest));
  }

  private static class MaxHeapComparator implements Comparator<Integer> {
    public int compare(Integer x, Integer y) {
      return y - x;
    }
  }
}
