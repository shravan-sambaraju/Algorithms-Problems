package problems.linkedlist;

/* Insert node in sorted linkedlist */

public class InsertNodeInSortedLinkedList {

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

	public static ListNode insertNode(ListNode head, ListNode newNode) {
		ListNode current = head;
		ListNode temp = head;
		if (head == null) {
			head = newNode;

		}
		while (current != null && current.getData() < newNode.getData()) {
			temp = current;
			current = current.getNext();
		}

		newNode.setNext(current);
		temp.setNext(newNode);

		return head;

	}

	public static void main(String args[]) {
		InsertNodeInSortedLinkedList insertNodeInSortedLinkedList = new InsertNodeInSortedLinkedList();
		ListNode node = insertNodeInSortedLinkedList.new ListNode();
		node.setData(1);
		ListNode node2 = insertNodeInSortedLinkedList.new ListNode();
		node2.setData(2);
		node.setNext(node2);
		ListNode node3 = insertNodeInSortedLinkedList.new ListNode();
		node3.setData(4);
		node2.setNext(node3);
		ListNode node4 = insertNodeInSortedLinkedList.new ListNode();
		node4.setData(5);
		node3.setNext(node4);

		ListNode newNode = insertNodeInSortedLinkedList.new ListNode();
		newNode.setData(3);

		ListNode insertedNode = insertNode(node, newNode);

		while (insertedNode != null) {
			System.out.println(insertedNode.getData());
			insertedNode = insertedNode.getNext();

		}

	}

}
