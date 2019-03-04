package problems.linkedlist;

/* Find middle of linkedlist */

import common.utils.ListNode;

class FindMiddleOfLinkedList {

    private static ListNode getMiddleNode(ListNode head) {
        ListNode ptr1 = head, ptr2 = head;
        if (head == null) {
            return null;
        }
        while (ptr1 != null && ptr1.getNext() != null) {
            ptr1 = ptr1.getNext().getNext();
            ptr2 = ptr2.getNext();
        }
        return ptr2;
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
        ListNode node5 = new ListNode();
        node5.setData(5);
        node4.setNext(node5);

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

        System.out.println(getMiddleNode(node).getData());
        System.out.println(getMiddleNode(node11).getData());
    }
}
