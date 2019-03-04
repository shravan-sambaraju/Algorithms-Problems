package problems.linkedlist;

/* Reverse given singly linkedlist */

import common.utils.ListNode;

class ReverseSinglyLinkedList {

    private static ListNode reverseListIterative(ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            ListNode next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        return prev;
    }

    private static ListNode ReverseLinkedList(ListNode head) {

        if (head == null || head.getNext() == null) {
            return head;
        }

        ListNode second = head.getNext();
        head.setNext(null);
        ListNode reversed = ReverseLinkedList(second);
        second.setNext(head);
        return reversed;
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

        ListNode node11 = new ListNode();
        node11.setData(1);
        ListNode node12 = new ListNode();
        node12.setData(2);
        node11.setNext(node12);
        ListNode node13 = new ListNode();
        node13.setData(3);
        node12.setNext(node13);
        ListNode node14 = new ListNode();
        node14.setData(4);
        node13.setNext(node14);

        ListNode nodeList1 = node;
        ListNode nodeList2 = node11;

        while (node != null) {
            node = node.getNext();
        }

        ListNode reverserdNodeRecursive = ReverseLinkedList(nodeList2);
        while (reverserdNodeRecursive != null) {
            System.out.println(reverserdNodeRecursive.getData());
            reverserdNodeRecursive = reverserdNodeRecursive.getNext();
        }
        System.out.println("*********");
        ListNode reversedNode = reverseListIterative(nodeList1);

        while (reversedNode != null) {
            System.out.println(reversedNode.getData());
            reversedNode = reversedNode.getNext();
        }
    }
}
