package problems.trees;

public class MaximumElementInBST {

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
		BinaryTreeNode node = new BinaryTreeNode(50);
		node.left = new BinaryTreeNode(30);
		node.right = new BinaryTreeNode(70);
		node.left.left = new BinaryTreeNode(20);
		node.left.right = new BinaryTreeNode(40);
		node.right.left = new BinaryTreeNode(60);
		node.right.right = new BinaryTreeNode(80);
		
		System.out.println(max.maximumElement(node).data);
		System.out.println(max.maximumElementLevelOrder(node).data);

	}

}
