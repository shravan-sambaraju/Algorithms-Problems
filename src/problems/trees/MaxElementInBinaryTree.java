package problems.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaxElementInBinaryTree {
	
	public static int maxElementRecursion(BinaryTreeNode head){
		int maxValue = Integer.MIN_VALUE;
		if(head!=null){
			int leftMax = maxElementRecursion(head.left);
			int rightMax = maxElementRecursion(head.right);
			
			if(leftMax>rightMax){
				maxValue = leftMax;
			}else{
				maxValue = rightMax;
			}
			if(head.data>maxValue){
				maxValue=head.data;
			}
		}
		
		return maxValue;
		
	}
	
	public static int maxValueLevelOrder(BinaryTreeNode head){
		if(head==null){
			return Integer.MIN_VALUE;
		}
		int maxValue = Integer.MIN_VALUE;
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(head);
		while(!queue.isEmpty()){
			BinaryTreeNode temp = queue.poll();
			if(temp.data>maxValue)
				maxValue = temp.data;
			
			if(temp!=null){
				if(temp.left!=null){
					queue.offer(temp.left);
				}
				if(temp.right!=null){
					queue.offer(temp.right);
				}
			}
			
		}
		
		return maxValue;
		
	}
	
	public static void main(String args[]) {
		BinaryTreeNode node = new BinaryTreeNode(1);
		node.left = new BinaryTreeNode(2);
		node.right = new BinaryTreeNode(3);
		node.left.left = new BinaryTreeNode(4);
		node.left.right = new BinaryTreeNode(5);
		node.right.left = new BinaryTreeNode(6);
		node.right.right = new BinaryTreeNode(7);
		
		System.out.println(maxElementRecursion(node));
		System.out.println(maxValueLevelOrder(node));
	}
	}


