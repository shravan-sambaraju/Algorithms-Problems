package problems.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MinElementInBinaryTree {
	
	public static int minElementRecursion(BinaryTreeNode head){
		int minValue = Integer.MAX_VALUE;
		if(head!=null){
			int leftMax = minElementRecursion(head.left);
			int rightMax = minElementRecursion(head.right);
			
			if(leftMax<rightMax){
				minValue = leftMax;
			}else{
				minValue = rightMax;
			}
			if(head.data<minValue){
				minValue=head.data;
			}
		}
		
		return minValue;
		
	}
	
	public static int minValueLevelOrder(BinaryTreeNode head){
		if(head==null){
			return Integer.MIN_VALUE;
		}
		int minValue = Integer.MAX_VALUE;
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(head);
		while(!queue.isEmpty()){
			BinaryTreeNode temp = queue.poll();
			if(temp.data<minValue)
				minValue = temp.data;
			
			if(temp!=null){
				if(temp.left!=null){
					queue.offer(temp.left);
				}
				if(temp.right!=null){
					queue.offer(temp.right);
				}
			}
			
		}
		
		return minValue;
		
	}
	
	public static void main(String args[]){
		BinaryTreeNode node = new BinaryTreeNode(1);
		node.left = new BinaryTreeNode(2);
		node.right = new BinaryTreeNode(3);
		node.left.left = new BinaryTreeNode(4);
		node.left.right = new BinaryTreeNode(5);
		node.right.left = new BinaryTreeNode(6);
		node.right.right = new BinaryTreeNode(7);
		
		System.out.println(minElementRecursion(node));
		System.out.println(minValueLevelOrder(node));
		
	}

}
