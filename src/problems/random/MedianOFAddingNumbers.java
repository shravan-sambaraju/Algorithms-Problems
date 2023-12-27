package problems.random;

/*
 * Numbers are randomly generated and passed to a method. Write a program to find and maintain the
 * median value as new values are generated.
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class MedianOFAddingNumbers {

  private static Comparator<Integer> maxHeapComparator;
  private static Comparator<Integer> minHeapComparator;
  private static PriorityQueue<Integer> maxHeap;
  private static PriorityQueue<Integer> minHeap;

  private static void addNewNumber(int randomNumber) {
    if (maxHeap.size() == minHeap.size()) {
      if ((minHeap.peek() != null) && randomNumber > minHeap.peek()) {
        maxHeap.offer(minHeap.poll());
        minHeap.offer(randomNumber);
      } else {
        maxHeap.offer(randomNumber);
      }
    } else {
      if (randomNumber < maxHeap.peek()) {
        minHeap.offer(maxHeap.poll());
        maxHeap.offer(randomNumber);
      } else {
        minHeap.offer(randomNumber);
      }
    }
  }

  private static double getMedian() {
    if (maxHeap.isEmpty()) {
      return 0;
    }
    if (maxHeap.size() == minHeap.size()) {
      return ((double) minHeap.peek() + (double) maxHeap.peek()) / 2;
    } else {
      return maxHeap.peek();
    }
  }

  private static void addNewNumberAndPrintMedian(int randomNumber) {
    addNewNumber(randomNumber);
    System.out.println("Random Number = " + randomNumber);
    printMinHeapAndMaxHeap();
    System.out.println("\nMedian = " + getMedian() + "\n");
  }

  private static void printMinHeapAndMaxHeap() {
    Integer[] minHeapArray = minHeap.toArray(new Integer[minHeap.size()]);
    Integer[] maxHeapArray = maxHeap.toArray(new Integer[maxHeap.size()]);
    Arrays.sort(minHeapArray, maxHeapComparator);
    Arrays.sort(maxHeapArray, maxHeapComparator);
    System.out.print("MinHeap =");
    for (int i = minHeapArray.length - 1; i >= 0; i--) {
      System.out.print(" " + minHeapArray[i]);
    }
    System.out.print("\nMaxHeap =");
    for (int i = 0; i < maxHeapArray.length; i++) {
      System.out.print(" " + maxHeapArray[i]);
    }
  }

  public static void main(String[] args) {
    int arraySize = 10;
    int range = 7;

    MedianOFAddingNumbers md = new MedianOFAddingNumbers();
    maxHeapComparator = md.new MaxHeapComparator();
    minHeapComparator = md.new MinHeapComparator();
    maxHeap = new PriorityQueue<Integer>(arraySize - arraySize / 2, maxHeapComparator);
    minHeap = new PriorityQueue<Integer>(arraySize / 2, minHeapComparator);

    for (int i = 0; i < arraySize; i++) {
      int randomNumber = (int) (Math.random() * (range + 1));
      addNewNumberAndPrintMedian(randomNumber);
    }
  }

  private class MaxHeapComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
      // TODO Auto-generated method stub
      if (o1 < o2) {
        return 1;
      } else if (o1 == o2) {
        return 0;
      } else {
        return -1;
      }
    }
  }

  private class MinHeapComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
      if (o1 > o2) {
        return 1;
      } else if (o1 == o2) {
        return 0;
      } else {
        return -1;
      }
    }
  }
}
