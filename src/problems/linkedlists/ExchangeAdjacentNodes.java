package problems.linkedlists;

/* Exchange adjacent nodes in linkedlist */
import common.utils.ListNode;

class ExchangeAdjacentNodes {

  private static ListNode exchangeNodes(ListNode head) {

    ListNode swapped = new ListNode();
    swapped.setNext(head);
    ListNode prev = swapped;
    ListNode current = head;
    while (current != null && current.getNext() != null) {
      ListNode temp = current.getNext().getNext();
      current.getNext().setNext(prev.getNext());
      prev.setNext(current.getNext());
      current.setNext(temp);
      prev = current;
      current = prev.getNext();
    }
    return swapped.getNext();
  }

  public static void main(String args[]) {

    ListNode node = new ListNode();
    node.setData(1);
    ListNode node1 = new ListNode();
    node1.setData(2);
    node.setNext(node1);
    ListNode node2 = new ListNode();
    node2.setData(3);
    node1.setNext(node2);
    ListNode node3 = new ListNode();
    node3.setData(4);
    node2.setNext(node3);
    ListNode node4 = new ListNode();
    node4.setData(5);
    node3.setNext(node4);
    ListNode node5 = new ListNode();
    node5.setData(6);
    node4.setNext(node5);
    ListNode node6 = new ListNode();
    node6.setData(7);
    node5.setNext(node6);
    ListNode node7 = new ListNode();
    node7.setData(8);
    node6.setNext(node7);
    ListNode node8 = new ListNode();
    node8.setData(9);
    node7.setNext(node8);

    ListNode swapped = exchangeNodes(node);

    while (swapped != null) {
      System.out.println(swapped.getData());
      swapped = swapped.getNext();
    }
  }
}
