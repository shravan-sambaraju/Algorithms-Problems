package problems.linkedlist;

/* Reorder given linkedlist to first and last and so on */

import java.util.LinkedList;

public class ReOrderListFirstLastSecond {

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

	public void reorderList(ListNode head) {

		if (head == null)
			return;

		ListNode slowPointer = head;
		ListNode fastPointer = head.next;
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
			ListNode temp2 = head.getNext();
			temp.setNext(head.getNext());
			head.setNext(temp);
			head = head.getNext().getNext();

		}

		while (finalList != null) {
			System.out.println(finalList.getData());
			finalList = finalList.getNext();

		}

	}

	public void reOrderListTraversal(ListNode head) {
		if (head == null)
			return;
		ListNode slowPointer = head;
		ListNode fastPointer = head.getNext();

		while (fastPointer != null && fastPointer.getNext() != null) {
			fastPointer = fastPointer.getNext().getNext();
			slowPointer = slowPointer.getNext();

		}

		ListNode head2 = slowPointer.getNext();
		slowPointer.next = null;
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
		ListNode pointer = head.next;
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

		ListNode node = reOrderListFirstLastSecond.new ListNode();
		node.setData(1);
		ListNode node1 = reOrderListFirstLastSecond.new ListNode();
		node1.setData(2);
		node.setNext(node1);
		ListNode node2 = reOrderListFirstLastSecond.new ListNode();
		node2.setData(3);
		node1.setNext(node2);
		ListNode node3 = reOrderListFirstLastSecond.new ListNode();
		node3.setData(4);
		node2.setNext(node3);
		ListNode node4 = reOrderListFirstLastSecond.new ListNode();
		node4.setData(5);
		node3.setNext(node4);
		ListNode node5 = reOrderListFirstLastSecond.new ListNode();
		node5.setData(6);
		node4.setNext(node5);
		ListNode node6 = reOrderListFirstLastSecond.new ListNode();
		node6.setData(7);
		node5.setNext(node6);
		ListNode node7 = reOrderListFirstLastSecond.new ListNode();
		node7.setData(8);
		node6.setNext(node7);
		ListNode node8 = reOrderListFirstLastSecond.new ListNode();
		node8.setData(9);
		node7.setNext(node8);

		reOrderListFirstLastSecond.reorderList(node);
		System.out.println("*********************");

		ListNode node11 = reOrderListFirstLastSecond.new ListNode();
		node11.setData(2);
		ListNode node12 = reOrderListFirstLastSecond.new ListNode();
		node12.setData(4);
		node11.setNext(node12);
		ListNode node13 = reOrderListFirstLastSecond.new ListNode();
		node13.setData(6);
		node12.setNext(node13);
		ListNode node14 = reOrderListFirstLastSecond.new ListNode();
		node14.setData(8);
		node13.setNext(node14);
		reOrderListFirstLastSecond.reOrderListTraversal(node11);

	}
}
