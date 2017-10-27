package problems.trees;

public class FindAllAncestorsOfNode {
	
	public static boolean printAllAncestors(BinaryTreeNode root, BinaryTreeNode node){
		if(root == null) 
			return false;
		if(root.left == node || root.right == node || 
			printAllAncestors(root.left, node) || printAllAncestors(root.right, node)) {
			System.out.println(root.data);
			return true;
		}
		return false;
	}
	
	public static void main(String args[]) {
		BinaryTreeNode node = new BinaryTreeNode(1);
		node.left = new BinaryTreeNode(2);
		node.right = new BinaryTreeNode(3);
		node.left.left = new BinaryTreeNode(4);
		node.left.right = new BinaryTreeNode(5);
		node.right.left = new BinaryTreeNode(6);
		node.right.right = new BinaryTreeNode(7);

		printAllAncestors(node,node.right.right);
	}

}
