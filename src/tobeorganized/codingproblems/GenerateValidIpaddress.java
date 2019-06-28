package tobeorganized.codingproblems;

import java.util.ArrayList;
import java.util.List;

class GenerateValidIpaddress {

  public static List<String> validateAddress(String s) {
    List<String> result = new ArrayList<>();
    for (int i = 1; i < 4 && i < s.length(); i++) {
      final String first = s.substring(0, i);
      if (isValidPart(first)) {
        for (int j = 1; i + j < s.length(); j++) {
          final String second = s.substring(i, j + i);
          if (isValidPart(second)) {
            for (int k = 1; i + j + k < s.length() && k < 4; k++) {
              final String third = s.substring(k, j + i + k);
              final String fourth = s.substring(j + i + k);
              if (isValidPart(third) && isValidPart(fourth)) {
                result.add(first + "." + second + "." + third + "." + fourth);
              }
            }
          }
        }
      }
    }
    return result;
  }

  private static boolean isValidPart(String s) {
    if (s.length() > 3) {
      return false;
    }
    if (s.startsWith("0") && s.length() > 1) {
      return false;
    }
    int val = Integer.parseInt(s);
    return val < 255 && val >= 0;
  }

  public static void main(String[] args) {}
}
