package problems.linkedlist;

/* Implement josephus circle using linkedlist */

public class JosephusCircleLinkedList {

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

	public static void getJosephusPosition(int N, int M) {

		JosephusCircleLinkedList josephusCircleLinkedList = new JosephusCircleLinkedList();

		ListNode p = josephusCircleLinkedList.new ListNode();
		ListNode q, n, l;
		p.setData(1);

		n = p;
		l = p;
		for (int i = 2; i <= N; i++) {
			q = josephusCircleLinkedList.new ListNode();
			q.setData(i);
			p.setNext(q);
			p = p.getNext();

		}

		p.setNext(n);

		while (n.getNext() != l) {
			System.out.println(n.getData());
			n = n.getNext();

		}

		for (int count = N; count > 1; --count) {
			for (int i = 0; i < M - 1; ++i)
				p = p.getNext();
			p.setNext(p.getNext().getNext());

		}

		System.out.println("survivor " + p.getData());
	}

	public static void main(String args[]) {

		getJosephusPosition(9, 4);

	}

}
