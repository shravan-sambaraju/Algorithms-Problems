package problems.stringsandarrays;

/*
 * Implement basic string compression using the counts of repeated consecutive characters (for
 * example, 'aabcccccaaa' becomes 'a2b1c5a3'), returning the original string if compression does
 * not reduce its length.
 */
class StringCompression1 {

  private static String compressBad(String str) {
    String compressedString = "";
    int countConsecutive = 0;
    for (int i = 0; i < str.length(); i++) {
      countConsecutive++;
      if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
        compressedString += "" + str.charAt(i) + countConsecutive;
        countConsecutive = 0;
      }
    }
    return compressedString.length() < str.length() ? compressedString : str;
  }

  public static void main(String[] args) {
    String str = "aa";
    System.out.println(str);
    System.out.println(compressBad(str));
  }
}
