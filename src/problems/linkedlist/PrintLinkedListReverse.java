package problems.linkedlist;

/* Print given linkedlist in reverse */

import common.utils.ListNode;

class PrintLinkedListReverse {

  private static void printInReverse(ListNode head) {
    if (head == null) {
      return;
    }
    printInReverse(head.getNext());
    System.out.println(head.getData());
  }

  public static void main(String args[]) {

    ListNode node = new ListNode();
    node.setData(1);
    ListNode node2 = new ListNode();
    node2.setData(2);
    node.setNext(node2);
    ListNode node3 = new ListNode();
    node3.setData(3);
    node2.setNext(node3);
    ListNode node4 = new ListNode();
    node4.setData(4);
    node3.setNext(node4);

    printInReverse(node);
  }
}
