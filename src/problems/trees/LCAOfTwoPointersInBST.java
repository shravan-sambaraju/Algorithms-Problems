package problems.trees;

/* Lowest common ancestor of two pointers in binary search tree */

public class LCAOfTwoPointersInBST {

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

	public static BinaryTreeNode findLCA(BinaryTreeNode root, BinaryTreeNode a, BinaryTreeNode b) {
		if (root == null) {
			return null;
		}
		if (root == a || root == b) {
			return root;
		}
		if (Math.max(a.data, b.data) < root.data) {
			return findLCA(root.left, a, b);

		} else if (Math.min(a.data, b.data) > root.data) {
			return findLCA(root.right, a, b);
		} else {
			return root;
		}

	}

	public static void main(String args[]) {
		LCAOfTwoPointersInBST lcaOfTwoPointersInBST = new LCAOfTwoPointersInBST();
		BinaryTreeNode node = lcaOfTwoPointersInBST.new BinaryTreeNode(50);
		node.left = lcaOfTwoPointersInBST.new BinaryTreeNode(30);
		node.right = lcaOfTwoPointersInBST.new BinaryTreeNode(70);
		node.left.left = lcaOfTwoPointersInBST.new BinaryTreeNode(20);
		node.left.right = lcaOfTwoPointersInBST.new BinaryTreeNode(40);
		node.right.left = lcaOfTwoPointersInBST.new BinaryTreeNode(60);
		node.right.right = lcaOfTwoPointersInBST.new BinaryTreeNode(80);
		node.right.right.right = lcaOfTwoPointersInBST.new BinaryTreeNode(100);

		BinaryTreeNode lca = findLCA(node, node.left.left, node.right.left);
		System.out.println(lca.data);

	}

}
