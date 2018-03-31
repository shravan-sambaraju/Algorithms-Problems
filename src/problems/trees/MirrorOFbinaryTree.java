package problems.trees;

public class MirrorOFbinaryTree {

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

	public BinaryTreeNode mirrorOfBinaryTree(BinaryTreeNode root) {
		BinaryTreeNode temp;
		if (root != null) {
			mirrorOfBinaryTree(root.left);
			mirrorOfBinaryTree(root.right);
			/* swap the pointers in this node */
			temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
		return root;
	}

	public static void main(String args[]) {
		MirrorOFbinaryTree mirrorOFbinaryTree = new MirrorOFbinaryTree();
		BinaryTreeNode node = mirrorOFbinaryTree.new BinaryTreeNode(1);
		node.left = mirrorOFbinaryTree.new BinaryTreeNode(2);
		node.right = mirrorOFbinaryTree.new BinaryTreeNode(3);
		node.left.left = mirrorOFbinaryTree.new BinaryTreeNode(4);
		node.left.right = mirrorOFbinaryTree.new BinaryTreeNode(5);
		node.right.left = mirrorOFbinaryTree.new BinaryTreeNode(6);
		node.right.right = mirrorOFbinaryTree.new BinaryTreeNode(7);

		recursiveInorder(node);

		MirrorOFbinaryTree mirror = new MirrorOFbinaryTree();

		System.out.println();

		BinaryTreeNode mirrortree = mirror.mirrorOfBinaryTree(node);

		recursiveInorder(mirrortree);

	}

	public static void recursiveInorder(BinaryTreeNode head) {
		if (head != null) {
			recursiveInorder(head.left);
			System.out.print(head.data);
			recursiveInorder(head.right);

		}

	}

}
