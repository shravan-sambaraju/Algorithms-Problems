package problems.trees;

/* Find maximum level sum in given binary tree */

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSum {

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

	public static void maxSumLevel(BinaryTreeNode root) {
		if (root == null) {
			System.out.println("Tree is empty");
			return;
		}
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		// level delimiter
		queue.offer(null);

		int maxSum = 0;
		int level = 0;
		// default root level
		int localLevel = 0;
		int localSum = 0;
		while (!queue.isEmpty()) {
			BinaryTreeNode node = queue.poll();
			// Level change
			if (null == node) {
				if (!queue.isEmpty()) {
					// level delimiter
					queue.offer(null);
				}

				if (localSum > maxSum) {
					maxSum = localSum;
					level = localLevel;
				}
				// Reset the level sum for next level calculation
				localSum = 0;
				localLevel++;
			} else {
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
				localSum += node.data;
			}
		}
		System.out.println("Max Sum = " + maxSum + " is at Level = " + level);
	}

	public static void main(String args[]) {
		MaximumLevelSum maximumLevelSum = new MaximumLevelSum();
		BinaryTreeNode node = maximumLevelSum.new BinaryTreeNode(1);
		node.left = maximumLevelSum.new BinaryTreeNode(2);
		node.right = maximumLevelSum.new BinaryTreeNode(3);
		node.left.left = maximumLevelSum.new BinaryTreeNode(4);
		node.left.right = maximumLevelSum.new BinaryTreeNode(5);
		node.right.left = maximumLevelSum.new BinaryTreeNode(6);
		node.right.right = maximumLevelSum.new BinaryTreeNode(7);

		maxSumLevel(node);
	}
}