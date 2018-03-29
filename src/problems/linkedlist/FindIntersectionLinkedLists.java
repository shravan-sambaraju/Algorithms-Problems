package problems.linkedlist;

/* Find intersection of linkedlists */

public class FindIntersectionLinkedLists {

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

	public static ListNode findIntersection(ListNode list1, ListNode list2) {
		int l1 = 0, l2 = 0, d = 0;
		ListNode head1 = list1, head2 = list2;

		while (head1 != null) {
			l1++;
			head1 = head1.getNext();

		}

		while (head2 != null) {
			l2++;
			head2 = head2.getNext();

		}

		if (l1 < l2) {
			head1 = list2;
			head2 = list1;
			d = l2 - l1;

		} else {
			head1 = list1;
			head2 = list2;
			d = l1 - l2;
		}

		for (int i = 0; i < d; i++) {
			head1 = head1.getNext();
		}
		while (head1 != null && head2 != null) {
			if (head1 == head2)
				return head1;
			head1 = head1.getNext();
			head2 = head2.getNext();

		}

		return null;

	}

	public static void main(String args[]) {

		FindIntersectionLinkedLists findIntersectionLinkedLists = new FindIntersectionLinkedLists();

		ListNode node = findIntersectionLinkedLists.new ListNode();
		node.setData(1);
		ListNode node1 = findIntersectionLinkedLists.new ListNode();
		node1.setData(2);
		node.setNext(node1);
		ListNode node2 = findIntersectionLinkedLists.new ListNode();
		node2.setData(3);
		node1.setNext(node2);
		ListNode node3 = findIntersectionLinkedLists.new ListNode();
		node3.setData(4);
		node2.setNext(node3);
		ListNode node4 = findIntersectionLinkedLists.new ListNode();
		node4.setData(5);
		node3.setNext(node4);
		ListNode node5 = findIntersectionLinkedLists.new ListNode();
		node5.setData(6);
		node4.setNext(node5);
		ListNode node6 = findIntersectionLinkedLists.new ListNode();
		node6.setData(7);
		node5.setNext(node6);
		ListNode node7 = findIntersectionLinkedLists.new ListNode();
		node7.setData(8);
		node6.setNext(node7);
		ListNode node8 = findIntersectionLinkedLists.new ListNode();
		node8.setData(9);
		node7.setNext(node8);

		ListNode node11 = findIntersectionLinkedLists.new ListNode();
		node11.setData(11);
		ListNode node12 = findIntersectionLinkedLists.new ListNode();
		node12.setData(12);
		node11.setNext(node12);
		node12.setNext(node5);

		System.out.println(findIntersection(node, node11).getData());

	}

}
