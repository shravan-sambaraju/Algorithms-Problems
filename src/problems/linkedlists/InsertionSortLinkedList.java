package problems.linkedlists;

/** Sort given linkedlist using insertion sort */
import common.utils.ListNode;

class InsertionSortLinkedList {

  private static ListNode insertionSortList(ListNode head) {
    if (head == null || head.getNext() == null) {
      return head;
    }

    ListNode newHead = new ListNode(head.getData());
    ListNode pointer = head.getNext();

    while (pointer != null) {
      ListNode innerPointer = newHead;
      ListNode next = pointer.getNext();

      if (pointer.getData() <= newHead.getData()) {
        ListNode oldHead = newHead;
        newHead = pointer;
        newHead.setNext(oldHead);
      } else {
        while (innerPointer.getNext() != null) {

          if (pointer.getData() > innerPointer.getData()
              && pointer.getData() <= innerPointer.getNext().getData()) {
            ListNode oldNext = innerPointer.getNext();
            innerPointer.setNext(pointer);
            pointer.setNext(oldNext);
          }
          innerPointer = innerPointer.getNext();
        }
        if (innerPointer.getNext() == null && pointer.getData() > innerPointer.getData()) {
          innerPointer.setNext(pointer);
          pointer.setNext(null);
        }
      }
      pointer = next;
    }
    return newHead;
  }

  public static void main(String args[]) {

    ListNode node = new ListNode();
    node.setData(10);
    ListNode node1 = new ListNode();
    node1.setData(9);
    node.setNext(node1);
    ListNode node2 = new ListNode();
    node2.setData(8);
    node1.setNext(node2);
    ListNode node3 = new ListNode();
    node3.setData(7);
    node2.setNext(node3);
    ListNode node4 = new ListNode();
    node4.setData(6);
    node3.setNext(node4);
    ListNode node5 = new ListNode();
    node5.setData(5);
    node4.setNext(node5);
    ListNode node6 = new ListNode();
    node6.setData(4);
    node5.setNext(node6);
    ListNode node7 = new ListNode();
    node7.setData(3);
    node6.setNext(node7);
    ListNode node8 = new ListNode();
    node8.setData(2);
    node7.setNext(node8);

    ListNode finalNode = insertionSortList(node);

    while (finalNode != null) {
      System.out.println(finalNode.getData());
      finalNode = finalNode.getNext();
    }
  }
}
