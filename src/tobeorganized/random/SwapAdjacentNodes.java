package tobeorganized.random;

import common.utils.ListNode;

/*
 * Given a linked list, swap every two adjacent nodes and return its head.
 */
class SwapAdjacentNodes {

  public ListNode swapPairs(ListNode head) {
    if (head == null || head.getNext() == null) {
      return head;
    }
    ListNode n = head.getNext();
    head.setNext(swapPairs(head.getNext().getNext()));
    n.setNext(head);
    return n;
  }
}
