package problems.trees;

/* Print level order traversal of binary tree */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import common.utils.BinaryTreeNode;

class LevelOrderTraversal {

	private static ArrayList<Integer> levelOrder(BinaryTreeNode root) {
		if (root == null) {
			System.out.println("Please enter a valid tree!");
			return null;
		}
		ArrayList<Integer> result = new ArrayList<>();
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		while (queue.size() > 0) {
			root = queue.poll();
			result.add(root.getData());
			if (root.getLeft() != null) {
				queue.add(root.getLeft());
			}
			if (root.getRight() != null) {
				queue.add(root.getRight());
			}
		}
		return result;
	}

	private static void levelOrderReverse(BinaryTreeNode root) {

		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		queue.offer(root);
		while (queue.size() > 0) {
			root = queue.poll();
			stack.push(root);
			if (root.getLeft() != null) {
				queue.add(root.getLeft());
			}
			if (root.getRight() != null) {
				queue.add(root.getRight());
			}
		}

		while (!stack.isEmpty()) {
			System.out.println(stack.pop().getData());
		}
	}

	public static void main(String args[]) {

		BinaryTreeNode node = new BinaryTreeNode(1);
		node.setLeft(new BinaryTreeNode(2));
		node.setRight(new BinaryTreeNode(3));
		node.getLeft().setLeft(new BinaryTreeNode(4));
		node.getLeft().setRight(new BinaryTreeNode(5));
		node.getRight().setLeft(new BinaryTreeNode(6));
		node.getRight().setRight(new BinaryTreeNode(7));

		System.out.println(levelOrder(node).toString());
		levelOrderReverse(node);
	}
}
