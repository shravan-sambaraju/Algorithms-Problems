package tobeorganized.linkedlist;

import common.utils.ListNode;

import java.util.LinkedList;

public class ReverseEvenNodesInLinkedList {

  public static ListNode reverseEvenNodes(ListNode head) {

    ListNode evenList = null;
    ListNode curr = head;

    while (curr != null && curr.next != null) {
      ListNode even = curr.next;
      curr.next = even.next;
      even.next = evenList;
      evenList = even;
      curr = curr.next;
    }

    return mergeList(head, evenList);
  }

  private static ListNode mergeList(ListNode head, ListNode evenList) {

    if (evenList == null) {
      return head;
    }
    if (head == null) {
      return evenList;
    }

    ListNode finalList = head;

    while (head.next != null && evenList != null) {
      ListNode temp = evenList;
      evenList = evenList.next;
      temp.next = head.next;
      head.next = temp;
      head = temp.next;
    }
    if (head.next == null) {
      head.next = evenList;
    }

    return finalList;
  }

  public static void main(String[] args) {
    //
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

    ListNode reversed = reverseEvenNodes(node);

    while (reversed != null) {
      System.out.print(reversed.getData());
      reversed = reversed.getNext();
    }
  }
}
