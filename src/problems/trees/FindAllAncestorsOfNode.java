package problems.trees;

/* Find all ancestors of given node */

import common.utils.BinaryTreeNode;

class FindAllAncestorsOfNode {

	private static boolean printAllAncestors(BinaryTreeNode root, BinaryTreeNode node) {
		if (root == null)
			return false;
		if (root.getLeft() == node || root.getRight() == node || printAllAncestors(root.getLeft(), node)
				|| printAllAncestors(root.getRight(), node)) {
			System.out.println(root.getData());
			return true;
		}
		return false;
	}

	public static void main(String args[]) {
		BinaryTreeNode node = new BinaryTreeNode(1);
		node.setLeft(new BinaryTreeNode(2));
		node.setRight(new BinaryTreeNode(3));
		node.getLeft().setLeft(new BinaryTreeNode(4));
		node.getLeft().setRight(new BinaryTreeNode(5));
		node.getRight().setLeft(new BinaryTreeNode(6));
		node.getRight().setRight(new BinaryTreeNode(7));

		printAllAncestors(node, node.getRight().getRight());
	}

}
