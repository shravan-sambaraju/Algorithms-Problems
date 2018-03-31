package problems.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {

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

	public static int getMinimumDepthRecursive(BinaryTreeNode node) {
		if (node == null) {
			return 0;
		}

		if (node.left == null && node.right == null) {

			return 1;
		}

		if (node.left == null) {
			return getMinimumDepthRecursive(node.right) + 1;
		}
		if (node.right == null) {
			return getMinimumDepthRecursive(node.left) + 1;
		}
		return Math.min(getMinimumDepthRecursive(node.left), getMinimumDepthRecursive(node.right)) + 1;

	}

	public static int minDepthLevelOrder(BinaryTreeNode root) {
		if (root == null)
			return 0;
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		q.offer(null);
		int count = 1;
		while (!q.isEmpty()) {
			BinaryTreeNode currentNode = q.poll();
			if (currentNode != null) {
				if (currentNode.left == null && currentNode.right == null) {
					return count;
				}
				if (currentNode.left != null) {
					q.offer(currentNode.left);
				}
				if (currentNode.right != null) {
					q.offer(currentNode.right);
				}
			} else {
				if (!q.isEmpty()) {
					count++;
					q.offer(null);
				}
			}
		}
		return count;
	}

	public static void main(String args[]) {
		MinimumDepthOfBinaryTree minimumDepthOfBinaryTree = new MinimumDepthOfBinaryTree();
		BinaryTreeNode node = minimumDepthOfBinaryTree.new BinaryTreeNode(1);
		node.left = minimumDepthOfBinaryTree.new BinaryTreeNode(2);
		node.right = minimumDepthOfBinaryTree.new BinaryTreeNode(3);
		node.left.left = minimumDepthOfBinaryTree.new BinaryTreeNode(4);
		node.left.right = minimumDepthOfBinaryTree.new BinaryTreeNode(5);
		node.right.left = minimumDepthOfBinaryTree.new BinaryTreeNode(6);
		node.right.right = minimumDepthOfBinaryTree.new BinaryTreeNode(7);
		node.left.left.left = minimumDepthOfBinaryTree.new BinaryTreeNode(8);
		node.left.left.right = minimumDepthOfBinaryTree.new BinaryTreeNode(9);
		node.right.left.left = minimumDepthOfBinaryTree.new BinaryTreeNode(10);
		node.right.left.right = minimumDepthOfBinaryTree.new BinaryTreeNode(11);
		node.right.right.left = minimumDepthOfBinaryTree.new BinaryTreeNode(12);
		node.right.right.right = minimumDepthOfBinaryTree.new BinaryTreeNode(13);

		System.out.println(getMinimumDepthRecursive(node));
		System.out.println(minDepthLevelOrder(node));

	}

}
