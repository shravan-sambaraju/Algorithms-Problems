package tobeorganized.heaps;

import java.util.*;

public class TopKFrequentElementsInArray {

  public static List<Integer> topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int n : nums) {
      map.put(n, map.getOrDefault(n, 0) + 1);
    }

    PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
        new PriorityQueue<Map.Entry<Integer, Integer>>((e1, e2) -> e1.getValue() - e2.getValue());

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      minHeap.add(entry);
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }

    // create a list of top k numbers
    List<Integer> topNumbers = new ArrayList<>(k);
    while (!minHeap.isEmpty()) {
      topNumbers.add(minHeap.poll().getKey());
    }
    return topNumbers;
  }

  public static void main(String[] args) {
    int[] nums = {1, 1, 1, 2, 2, 3};
    System.out.println(topKFrequent(nums, 2));
  }
}
