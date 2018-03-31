package problems.trees;

public class DeleteFromBinarySearchTree {

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

	public static BinaryTreeNode deleteRecursive(BinaryTreeNode node, int value) {

		BinaryTreeNode temp;

		if (node == null) {
			return null;
		}

		if (value < node.data) {
			node.left = deleteRecursive(node.left, value);

		} else if (value > node.data) {
			node.right = deleteRecursive(node.right, value);
		} else {

			if (node.left != null && node.right != null) {
				temp = findMax(node.left);
				node.setData(temp.data);
				node.left = deleteRecursive(node.left, node.data);

			} else if (node.left == null && node.right == null) {
				node = null;
			}

			else {
				temp = node;
				if (node.left == null && node.right == null) {
					node = null;
				}

				if (node.left == null) {
					node = node.right;

				} else if (node.right == null) {
					node = node.left;

				}
			}
		}

		return node;

	}

	private static BinaryTreeNode findMax(BinaryTreeNode root) {
		BinaryTreeNode leftMax = root;
		while (root.right != null) {
			leftMax = root.right;
			root = root.right;

		}
		return leftMax;
	}

	public static void main(String args[]) {
		DeleteFromBinarySearchTree deleteFromBinarySearchTree = new DeleteFromBinarySearchTree();
		BinaryTreeNode node = deleteFromBinarySearchTree.new BinaryTreeNode(50);
		node.left = deleteFromBinarySearchTree.new BinaryTreeNode(30);
		node.right = deleteFromBinarySearchTree.new BinaryTreeNode(70);
		node.left.left = deleteFromBinarySearchTree.new BinaryTreeNode(20);
		node.left.right = deleteFromBinarySearchTree.new BinaryTreeNode(40);
		node.right.left = deleteFromBinarySearchTree.new BinaryTreeNode(60);
		node.right.right = deleteFromBinarySearchTree.new BinaryTreeNode(80);
		node.right.right.right = deleteFromBinarySearchTree.new BinaryTreeNode(100);

		BinaryTreeNode node2 = deleteFromBinarySearchTree.new BinaryTreeNode(50);
		node2.left = deleteFromBinarySearchTree.new BinaryTreeNode(30);
		node2.right = deleteFromBinarySearchTree.new BinaryTreeNode(70);
		node2.left.left = deleteFromBinarySearchTree.new BinaryTreeNode(20);
		node2.left.right = deleteFromBinarySearchTree.new BinaryTreeNode(40);
		node2.right.left = deleteFromBinarySearchTree.new BinaryTreeNode(60);
		node2.right.right = deleteFromBinarySearchTree.new BinaryTreeNode(80);
		node2.right.right.right = deleteFromBinarySearchTree.new BinaryTreeNode(100);

		BinaryTreeNode node3 = deleteFromBinarySearchTree.new BinaryTreeNode(50);
		node3.left = deleteFromBinarySearchTree.new BinaryTreeNode(30);
		node3.right = deleteFromBinarySearchTree.new BinaryTreeNode(70);
		node3.left.left = deleteFromBinarySearchTree.new BinaryTreeNode(20);
		node3.left.right = deleteFromBinarySearchTree.new BinaryTreeNode(40);
		node3.right.left = deleteFromBinarySearchTree.new BinaryTreeNode(60);
		node3.right.left.left = deleteFromBinarySearchTree.new BinaryTreeNode(55);
		node3.right.right = deleteFromBinarySearchTree.new BinaryTreeNode(80);
		node3.right.right.right = deleteFromBinarySearchTree.new BinaryTreeNode(100);

		BinaryTreeNode leafDeleted = node;
		BinaryTreeNode noRightDeleted = node2;
		BinaryTreeNode twoChildDelete = node3;

		System.out.println(leafDeleted.right.right.right.data);
		leafDeleted = deleteRecursive(leafDeleted, 100);
		if (null == leafDeleted.right.right.right) {
			System.out.println("deleted");

		}
		System.out.println(noRightDeleted.right.right.data);
		noRightDeleted = deleteRecursive(noRightDeleted, 80);
		System.out.println(noRightDeleted.right.right.data);

		System.out.println(twoChildDelete.right.data);
		twoChildDelete = deleteRecursive(twoChildDelete, 70);
		System.out.println(twoChildDelete.right.data);

	}

}
