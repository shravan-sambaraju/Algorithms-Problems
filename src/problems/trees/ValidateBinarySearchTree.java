package problems.trees;

import common.utils.BinaryTreeNode;

/* Validate if given tree is binary search tree */

class ValidateBinarySearchTree {

	private BinaryTreeNode prev;

	private static boolean isBST(BinaryTreeNode node) {
		return isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isBST(BinaryTreeNode node, int minValue, int maxValue) {
		if (node == null) {
			return true;
		}
		if (node.getData() < minValue || node.getData() > maxValue)
			return false;
		return (isBST(node.getLeft(), minValue, node.getData() - 1)
				&& isBST(node.getRight(), node.getData() + 1, maxValue));
	}

	private boolean isBSTIterative(BinaryTreeNode node) {
		prev = null;
		return isBSTIterativeUtil(node);
	}

	private boolean isBSTIterativeUtil(BinaryTreeNode node) {
		if (node != null) {
			if (!isBST(node.getLeft()))
				return false;
			if (prev != null && node.getData() <= prev.getData())
				return false;
			prev = node;
			return isBST(node.getRight());
		}
		return true;
	}

	public static void main(String args[]) {

		BinaryTreeNode node = new BinaryTreeNode(50);
		node.setLeft(new BinaryTreeNode(30));
		node.setRight(new BinaryTreeNode(70));
		node.getLeft().setLeft(new BinaryTreeNode(20));
		node.getLeft().setRight(new BinaryTreeNode(40));
		node.getRight().setLeft(new BinaryTreeNode(60));
		node.getRight().setRight(new BinaryTreeNode(80));
		node.getRight().getRight().setRight(new BinaryTreeNode(100));

		BinaryTreeNode node2 = new BinaryTreeNode(50);
		node2.setLeft(new BinaryTreeNode(60));
		node2.setRight(new BinaryTreeNode(70));
		node2.getLeft().setLeft(new BinaryTreeNode(20));
		node2.getLeft().setRight(new BinaryTreeNode(40));
		node2.getRight().setLeft(new BinaryTreeNode(60));
		node2.getRight().setRight(new BinaryTreeNode(80));
		node2.getRight().getRight().setRight(new BinaryTreeNode(100));

		ValidateBinarySearchTree validtree = new ValidateBinarySearchTree();
		System.out.println(isBST(node));
		System.out.println(validtree.isBSTIterative(node));
		System.out.println(validtree.isBSTIterative(node2));
	}
}
