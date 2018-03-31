package problems.trees;

public class FindLowestCommonAncestor {

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

	public static BinaryTreeNode lca(BinaryTreeNode root, BinaryTreeNode n1, BinaryTreeNode n2) {
		if (root == null) {
			return null;
		}
		if (root == n1 || root == n2) {
			return root;
		}

		BinaryTreeNode left = lca(root.left, n1, n2);
		BinaryTreeNode right = lca(root.right, n1, n2);

		if (left != null && right != null) {
			return root;
		}
		return left != null ? left : right;
	}

	public static void main(String args[]) {
		FindLowestCommonAncestor findLowestCommonAncestor = new FindLowestCommonAncestor();
		BinaryTreeNode node = findLowestCommonAncestor.new BinaryTreeNode(1);
		node.left = findLowestCommonAncestor.new BinaryTreeNode(2);
		node.right = findLowestCommonAncestor.new BinaryTreeNode(3);
		node.left.left = findLowestCommonAncestor.new BinaryTreeNode(4);
		node.left.right = findLowestCommonAncestor.new BinaryTreeNode(5);
		node.right.left = findLowestCommonAncestor.new BinaryTreeNode(6);
		node.right.right = findLowestCommonAncestor.new BinaryTreeNode(7);

		BinaryTreeNode result = lca(node, node.left.left, node.right.left);
		System.out.println(result.data);

	}
}
