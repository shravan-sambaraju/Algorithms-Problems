package algorithms.sorting;

/* Java implementation of insertion sort */

import java.util.ArrayList;
import java.util.List;

class InsertionSort {

  public static void main(String[] args) {
    List<Integer> normalList = new ArrayList<Integer>();

    normalList.add(1);
    normalList.add(7);
    normalList.add(6);
    normalList.add(4);
    normalList.add(9);
    normalList.add(2);
    insertionSort(normalList);
    System.out.println(normalList.toString());
  }

  private static ArrayList<Integer> insertionSort(List<Integer> normalList) {
    int i, j, key, temp;
    for (i = 1; i < normalList.size(); i++) {
      key = normalList.get(i);
      j = i - 1;
      while (j > 0 && key < normalList.get(j)) {
        temp = normalList.get(j);
        normalList.set(j, normalList.get(j + 1));
        normalList.set(j + 1, temp);
        j--;
      }
    }
    return (ArrayList<Integer>) normalList;
  }
}
