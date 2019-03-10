package datastructures;

/** Java implementation of fixed size array using stack */
class FixedSizeArrayStack {

  private static final int CAPACITY = 16;
  private int capacity;
  private int[] stackRep;

  private int top = -1;

  public FixedSizeArrayStack() {
    this(CAPACITY);
  }

  public FixedSizeArrayStack(int cap) {
    capacity = cap;
    stackRep = new int[capacity];
  }

  private int size() {
    return (top + 1);
  }

  private boolean isEmpty() {
    return (top < 0);
  }

  private void push(int data) throws Exception {
    if (size() == capacity) {
      throw new Exception("Stack is full.");
    }
    stackRep[++top] = data;
  }

  private int top() throws Exception {
    if (isEmpty()) {
      throw new Exception("Stack is empty.");
    }
    return stackRep[top];
  }

  private int pop() throws Exception {
    int data;
    if (isEmpty()) {
      throw new Exception("Stack is empty.");
    }
    data = stackRep[top];
    stackRep[top--] = Integer.MIN_VALUE;
    return data;
  }

  public String toString() {
    String s;
    s = "[";
    if (size() > 0) {
      s += stackRep[0];
    }
    if (size() > 1) {
      for (int i = 1; i <= size() - 1; i++) {
        s += ", " + stackRep[i];
      }
    }
    return s + "]";
  }
}
