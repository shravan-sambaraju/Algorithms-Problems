package problems.trees;

public class DiameterOfBinaryTree {

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

	public static int diameter(BinaryTreeNode root) {
		if (root == null)
			return 0;

		// the path goes through the root
		int len1 = height(root.left) + height(root.right) + 1;

		// the path does not pass the root
		int len2 = Math.max(diameter(root.left), diameter(root.right));

		return Math.max(len1, len2);
	}

	public static int height(BinaryTreeNode root) {
		if (root == null)
			return 0;
		/* compute the depth of each subtree */
		int leftDepth = height(root.left);
		int rightDepth = height(root.right);
		return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
	}

	public static void main(String args[]) {
		DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
		BinaryTreeNode node = diameterOfBinaryTree.new BinaryTreeNode(1);
		node.left = diameterOfBinaryTree.new BinaryTreeNode(2);
		node.right = diameterOfBinaryTree.new BinaryTreeNode(3);
		node.left.left = diameterOfBinaryTree.new BinaryTreeNode(4);
		node.left.right = diameterOfBinaryTree.new BinaryTreeNode(5);
		node.right.left = diameterOfBinaryTree.new BinaryTreeNode(6);
		node.right.right = diameterOfBinaryTree.new BinaryTreeNode(7);

		System.out.println(diameter(node));
	}
}
