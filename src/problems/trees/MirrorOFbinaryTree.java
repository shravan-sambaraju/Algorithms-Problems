package problems.trees;

public class MirrorOFbinaryTree {

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
		BinaryTreeNode node = new BinaryTreeNode(1);
		node.left = new BinaryTreeNode(2);
		node.right = new BinaryTreeNode(3);
		node.left.left = new BinaryTreeNode(4);
		node.left.right = new BinaryTreeNode(5);
		node.right.left = new BinaryTreeNode(6);
		node.right.right = new BinaryTreeNode(7);

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
