package tobeorganized.stringsandarrays;

public class StringToIntegerReverseInteger {

  public static int stringToInteger(String s) {
    int result = 0;

    for (int i = 0; i < s.length(); i++) {
      result = result * 10;
      int temp = s.charAt(i) - '0';
      result = result + temp;
    }

    return result;
  }

  public static int reverseInteger(int value) {
    int result = 0;
    while (value != 0) {
      int tail = value % 10;
      int newResult = result * 10 + tail;
      if ((newResult - tail) / 10 != result) {
        return 0;
      }
      result = newResult;
      value = value / 10;
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(reverseInteger(-123));
    System.out.println(reverseInteger(321));
    System.out.println(stringToInteger("321"));
    System.out.println(stringToInteger("123"));
  }
}
