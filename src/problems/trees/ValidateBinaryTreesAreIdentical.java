package problems.trees;

import java.util.LinkedList;
import java.util.Queue;

public class ValidateBinaryTreesAreIdentical {

	public static boolean checkIdenticalRecursive(BinaryTreeNode head1, BinaryTreeNode head2) {
		if (head1 == null && head2 == null) {
			return true;

		}
		if (head1 == null || head2 == null) {
			return false;

		}
		return (checkIdenticalRecursive(head1.left, head2.left) && checkIdenticalRecursive(head1.right, head2.right));

	}

	public static boolean checkIdenticalLevelOrder(BinaryTreeNode node1, BinaryTreeNode node2) {

	
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		Queue<BinaryTreeNode> q1 = new LinkedList<BinaryTreeNode>();

		q.offer(node1);
		q1.offer(node2);

		while (!q.isEmpty() && !q1.isEmpty()) {
			BinaryTreeNode temp1 = q.poll();
			BinaryTreeNode temp2 = q1.poll();

			if (temp1.left != null && temp2.left != null) {
				q.offer(temp1.left);
				q1.offer(temp2.left);
			}
			if (temp2.right != null && temp1.right != null) {
				q.offer(temp1.right);
				q1.offer(temp2.right);

			}
			
			if((temp1.left == null && temp2.left != null)|| (temp2.right == null && temp1.right != null)
					|| (temp1.left != null && temp2.left == null) || (temp2.right != null && temp1.right == null)  ){
				
				return false;
			}


		}
		return true;

	}

	public static void main(String args[]) {
		BinaryTreeNode node = new BinaryTreeNode(1);
		node.left = new BinaryTreeNode(2);
		node.right = new BinaryTreeNode(3);
		node.left.left = new BinaryTreeNode(4);
		node.left.right = new BinaryTreeNode(5);
		node.right.left = new BinaryTreeNode(6);
		node.right.right = new BinaryTreeNode(7);

		BinaryTreeNode node2 = new BinaryTreeNode(1);
		node2.left = new BinaryTreeNode(2);
		node2.right = new BinaryTreeNode(3);
		node2.left.left = new BinaryTreeNode(4);
		node2.left.right = new BinaryTreeNode(5);
		node2.right.left = new BinaryTreeNode(6);
		node2.right.right = new BinaryTreeNode(7);
		node2.right.right.right = new BinaryTreeNode(9);

		// System.out.println(checkIdenticalRecursive(node,node2));
		System.out.println(checkIdenticalLevelOrder(node, node2));

	}

}
