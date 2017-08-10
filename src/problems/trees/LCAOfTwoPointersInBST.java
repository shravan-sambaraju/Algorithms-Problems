package problems.trees;

public class LCAOfTwoPointersInBST {
	
	public static BinaryTreeNode findLCA(BinaryTreeNode root, BinaryTreeNode a, BinaryTreeNode b){
		if(root==null){
			return null;
		}
		if(root==a|| root==b){
			return root;
		}
		if(Math.max(a.data, b.data)<root.data){
			return findLCA(root.left,a,b);
			
		}else if(Math.min(a.data, b.data)>root.data){
			return findLCA(root.right,a,b);
		}else{
			return root;
		}
		
	}
	
	public static void main(String args[]){
		BinaryTreeNode node = new BinaryTreeNode(50);
		node.left = new BinaryTreeNode(30);
		node.right = new BinaryTreeNode(70);
		node.left.left = new BinaryTreeNode(20);
		node.left.right = new BinaryTreeNode(40);
		node.right.left = new BinaryTreeNode(60);
		node.right.right = new BinaryTreeNode(80);
		node.right.right.right = new BinaryTreeNode(100);
		
		BinaryTreeNode lca = findLCA(node,node.left.left,node.right.left);
		System.out.println(lca.data);
		
	}

}
