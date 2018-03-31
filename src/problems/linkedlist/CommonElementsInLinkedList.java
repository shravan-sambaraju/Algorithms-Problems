package problems.linkedlist;

/* Check common elements in linkedlist */

public class CommonElementsInLinkedList {

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

	public static ListNode commonElement(ListNode list1, ListNode list2) {
		CommonElementsInLinkedList commonElementsInLinkedList = new CommonElementsInLinkedList();

		ListNode temp = commonElementsInLinkedList.new ListNode(0);
		ListNode head = temp;
		while (list1 != null && list2 != null) {
			if (list1.data == list2.data) {
				head.next = commonElementsInLinkedList.new ListNode(list1.data); // Copy
																					// common
																					// element.
				list1 = list1.next;
				list2 = list2.next;
				head = head.next;
			} else if (list1.data > list2.data) {
				list2 = list2.next;
			} else { // list1.data < list2.data
				list1 = list1.next;
			}
		}
		return temp.next;
	}

	public static void main(String[] args) {
		CommonElementsInLinkedList commonElementsInLinkedList = new CommonElementsInLinkedList();
		ListNode node = commonElementsInLinkedList.new ListNode();
		node.setData(1);
		ListNode node1 = commonElementsInLinkedList.new ListNode();
		node1.setData(2);
		node.setNext(node1);
		ListNode node2 = commonElementsInLinkedList.new ListNode();
		node2.setData(3);
		node1.setNext(node2);
		ListNode node3 = commonElementsInLinkedList.new ListNode();
		node3.setData(4);
		node2.setNext(node3);
		ListNode node4 = commonElementsInLinkedList.new ListNode();
		node4.setData(5);
		node3.setNext(node4);
		ListNode node5 = commonElementsInLinkedList.new ListNode();
		node5.setData(5);
		node4.setNext(node5);
		ListNode node6 = commonElementsInLinkedList.new ListNode();
		node6.setData(7);
		node5.setNext(node6);
		ListNode node7 = commonElementsInLinkedList.new ListNode();
		node7.setData(3);
		node6.setNext(node7);
		ListNode node8 = commonElementsInLinkedList.new ListNode();
		node8.setData(9);
		node7.setNext(node8);

		ListNode node11 = commonElementsInLinkedList.new ListNode();
		node11.setData(2);
		ListNode node12 = commonElementsInLinkedList.new ListNode();
		node12.setData(4);
		node11.setNext(node12);
		ListNode node13 = commonElementsInLinkedList.new ListNode();
		node13.setData(4);
		node12.setNext(node13);
		ListNode node14 = commonElementsInLinkedList.new ListNode();
		node14.setData(8);
		node13.setNext(node14);

		ListNode commonElments = commonElement(node, node11);

		while (commonElments != null) {
			System.out.println(commonElments.getData());
			commonElments = commonElments.getNext();

		}

	}
}
