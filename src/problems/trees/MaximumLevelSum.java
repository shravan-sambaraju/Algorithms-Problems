package problems.trees;

/* Find maximum level sum in given binary tree */

import java.util.LinkedList;
import java.util.Queue;
import common.utils.BinaryTreeNode;

class MaximumLevelSum {

	private static void maxSumLevel(BinaryTreeNode root) {
		if (root == null) {
			System.out.println("Tree is empty");
			return;
		}
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		queue.offer(null);

		int maxSum = 0;
		int level = 0;
		int localLevel = 0;
		int localSum = 0;
		while (!queue.isEmpty()) {
			BinaryTreeNode node = queue.poll();
			if (null == node) {
				if (!queue.isEmpty()) {
					queue.offer(null);
				}

				if (localSum > maxSum) {
					maxSum = localSum;
					level = localLevel;
				}
				localSum = 0;
				localLevel++;
			} else {
				if (node.getLeft() != null) {
					queue.offer(node.getLeft());
				}
				if (node.getRight() != null) {
					queue.offer(node.getRight());
				}
				localSum += node.getData();
			}
		}
		System.out.println("Max Sum = " + maxSum + " is at Level = " + level);
	}

	public static void main(String args[]) {

		BinaryTreeNode node = new BinaryTreeNode(1);
		node.setLeft(new BinaryTreeNode(2));
		node.setRight(new BinaryTreeNode(3));
		node.getLeft().setLeft(new BinaryTreeNode(4));
		node.getLeft().setRight(new BinaryTreeNode(5));
		node.getRight().setLeft(new BinaryTreeNode(6));
		node.getRight().setRight(new BinaryTreeNode(7));

		maxSumLevel(node);
	}
}