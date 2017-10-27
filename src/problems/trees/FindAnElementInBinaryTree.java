package problems.trees;

import java.util.LinkedList;
import java.util.Queue;

public class FindAnElementInBinaryTree {

	public static boolean findElementLevelOrder(BinaryTreeNode head, int data) {
		if (head == null) {
			return false;
		}
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(head);
		while (!queue.isEmpty()) {
			BinaryTreeNode temp = queue.poll();
			if (temp.data == data) {
				return true;

			}

			if (temp != null) {
				if (temp.left != null) {
					queue.offer(temp.left);
				}
				if (temp.right != null) {
					queue.offer(temp.right);
				}
			}

		}

		return false;

	}
	
	public static boolean findElementRecursion(BinaryTreeNode head, int data){
		if(head ==null){
			return false;
		}
		if(head.data == data){
			return true;
			
		}
		
		return findElementRecursion(head.left,data) || findElementRecursion(head.right,data);
		
	}
	
	public static void main(String args[]){
		
		BinaryTreeNode node = new BinaryTreeNode(1);
		node.left = new BinaryTreeNode(2);
		node.right = new BinaryTreeNode(3);
		node.left.left = new BinaryTreeNode(4);
		node.left.right = new BinaryTreeNode(5);
		node.right.left = new BinaryTreeNode(6);
		node.right.right = new BinaryTreeNode(7);
		
		System.out.println(findElementLevelOrder(node,7));
		System.out.println(findElementLevelOrder(node,11));
		System.out.println(findElementRecursion(node,7));
		System.out.println(findElementRecursion(node,11));
		
	}

}
