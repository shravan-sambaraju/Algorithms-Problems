package problems.linkedlist;

/* Sort linkedlist using insertion sort */

public class InsertionSortLinkedList {

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

	public static ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		InsertionSortLinkedList insertionSortLinkedList = new InsertionSortLinkedList();
		ListNode newHead = insertionSortLinkedList.new ListNode(head.data);
		ListNode pointer = head.next;

		// loop through each element in the list
		while (pointer != null) {
			// insert this element to the new list

			ListNode innerPointer = newHead;
			ListNode next = pointer.next;

			if (pointer.data <= newHead.data) {
				ListNode oldHead = newHead;
				newHead = pointer;
				newHead.next = oldHead;
			} else {
				while (innerPointer.next != null) {

					if (pointer.data > innerPointer.data && pointer.data <= innerPointer.next.data) {
						ListNode oldNext = innerPointer.next;
						innerPointer.next = pointer;
						pointer.next = oldNext;
					}

					innerPointer = innerPointer.next;
				}

				if (innerPointer.next == null && pointer.data > innerPointer.data) {
					innerPointer.next = pointer;
					pointer.next = null;
				}
			}

			// finally
			pointer = next;
		}

		return newHead;
	}

	public static void main(String args[]) {

		InsertionSortLinkedList insertionSortLinkedList = new InsertionSortLinkedList();
		ListNode node = insertionSortLinkedList.new ListNode();
		node.setData(10);
		ListNode node1 = insertionSortLinkedList.new ListNode();
		node1.setData(9);
		node.setNext(node1);
		ListNode node2 = insertionSortLinkedList.new ListNode();
		node2.setData(8);
		node1.setNext(node2);
		ListNode node3 = insertionSortLinkedList.new ListNode();
		node3.setData(7);
		node2.setNext(node3);
		ListNode node4 = insertionSortLinkedList.new ListNode();
		node4.setData(6);
		node3.setNext(node4);
		ListNode node5 = insertionSortLinkedList.new ListNode();
		node5.setData(5);
		node4.setNext(node5);
		ListNode node6 = insertionSortLinkedList.new ListNode();
		node6.setData(4);
		node5.setNext(node6);
		ListNode node7 = insertionSortLinkedList.new ListNode();
		node7.setData(3);
		node6.setNext(node7);
		ListNode node8 = insertionSortLinkedList.new ListNode();
		node8.setData(2);
		node7.setNext(node8);

		ListNode finalNode = insertionSortList(node);

		while (finalNode != null) {
			System.out.println(finalNode.getData());
			finalNode = finalNode.getNext();

		}

	}

}
