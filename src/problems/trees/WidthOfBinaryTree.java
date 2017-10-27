package problems.trees;

public class WidthOfBinaryTree {
	
	 public static int width(BinaryTreeNode root)
	   {
	      int max = 0;
	      int height = maxDepthRecursive(root);
	      for(int k = 0; k <= height; k++)
	      {
	         int tmp = width(root, k);
	         if(tmp > max) max = tmp;
	      }
	      return max;
	   }
	   // Returns the number of node on a given level
	   public static int width(BinaryTreeNode root, int depth)
	   {
	      if(root==null) 
	    	  return 0;
	      else
		      if(depth == 0) 
		    	  return 1;
		      else
		    	  return width(root.left, depth-1) + width(root.right, depth-1);
	   }
	    public static int maxDepthRecursive(BinaryTreeNode root) {
	        if(root == null) return 0;
	        /* compute the depth of each subtree */
	        int leftDepth = maxDepthRecursive(root.left);
	        int rightDepth = maxDepthRecursive(root.right);
	        return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
	    } 
	    
	    public static void main(String args[]) {
			BinaryTreeNode node = new BinaryTreeNode(1);
			node.left = new BinaryTreeNode(2);
			node.right = new BinaryTreeNode(3);
			node.left.left = new BinaryTreeNode(4);
			node.left.right = new BinaryTreeNode(5);
			node.right.left = new BinaryTreeNode(6);
			node.right.right = new BinaryTreeNode(7);

			System.out.println(width(node));

		}

}
