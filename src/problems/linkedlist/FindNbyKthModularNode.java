package problems.linkedlist;

/* Find N by Kth modular node in linkedlist */

public class FindNbyKthModularNode {

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

	public ListNode findNbyKthNodeFromStart(ListNode head, int k) {
		ListNode result = null;
		int i = 0;
		if (k <= 0 || head == null) {
			return null;

		}

		for (; head != null; head = head.getNext()) {
			if (i % k == 0) {
				result = head;
			}

			i++;
		}

		return result;

	}

	public static void main(String args[]) {

		FindNbyKthModularNode findNbyKthModularNode = new FindNbyKthModularNode();

		ListNode node = findNbyKthModularNode.new ListNode();
		node.setData(1);
		ListNode node1 = findNbyKthModularNode.new ListNode();
		node1.setData(2);
		node.setNext(node1);
		ListNode node2 = findNbyKthModularNode.new ListNode();
		node2.setData(3);
		node1.setNext(node2);
		ListNode node3 = findNbyKthModularNode.new ListNode();
		node3.setData(4);
		node2.setNext(node3);
		ListNode node4 = findNbyKthModularNode.new ListNode();
		node4.setData(5);
		node3.setNext(node4);
		ListNode node5 = findNbyKthModularNode.new ListNode();
		node5.setData(6);
		node4.setNext(node5);
		ListNode node6 = findNbyKthModularNode.new ListNode();
		node6.setData(7);
		node5.setNext(node6);
		ListNode node7 = findNbyKthModularNode.new ListNode();
		node7.setData(8);
		node6.setNext(node7);
		ListNode node8 = findNbyKthModularNode.new ListNode();
		node8.setData(9);
		node7.setNext(node8);

		FindNbyKthModularNode findNode = new FindNbyKthModularNode();
		ListNode modularNode = findNode.findNbyKthNodeFromStart(node, 3);

		System.out.println(modularNode.getData());

	}

}
