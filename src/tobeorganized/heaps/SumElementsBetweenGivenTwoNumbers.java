package tobeorganized.heaps;

import java.util.PriorityQueue;

public class SumElementsBetweenGivenTwoNumbers {
  public static int findSumOfElements(int[] nums, int k1, int k2) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
    // insert all numbers to the min heap
    for (int i = 0; i < nums.length; i++) minHeap.add(nums[i]);

    // remove k1 small numbers from the min heap
    for (int i = 0; i < k1; i++) minHeap.poll();

    int elementSum = 0;
    // sum next K2-1 numbers
    for (int i = 0; i < k2 - k1 - 1; i++) elementSum += minHeap.poll();

    return elementSum;
  }

  public static void main(String[] args) {
    int result =
        SumElementsBetweenGivenTwoNumbers.findSumOfElements(new int[] {1, 3, 12, 5, 15, 11}, 3, 6);
    System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);

    result = SumElementsBetweenGivenTwoNumbers.findSumOfElements(new int[] {3, 5, 8, 7}, 1, 4);
    System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);
  }
}
