package problems.trees;

/* Print pre oder traversal of binary tree */

import java.util.ArrayList;
import java.util.Stack;

public class PreOrderTraversal {

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

	public static ArrayList<Integer> interativePreOder(BinaryTreeNode head) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (head == null) {
			return result;

		}

		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		stack.push(head);
		while (!stack.isEmpty()) {
			BinaryTreeNode temp = stack.pop();
			result.add(temp.data);
			if (temp.right != null) {
				stack.push(temp.right);

			}
			if (temp.left != null) {
				stack.push(temp.left);

			}

		}

		return result;

	}

	public static void recursivePreOrder(BinaryTreeNode head) {
		if (head != null) {
			System.out.println(head.data);
			recursivePreOrder(head.left);
			recursivePreOrder(head.right);

		}

	}

	public static void main(String args[]) {
		PreOrderTraversal preOrderTraversal = new PreOrderTraversal();
		BinaryTreeNode node = preOrderTraversal.new BinaryTreeNode(1);
		node.left = preOrderTraversal.new BinaryTreeNode(2);
		node.right = preOrderTraversal.new BinaryTreeNode(3);
		node.left.left = preOrderTraversal.new BinaryTreeNode(4);
		node.left.right = preOrderTraversal.new BinaryTreeNode(5);
		node.right.left = preOrderTraversal.new BinaryTreeNode(6);
		node.right.right = preOrderTraversal.new BinaryTreeNode(7);

		System.out.println(interativePreOder(node).toString());
		recursivePreOrder(node);

	}

}
