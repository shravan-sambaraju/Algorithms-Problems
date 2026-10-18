package problems.stacksandqueues;

import java.util.Stack;

/*
 * Write a program to sort a stack such that the smallest items are on the top. You can use an
 * additional temporary stack, but you may not copy the elements into any other data structure
 * (such as an array).
 */
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

  public static void sortStackInterative(Stack<Integer> stack) {
    // Write -- Your -- Code
    Stack<Integer> newStack = new Stack<>();

    while (!stack.isEmpty()) {
      Integer value = stack.pop();
      if (!newStack.isEmpty() && value >= newStack.peek()) {
        newStack.push(value);
      } else {
        while (!newStack.isEmpty() && newStack.peek() > value) {
          stack.push(newStack.pop());
        }
        newStack.push(value);
      }
    }

    while (!newStack.isEmpty()) stack.push(newStack.pop());
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

    Stack sortedIterative = sortStack(stack);
    System.out.println(sortedIterative.toString());
  }
}
