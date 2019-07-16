package common.utils;

public class ListNode {
  public int data;
  public ListNode next;
  public ListNode random;

  public ListNode() {}

  public ListNode(int data) {
    next = null;
    this.data = data;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public ListNode getNext() {
    return next;
  }

  public void setNext(ListNode next) {
    this.next = next;
  }

  public ListNode getRandom() {
    return random;
  }

  public void setRandom(ListNode random) {
    this.random = random;
  }
}
