package problems.trees;

public class MinimumElementInBST {

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

	public BinaryTreeNode minimumElement(BinaryTreeNode node) {
		if (node == null) {
			return node;
		} else {
			if (node.left == null) {
				return node;
			} else {
				return minimumElement(node.left);
			}
		}

	}

	public BinaryTreeNode minimumElementLevelOrder(BinaryTreeNode root) {
		if (root == null) {
			return null;

		}
		while (root.left != null) {
			root = root.left;

		}
		return root;

	}

	public static void main(String args[]) {

		MinimumElementInBST min = new MinimumElementInBST();
		BinaryTreeNode node = min.new BinaryTreeNode(50);
		node.left = min.new BinaryTreeNode(30);
		node.right = min.new BinaryTreeNode(70);
		node.left.left = min.new BinaryTreeNode(20);
		node.left.right = min.new BinaryTreeNode(40);
		node.right.left = min.new BinaryTreeNode(60);
		node.right.right = min.new BinaryTreeNode(80);

		System.out.println(min.minimumElement(node).data);
		System.out.println(min.minimumElementLevelOrder(node).data);
	}

}
