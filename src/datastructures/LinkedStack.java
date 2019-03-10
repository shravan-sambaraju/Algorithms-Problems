package datastructures;

/** Java implementation of linked stack */
import common.utils.ListNode;

import java.util.EmptyStackException;

class LinkedStack {

  private int length;
  private ListNode top;

  public LinkedStack() {
    length = 0;
    top = null;
  }

  private void push(int data) {
    ListNode temp = new ListNode(data);
    temp.setNext(top);
    top = temp;
    length++;
  }

  private int pop() throws EmptyStackException {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    int result = top.getData();
    top = top.getNext();
    length--;
    return result;
  }

  private int peek() throws EmptyStackException {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    return top.getData();
  }

  private boolean isEmpty() {
    return (length == 0);
  }

  private int size() {
    return length;
  }

  public String toString() {
    String result = "";
    ListNode current = top;
    while (current != null) {
      result = result + current.toString() + "\n";
      current = current.getNext();
    }
    return result;
  }
}
