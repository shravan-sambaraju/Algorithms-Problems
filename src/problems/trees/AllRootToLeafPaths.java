package problems.trees;

/* Find all root to leaf paths */

public class AllRootToLeafPaths {

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

	public void printPaths(BinaryTreeNode root) {
		int[] path = new int[256];
		printPaths(root, path, 0);
	}

	private void printPaths(BinaryTreeNode root, int[] path, int pathLen) {
		if (root == null)
			return;
		// append this node to the path array
		path[pathLen] = root.data;
		pathLen++;
		// it's a leaf, so print the path that led to here
		if (root.left == null && root.right == null) {
			printArray(path, pathLen);
		} else { // otherwise try both subtrees
			printPaths(root.left, path, pathLen);
			printPaths(root.right, path, pathLen);
		}
	}

	private void printArray(int[] ints, int len) {
		for (int i = 0; i < len; i++) {
			System.out.print(ints[i] + " ");
		}
		System.out.println();
	}

	public static void main(String args[]) {
		AllRootToLeafPaths allRootToLeafPaths = new AllRootToLeafPaths();
		BinaryTreeNode node = allRootToLeafPaths.new BinaryTreeNode(1);
		node.left = allRootToLeafPaths.new BinaryTreeNode(2);
		node.right = allRootToLeafPaths.new BinaryTreeNode(3);
		node.left.left = allRootToLeafPaths.new BinaryTreeNode(4);
		node.left.right = allRootToLeafPaths.new BinaryTreeNode(5);
		node.right.left = allRootToLeafPaths.new BinaryTreeNode(6);
		node.right.right = allRootToLeafPaths.new BinaryTreeNode(7);

		AllRootToLeafPaths paths = new AllRootToLeafPaths();

		paths.printPaths(node);

	}

}
