package problems.linkedlist;

/* Print given linkedlist in reverse */

public class PrintLinkedListReverse {

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

	public static void printInReverse(ListNode head) {
		if (head == null) {
			return;
		}

		printInReverse(head.getNext());
		System.out.println(head.getData());

	}

	public static void main(String args[]) {
		PrintLinkedListReverse printLinkedListReverse = new PrintLinkedListReverse();
		ListNode node = printLinkedListReverse.new ListNode();
		node.setData(1);
		ListNode node2 = printLinkedListReverse.new ListNode();
		node2.setData(2);
		node.setNext(node2);
		ListNode node3 = printLinkedListReverse.new ListNode();
		node3.setData(3);
		node2.setNext(node3);
		ListNode node4 = printLinkedListReverse.new ListNode();
		node4.setData(4);
		node3.setNext(node4);

		printInReverse(node);
	}

}
