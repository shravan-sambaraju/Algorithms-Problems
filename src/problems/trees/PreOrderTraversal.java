package problems.trees;

import java.util.ArrayList;
import java.util.Stack;

public class PreOrderTraversal {

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
		BinaryTreeNode node = new BinaryTreeNode(1);
		node.left = new BinaryTreeNode(2);
		node.right = new BinaryTreeNode(3);
		node.left.left = new BinaryTreeNode(4);
		node.left.right = new BinaryTreeNode(5);
		node.right.left = new BinaryTreeNode(6);
		node.right.right = new BinaryTreeNode(7);

		System.out.println(interativePreOder(node).toString());
		recursivePreOrder(node);

	}

}
