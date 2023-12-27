package problems.random;

/* Generate string representation of given number */
import java.util.LinkedList;

import static common.utils.UtilMethods.randomIntInRange;

class StringRepresentationOfNum {

  private static String[] smalls = {
    "Zero",
    "One",
    "Two",
    "Three",
    "Four",
    "Five",
    "Six",
    "Seven",
    "Eight",
    "Nine",
    "Ten",
    "Eleven",
    "Twelve",
    "Thirteen",
    "Fourteen",
    "Fifteen",
    "Sixteen",
    "Seventeen",
    "Eighteen",
    "Nineteen"
  };
  private static String[] tens = {
    "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
  };
  private static String[] bigs = {"", "Thousand", "Million", "Billion"};
  private static String hundred = "Hundred";
  private static String negative = "Negative";

  private static String convert(int num) {
    if (num == 0) {
      return smalls[0];
    } else if (num < 0) {
      return negative + " " + convert(-1 * num);
    }

    LinkedList<String> parts = new LinkedList<String>();
    int chunkCount = 0;

    while (num > 0) {
      if (num % 1000 != 0) {
        String chunk = convertChunk(num % 1000) + " " + bigs[chunkCount];
        parts.addFirst(chunk);
      }
      num /= 1000;
      chunkCount++;
    }

    return listToString(parts);
  }

  private static String listToString(LinkedList<String> parts) {
    StringBuilder sb = new StringBuilder();
    while (parts.size() > 1) {
      sb.append(parts.pop());
      sb.append(" ");
    }
    sb.append(parts.pop());
    return sb.toString();
  }

  private static String convertChunk(int number) {
    LinkedList<String> parts = new LinkedList<String>();

    if (number >= 100) {
      parts.addLast(smalls[number / 100]);
      parts.addLast(hundred);
      number %= 100;
    }

    if (number >= 10 && number <= 19) {
      parts.addLast(smalls[number]);
    } else if (number >= 20) {
      parts.addLast(tens[number / 10]);
      number %= 10;
    }

    if (number >= 1 && number <= 9) {
      parts.addLast(smalls[number]);
    }
    return listToString(parts);
  }

  public static void main(String[] args) {

    for (int i = 0; i < 8; i++) {
      int value = (int) (-1 * Math.pow(10, i));
      String s = convert(value);
      System.out.println(value + ": " + s);
    }

    for (int i = 0; i < 10; i++) {
      int value = randomIntInRange(0, 100);
      String s = convert(value);
      System.out.println(value + ": " + s);
    }

    for (int i = 0; i < 10; i++) {
      int value = randomIntInRange(100, 1000);
      String s = convert(value);
      System.out.println(value + ": " + s);
    }

    for (int i = 0; i < 10; i++) {
      int value = randomIntInRange(1000, 100000);
      String s = convert(value);
      System.out.println(value + ": " + s);
    }

    for (int i = 0; i < 10; i++) {
      int value = randomIntInRange(100000, 100000000);
      String s = convert(value);
      System.out.println(value + ": " + s);
    }

    for (int i = 0; i < 10; i++) {
      int value = randomIntInRange(100000000, 1000000000);
      String s = convert(value);
      System.out.println(value + ": " + s);
    }

    for (int i = 0; i < 10; i++) {
      int value = randomIntInRange(1000000000, Integer.MAX_VALUE);
      String s = convert(value);
      System.out.println(value + ": " + s);
    }
  }
}
