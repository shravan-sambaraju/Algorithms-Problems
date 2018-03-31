package problems.trees;

/* Find maximum element in binary search tree */

public class MaximumElementInBST {

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

	public BinaryTreeNode maximumElement(BinaryTreeNode node) {
		if (node == null) {
			return node;
		} else {
			if (node.right == null) {
				return node;
			} else {
				return maximumElement(node.right);
			}
		}

	}

	public BinaryTreeNode maximumElementLevelOrder(BinaryTreeNode root) {
		if (root == null) {
			return null;

		}
		while (root.right != null) {
			root = root.right;

		}
		return root;

	}

	public static void main(String args[]) {

		MaximumElementInBST max = new MaximumElementInBST();
		BinaryTreeNode node = max.new BinaryTreeNode(50);
		node.left = max.new BinaryTreeNode(30);
		node.right = max.new BinaryTreeNode(70);
		node.left.left = max.new BinaryTreeNode(20);
		node.left.right = max.new BinaryTreeNode(40);
		node.right.left = max.new BinaryTreeNode(60);
		node.right.right = max.new BinaryTreeNode(80);

		System.out.println(max.maximumElement(node).data);
		System.out.println(max.maximumElementLevelOrder(node).data);

	}

}
