package problems.trees;

public class FindAllAncestorsOfNode {

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

	public static boolean printAllAncestors(BinaryTreeNode root, BinaryTreeNode node) {
		if (root == null)
			return false;
		if (root.left == node || root.right == node || printAllAncestors(root.left, node)
				|| printAllAncestors(root.right, node)) {
			System.out.println(root.data);
			return true;
		}
		return false;
	}

	public static void main(String args[]) {
		FindAllAncestorsOfNode findAllAncestorsOfNode = new FindAllAncestorsOfNode();
		BinaryTreeNode node = findAllAncestorsOfNode.new BinaryTreeNode(1);
		node.left = findAllAncestorsOfNode.new BinaryTreeNode(2);
		node.right = findAllAncestorsOfNode.new BinaryTreeNode(3);
		node.left.left = findAllAncestorsOfNode.new BinaryTreeNode(4);
		node.left.right = findAllAncestorsOfNode.new BinaryTreeNode(5);
		node.right.left = findAllAncestorsOfNode.new BinaryTreeNode(6);
		node.right.right = findAllAncestorsOfNode.new BinaryTreeNode(7);

		printAllAncestors(node, node.right.right);
	}

}
