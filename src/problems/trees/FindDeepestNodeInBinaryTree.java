package problems.trees;

import java.util.LinkedList;
import java.util.Queue;

public class FindDeepestNodeInBinaryTree {
	
	public static BinaryTreeNode getdeepestBinaryNode(BinaryTreeNode head){
		BinaryTreeNode temp = null;
		if(head == null){
			return null;
		}
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(head);
		while(!q.isEmpty()){
			temp = q.poll();
			if(temp.left!=null){
				q.offer(temp.left);
				
			}
			if(temp.right!=null){
				q.offer(temp.right);
			}
			
		}
		
		return temp;
		
	}
	
	
	
	public static void main(String args[]){
		BinaryTreeNode node = new BinaryTreeNode(1);
		node.left = new BinaryTreeNode(2);
		node.right = new BinaryTreeNode(3);
		node.left.left = new BinaryTreeNode(4);
		node.left.right = new BinaryTreeNode(5);
		node.right.left = new BinaryTreeNode(6);
		node.right.right = new BinaryTreeNode(7);
		node.right.right.left = new BinaryTreeNode(8);
		
		System.out.println(getdeepestBinaryNode(node).data);
		
	}

}
