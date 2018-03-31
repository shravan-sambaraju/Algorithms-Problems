package problems.trees;

/* Find width of binary tree */

public class WidthOfBinaryTree {

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

	public static int width(BinaryTreeNode root) {
		int max = 0;
		int height = maxDepthRecursive(root);
		for (int k = 0; k <= height; k++) {
			int tmp = width(root, k);
			if (tmp > max)
				max = tmp;
		}
		return max;
	}

	// Returns the number of node on a given level
	public static int width(BinaryTreeNode root, int depth) {
		if (root == null)
			return 0;
		else if (depth == 0)
			return 1;
		else
			return width(root.left, depth - 1) + width(root.right, depth - 1);
	}

	public static int maxDepthRecursive(BinaryTreeNode root) {
		if (root == null)
			return 0;
		/* compute the depth of each subtree */
		int leftDepth = maxDepthRecursive(root.left);
		int rightDepth = maxDepthRecursive(root.right);
		return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
	}

	public static void main(String args[]) {
		WidthOfBinaryTree widthOfBinaryTree = new WidthOfBinaryTree();
		BinaryTreeNode node = widthOfBinaryTree.new BinaryTreeNode(1);
		node.left = widthOfBinaryTree.new BinaryTreeNode(2);
		node.right = widthOfBinaryTree.new BinaryTreeNode(3);
		node.left.left = widthOfBinaryTree.new BinaryTreeNode(4);
		node.left.right = widthOfBinaryTree.new BinaryTreeNode(5);
		node.right.left = widthOfBinaryTree.new BinaryTreeNode(6);
		node.right.right = widthOfBinaryTree.new BinaryTreeNode(7);

		System.out.println(width(node));

	}

}
