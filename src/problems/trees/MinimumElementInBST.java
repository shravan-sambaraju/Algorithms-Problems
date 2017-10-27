package problems.trees;

public class MinimumElementInBST {
	
	public BinaryTreeNode minimumElement(BinaryTreeNode node){
		if(node ==null){
			return node;
		}
		else{
			if(node.left==null){
				return node;
			}else{
				return minimumElement(node.left);
			}
		}
		
		
	}
	
	public BinaryTreeNode minimumElementLevelOrder(BinaryTreeNode root){
		if(root==null){
			return null;
			
		}
		while(root.left!=null){
			root = root.left;
			
		}
		return root;
		
	}
	
	public static void main(String args[]) {
		
		MinimumElementInBST min = new MinimumElementInBST();
		BinaryTreeNode node = new BinaryTreeNode(50);
		node.left = new BinaryTreeNode(30);
		node.right = new BinaryTreeNode(70);
		node.left.left = new BinaryTreeNode(20);
		node.left.right = new BinaryTreeNode(40);
		node.right.left = new BinaryTreeNode(60);
		node.right.right = new BinaryTreeNode(80);
		
		System.out.println(min.minimumElement(node).data);
		System.out.println(min.minimumElementLevelOrder(node).data);
	}
	
}
