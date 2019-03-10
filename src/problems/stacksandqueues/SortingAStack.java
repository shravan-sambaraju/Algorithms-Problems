package problems.stacksandqueues;

/** Sort a given stack */

import java.util.Stack;

class SortingAStack {

  private static Stack sortStack(Stack<Integer> s) {

    if (!s.isEmpty()) {
      int x = s.pop();
      sortStack(s);
      sortedInsert(s, x);
    }
    return s;
  }

  private static void sortedInsert(Stack<Integer> s, int x) {
    if (s.isEmpty() || x > s.peek()) {
      s.push(x);
      return;
    }
    int temp = s.pop();
    sortedInsert(s, x);
    s.push(temp);
  }

  public static void main(String args[]) {
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(4);
    stack.push(3);
    stack.push(2);
    stack.push(1);

    System.out.println(stack.toString());
    Stack sorted = sortStack(stack);
    System.out.println(sorted.toString());
  }
}
