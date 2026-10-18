package problems.stacksandqueues;

import java.util.Stack;

/*
 * Implement a MyQueue class which implements a FIFO queue using two stacks.
 */
class QueueWithTwoStacks<T> {
  private Stack<T> S1 = new Stack<T>();
  private Stack<T> S2 = new Stack<T>();

  private void enqueue(T data) {
    S1.push(data);
  }

  private T dequeue() {
    if (S2.empty()) {
      while (!S1.isEmpty()) {
        S2.push(S1.pop());
      }
    }
    return S2.pop();
  }
}
