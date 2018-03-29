package problems.linkedlist;

/* Remove duplicates from linkedlist */

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesFromLinkedList {

	class ListNode {
		int data;
		ListNode next;

		public ListNode() {

		}

		public ListNode(int data) {
			next = null;
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public ListNode getNext() {
			return next;
		}

		public void setNext(ListNode next) {
			this.next = next;
		}

	}

	public static void removeDuplicates(ListNode head) {
		ListNode curr = head;
		if (curr == null || curr.getNext() == null) {
			return; // 0 or 1 nodes in the list so no duplicates
		}
		ListNode curr2;
		ListNode prev;
		while (curr != null) {
			curr2 = curr.getNext();
			prev = curr;
			while (curr2 != null) {
				// check and see if curr and curr2 values are the same, if they
				// are then delete curr2
				if (curr.getData() == curr2.getData()) {
					prev.setNext(curr2.getNext());
				}
				prev = curr2;
				curr2 = curr2.getNext();
			}
			curr = curr.getNext();
		}

		while (head != null) {
			System.out.println(head.getData());
			head = head.getNext();
		}
	}

	public static void removeDuplicatesHashing(ListNode head) {
		Map<Integer, Boolean> mapper = new HashMap<Integer, Boolean>();
		ListNode curr = head;
		ListNode next;
		while (curr.getNext() != null) {
			next = curr.getNext();
			if (mapper.get(next.getData()) != null) {
				// already seen it, so delete
				curr.setNext(next.getNext());
			} else {
				mapper.put(next.getData(), true);
				curr = curr.getNext();
			}
		}

		while (head != null) {
			System.out.println(head.getData());
			head = head.getNext();
		}
	}

	public static void main(String[] args) {
		RemoveDuplicatesFromLinkedList removeDuplicatesFromLinkedList = new RemoveDuplicatesFromLinkedList();
		ListNode node = removeDuplicatesFromLinkedList.new ListNode();
		node.setData(1);
		ListNode node1 = removeDuplicatesFromLinkedList.new ListNode();
		node1.setData(2);
		node.setNext(node1);
		ListNode node2 = removeDuplicatesFromLinkedList.new ListNode();
		node2.setData(3);
		node1.setNext(node2);
		ListNode node3 = removeDuplicatesFromLinkedList.new ListNode();
		node3.setData(4);
		node2.setNext(node3);
		ListNode node4 = removeDuplicatesFromLinkedList.new ListNode();
		node4.setData(5);
		node3.setNext(node4);
		ListNode node5 = removeDuplicatesFromLinkedList.new ListNode();
		node5.setData(5);
		node4.setNext(node5);
		ListNode node6 = removeDuplicatesFromLinkedList.new ListNode();
		node6.setData(7);
		node5.setNext(node6);
		ListNode node7 = removeDuplicatesFromLinkedList.new ListNode();
		node7.setData(3);
		node6.setNext(node7);
		ListNode node8 = removeDuplicatesFromLinkedList.new ListNode();
		node8.setData(9);
		node7.setNext(node8);

		removeDuplicates(node);

		System.out.println("***********");

		ListNode node11 = removeDuplicatesFromLinkedList.new ListNode();
		node11.setData(2);
		ListNode node12 = removeDuplicatesFromLinkedList.new ListNode();
		node12.setData(4);
		node11.setNext(node12);
		ListNode node13 = removeDuplicatesFromLinkedList.new ListNode();
		node13.setData(4);
		node12.setNext(node13);
		ListNode node14 = removeDuplicatesFromLinkedList.new ListNode();
		node14.setData(8);
		node13.setNext(node14);

		removeDuplicatesHashing(node11);

	}

}
