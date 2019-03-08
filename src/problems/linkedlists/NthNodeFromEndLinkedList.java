package problems.linkedlists;

/* Fetch Nth Node from the end of linkedlist */

import common.utils.ListNode;

class NthNodeFromEndLinkedList {

  int count;

  private static ListNode nthNodeFromEndIterative(ListNode head, int Nth) {
    if (head == null) {
      return null;
    }
    ListNode nth = head;
    for (int i = 0; i < Nth; i++) {
      if (nth == null) {
        return null;
      }
      nth = nth.getNext();
    }

    while (nth != null) {
      nth = nth.getNext();
      head = head.getNext();
    }
    return head;
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

    NthNodeFromEndLinkedList nthClass = new NthNodeFromEndLinkedList();
    System.out.println((nthClass.getNthLastNodeFromLinkListRecursive(node, 1)));

    NthNodeFromEndLinkedList nthClass1 = new NthNodeFromEndLinkedList();
    System.out.println(nthClass1.getNthLastNodeFromLinkListRecursive(node, 2));

    NthNodeFromEndLinkedList nthClass2 = new NthNodeFromEndLinkedList();
    System.out.println(nthClass2.getNthLastNodeFromLinkListRecursive(node, 3));
    System.out.println("************");

    System.out.println((nthNodeFromEndIterative(node, 1)).getData());
    System.out.println((nthNodeFromEndIterative(node, 2)).getData());
    System.out.println((nthNodeFromEndIterative(node, 3)).getData());
  }

  private int getNthLastNodeFromLinkListRecursive(ListNode startNode, int nodeFromLast) {
    if (startNode == null) {
      return -1;
    }

    int data = getNthLastNodeFromLinkListRecursive(startNode.getNext(), nodeFromLast);
    count++;
    if (count == nodeFromLast) {
      return startNode.getData();
    }
    return data;
  }
}
