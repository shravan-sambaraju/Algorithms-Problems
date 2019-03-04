package problems.linkedlist;

/* Partition linkedlist to even and odd across pivot */

import common.utils.ListNode;

class PartitionListToEvenOddPivot {

    private static ListNode partition(ListNode head, int K) {

        ListNode root = new ListNode(0);
        ListNode pivot = new ListNode(K);
        ListNode rootNext = root, pivotNext = pivot;
        ListNode currentNode = head;
        while (currentNode != null) {
            ListNode next = currentNode.getNext();
            if (currentNode.getData() >= K) {
                pivotNext.setNext(currentNode);
                pivotNext = currentNode;
                pivotNext.setNext(null);
            } else {
                rootNext.setNext(currentNode);
                rootNext = currentNode;
            }
            currentNode = next;
        }
        rootNext.setNext(pivot.getNext());
        return root.getNext();
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

        ListNode finalNode = partition(node, 5);

        while (finalNode != null) {
            System.out.println(finalNode.getData());
            finalNode = finalNode.getNext();
        }
    }
}
