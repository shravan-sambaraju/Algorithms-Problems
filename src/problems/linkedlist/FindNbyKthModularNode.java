package problems.linkedlist;

/* Find N by Kth modular node in linkedlist */

import common.utils.ListNode;

class FindNbyKthModularNode {

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

    FindNbyKthModularNode findNode = new FindNbyKthModularNode();
    ListNode modularNode = findNode.findNbyKthNodeFromStart(node, 3);

    System.out.println(modularNode.getData());
  }

  private ListNode findNbyKthNodeFromStart(ListNode head, int k) {
    ListNode result = null;
    int i = 0;
    if (k <= 0 || head == null) {
      return null;
    }

    for (; head != null; head = head.getNext()) {
      if (i % k == 0) {
        result = head;
      }
      i++;
    }
    return result;
  }
}
