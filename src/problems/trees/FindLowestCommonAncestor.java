package problems.trees;

public class FindLowestCommonAncestor {
	
	 public static BinaryTreeNode lca(BinaryTreeNode root, BinaryTreeNode n1, BinaryTreeNode n2){
	        if(root == null){
	            return null;
	        }
	        if(root == n1 || root == n2){
	            return root;
	        }
	        
	        BinaryTreeNode left = lca(root.left, n1, n2);
	        BinaryTreeNode right = lca(root.right, n1, n2);

	        if(left != null && right != null){
	            return root;
	        }
	        return left != null ? left : right;
	    }
	 
	 public static void main(String args[]) {
			BinaryTreeNode node = new BinaryTreeNode(1);
			node.left = new BinaryTreeNode(2);
			node.right = new BinaryTreeNode(3);
			node.left.left = new BinaryTreeNode(4);
			node.left.right = new BinaryTreeNode(5);
			node.right.left = new BinaryTreeNode(6);
			node.right.right = new BinaryTreeNode(7);
			
			BinaryTreeNode result = lca(node, node.left.left,node.right.left);
			System.out.println(result.data);
			

}}
