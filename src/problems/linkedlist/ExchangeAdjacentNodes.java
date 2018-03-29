package problems.linkedlist;

/* Exchange adjacent nodes in linkedlist */

public class ExchangeAdjacentNodes {

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

	public static ListNode exchangeNodes(ListNode head) {

		ExchangeAdjacentNodes exchangeAdjacentNodes = new ExchangeAdjacentNodes();

		ListNode swapped = exchangeAdjacentNodes.new ListNode();
		swapped.setNext(head);
		ListNode prev = swapped;
		ListNode current = head;
		while (current != null && current.getNext() != null) {
			ListNode temp = current.getNext().getNext();
			current.getNext().setNext(prev.getNext());
			prev.setNext(current.getNext());
			current.setNext(temp);
			prev = current;
			current = prev.getNext();

		}

		return swapped.getNext();

	}

	public static void main(String args[]) {

		ExchangeAdjacentNodes exchangeAdjacentNodes = new ExchangeAdjacentNodes();

		ListNode node = exchangeAdjacentNodes.new ListNode();
		node.setData(1);
		ListNode node1 = exchangeAdjacentNodes.new ListNode();
		node1.setData(2);
		node.setNext(node1);
		ListNode node2 = exchangeAdjacentNodes.new ListNode();
		node2.setData(3);
		node1.setNext(node2);
		ListNode node3 = exchangeAdjacentNodes.new ListNode();
		node3.setData(4);
		node2.setNext(node3);
		ListNode node4 = exchangeAdjacentNodes.new ListNode();
		node4.setData(5);
		node3.setNext(node4);
		ListNode node5 = exchangeAdjacentNodes.new ListNode();
		node5.setData(6);
		node4.setNext(node5);
		ListNode node6 = exchangeAdjacentNodes.new ListNode();
		node6.setData(7);
		node5.setNext(node6);
		ListNode node7 = exchangeAdjacentNodes.new ListNode();
		node7.setData(8);
		node6.setNext(node7);
		ListNode node8 = exchangeAdjacentNodes.new ListNode();
		node8.setData(9);
		node7.setNext(node8);

		ListNode swapped = exchangeNodes(node);

		while (swapped != null) {
			System.out.println(swapped.getData());
			swapped = swapped.getNext();
		}

	}

}
