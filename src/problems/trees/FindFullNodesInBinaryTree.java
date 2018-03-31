package problems.trees;

import java.util.LinkedList;
import java.util.Queue;

public class FindFullNodesInBinaryTree {

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

	public static int getNumberOfFullNodesRecursion(BinaryTreeNode node) {
		int count = 0;
		if (node == null) {
			return 0;

		}
		if (node.left != null && node.right != null) {
			count++;
		}

		count += getNumberOfFullNodesRecursion(node.left) + getNumberOfFullNodesRecursion(node.right);

		return count;

	}

	public static int getNumberOfFullNodesLevelOrder(BinaryTreeNode node) {
		int count = 0;
		if (node == null) {
			return 0;
		}
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(node);
		while (!q.isEmpty()) {
			BinaryTreeNode temp = q.poll();
			if (temp.left != null && temp.right != null) {
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
		FindFullNodesInBinaryTree findFullNodesInBinaryTree = new FindFullNodesInBinaryTree();
		BinaryTreeNode node = findFullNodesInBinaryTree.new BinaryTreeNode(1);
		node.left = findFullNodesInBinaryTree.new BinaryTreeNode(2);
		node.right = findFullNodesInBinaryTree.new BinaryTreeNode(3);
		node.left.left = findFullNodesInBinaryTree.new BinaryTreeNode(4);
		node.left.right = findFullNodesInBinaryTree.new BinaryTreeNode(5);
		node.right.left = findFullNodesInBinaryTree.new BinaryTreeNode(6);
		node.right.right = findFullNodesInBinaryTree.new BinaryTreeNode(7);

		System.out.println(getNumberOfFullNodesRecursion(node));
		System.out.println(getNumberOfFullNodesLevelOrder(node));

	}

}
