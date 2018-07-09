package problems.trees;

/* Find element in binary search tree */

import common.utils.BinaryTreeNode;

class FindElementBinarySearchTree {

	private BinaryTreeNode find(BinaryTreeNode root, int data) {

		if (root == null) {
			return null;
		}
		if (data == root.getData()) {
			return root;
		}
		if (data < root.getData()) {
			return find(root.getLeft(), data);
		}
		return find(root.getRight(), data);
	}

	private BinaryTreeNode findLevelOrder(BinaryTreeNode node, int data) {
		if (node == null) {
			return null;
		}
		while (node != null) {
			if (data == node.getData()) {
				return node;
			} else if (data < node.getData()) {
				node = node.getLeft();
			} else {
				node = node.getRight();
			}
		}
		return null;
	}

	public static void main(String args[]) {
		FindElementBinarySearchTree tree = new FindElementBinarySearchTree();
		BinaryTreeNode node = new BinaryTreeNode(50);
		node.setLeft(new BinaryTreeNode(30));
		node.setRight(new BinaryTreeNode(70));
		node.getLeft().setLeft(new BinaryTreeNode(20));
		node.getLeft().setRight(new BinaryTreeNode(40));
		node.getRight().setLeft(new BinaryTreeNode(60));
		node.getRight().setRight(new BinaryTreeNode(80));

		System.out.println(tree.find(node, 60).getData());
		System.out.println(tree.find(node, 133));
		System.out.println(tree.findLevelOrder(node, 30).getData());

	}

}
