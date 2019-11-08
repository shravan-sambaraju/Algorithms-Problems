package tobeorganized.random;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnSameLine {

  public static int maxPoints(int[][] points) {
    if (points.length < 3) return points.length;
    int max = 0;
    HashMap<Long, Integer> map = new HashMap<Long, Integer>();
    for (int i = 0; i < points.length; i++) {
      int dup = 1;
      map.clear();
      for (int j = i + 1; j < points.length; j++) {
        int dx = points[j][0] - points[i][0], dy = points[j][1] - points[i][1];
        if (dx == 0 && dy == 0) dup++;
        else {
          int gcd = getGcd(dx, dy);
          long slope = ((long) (dy / gcd) << 32) + (dx / gcd);
          map.put(slope, map.getOrDefault(slope, 0) + 1);
        }
      }
      max = Math.max(max, dup);
      for (Map.Entry<Long, Integer> entry : map.entrySet())
        max = Math.max(max, entry.getValue() + dup);
    }
    return max;
  }

  static int getGcd(int a, int b) {
    return b == 0 ? a : getGcd(b, a % b);
  }

  public static void main(String[] args) {
    int[][] array = new int[][] {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
    System.out.println(maxPoints(array));
  }
}
