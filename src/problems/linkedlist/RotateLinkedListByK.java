package problems.linkedlist;

/* Rotate linkedlist by k */

public class RotateLinkedListByK {

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

	public static ListNode rotateRight(ListNode head, int n) {
		if (head == null || head.next == null)
			return head;
		ListNode rotateStart = head, rotateEnd = head;
		while (n-- > 0) {
			rotateEnd = rotateEnd.next;
			if (rotateEnd == null) {
				rotateEnd = head;

			}
		}
		if (rotateStart == rotateEnd)
			return head;
		while (rotateEnd.next != null) {
			rotateStart = rotateStart.next;
			rotateEnd = rotateEnd.next;
		}
		ListNode temp = rotateStart.next;
		rotateEnd.next = head;
		rotateStart.next = null;
		return temp;
	}

	public static void main(String args[]) {

		RotateLinkedListByK rotateLinkedListByK = new RotateLinkedListByK();
		ListNode node = rotateLinkedListByK.new ListNode();
		node.setData(1);
		ListNode node1 = rotateLinkedListByK.new ListNode();
		node1.setData(2);
		node.setNext(node1);
		ListNode node2 = rotateLinkedListByK.new ListNode();
		node2.setData(3);
		node1.setNext(node2);
		ListNode node3 = rotateLinkedListByK.new ListNode();
		node3.setData(4);
		node2.setNext(node3);
		ListNode node4 = rotateLinkedListByK.new ListNode();
		node4.setData(5);
		node3.setNext(node4);
		ListNode node5 = rotateLinkedListByK.new ListNode();
		node5.setData(6);
		node4.setNext(node5);
		ListNode node6 = rotateLinkedListByK.new ListNode();
		node6.setData(7);
		node5.setNext(node6);
		ListNode node7 = rotateLinkedListByK.new ListNode();
		node7.setData(8);
		node6.setNext(node7);
		ListNode node8 = rotateLinkedListByK.new ListNode();
		node8.setData(9);
		node7.setNext(node8);

		ListNode rotatedNode = rotateRight(node, 3);

		while (rotatedNode != null) {
			System.out.println(rotatedNode.getData());
			rotatedNode = rotatedNode.getNext();

		}

	}

}
