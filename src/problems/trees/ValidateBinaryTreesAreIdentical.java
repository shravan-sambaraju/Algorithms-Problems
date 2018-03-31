package problems.trees;

import java.util.LinkedList;
import java.util.Queue;

public class ValidateBinaryTreesAreIdentical {

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

	public static boolean checkIdenticalRecursive(BinaryTreeNode head1, BinaryTreeNode head2) {
		if (head1 == null && head2 == null) {
			return true;

		}
		if (head1 == null || head2 == null) {
			return false;

		}
		return (checkIdenticalRecursive(head1.left, head2.left) && checkIdenticalRecursive(head1.right, head2.right));

	}

	public static boolean checkIdenticalLevelOrder(BinaryTreeNode node1, BinaryTreeNode node2) {

		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		Queue<BinaryTreeNode> q1 = new LinkedList<BinaryTreeNode>();

		q.offer(node1);
		q1.offer(node2);

		while (!q.isEmpty() && !q1.isEmpty()) {
			BinaryTreeNode temp1 = q.poll();
			BinaryTreeNode temp2 = q1.poll();

			if (temp1.left != null && temp2.left != null) {
				q.offer(temp1.left);
				q1.offer(temp2.left);
			}
			if (temp2.right != null && temp1.right != null) {
				q.offer(temp1.right);
				q1.offer(temp2.right);

			}

			if ((temp1.left == null && temp2.left != null) || (temp2.right == null && temp1.right != null)
					|| (temp1.left != null && temp2.left == null) || (temp2.right != null && temp1.right == null)) {

				return false;
			}

		}
		return true;

	}

	public static void main(String args[]) {
		ValidateBinaryTreesAreIdentical validateBinaryTreesAreIdentical = new ValidateBinaryTreesAreIdentical();
		BinaryTreeNode node = validateBinaryTreesAreIdentical.new BinaryTreeNode(1);
		node.left = validateBinaryTreesAreIdentical.new BinaryTreeNode(2);
		node.right = validateBinaryTreesAreIdentical.new BinaryTreeNode(3);
		node.left.left = validateBinaryTreesAreIdentical.new BinaryTreeNode(4);
		node.left.right = validateBinaryTreesAreIdentical.new BinaryTreeNode(5);
		node.right.left = validateBinaryTreesAreIdentical.new BinaryTreeNode(6);
		node.right.right = validateBinaryTreesAreIdentical.new BinaryTreeNode(7);

		BinaryTreeNode node2 = validateBinaryTreesAreIdentical.new BinaryTreeNode(1);
		node2.left = validateBinaryTreesAreIdentical.new BinaryTreeNode(2);
		node2.right = validateBinaryTreesAreIdentical.new BinaryTreeNode(3);
		node2.left.left = validateBinaryTreesAreIdentical.new BinaryTreeNode(4);
		node2.left.right = validateBinaryTreesAreIdentical.new BinaryTreeNode(5);
		node2.right.left = validateBinaryTreesAreIdentical.new BinaryTreeNode(6);
		node2.right.right = validateBinaryTreesAreIdentical.new BinaryTreeNode(7);
		node2.right.right.right = validateBinaryTreesAreIdentical.new BinaryTreeNode(9);

		// System.out.println(checkIdenticalRecursive(node,node2));
		System.out.println(checkIdenticalLevelOrder(node, node2));

	}

}
