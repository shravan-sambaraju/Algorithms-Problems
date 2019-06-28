package tobeorganized.random;

import common.utils.ListNode;

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
