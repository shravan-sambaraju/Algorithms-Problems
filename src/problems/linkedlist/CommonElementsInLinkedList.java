package problems.linkedlist;

/* Check common elements in linkedlist */

import common.utils.ListNode;

class CommonElementsInLinkedList {

	private static ListNode commonElement(ListNode list1, ListNode list2) {

		ListNode temp = new ListNode(0);
		ListNode head = temp;
		while (list1 != null && list2 != null) {
			if (list1.getData() == list2.getData()) {
				head.setNext(new ListNode(list1.getData()));
				list1 = list1.getNext();
				list2 = list2.getNext();
				head = head.getNext();
			} else if (list1.getData() > list2.getData()) {
				list2 = list2.getNext();
			} else {
				list1 = list1.getNext();
			}
		}
		return temp.getNext();
	}

	public static void main(String[] args) {
		ListNode node = new ListNode();
		node.setData(1);
		ListNode node1 = new ListNode();
		node1.setData(2);
		node.setNext(node1);
		ListNode node2 = new ListNode();
		node2.setData(3);
		node1.setNext(node2);
		ListNode node3 = new ListNode();
		node3.setData(4);
		node2.setNext(node3);
		ListNode node4 = new ListNode();
		node4.setData(5);
		node3.setNext(node4);
		ListNode node5 = new ListNode();
		node5.setData(5);
		node4.setNext(node5);
		ListNode node6 = new ListNode();
		node6.setData(7);
		node5.setNext(node6);
		ListNode node7 = new ListNode();
		node7.setData(3);
		node6.setNext(node7);
		ListNode node8 = new ListNode();
		node8.setData(9);
		node7.setNext(node8);

		ListNode node11 = new ListNode();
		node11.setData(2);
		ListNode node12 = new ListNode();
		node12.setData(4);
		node11.setNext(node12);
		ListNode node13 = new ListNode();
		node13.setData(4);
		node12.setNext(node13);
		ListNode node14 = new ListNode();
		node14.setData(8);
		node13.setNext(node14);

		ListNode commonElments = commonElement(node, node11);

		while (commonElments != null) {
			System.out.println(commonElments.getData());
			commonElments = commonElments.getNext();

		}
	}
}
