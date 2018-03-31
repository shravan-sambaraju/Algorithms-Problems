package problems.trees;

/* Print post order traversal of binary tree */

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderTraversal {

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

	public static void recursivePostOrder(BinaryTreeNode head) {
		if (head != null) {

			recursivePostOrder(head.left);
			recursivePostOrder(head.right);
			System.out.println(head.data);

		}
	}

	public static ArrayList<Integer> iterativePostOrderUsingOneStack(BinaryTreeNode head) {
		ArrayList<Integer> result = new ArrayList<>();
		if (head == null) {
			return result;
		}
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		stack.push(head);
		BinaryTreeNode prev = null;
		while (!stack.isEmpty()) {
			BinaryTreeNode curr = stack.peek();
			if (prev == null || prev.left == curr || prev.right == curr) {
				// traverse from top to bottom, and if curr has left child or
				// right child,
				// push into the stack; otherwise, pop out.
				if (curr.left != null)
					stack.push(curr.left);
				else if (curr.right != null)
					stack.push(curr.right);
			} else if (curr.left == prev) {
				if (curr.right != null)
					stack.push(curr.right);
			} else {
				result.add(curr.data);
				stack.pop();
			}
			prev = curr;
		}
		return result;
	}

	public static void interativePostOrderUsingTwoStack(BinaryTreeNode head) {
		Stack<BinaryTreeNode> stack1 = new Stack<BinaryTreeNode>();
		Stack<BinaryTreeNode> stack2 = new Stack<BinaryTreeNode>();
		stack1.push(head);

		while (!stack1.isEmpty()) {
			head = stack1.pop();
			if (head.left != null) {
				stack1.push(head.left);

			}
			if (head.right != null) {
				stack1.push(head.right);

			}

			stack2.push(head);
		}

		while (!stack2.isEmpty()) {
			System.out.println(stack2.pop().data);

		}

	}

	public static void main(String args[]) {
		PostOrderTraversal postOrderTraversal = new PostOrderTraversal();
		BinaryTreeNode node = postOrderTraversal.new BinaryTreeNode(1);
		node.left = postOrderTraversal.new BinaryTreeNode(2);
		node.right = postOrderTraversal.new BinaryTreeNode(3);
		node.left.left = postOrderTraversal.new BinaryTreeNode(4);
		node.left.right = postOrderTraversal.new BinaryTreeNode(5);
		node.right.left = postOrderTraversal.new BinaryTreeNode(6);
		node.right.right = postOrderTraversal.new BinaryTreeNode(7);

		BinaryTreeNode node1 = node;
		BinaryTreeNode node2 = node;

		System.out.println(iterativePostOrderUsingOneStack(node).toString());
		recursivePostOrder(node1);
		interativePostOrderUsingTwoStack(node2);

	}

}
