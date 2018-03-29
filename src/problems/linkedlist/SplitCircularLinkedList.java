package problems.linkedlist;

/* Split given circular linkedlist */

public class SplitCircularLinkedList {

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

	static ListNode head1, head2;

	public void splitList(ListNode head) {
		ListNode slowPointer = head;
		ListNode fastPointer = head;

		if (head == null) {
			return;
		}

		while (fastPointer.getNext() != head && fastPointer.getNext().getNext() != head) {
			fastPointer = fastPointer.getNext().getNext();
			slowPointer = slowPointer.getNext();

		}

		if (fastPointer.getNext().getNext() == head) {
			fastPointer = fastPointer.getNext();

		}

		head1 = head;

		if (head.getNext() != head) {
			head2 = slowPointer.getNext();

		}

		fastPointer.setNext(slowPointer.getNext());
		slowPointer.setNext(head);

	}

	public static void main(String args[]) {
		SplitCircularLinkedList splitCircularLinkedList = new SplitCircularLinkedList();

		ListNode node = splitCircularLinkedList.new ListNode();
		node.setData(1);
		ListNode node1 = splitCircularLinkedList.new ListNode();
		node1.setData(2);
		node.setNext(node1);
		ListNode node2 = splitCircularLinkedList.new ListNode();
		node2.setData(3);
		node1.setNext(node2);
		ListNode node3 = splitCircularLinkedList.new ListNode();
		node3.setData(4);
		node2.setNext(node3);
		ListNode node4 = splitCircularLinkedList.new ListNode();
		node4.setData(5);
		node3.setNext(node4);
		ListNode node5 = splitCircularLinkedList.new ListNode();
		node5.setData(6);
		node4.setNext(node5);
		ListNode node6 = splitCircularLinkedList.new ListNode();
		node6.setData(7);
		node5.setNext(node6);
		ListNode node7 = splitCircularLinkedList.new ListNode();
		node7.setData(8);
		node6.setNext(node7);
		ListNode node8 = splitCircularLinkedList.new ListNode();
		node8.setData(9);
		node7.setNext(node8);
		node8.setNext(node);

		splitCircularLinkedList.splitList(node);

		ListNode originalFirstHead1 = head1;
		ListNode originalSecondHead2 = head2;

		do {
			System.out.println(head1.getData());
			head1 = head1.getNext();
		} while (head1 != originalFirstHead1);

		System.out.println("*********************");

		do {
			System.out.println(head2.getData());
			head2 = head2.getNext();
		} while (head2 != originalSecondHead2);

	}

}
