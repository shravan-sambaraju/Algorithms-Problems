package tobeorganized.random;

public class StringToIntInterconversion {

  static int x = 0;

  public static String intToString(int x) {

    boolean isNegative = false;
    if (x < 0) {
      isNegative = true;
    }

    StringBuilder s = new StringBuilder();
    do {
      s.append((char) ('0' + Math.abs(x % 10)));
      x /= 10;
    } while (x != 0);

    return s.append(isNegative ? "-" : "").reverse().toString();
  }

  public static String intToStringRecursive(int x) {
    StringBuilder s = new StringBuilder();
    intToStringRecursiveHelper(x, s);
    return s.reverse().toString();
  }

  public static void intToStringRecursiveHelper(int x, StringBuilder sb) {
    if (x == 0) {
      return;
    }
    sb.append((char) ('0' + Math.abs(x % 10)));
    intToStringRecursiveHelper(x / 10, sb);
  }

  public static int stringToIntIterative(String s) {

    int number = 0;
    for (int i = 0; i < s.length(); i++) {
      number = 10 * number + (int) (s.charAt(i) - '0');
    }

    return number;
  }

  public static int stringToIntRecursive(String s) {
    if (s.length() == 1) {
      return x = 10 * x + (s.charAt(0) - '0');
    } else {
      x = 10 * x + (s.charAt(0) - '0');
      stringToIntRecursive(s.substring(1, s.length()));
    }
    return x;
  }

  public static void main(String[] args) {
    System.out.println(stringToIntIterative("19080"));
    System.out.println(stringToIntRecursive("19080"));
    System.out.println(intToString(19080));
    System.out.println(intToStringRecursive(19080));
  }
}
