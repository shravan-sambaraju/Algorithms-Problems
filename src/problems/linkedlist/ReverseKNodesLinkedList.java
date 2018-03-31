package problems.linkedlist;

/* Reverse linkedlist by k nodes */

public class ReverseKNodesLinkedList {

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

	public static ListNode reverseNodesRecursive(ListNode head, int k) {
		ListNode current = head;
		ListNode next = null;
		ListNode prev = null;
		int count = k;

		while (current != null && count > 0) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
			count--;
		}

		if (next != null) {
			head.setNext(reverseNodesRecursive(next, k));
		}

		return prev;

	}

	public static ListNode reverseKNodes(ListNode head, int k) {

		ListNode current = head;

		ListNode prevTail = null;

		ListNode prevCurrent = head;
		while (current != null) {

			int count = k;
			ListNode tail = null;
			while (current != null && count > 0) {
				ListNode next = current.getNext();
				current.setNext(tail);
				tail = current;
				current = next;
				count--;
			}

			if (prevTail != null) {

				prevTail.setNext(tail);
			} else {

				head = tail;
			}

			prevTail = prevCurrent;

			prevCurrent = current;
		}
		return head;

	}

	public static void main(String args[]) {

		ReverseKNodesLinkedList reverseKNodesLinkedList = new ReverseKNodesLinkedList();

		ListNode node = reverseKNodesLinkedList.new ListNode();
		node.setData(1);
		ListNode node1 = reverseKNodesLinkedList.new ListNode();
		node1.setData(2);
		node.setNext(node1);
		ListNode node2 = reverseKNodesLinkedList.new ListNode();
		node2.setData(3);
		node1.setNext(node2);
		ListNode node3 = reverseKNodesLinkedList.new ListNode();
		node3.setData(4);
		node2.setNext(node3);
		ListNode node4 = reverseKNodesLinkedList.new ListNode();
		node4.setData(5);
		node3.setNext(node4);
		ListNode node5 = reverseKNodesLinkedList.new ListNode();
		node5.setData(6);
		node4.setNext(node5);
		ListNode node6 = reverseKNodesLinkedList.new ListNode();
		node6.setData(7);
		node5.setNext(node6);
		ListNode node7 = reverseKNodesLinkedList.new ListNode();
		node7.setData(8);
		node6.setNext(node7);
		ListNode node8 = reverseKNodesLinkedList.new ListNode();
		node8.setData(9);
		node7.setNext(node8);

		ListNode swapped = reverseNodesRecursive(node, 5);
		while (swapped != null) {
			System.out.println(swapped.getData());
			swapped = swapped.getNext();

		}

		System.out.println("********************");

		ListNode node11 = reverseKNodesLinkedList.new ListNode();
		node11.setData(1);
		ListNode node12 = reverseKNodesLinkedList.new ListNode();
		node12.setData(2);
		node11.setNext(node12);
		ListNode node13 = reverseKNodesLinkedList.new ListNode();
		node13.setData(3);
		node12.setNext(node13);
		ListNode node14 = reverseKNodesLinkedList.new ListNode();
		node14.setData(4);
		node13.setNext(node14);

		ListNode swapped2 = reverseKNodes(node11, 3);
		while (swapped2 != null) {
			System.out.println(swapped2.getData());
			swapped2 = swapped2.getNext();

		}

	}

}
