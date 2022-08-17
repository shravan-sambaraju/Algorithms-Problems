package problems.trees;

import java.util.*;

public class Trails {

  // Program to count the frequency of the elements in a List

  public static void main(String[] args) {

    List<String> list =
        Arrays.asList(
            "hershey",
            "kitkat",
            "kitkat",
            "butterfinger",
            "hershey",
            "kitkat",
            "hershey",
            "hershey");

    Map<String, Integer> coreMap = new HashMap<>();

    for (String item : list) {
      if (coreMap.get(item) == null) {
        coreMap.put(item, 0);
      }
      coreMap.put(item, coreMap.get(item) + 1);
    }

    String maxKey = null;
    int maxValue = 0;

    for (Map.Entry<String, Integer> entry : coreMap.entrySet()) {
      if (entry.getValue() > maxValue) {
        maxValue = entry.getValue();
        maxKey = entry.getKey();
      }
    }

    System.out.println(coreMap.toString());
    System.out.println(maxKey + " " + maxValue);

    List<List<String>> pairs = new ArrayList<>();

    for (int i = 0; i < maxValue; i++) {
      List<String> sublist = new ArrayList<>();
      Iterator<Map.Entry<String, Integer>> it = coreMap.entrySet().iterator();
      while (it.hasNext()) {
        Map.Entry<String, Integer> entry = it.next();
        String item = entry.getKey();
        Integer value = entry.getValue();

        if (value == 1) {
          it.remove();
          coreMap.remove(item);
        } else {
          coreMap.replace(item, value, value - 1);
        }

        sublist.add(item);
      }
      pairs.add(sublist);
    }

    for (List<String> list1 : pairs) {
      System.out.println(list1);
    }
  }
}
