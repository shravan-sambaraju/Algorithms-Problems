package problems.trees;

/* Find element in binary search tree */

public class FindElementBinarySearchTree {

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

	public BinaryTreeNode find(BinaryTreeNode root, int data) {

		if (root == null) {
			return null;

		}
		if (data == root.data) {
			return root;
		}
		if (data < root.data) {
			return find(root.left, data);

		}
		return find(root.right, data);

	}

	public BinaryTreeNode findLevelOrder(BinaryTreeNode node, int data) {
		if (node == null) {
			return null;
		}
		while (node != null) {
			if (data == node.data) {
				return node;
			} else if (data < node.data) {
				node = node.left;
			} else {
				node = node.right;
			}

		}
		return null;
	}

	public static void main(String args[]) {
		FindElementBinarySearchTree tree = new FindElementBinarySearchTree();
		BinaryTreeNode node = tree.new BinaryTreeNode(50);
		node.left = tree.new BinaryTreeNode(30);
		node.right = tree.new BinaryTreeNode(70);
		node.left.left = tree.new BinaryTreeNode(20);
		node.left.right = tree.new BinaryTreeNode(40);
		node.right.left = tree.new BinaryTreeNode(60);
		node.right.right = tree.new BinaryTreeNode(80);

		System.out.println(tree.find(node, 60).data);
		System.out.println(tree.find(node, 133));
		System.out.println(tree.findLevelOrder(node, 30).data);

	}

}
