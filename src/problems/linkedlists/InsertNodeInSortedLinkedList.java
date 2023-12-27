package problems.linkedlists;

/* Insert node in a sorted linkedlist */
import common.utils.ListNode;

class InsertNodeInSortedLinkedList {

  private static ListNode insertNode(ListNode head, ListNode newNode) {
    ListNode current = head;
    ListNode temp = head;
    if (head == null) {
      head = newNode;
    }
    while (current != null && current.getData() < newNode.getData()) {
      temp = current;
      current = current.getNext();
    }
    newNode.setNext(current);
    temp.setNext(newNode);
    return head;
  }

  public static void main(String args[]) {

    ListNode node = new ListNode();
    node.setData(1);
    ListNode node2 = new ListNode();
    node2.setData(2);
    node.setNext(node2);
    ListNode node3 = new ListNode();
    node3.setData(4);
    node2.setNext(node3);
    ListNode node4 = new ListNode();
    node4.setData(5);
    node3.setNext(node4);

    ListNode newNode = new ListNode();
    newNode.setData(3);

    ListNode insertedNode = insertNode(node, newNode);

    while (insertedNode != null) {
      System.out.println(insertedNode.getData());
      insertedNode = insertedNode.getNext();
    }
  }
}
