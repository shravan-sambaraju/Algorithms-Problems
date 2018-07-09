package problems.linkedlist;

/* Reorder given linkedlist to first and last and so on */

import java.util.LinkedList;
import common.utils.ListNode;

class ReOrderListFirstLastSecond {

	private void reorderList(ListNode head) {

		if (head == null)
			return;
		ListNode slowPointer = head;
		ListNode fastPointer = head.getNext();
		ListNode finalList = head;

		while (fastPointer != null && fastPointer.getNext() != null) {
			fastPointer = fastPointer.getNext().getNext();
			slowPointer = slowPointer.getNext();
		}

		ListNode head2 = slowPointer.getNext();
		slowPointer.setNext(null);
		LinkedList<ListNode> queue = new LinkedList<ListNode>();
		while (head2 != null) {
			ListNode temp = head2;
			head2 = head2.getNext();
			temp.setNext(null);
			queue.push(temp);
		}

		while (!queue.isEmpty()) {
			ListNode temp = queue.pop();
			temp.setNext(head.getNext());
			head.setNext(temp);
			head = head.getNext().getNext();
		}

		while (finalList != null) {
			System.out.println(finalList.getData());
			finalList = finalList.getNext();
		}
	}

	private void reOrderListTraversal(ListNode head) {
		if (head == null)
			return;
		ListNode slowPointer = head;
		ListNode fastPointer = head.getNext();

		while (fastPointer != null && fastPointer.getNext() != null) {
			fastPointer = fastPointer.getNext().getNext();
			slowPointer = slowPointer.getNext();
		}

		ListNode head2 = slowPointer.getNext();
		slowPointer.setNext(null);
		head2 = reverseList(head2);
		alternate(head, head2);

		while (head != null) {
			System.out.println(head.getData());
			head = head.getNext();
		}
	}

	private ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode reverseList = head;
		ListNode pointer = head.getNext();
		reverseList.setNext(null);
		while (pointer != null) {
			ListNode temp = pointer;
			pointer = pointer.getNext();
			temp.setNext(reverseList);
			reverseList = temp;
		}
		return reverseList;
	}

	private void alternate(ListNode head1, ListNode head2) {
		ListNode pointer = head1;
		head1 = head1.getNext();
		boolean nextList1 = false;
		while (head1 != null || head2 != null) {
			if ((head2 != null && !nextList1) || (head1 == null)) {
				pointer.setNext(head2);
				head2 = head2.getNext();
				nextList1 = true;
				pointer = pointer.getNext();
			} else {
				pointer.setNext(head1);
				head1 = head1.getNext();
				nextList1 = false;
				pointer = pointer.getNext();
			}
		}
	}

	public static void main(String args[]) {

		ReOrderListFirstLastSecond reOrderListFirstLastSecond = new ReOrderListFirstLastSecond();

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

		reOrderListFirstLastSecond.reorderList(node);
		System.out.println("*********************");

		ListNode node11 = new ListNode();
		node11.setData(2);
		ListNode node12 = new ListNode();
		node12.setData(4);
		node11.setNext(node12);
		ListNode node13 = new ListNode();
		node13.setData(6);
		node12.setNext(node13);
		ListNode node14 = new ListNode();
		node14.setData(8);
		node13.setNext(node14);
		reOrderListFirstLastSecond.reOrderListTraversal(node11);
	}
}
