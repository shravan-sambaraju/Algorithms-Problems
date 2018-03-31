package problems.linkedlist;

/* Partition linkedlist to even and odd across pivot */

public class PartitionListToEvenOddPivot {

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

	public static ListNode partition(ListNode head, int K) {

		PartitionListToEvenOddPivot partitionListToEvenOddPivot = new PartitionListToEvenOddPivot();
		ListNode root = partitionListToEvenOddPivot.new ListNode(0);
		ListNode pivot = partitionListToEvenOddPivot.new ListNode(K);
		ListNode rootNext = root, pivotNext = pivot;
		ListNode currentNode = head;
		while (currentNode != null) {
			ListNode next = currentNode.next;
			if (currentNode.data >= K) {
				pivotNext.next = currentNode;
				pivotNext = currentNode;
				pivotNext.next = null;
			} else {
				rootNext.next = currentNode;
				rootNext = currentNode;
			}
			currentNode = next;
		}
		rootNext.next = pivot.next;
		return root.next;
	}

	public static void main(String args[]) {
		PartitionListToEvenOddPivot partitionListToEvenOddPivot = new PartitionListToEvenOddPivot();
		ListNode node = partitionListToEvenOddPivot.new ListNode();
		node.setData(10);
		ListNode node1 = partitionListToEvenOddPivot.new ListNode();
		node1.setData(9);
		node.setNext(node1);
		ListNode node2 = partitionListToEvenOddPivot.new ListNode();
		node2.setData(8);
		node1.setNext(node2);
		ListNode node3 = partitionListToEvenOddPivot.new ListNode();
		node3.setData(7);
		node2.setNext(node3);
		ListNode node4 = partitionListToEvenOddPivot.new ListNode();
		node4.setData(6);
		node3.setNext(node4);
		ListNode node5 = partitionListToEvenOddPivot.new ListNode();
		node5.setData(5);
		node4.setNext(node5);
		ListNode node6 = partitionListToEvenOddPivot.new ListNode();
		node6.setData(4);
		node5.setNext(node6);
		ListNode node7 = partitionListToEvenOddPivot.new ListNode();
		node7.setData(3);
		node6.setNext(node7);
		ListNode node8 = partitionListToEvenOddPivot.new ListNode();
		node8.setData(2);
		node7.setNext(node8);

		ListNode finalNode = partition(node, 5);

		while (finalNode != null) {
			System.out.println(finalNode.getData());
			finalNode = finalNode.getNext();

		}

	}

}
