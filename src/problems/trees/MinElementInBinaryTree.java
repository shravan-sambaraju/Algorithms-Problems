package problems.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MinElementInBinaryTree {

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

	public static int minElementRecursion(BinaryTreeNode head) {
		int minValue = Integer.MAX_VALUE;
		if (head != null) {
			int leftMax = minElementRecursion(head.left);
			int rightMax = minElementRecursion(head.right);

			if (leftMax < rightMax) {
				minValue = leftMax;
			} else {
				minValue = rightMax;
			}
			if (head.data < minValue) {
				minValue = head.data;
			}
		}

		return minValue;

	}

	public static int minValueLevelOrder(BinaryTreeNode head) {
		if (head == null) {
			return Integer.MIN_VALUE;
		}
		int minValue = Integer.MAX_VALUE;
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(head);
		while (!queue.isEmpty()) {
			BinaryTreeNode temp = queue.poll();
			if (temp.data < minValue)
				minValue = temp.data;

			if (temp != null) {
				if (temp.left != null) {
					queue.offer(temp.left);
				}
				if (temp.right != null) {
					queue.offer(temp.right);
				}
			}

		}

		return minValue;

	}

	public static void main(String args[]) {
		MinElementInBinaryTree minElementInBinaryTree = new MinElementInBinaryTree();
		BinaryTreeNode node = minElementInBinaryTree.new BinaryTreeNode(1);
		node.left = minElementInBinaryTree.new BinaryTreeNode(2);
		node.right = minElementInBinaryTree.new BinaryTreeNode(3);
		node.left.left = minElementInBinaryTree.new BinaryTreeNode(4);
		node.left.right = minElementInBinaryTree.new BinaryTreeNode(5);
		node.right.left = minElementInBinaryTree.new BinaryTreeNode(6);
		node.right.right = minElementInBinaryTree.new BinaryTreeNode(7);

		System.out.println(minElementRecursion(node));
		System.out.println(minValueLevelOrder(node));

	}

}
