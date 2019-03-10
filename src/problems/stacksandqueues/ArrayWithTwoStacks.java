package problems.stacksandqueues;

/** Implement array with two stacks */
import java.util.EmptyStackException;

class ArrayWithTwoStacks {

  private int[] dataArray;
  private int size, topOne, topTwo;

  public ArrayWithTwoStacks(int size) {
    if (size < 2) {
      throw new IllegalStateException();
    }
    dataArray = new int[size];
    this.size = size;
    topOne = -1;
    topTwo = size;
  }

  public static void main(String args[]) {

    ArrayWithTwoStacks array = new ArrayWithTwoStacks(8);
    array.push(1, 1);
    array.push(1, 2);
    array.push(1, 3);
    array.push(2, 6);
    array.push(2, 7);
    array.push(2, 8);
    array.pop(1);
    array.pop(2);
    for (int i : array.dataArray) {
      System.out.println(i);
    }
  }

  private void push(int stackID, int data) {
    if (topTwo == topOne + 1) {
      throw new StackOverflowError();
    }
    if (stackID == 1) {
      dataArray[++topOne] = data;
    } else if (stackID == 2) {
      dataArray[--topTwo] = data;

    } else {
      return;
    }
  }

  private int pop(int stackID) {
    if (stackID == 1) {
      if (topOne == -1) {
        throw new EmptyStackException();
      }
      int toPop = dataArray[topOne];
      dataArray[topOne--] = 0;

    } else if (stackID == 2) {
      if (topTwo == this.size) {
        throw new EmptyStackException();
      }
      int toPop = dataArray[topTwo];
      dataArray[topTwo++] = 0;
      return toPop;
    }
    return 0;
  }

  @SuppressWarnings("null")
  private int top(int stackID) {
    if (stackID == 1) {
      if (topOne == -1) {
        throw new EmptyStackException();
      }
      return dataArray[topOne];
    } else if (stackID == 2) {
      if (topTwo == this.size) {
        throw new EmptyStackException();
      }
      return dataArray[topTwo];
    }

    return (Integer) null;
  }
}
