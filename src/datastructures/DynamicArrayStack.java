package datastructures;

/** Java implementation of dynamic stack using array */
class DynamicArrayStack {
  private static final int CAPACITY = 16;
  private static int MINCAPACITY = 1 << 15;
  private int capacity;
  private int[] stackRep;

  private int top = -1;

  public DynamicArrayStack() {
    this(CAPACITY);
  }

  public DynamicArrayStack(int cap) {
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
      expand();
    }
    stackRep[++top] = data;
  }

  private void expand() {
    int length = size();
    int[] newstack = new int[length << 1];
    System.arraycopy(stackRep, 0, newstack, 0, length);
    stackRep = newstack;
    this.capacity = this.capacity << 1;
  }

  private void shrink() {
    int length = top + 1;
    if (length <= MINCAPACITY || top << 2 >= length) {
      return;
    }
    length = length + (top << 1);
    if (top < MINCAPACITY) {
      length = MINCAPACITY;
    }
    int[] newStack = new int[length];
    System.arraycopy(stackRep, 0, newStack, 0, top + 1);
    stackRep = newStack;
    capacity = length;
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
    shrink();
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
