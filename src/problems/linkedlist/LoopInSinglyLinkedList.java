package problems.linkedlist;

/* Detect loop in a linkedlist */

public class LoopInSinglyLinkedList {

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

	public static ListNode findBeginOfLoop(ListNode node) {
		boolean loopExists = false;
		ListNode fastPointer = node;
		ListNode slowPointer = node;
		ListNode loopCause = node;

		while (fastPointer != null && fastPointer.getNext() != null) {
			fastPointer = fastPointer.getNext().getNext();
			slowPointer = slowPointer.getNext();

			if (fastPointer == slowPointer) {
				loopExists = true;
			}

			if (loopExists) {
				slowPointer = node;
				while (slowPointer != fastPointer) {
					slowPointer = slowPointer.getNext();
					loopCause = fastPointer;
					fastPointer = fastPointer.getNext();

				}
				System.out.println("loopcause " + loopCause.getData());
				loopCause.setNext(null);

				return fastPointer;

			}

		}
		return null;

	}

	public static boolean checkForLoopUsingFloyds(ListNode node) {

		ListNode fastPointer = node;
		ListNode slowPointer = node;

		while (fastPointer != null && fastPointer.getNext() != null) {
			fastPointer = fastPointer.getNext().getNext();
			slowPointer = slowPointer.getNext();

			if (fastPointer == slowPointer) {
				numberOfElementsinLoop(fastPointer, slowPointer);

				return true;
			}

		}

		return false;

	}

	public static void numberOfElementsinLoop(ListNode slow, ListNode fast) {
		int count = 1;
		fast = fast.getNext();
		while (fast != slow) {
			fast = fast.getNext();
			++count;

		}
		System.out.println("number of elements " + count);

	}

	public static void main(String args[]) {

		LoopInSinglyLinkedList loopInSinglyLinkedList = new LoopInSinglyLinkedList();

		ListNode node = loopInSinglyLinkedList.new ListNode();
		node.setData(1);
		ListNode node1 = loopInSinglyLinkedList.new ListNode();
		node1.setData(2);
		node.setNext(node1);
		ListNode node2 = loopInSinglyLinkedList.new ListNode();
		node2.setData(3);
		node1.setNext(node2);
		ListNode node3 = loopInSinglyLinkedList.new ListNode();
		node3.setData(4);
		node2.setNext(node3);
		ListNode node4 = loopInSinglyLinkedList.new ListNode();
		node4.setData(5);
		node3.setNext(node4);
		ListNode node5 = loopInSinglyLinkedList.new ListNode();
		node5.setData(6);
		node4.setNext(node5);
		ListNode node6 = loopInSinglyLinkedList.new ListNode();
		node6.setData(7);
		node5.setNext(node6);
		ListNode node7 = loopInSinglyLinkedList.new ListNode();
		node7.setData(8);
		node6.setNext(node7);
		ListNode node8 = loopInSinglyLinkedList.new ListNode();
		node8.setData(9);
		node7.setNext(node8);
		node8.setNext(node3);

		System.out.println(checkForLoopUsingFloyds(node));
		System.out.println("begin of the loop " + findBeginOfLoop(node).getData());
		System.out.println(checkForLoopUsingFloyds(node));

	}

}
