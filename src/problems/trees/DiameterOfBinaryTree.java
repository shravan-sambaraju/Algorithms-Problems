package problems.trees;

public class DiameterOfBinaryTree {

	
	public static int diameter(BinaryTreeNode root){
		if(root==null) return 0;

		//the path goes through the root
		int len1 = height(root.left) + height(root.right)+1;

		//the path does not pass the root
		int len2 = Math.max(diameter(root.left), diameter(root.right));

		return Math.max(len1, len2);
	}
	public static int height(BinaryTreeNode root) {
		if(root == null) 
			return 0;
		/* compute the depth of each subtree */
		int leftDepth = height(root.left);
		int rightDepth = height(root.right);
		return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
	} 

	public static void main(String args[]){
		BinaryTreeNode node = new BinaryTreeNode(1);
		node.left = new BinaryTreeNode(2);
		node.right = new BinaryTreeNode(3);
		node.left.left = new BinaryTreeNode(4);
		node.left.right = new BinaryTreeNode(5);
		node.right.left = new BinaryTreeNode(6);
		node.right.right = new BinaryTreeNode(7);
		
		System.out.println(diameter(node));
	}
}
