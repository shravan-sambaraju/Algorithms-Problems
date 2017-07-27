package problems.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {

	public static int getMinimumDepthRecursive(BinaryTreeNode node) {
		if (node == null) {
			return 0;
		}

		if (node.left == null && node.right == null) {

			return 1;
		}
		
		if(node.left==null){
			return getMinimumDepthRecursive(node.right)+1;
		}
		if(node.right==null){
			return getMinimumDepthRecursive(node.left)+1;
		}
		return Math.min(getMinimumDepthRecursive(node.left), getMinimumDepthRecursive(node.right))+1;

	}
	
	 public static int minDepthLevelOrder(BinaryTreeNode root) {
	        if(root == null) return 0;
	        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
	        q.offer(root);
	        q.offer(null);
	        int count = 1;
	        while(!q.isEmpty()){
	            BinaryTreeNode currentNode = q.poll();
	            if(currentNode != null){
	                if(currentNode.left == null && currentNode.right == null){
	                    return count;
	                }
	                if(currentNode.left != null){
	                    q.offer(currentNode.left);
	                }
	                if(currentNode.right != null){
	                    q.offer(currentNode.right);
	                }   
	            }else{
	                if(!q.isEmpty()){
	                    count++;
	                    q.offer(null);
	                }
	            }
	        }
	        return count;
	    }
	
	public static void main(String args[]){
		BinaryTreeNode node = new BinaryTreeNode(1);
		node.left = new BinaryTreeNode(2);
		node.right = new BinaryTreeNode(3);
		node.left.left = new BinaryTreeNode(4);
		node.left.right = new BinaryTreeNode(5);
		node.right.left = new BinaryTreeNode(6);
		node.right.right = new BinaryTreeNode(7);
		node.left.left.left = new BinaryTreeNode(8);
		node.left.left.right = new BinaryTreeNode(9);
		node.right.left.left = new BinaryTreeNode(10);
		node.right.left.right = new BinaryTreeNode(11);
		node.right.right.left = new BinaryTreeNode(12);
		node.right.right.right = new BinaryTreeNode(13);
		
		System.out.println(getMinimumDepthRecursive(node));
		System.out.println(minDepthLevelOrder(node));
		
	}

}
