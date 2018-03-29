package problems.linkedlist;

/* Merge given sorted linkedlists */

public class MergeSortedLinkedLists {

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

	public static ListNode mergeUsingRecursion(ListNode head, ListNode head1) {
		if (head == null) {
			return head1;
		}
		if (head1 == null) {
			return head;
		}

		MergeSortedLinkedLists mergeSortedLinkedLists = new MergeSortedLinkedLists();

		ListNode head2 = mergeSortedLinkedLists.new ListNode();
		if (head.getData() < head1.getData()) {
			head2 = head;
			head2.setNext(mergeUsingRecursion(head.getNext(), head1));

		} else {
			head2 = head1;
			head2.setNext(mergeUsingRecursion(head, head1.getNext()));
		}

		return head2;

	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		MergeSortedLinkedLists mergeSortedLinkedLists = new MergeSortedLinkedLists();
		ListNode head = mergeSortedLinkedLists.new ListNode(0);
		ListNode p = head;

		while (l1 != null || l2 != null) {
			if (l1 != null && l2 != null) {
				if (l1.data < l2.data) {
					p.next = l1;
					l1 = l1.next;
				} else {
					p.next = l2;
					l2 = l2.next;
				}
				p = p.next;
			} else if (l1 == null) {
				p.next = l2;
				break;
			} else if (l2 == null) {
				p.next = l1;
				break;
			}
		}

		return head.next;
	}

	public static void main(String args[]) {

		MergeSortedLinkedLists mergeSortedLinkedLists = new MergeSortedLinkedLists();
		ListNode node = mergeSortedLinkedLists.new ListNode();
		node.setData(1);
		ListNode node2 = mergeSortedLinkedLists.new ListNode();
		node2.setData(3);
		node.setNext(node2);
		ListNode node3 = mergeSortedLinkedLists.new ListNode();
		node3.setData(5);
		node2.setNext(node3);
		ListNode node4 = mergeSortedLinkedLists.new ListNode();
		node4.setData(7);
		node3.setNext(node4);
		ListNode node5 = mergeSortedLinkedLists.new ListNode();
		node5.setData(9);
		node4.setNext(node5);

		ListNode node11 = mergeSortedLinkedLists.new ListNode();
		node11.setData(2);
		ListNode node12 = mergeSortedLinkedLists.new ListNode();
		node12.setData(4);
		node11.setNext(node12);
		ListNode node13 = mergeSortedLinkedLists.new ListNode();
		node13.setData(6);
		node12.setNext(node13);
		ListNode node14 = mergeSortedLinkedLists.new ListNode();
		node14.setData(8);
		node13.setNext(node14);

		/*
		 * ListNode sortedNode = mergeUsingRecursion(node, node11);
		 * 
		 * while(sortedNode!=null){ System.out.println(sortedNode.getData());
		 * sortedNode = sortedNode.getNext(); }
		 */
		System.out.println("**********");
		ListNode sortedNode2 = mergeTwoLists(node, node11);
		while (sortedNode2 != null) {
			System.out.println(sortedNode2.getData());
			sortedNode2 = sortedNode2.getNext();

		}
	}

}
