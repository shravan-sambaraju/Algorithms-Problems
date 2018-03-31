package problems.linkedlist;

/* Check whether if given linkedlist is palindrome */

public class LinkedListPalindrome {

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

	ListNode left;

	public boolean checkPalindromeRecursion(ListNode head) {
		left = head;

		boolean result = checkPalindrome(head);
		return result;
	}

	public boolean checkPalindrome(ListNode right) {

		if (right == null) {
			return true;
		}

		boolean checkPalindromeEnd = checkPalindrome(right.getNext());
		if (!checkPalindromeEnd) {
			return false;
		}

		boolean isPalindrome = (left.getData() == right.getData());

		left = left.getNext();

		return isPalindrome;

	}

	public static boolean checkPalidromeBreakAndReverse(ListNode head) {
		if (head == null || head.getNext() == null) {
			return true;

		}

		ListNode fast = head;
		ListNode slow = head;
		ListNode prevSlow = head;
		ListNode midNode = null;
		ListNode secondList = null;

		while (fast != null && fast.getNext() != null) {
			fast = fast.getNext().getNext();
			prevSlow = slow;
			slow = slow.getNext();
		}

		if (fast != null) {
			midNode = slow;
			slow = slow.getNext();

		}

		secondList = slow;
		prevSlow.setNext(null);
		ListNode temp = null;
		ListNode current = secondList;
		ListNode next;
		while (current != null) {
			next = current.getNext();
			current.setNext(temp);
			temp = current;
			current = next;
		}
		secondList = temp;

		while (head != null && secondList != null) {
			if (head.getData() == secondList.getData()) {
				head = head.getNext();
				secondList = secondList.getNext();

			} else {
				return false;
			}
			if (head == null && secondList == null) {
				return true;

			}
		}

		return false;

	}

	public static void main(String args[]) {
		LinkedListPalindrome linkedListPalindrome = new LinkedListPalindrome();
		ListNode node = linkedListPalindrome.new ListNode();
		node.setData(1);
		ListNode node1 = linkedListPalindrome.new ListNode();
		node1.setData(2);
		node.setNext(node1);
		ListNode node2 = linkedListPalindrome.new ListNode();
		node2.setData(3);
		node1.setNext(node2);
		ListNode node3 = linkedListPalindrome.new ListNode();
		node3.setData(4);
		node2.setNext(node3);
		ListNode node4 = linkedListPalindrome.new ListNode();
		node4.setData(5);
		node3.setNext(node4);
		ListNode node5 = linkedListPalindrome.new ListNode();
		node5.setData(4);
		node4.setNext(node5);
		ListNode node6 = linkedListPalindrome.new ListNode();
		node6.setData(3);
		node5.setNext(node6);
		ListNode node7 = linkedListPalindrome.new ListNode();
		node7.setData(2);
		node6.setNext(node7);
		ListNode node8 = linkedListPalindrome.new ListNode();
		node8.setData(1);
		node7.setNext(node8);

		LinkedListPalindrome llp = new LinkedListPalindrome();

		System.out.println(llp.checkPalindromeRecursion(node));
		System.out.println(LinkedListPalindrome.checkPalidromeBreakAndReverse(node));

	}

}
