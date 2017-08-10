package problems.trees;

public class BinaryTreeNode {
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
