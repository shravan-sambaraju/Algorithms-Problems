package problems.trees;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPathEqualsSum {

	class BinaryTreeNode {
		int data;
		BinaryTreeNode left;
		BinaryTreeNode right;

		BinaryTreeNode(int x) {
			data = x;
			left = null;
			right = null;

		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public BinaryTreeNode getLeft() {
			return left;
		}

		public void setLeft(BinaryTreeNode left) {
			this.left = left;
		}

		public BinaryTreeNode getRight() {
			return right;
		}

		public void setRight(BinaryTreeNode right) {
			this.right = right;
		}
	}

	public boolean printPath(BinaryTreeNode root, int sum, List<BinaryTreeNode> path) {
		if (root == null) {
			return false;
		}

		if (root.left == null && root.right == null) {
			if (root.data == sum) {
				path.add(root);
				return true;
			} else {
				return false;
			}
		}
		if (printPath(root.left, sum - root.data, path) || printPath(root.right, sum - root.data, path)) {
			path.add(root);
			return true;
		}
		return false;
	}

	public static void main(String args[]) {
		RootToLeafPathEqualsSum rootToLeafPathEqualsSum = new RootToLeafPathEqualsSum();
		BinaryTreeNode node = rootToLeafPathEqualsSum.new BinaryTreeNode(1);
		node.left = rootToLeafPathEqualsSum.new BinaryTreeNode(2);
		node.right = rootToLeafPathEqualsSum.new BinaryTreeNode(3);
		node.left.left = rootToLeafPathEqualsSum.new BinaryTreeNode(4);
		node.left.right = rootToLeafPathEqualsSum.new BinaryTreeNode(5);
		node.right.left = rootToLeafPathEqualsSum.new BinaryTreeNode(6);
		node.right.right = rootToLeafPathEqualsSum.new BinaryTreeNode(7);

		List<BinaryTreeNode> resultList = new ArrayList<BinaryTreeNode>();

		RootToLeafPathEqualsSum rtsum = new RootToLeafPathEqualsSum();

		boolean result = rtsum.printPath(node, 10, resultList);

		if (result) {
			resultList.forEach(BinaryTreeNode -> System.out.print(BinaryTreeNode.data + " "));
		} else {
			System.out.println("No path for sum " + 10);
		}

	}
}
