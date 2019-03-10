package problems.recursion;

/** Check if given paranthesis are properly closed */

import java.util.ArrayList;

class ParanthesisCombination {
  private static void addParen(
      ArrayList<String> list, int leftRem, int rightRem, char[] str, int index) {
    if (leftRem < 0 || rightRem < leftRem) {
      return;
    }
    if (leftRem == 0 && rightRem == 0) {
      list.add(String.copyValueOf(str));
    } else {
      if (leftRem > 0) {
        str[index] = '(';
        addParen(list, leftRem - 1, rightRem, str, index + 1);
      }
      if (rightRem > leftRem) {
        str[index] = ')';
        addParen(list, leftRem, rightRem - 1, str, index + 1);
      }
    }
  }

  private static ArrayList<String> generateParens(int count) {
    char[] str = new char[count * 2];
    ArrayList<String> list = new ArrayList<String>();
    addParen(list, count, count, str, 0);
    return list;
  }

  public static void main(String[] args) {
    ArrayList<String> list = generateParens(6);
    for (String s : list) {
      System.out.println(s);
    }
    System.out.println(list.size());
  }
}
