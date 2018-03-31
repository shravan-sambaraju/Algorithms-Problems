package problems.trees;

/* Find all leaf nodes in binary tree */

import java.util.LinkedList;
import java.util.Queue;

public class FindLeafNodesinBinaryTree {

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

	public static int getNumberOfLEafNodesRecursion(BinaryTreeNode node) {
		if (node == null) {
			return 0;

		}
		if (node.left == null && node.right == null) {
			return 1;
		}

		return getNumberOfLEafNodesRecursion(node.left) + getNumberOfLEafNodesRecursion(node.right);

	}

	public static int getNumberOfLEafNodesLevelOrder(BinaryTreeNode node) {
		int count = 0;
		if (node == null) {
			return 0;
		}
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(node);
		while (!q.isEmpty()) {
			BinaryTreeNode temp = q.poll();
			if (temp.left == null && temp.right == null) {
				count++;

			}
			if (temp.left != null) {
				q.offer(temp.left);
			}
			if (temp.right != null) {
				q.offer(temp.right);

			}

		}
		return count;

	}

	public static void main(String args[]) {
		FindLeafNodesinBinaryTree findLeafNodesinBinaryTree = new FindLeafNodesinBinaryTree();
		BinaryTreeNode node = findLeafNodesinBinaryTree.new BinaryTreeNode(1);
		node.left = findLeafNodesinBinaryTree.new BinaryTreeNode(2);
		node.right = findLeafNodesinBinaryTree.new BinaryTreeNode(3);
		node.left.left = findLeafNodesinBinaryTree.new BinaryTreeNode(4);
		node.left.right = findLeafNodesinBinaryTree.new BinaryTreeNode(5);
		node.right.left = findLeafNodesinBinaryTree.new BinaryTreeNode(6);
		node.right.right = findLeafNodesinBinaryTree.new BinaryTreeNode(7);

		System.out.println(getNumberOfLEafNodesRecursion(node));
		System.out.println(getNumberOfLEafNodesLevelOrder(node));

	}

}
