package algorithms.sorting;

/* Sort string anagrams next to each other */

import java.util.Arrays;
import java.util.Comparator;

import static common.utils.UtilMethods.stringArrayToString;

class SortAnagramsNextToEachOther {

  public static void main(String[] args) {
    String[] array = {
      "apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"
    };
    System.out.println(stringArrayToString(array));
    SortAnagramsNextToEachOther sort = new SortAnagramsNextToEachOther();
    Arrays.sort(array, sort.new AnagramComparator());
    System.out.println(stringArrayToString(array));
  }

  private class AnagramComparator implements Comparator<String> {
    private String sortChars(String s) {
      char[] content = s.toCharArray();
      Arrays.sort(content);
      return new String(content);
    }

    public int compare(String s1, String s2) {
      return sortChars(s1).compareTo(sortChars(s2));
    }
  }
}
