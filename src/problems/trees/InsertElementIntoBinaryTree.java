package problems.trees;

import java.util.LinkedList;
import java.util.Queue;

public class InsertElementIntoBinaryTree {

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

	public static BinaryTreeNode insertIntoTreeLevelOrder(BinaryTreeNode root, int data) {
		InsertElementIntoBinaryTree insertElementIntoBinaryTree = new InsertElementIntoBinaryTree();
		if (root == null) {
			return insertElementIntoBinaryTree.new BinaryTreeNode(data);
		}
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			BinaryTreeNode temp = q.poll();
			if (temp != null) {
				if (temp.left != null) {
					q.offer(temp.left);
				} else {
					temp.left = insertElementIntoBinaryTree.new BinaryTreeNode(data);
					return root;
				}
				if (temp.right != null) {
					q.offer(temp.right);
				} else {
					temp.right = insertElementIntoBinaryTree.new BinaryTreeNode(data);
					return root;
				}
			}

		}
		return root;

	}

	public static BinaryTreeNode insertElementIntoTreeRecursive(BinaryTreeNode root, int data) {
		InsertElementIntoBinaryTree insertElementIntoBinaryTree = new InsertElementIntoBinaryTree();
		if (root == null) {
			return insertElementIntoBinaryTree.new BinaryTreeNode(data);

		} else {
			insertHelper(root, data);
		}

		return root;

	}

	private static void insertHelper(BinaryTreeNode head, int element) {
		InsertElementIntoBinaryTree insertElementIntoBinaryTree = new InsertElementIntoBinaryTree();

		if (head.left == null) {
			head.left = insertElementIntoBinaryTree.new BinaryTreeNode(element);
		} else {
			insertHelper(head.left, element);
		}
		if (head.right == null) {
			head.right = insertElementIntoBinaryTree.new BinaryTreeNode(element);
		} else {
			insertHelper(head.right, element);
		}

	}

	public static void main(String args[]) {
		InsertElementIntoBinaryTree insertElementIntoBinaryTree = new InsertElementIntoBinaryTree();
		BinaryTreeNode node = insertElementIntoBinaryTree.new BinaryTreeNode(1);
		node.left = insertElementIntoBinaryTree.new BinaryTreeNode(2);
		node.right = insertElementIntoBinaryTree.new BinaryTreeNode(3);
		node.left.left = insertElementIntoBinaryTree.new BinaryTreeNode(4);
		node.left.right = insertElementIntoBinaryTree.new BinaryTreeNode(5);
		node.right.left = insertElementIntoBinaryTree.new BinaryTreeNode(6);
		node.right.right = insertElementIntoBinaryTree.new BinaryTreeNode(7);

		System.out.println(insertIntoTreeLevelOrder(node, 8).left.left.left.data);
		System.out.println(insertIntoTreeLevelOrder(node, 9).left.left.right.data);
		System.out.println(insertElementIntoTreeRecursive(node, 8).left.left.left.data);
		System.out.println(insertElementIntoTreeRecursive(node, 9).left.left.right.data);

	}

}
