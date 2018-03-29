package problems.linkedlist;

/* Check if linkedlist is odd or even */

public class CheckEvenOrOddLinkedList {

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

	public static String checkEvenOrOdd(ListNode head) {
		while (head != null && head.getNext() != null) {
			head = head.getNext().getNext();

		}
		if (head == null) {
			return "even";
		}
		return "odd";
	}

	public static void main(String args[]) {

		CheckEvenOrOddLinkedList checkEvenOrOddLinkedList = new CheckEvenOrOddLinkedList();

		ListNode node = checkEvenOrOddLinkedList.new ListNode();
		node.setData(1);
		ListNode node2 = checkEvenOrOddLinkedList.new ListNode();
		node2.setData(2);
		node.setNext(node2);
		ListNode node3 = checkEvenOrOddLinkedList.new ListNode();
		node3.setData(3);
		node2.setNext(node3);
		ListNode node4 = checkEvenOrOddLinkedList.new ListNode();
		node4.setData(4);
		node3.setNext(node4);
		ListNode node5 = checkEvenOrOddLinkedList.new ListNode();
		node5.setData(5);
		node4.setNext(node5);

		ListNode node11 = checkEvenOrOddLinkedList.new ListNode();
		node11.setData(1);
		ListNode node12 = checkEvenOrOddLinkedList.new ListNode();
		node12.setData(2);
		node11.setNext(node12);
		ListNode node13 = checkEvenOrOddLinkedList.new ListNode();
		node13.setData(3);
		node12.setNext(node13);
		ListNode node14 = checkEvenOrOddLinkedList.new ListNode();
		node14.setData(4);
		node13.setNext(node14);

		System.out.println(checkEvenOrOdd(node));
		System.out.println(checkEvenOrOdd(node11));

	}

}
