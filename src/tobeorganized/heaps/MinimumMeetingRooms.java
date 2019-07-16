package tobeorganized.heaps;

import common.utils.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumMeetingRooms {

  public static int findMinimumMeetingRooms(List<Interval> meetings) {
    if (meetings == null || meetings.size() == 0) return 0;

    // sort the meetings by start time
    Collections.sort(meetings, (a, b) -> Integer.compare(a.start, b.start));

    int minRooms = 0;
    PriorityQueue<Interval> minHeap =
        new PriorityQueue<>(meetings.size(), (a, b) -> Integer.compare(a.end, b.end));
    for (Interval meeting : meetings) {
      // remove all meetings that have ended
      while (!minHeap.isEmpty() && meeting.start >= minHeap.peek().end) minHeap.poll();
      // add the current meeting into the minHeap
      minHeap.offer(meeting);
      // all active meeting are in the minHeap, so we need rooms for all of them.
      minRooms = Math.max(minRooms, minHeap.size());
    }
    return minRooms;
  }

  public static void main(String[] args) {
    List<Interval> input =
        new ArrayList<Interval>() {
          {
            add(new Interval(4, 5));
            add(new Interval(2, 3));
            add(new Interval(2, 4));
            add(new Interval(3, 5));
          }
        };
    int result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
    System.out.println("Minimum meeting rooms required: " + result);

    input =
        new ArrayList<Interval>() {
          {
            add(new Interval(1, 4));
            add(new Interval(2, 5));
            add(new Interval(7, 9));
          }
        };
    result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
    System.out.println("Minimum meeting rooms required: " + result);

    input =
        new ArrayList<Interval>() {
          {
            add(new Interval(6, 7));
            add(new Interval(2, 4));
            add(new Interval(8, 12));
          }
        };
    result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
    System.out.println("Minimum meeting rooms required: " + result);

    input =
        new ArrayList<Interval>() {
          {
            add(new Interval(1, 4));
            add(new Interval(2, 3));
            add(new Interval(3, 6));
          }
        };
    result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
    System.out.println("Minimum meeting rooms required: " + result);

    input =
        new ArrayList<Interval>() {
          {
            add(new Interval(4, 5));
            add(new Interval(2, 3));
            add(new Interval(2, 4));
            add(new Interval(3, 5));
          }
        };
    result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
    System.out.println("Minimum meeting rooms required: " + result);
  }
}
