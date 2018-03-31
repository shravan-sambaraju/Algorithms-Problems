package problems.trees;

/* Print size of binary tree */

import java.util.LinkedList;
import java.util.Queue;

public class SizeOfBinaryTree {

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

	public static int getSizeRecursive(BinaryTreeNode node) {
		if (node == null) {
			return 0;
		}
		return 1 + getSizeRecursive(node.left) + getSizeRecursive(node.right);

	}

	public static int getSizeLevelOrder(BinaryTreeNode node) {
		int count = 0;
		if (node == null) {
			return count;
		}
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(node);
		while (!q.isEmpty()) {
			BinaryTreeNode temp = q.poll();
			count++;
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
		SizeOfBinaryTree sizeOfBinaryTree = new SizeOfBinaryTree();
		BinaryTreeNode node = sizeOfBinaryTree.new BinaryTreeNode(1);
		node.left = sizeOfBinaryTree.new BinaryTreeNode(2);
		node.right = sizeOfBinaryTree.new BinaryTreeNode(3);
		node.left.left = sizeOfBinaryTree.new BinaryTreeNode(4);
		node.left.right = sizeOfBinaryTree.new BinaryTreeNode(5);
		node.right.left = sizeOfBinaryTree.new BinaryTreeNode(6);
		node.right.right = sizeOfBinaryTree.new BinaryTreeNode(7);

		System.out.println(getSizeRecursive(node));
		System.out.println(getSizeLevelOrder(node));
	}

}
