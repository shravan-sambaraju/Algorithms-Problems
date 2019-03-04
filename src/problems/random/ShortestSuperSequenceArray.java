package problems.random;

/* Find shortest super sequence array */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class ShortestSuperSequenceArray {

  private static Range getShortestClosure(ArrayList<Queue<Integer>> lists) {
    PriorityQueue<HeapNode> minHeap = new PriorityQueue<HeapNode>();
    int max = Integer.MIN_VALUE;
    ShortestSuperSequenceArray ss = new ShortestSuperSequenceArray();

    for (int i = 0; i < lists.size(); i++) {
      int head = lists.get(i).remove();

      minHeap.add(ss.new HeapNode(head, i));
      max = Math.max(max, head);
    }

    int min = minHeap.peek().locationWithinList;
    int bestRangeMin = min;
    int bestRangeMax = max;

    while (true) {
      HeapNode n = minHeap.poll();
      Queue<Integer> list = lists.get(n.listId);
      min = n.locationWithinList;
      if (max - min < bestRangeMax - bestRangeMin) {
        bestRangeMax = max;
        bestRangeMin = min;
      }
      if (list.size() == 0) {
        break;
      }
      n.locationWithinList = list.remove();
      minHeap.add(n);
      max = Math.max(max, n.locationWithinList);
    }
    return ss.new Range(bestRangeMin, bestRangeMax);
  }

  private static ArrayList<Queue<Integer>> getLocationsForElements(int[] big, int[] small) {
    HashMap<Integer, Queue<Integer>> itemLocations = new HashMap<Integer, Queue<Integer>>();
    for (int s : small) {
      Queue<Integer> queue = new LinkedList<Integer>();
      itemLocations.put(s, queue);
    }
    for (int i = 0; i < big.length; i++) {
      Queue<Integer> queue = itemLocations.get(big[i]);
      if (queue != null) {
        queue.add(i);
      }
    }

    ArrayList<Queue<Integer>> allLocations = new ArrayList<Queue<Integer>>();
    allLocations.addAll(itemLocations.values());
    return allLocations;
  }

  private static Range shortestSupersequence(int[] big, int[] small) {
    ArrayList<Queue<Integer>> locations = getLocationsForElements(big, small);
    if (locations == null) {
      return null;
    }
    return getShortestClosure(locations);
  }

  public static void main(String[] args) {
    int[] array = {7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7};
    int[] set = {1, 5, 9};
    System.out.println(array.length);
    Range shortest = shortestSupersequence(array, set);
    if (shortest == null) {
      System.out.println("not found");
    } else {
      System.out.println(shortest.getStart() + ", " + shortest.getEnd());
    }
  }

  private class Range {
    private int start;
    private int end;

    public Range(int s, int e) {
      start = s;
      end = e;
    }

    private int length() {
      return end - start + 1;
    }

    private boolean shorterThan(Range other) {
      return length() < other.length();
    }

    private int getStart() {
      return start;
    }

    private int getEnd() {
      return end;
    }
  }

  private class HeapNode implements Comparable<HeapNode> {
    private int locationWithinList;
    private int listId;

    private HeapNode(int location, int list) {
      locationWithinList = location;
      listId = list;
    }

    @Override
    public int compareTo(HeapNode n) {
      return locationWithinList - n.locationWithinList;
    }
  }
}
