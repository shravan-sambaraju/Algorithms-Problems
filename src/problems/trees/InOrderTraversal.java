package problems.trees;

/* Print inorder traversal of binary node */

import java.util.ArrayList;
import java.util.Stack;

public class InOrderTraversal {

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

	public static void recursiveInorder(BinaryTreeNode head) {
		if (head != null) {
			recursiveInorder(head.left);
			System.out.println(head.data);
			recursiveInorder(head.right);

		}

	}

	public static ArrayList<Integer> iterativeInorder(BinaryTreeNode head) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (head == null) {
			return result;

		}
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		BinaryTreeNode current = head;
		boolean done = false;
		while (!done) {
			if (current != null) {
				stack.push(current);
				current = current.left;
			} else {
				if (stack.isEmpty())
					done = true;
				else {
					current = stack.pop();
					result.add(current.data);
					current = current.right;
				}
			}
		}
		return result;
	}

	public static void main(String args[]) {
		InOrderTraversal inOrderTraversal = new InOrderTraversal();
		BinaryTreeNode node = inOrderTraversal.new BinaryTreeNode(1);
		node.left = inOrderTraversal.new BinaryTreeNode(2);
		node.right = inOrderTraversal.new BinaryTreeNode(3);
		node.left.left = inOrderTraversal.new BinaryTreeNode(4);
		node.left.right = inOrderTraversal.new BinaryTreeNode(5);
		node.right.left = inOrderTraversal.new BinaryTreeNode(6);
		node.right.right = inOrderTraversal.new BinaryTreeNode(7);

		System.out.println(iterativeInorder(node).toString());
		recursiveInorder(node);

	}
}