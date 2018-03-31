package problems.trees;

/* Find element in binary node */

import java.util.LinkedList;
import java.util.Queue;

public class FindAnElementInBinaryTree {

	class BinaryTreeNode {
		int data;
		BinaryTreeNode left;
		BinaryTreeNode right;

		BinaryTreeNode(int x) {
			data = x;
			left = null;
			right = null;

		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public BinaryTreeNode getLeft() {
			return left;
		}

		public void setLeft(BinaryTreeNode left) {
			this.left = left;
		}

		public BinaryTreeNode getRight() {
			return right;
		}

		public void setRight(BinaryTreeNode right) {
			this.right = right;
		}
	}

	public static boolean findElementLevelOrder(BinaryTreeNode head, int data) {
		if (head == null) {
			return false;
		}
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(head);
		while (!queue.isEmpty()) {
			BinaryTreeNode temp = queue.poll();
			if (temp.data == data) {
				return true;

			}

			if (temp != null) {
				if (temp.left != null) {
					queue.offer(temp.left);
				}
				if (temp.right != null) {
					queue.offer(temp.right);
				}
			}

		}

		return false;

	}

	public static boolean findElementRecursion(BinaryTreeNode head, int data) {
		if (head == null) {
			return false;
		}
		if (head.data == data) {
			return true;

		}

		return findElementRecursion(head.left, data) || findElementRecursion(head.right, data);

	}

	public static void main(String args[]) {

		FindAnElementInBinaryTree findAnElementInBinaryTree = new FindAnElementInBinaryTree();
		BinaryTreeNode node = findAnElementInBinaryTree.new BinaryTreeNode(1);
		node.left = findAnElementInBinaryTree.new BinaryTreeNode(2);
		node.right = findAnElementInBinaryTree.new BinaryTreeNode(3);
		node.left.left = findAnElementInBinaryTree.new BinaryTreeNode(4);
		node.left.right = findAnElementInBinaryTree.new BinaryTreeNode(5);
		node.right.left = findAnElementInBinaryTree.new BinaryTreeNode(6);
		node.right.right = findAnElementInBinaryTree.new BinaryTreeNode(7);

		System.out.println(findElementLevelOrder(node, 7));
		System.out.println(findElementLevelOrder(node, 11));
		System.out.println(findElementRecursion(node, 7));
		System.out.println(findElementRecursion(node, 11));

	}

}
