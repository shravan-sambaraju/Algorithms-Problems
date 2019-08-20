package tobeorganized.stringsandarrays;

import java.util.HashMap;
import java.util.Map;

// given unsorted array find length of longest consecutive sequence
public class LongestConsecutiveSequence {
  public int longestConsecutive(int[] num) {
    int result = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int number : num) {
      if (!map.containsKey(number)) {
        int left = map.containsKey(number - 1) ? map.get(number - 1) : 0;
        int right = map.containsKey(number + 1) ? map.get(number + 1) : 0;
        int sum = left + right + 1;
        map.put(number, sum);
        result = Math.max(result, sum);
        map.put(number - left, sum);
        map.put(number + right, sum);

      } else {
        continue;
      }
    }

    return result;
  }
}
