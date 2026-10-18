package tobeorganized.random;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * Given two lists of strings list1 and list2, find the common strings with the least index sum. If
 * there is a choice tie between answers, output all of them with no order requirement.
 */
class CommonStringsWithMinIndexCombined {

  public String[] findRestaurant(String[] list1, String[] list2) {
    Map<String, Integer> map = new HashMap<>();
    List<String> res = new LinkedList<>();
    int minSum = Integer.MAX_VALUE;
    for (int i = 0; i < list1.length; i++) {
      map.put(list1[i], i);
    }
    for (int i = 0; i < list2.length; i++) {
      Integer j = map.get(list2[i]);
      if (j != null && i + j <= minSum) {
        if (i + j < minSum) {
          res.clear();
          minSum = i + j;
        }
        res.add(list2[i]);
      }
    }
    return res.toArray(new String[res.size()]);
  }
}
