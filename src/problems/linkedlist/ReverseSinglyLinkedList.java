package problems.linkedlist;

/* Reverse given singly linkedlist */

public class ReverseSinglyLinkedList {

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

	public static ListNode reverseListIterative(ListNode head) {
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

	public static ListNode ReverseLinkedList(ListNode head) {

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
		ReverseSinglyLinkedList reverseSinglyLinkedList = new ReverseSinglyLinkedList();
		ListNode node = reverseSinglyLinkedList.new ListNode();
		node.setData(1);
		ListNode node2 = reverseSinglyLinkedList.new ListNode();
		node2.setData(2);
		node.setNext(node2);
		ListNode node3 = reverseSinglyLinkedList.new ListNode();
		node3.setData(3);
		node2.setNext(node3);
		ListNode node4 = reverseSinglyLinkedList.new ListNode();
		node4.setData(4);
		node3.setNext(node4);

		ListNode node11 = reverseSinglyLinkedList.new ListNode();
		node11.setData(1);
		ListNode node12 = reverseSinglyLinkedList.new ListNode();
		node12.setData(2);
		node11.setNext(node12);
		ListNode node13 = reverseSinglyLinkedList.new ListNode();
		node13.setData(3);
		node12.setNext(node13);
		ListNode node14 = reverseSinglyLinkedList.new ListNode();
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
