package problems.stringsandarrays;

/*
 * Implement a method to perform basic string compression using a StringBuilder to count repeated
 * consecutive characters (e.g., 'aabcccccaaa' -> 'a2b1c5a3'), returning the original string if the
 * compressed version is not shorter.
 */
class StringCompression2 {

  private static String compress(String str) {
    StringBuilder compressed = new StringBuilder();
    int countConsecutive = 0;
    for (int i = 0; i < str.length(); i++) {
      countConsecutive++;
      if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
        compressed.append(str.charAt(i));
        compressed.append(countConsecutive);
        countConsecutive = 0;
      }
    }
    return compressed.length() < str.length() ? compressed.toString() : str;
  }

  public static void main(String[] args) {
    String str = "aaa";
    System.out.println(str);
    System.out.println(compress(str));
  }
}
