package problems.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSum {
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
			BinaryTreeNode node = new BinaryTreeNode(1);
			node.left = new BinaryTreeNode(2);
			node.right = new BinaryTreeNode(3);
			node.left.left = new BinaryTreeNode(4);
			node.left.right = new BinaryTreeNode(5);
			node.right.left = new BinaryTreeNode(6);
			node.right.right = new BinaryTreeNode(7);

			maxSumLevel(node);
		}
}