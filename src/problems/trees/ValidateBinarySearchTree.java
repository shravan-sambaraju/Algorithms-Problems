package problems.trees;

public class ValidateBinarySearchTree {
	BinaryTreeNode prev;
	
	public static boolean isBST(BinaryTreeNode node){
		return isBST(node, Integer.MIN_VALUE,Integer.MAX_VALUE);
		
	}

	private static boolean isBST(BinaryTreeNode node, int minValue, int maxValue) {
		if(node==null){
			return true;
		}
		if (node.data < minValue || node.data > maxValue)
	          return false;
		// TODO Auto-generated method stub
		return (isBST(node.left, minValue, node.data-1) &&
				isBST(node.right, node.data+1, maxValue));
	}
	
	boolean isBSTIterative(BinaryTreeNode node)  {
        prev = null;
        return isBSTIterativeUtil(node);
    }
 
    /* Returns true if given search tree is binary
       search tree (efficient version) */
    boolean isBSTIterativeUtil(BinaryTreeNode node)
    {
        // traverse the tree in inorder fashion and
        // keep a track of previous node
        if (node != null)
        {
            if (!isBST(node.left))
                return false;
 
            // allows only distinct values node
            if (prev != null && node.data <= prev.data )
                return false;
            prev = node;
            return isBST(node.right);
        }
        return true;
    }
	
	public static void main(String args[]){
		
		ValidateBinarySearchTree validtree = new ValidateBinarySearchTree();
		BinaryTreeNode node = new BinaryTreeNode(50);
		node.left = new BinaryTreeNode(30);
		node.right = new BinaryTreeNode(70);
		node.left.left = new BinaryTreeNode(20);
		node.left.right = new BinaryTreeNode(40);
		node.right.left = new BinaryTreeNode(60);
		node.right.right = new BinaryTreeNode(80);
		node.right.right.right = new BinaryTreeNode(100);
		
		BinaryTreeNode node2 = new BinaryTreeNode(50);
		node2.left = new BinaryTreeNode(60);
		node2.right = new BinaryTreeNode(70);
		node2.left.left = new BinaryTreeNode(20);
		node2.left.right = new BinaryTreeNode(40);
		node2.right.left = new BinaryTreeNode(60);
		node2.right.right = new BinaryTreeNode(80);
		node2.right.right.right = new BinaryTreeNode(100);
		
		
		System.out.println(isBST(node));
		System.out.println(validtree.isBSTIterative(node));
		System.out.println(validtree.isBSTIterative(node2));
		
	}
	

}