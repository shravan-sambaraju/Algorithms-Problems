package problems.stacksandqueues;

import java.util.Stack;

/*
 * How would you design a stack which, in addition to push and pop, has a function min which
 * returns the minimum element? Push, pop and min should all operate in O(1) time.
 */
class MinimumFunctionInStack {

  public static void main(String[] args) {
    MinimumFunctionInStack min = new MinimumFunctionInStack();
    StackWithMin stack = min.new StackWithMin();
    int[] array = {2, 1, 3, 1};
    for (int value : array) {
      stack.push(value);
      System.out.print(value + ", ");
    }
    System.out.println('\n');
    for (int i = 0; i < array.length; i++) {
      System.out.println("Popped " + stack.pop());
      System.out.println("New min is " + stack.min() + ", " + stack.min());
    }
  }

  private class StackWithMin extends Stack<Integer> {
    private static final long serialVersionUID = 1L;
    Stack<Integer> s2;

    public StackWithMin() {
      s2 = new Stack<Integer>();
    }

    public void push(int value) {
      if (value <= min()) {
        s2.push(value);
      }
      super.push(value);
    }

    public Integer pop() {
      int value = super.pop();
      if (value == min()) {
        s2.pop();
      }
      return value;
    }

    public int min() {
      if (s2.isEmpty()) {
        return Integer.MAX_VALUE;
      } else {
        return s2.peek();
      }
    }
  }
}
