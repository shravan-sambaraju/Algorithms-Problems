package problems.trees;

import java.util.LinkedList;
import java.util.Queue;


public class InsertElementIntoBinaryTree {

	public static BinaryTreeNode insertIntoTreeLevelOrder(BinaryTreeNode root, int data) {
		if (root == null) {
			return new BinaryTreeNode(data);
		}
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			BinaryTreeNode temp = q.poll();
			if (temp != null) {
				if (temp.left != null) {
					q.offer(temp.left);
				} else {
					temp.left = new BinaryTreeNode(data);
					return root;
				}
				if (temp.right != null) {
					q.offer(temp.right);
				} else {
					temp.right = new BinaryTreeNode(data);
					return root;
				}
			}

		}
		return root;

	}

	public static BinaryTreeNode insertElementIntoTreeRecursive(BinaryTreeNode root, int data) {
		if (root == null) {
			return new BinaryTreeNode(data);

		} else {
			insertHelper(root, data);
		}

		return root;

	}

	private static void insertHelper(BinaryTreeNode head, int element) {
		if(head.left==null){
			head.left = new BinaryTreeNode(element);
		}else{
			insertHelper(head.left, element);
		}
		if(head.right==null){
			head.right = new BinaryTreeNode(element);
		}else{
			insertHelper(head.right, element);
		}

	}

	public static void main(String args[]) {
		BinaryTreeNode node = new BinaryTreeNode(1);
		node.left = new BinaryTreeNode(2);
		node.right = new BinaryTreeNode(3);
		node.left.left = new BinaryTreeNode(4);
		node.left.right = new BinaryTreeNode(5);
		node.right.left = new BinaryTreeNode(6);
		node.right.right = new BinaryTreeNode(7);

		BinaryTreeNode node1 = node;

		System.out.println(insertIntoTreeLevelOrder(node, 8).left.left.left.data);
		System.out.println(insertIntoTreeLevelOrder(node, 9).left.left.right.data);
		System.out.println(insertElementIntoTreeRecursive(node,8).left.left.left.data);
		System.out.println(insertElementIntoTreeRecursive(node,9).left.left.right.data);

	}

}
