package problems.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversal {

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

	public static ArrayList<Integer> levelOrder(BinaryTreeNode root) {
		if (root == null) {
			System.out.println("Please enter a valid tree!");
			return null;
		}
		ArrayList<Integer> result = new ArrayList<>();
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		while (queue.size() > 0) {
			root = queue.poll();
			result.add(root.data);
			if (root.left != null) {
				queue.add(root.left);
			}
			if (root.right != null) {
				queue.add(root.right);
			}
		}
		return result;
	}

	public static void levelOrderReverse(BinaryTreeNode root) {

		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		queue.offer(root);
		while (queue.size() > 0) {
			root = queue.poll();
			stack.push(root);
			if (root.left != null) {
				queue.add(root.left);
			}
			if (root.right != null) {
				queue.add(root.right);
			}

		}

		while (!stack.isEmpty()) {
			System.out.println(stack.pop().data);

		}

	}

	public static void main(String args[]) {
		LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
		BinaryTreeNode node = levelOrderTraversal.new BinaryTreeNode(1);
		node.left = levelOrderTraversal.new BinaryTreeNode(2);
		node.right = levelOrderTraversal.new BinaryTreeNode(3);
		node.left.left = levelOrderTraversal.new BinaryTreeNode(4);
		node.left.right = levelOrderTraversal.new BinaryTreeNode(5);
		node.right.left = levelOrderTraversal.new BinaryTreeNode(6);
		node.right.right = levelOrderTraversal.new BinaryTreeNode(7);

		System.out.println(levelOrder(node).toString());
		levelOrderReverse(node);

	}
}
