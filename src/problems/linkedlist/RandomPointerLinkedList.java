package problems.linkedlist;

/* Clone a linkedlist with random pointer */

import common.utils.ListNode;

import java.util.HashMap;
import java.util.Map;

class RandomPointerLinkedList {

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
        node.setRandom(node3);
        node2.setRandom(node4);
        node3.setRandom(node);
        node4.setRandom(node2);

        ListNode nodetobeSent = node;

        while (node != null) {
            System.out.println(node.getData());
            System.out.println(node.getRandom().getData());
            node = node.getNext();
        }

        System.out.println("*****************");

        RandomPointerLinkedList rp = new RandomPointerLinkedList();
        ListNode random = rp.cloneUsingCopy(nodetobeSent);

        while (random != null) {
            System.out.println(random.getData());
            System.out.println(random.getRandom().getData());
            random = random.getNext();
        }

        System.out.println("*****************");

        ListNode random2 = rp.usingHashMap(nodetobeSent);

        while (random2 != null) {
            System.out.println(random2.getData());
            System.out.println(random2.getRandom().getData());
            random2 = random2.getNext();
        }
    }

    private ListNode cloneUsingCopy(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode current = head;
        while (current != null) {
            ListNode temp = new ListNode();
            temp.setData(current.getData());
            temp.setNext(current.getNext());
            current.setNext(temp);
            current = current.getNext().getNext();
        }

        current = head;
        while (current != null) {
            current.getNext().setRandom(current.getRandom().getNext());
            current = current.getNext().getNext();
        }

        ListNode copy = head.getNext();
        current = head;
        while (current.getNext() != null) {
            ListNode temp = current.getNext();
            current.setNext(current.getNext().getNext());
            current = temp;
        }
        return copy;
    }

    private ListNode usingHashMap(ListNode head) {
        ListNode X, Y;
        X = head;

        Map<ListNode, ListNode> map = new HashMap<ListNode, ListNode>();
        while (X != null) {
            Y = new ListNode();
            Y.setData(X.getData());
            Y.setNext(null);
            Y.setRandom(null);
            map.put(X, Y);
            X = X.getNext();
        }
        X = head;
        while (X != null) {
            Y = map.get(X);
            Y.setData(X.getData());
            Y.setNext(map.get(X.getNext()));
            Y.setRandom(map.get(X.getRandom()));
            X = X.getNext();
        }
        return map.get(head);
    }
}
