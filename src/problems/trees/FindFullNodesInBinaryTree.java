package problems.trees;

import java.util.LinkedList;
import java.util.Queue;

public class FindFullNodesInBinaryTree {
	
	public static int getNumberOfFullNodesRecursion(BinaryTreeNode node){
		int count =0;
		if(node == null){
			return 0;
			
		}if(node.left!=null && node.right!=null){
			count++;
		}
		
		count += getNumberOfFullNodesRecursion(node.left)+getNumberOfFullNodesRecursion(node.right);
		
		return count;
		
	}
	
	public static int getNumberOfFullNodesLevelOrder(BinaryTreeNode node){
		int count =0;
		if(node ==null){
			return 0;
		}
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(node);
		while(!q.isEmpty()){
			BinaryTreeNode temp = q.poll();
			if(temp.left!=null && temp.right!=null){
				count++;
				
			}
			if(temp.left!=null){
				q.offer(temp.left);
			}
			if(temp.right!=null){
				q.offer(temp.right);
				
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
		
		System.out.println(getNumberOfFullNodesRecursion(node));
		System.out.println(getNumberOfFullNodesLevelOrder(node));
		
	}

}
