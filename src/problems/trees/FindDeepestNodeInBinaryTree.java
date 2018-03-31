package problems.trees;

/* Find deepest node in binary tree */

import java.util.LinkedList;
import java.util.Queue;

public class FindDeepestNodeInBinaryTree {

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

	public static BinaryTreeNode getdeepestBinaryNode(BinaryTreeNode head) {
		BinaryTreeNode temp = null;
		if (head == null) {
			return null;
		}
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(head);
		while (!q.isEmpty()) {
			temp = q.poll();
			if (temp.left != null) {
				q.offer(temp.left);

			}
			if (temp.right != null) {
				q.offer(temp.right);
			}

		}

		return temp;

	}

	public static void main(String args[]) {
		FindDeepestNodeInBinaryTree findDeepestNodeInBinaryTree = new FindDeepestNodeInBinaryTree();
		BinaryTreeNode node = findDeepestNodeInBinaryTree.new BinaryTreeNode(1);
		node.left = findDeepestNodeInBinaryTree.new BinaryTreeNode(2);
		node.right = findDeepestNodeInBinaryTree.new BinaryTreeNode(3);
		node.left.left = findDeepestNodeInBinaryTree.new BinaryTreeNode(4);
		node.left.right = findDeepestNodeInBinaryTree.new BinaryTreeNode(5);
		node.right.left = findDeepestNodeInBinaryTree.new BinaryTreeNode(6);
		node.right.right = findDeepestNodeInBinaryTree.new BinaryTreeNode(7);
		node.right.right.left = findDeepestNodeInBinaryTree.new BinaryTreeNode(8);

		System.out.println(getdeepestBinaryNode(node).data);

	}

}
