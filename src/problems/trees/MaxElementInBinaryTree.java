package problems.trees;

/* Find maximum element in binary tree */

import java.util.LinkedList;
import java.util.Queue;

public class MaxElementInBinaryTree {

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

	public static int maxElementRecursion(BinaryTreeNode head) {
		int maxValue = Integer.MIN_VALUE;
		if (head != null) {
			int leftMax = maxElementRecursion(head.left);
			int rightMax = maxElementRecursion(head.right);

			if (leftMax > rightMax) {
				maxValue = leftMax;
			} else {
				maxValue = rightMax;
			}
			if (head.data > maxValue) {
				maxValue = head.data;
			}
		}

		return maxValue;

	}

	public static int maxValueLevelOrder(BinaryTreeNode head) {
		if (head == null) {
			return Integer.MIN_VALUE;
		}
		int maxValue = Integer.MIN_VALUE;
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(head);
		while (!queue.isEmpty()) {
			BinaryTreeNode temp = queue.poll();
			if (temp.data > maxValue)
				maxValue = temp.data;

			if (temp != null) {
				if (temp.left != null) {
					queue.offer(temp.left);
				}
				if (temp.right != null) {
					queue.offer(temp.right);
				}
			}

		}

		return maxValue;

	}

	public static void main(String args[]) {
		MaxElementInBinaryTree maxElementInBinaryTree = new MaxElementInBinaryTree();
		BinaryTreeNode node = maxElementInBinaryTree.new BinaryTreeNode(1);
		node.left = maxElementInBinaryTree.new BinaryTreeNode(2);
		node.right = maxElementInBinaryTree.new BinaryTreeNode(3);
		node.left.left = maxElementInBinaryTree.new BinaryTreeNode(4);
		node.left.right = maxElementInBinaryTree.new BinaryTreeNode(5);
		node.right.left = maxElementInBinaryTree.new BinaryTreeNode(6);
		node.right.right = maxElementInBinaryTree.new BinaryTreeNode(7);

		System.out.println(maxElementRecursion(node));
		System.out.println(maxValueLevelOrder(node));
	}
}
