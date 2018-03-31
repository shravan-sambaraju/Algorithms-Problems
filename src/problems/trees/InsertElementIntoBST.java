package problems.trees;

public class InsertElementIntoBST {

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

	public BinaryTreeNode insertRecursive(BinaryTreeNode root, int data) {
		if (root == null) {
			return new BinaryTreeNode(data);
		} else {
			if (data < root.data) {
				root.setLeft(insertRecursive(root.left, data));
			} else if (data > root.data) {
				root.setRight(insertRecursive(root.right, data));
			}
		}
		return root;

	}

	public BinaryTreeNode addNode(int data, BinaryTreeNode head) {
		BinaryTreeNode tempHead = head;
		BinaryTreeNode n = new BinaryTreeNode(data);
		if (head == null) {
			head = n;
			return head;
		}
		BinaryTreeNode prev = null;
		while (head != null) {
			prev = head;
			if (head.data < data) {
				head = head.right;
			} else {
				head = head.left;
			}
		}
		if (prev.data < data) {
			prev.right = n;
		} else {
			prev.left = n;
		}
		return tempHead;
	}

	public static void main(String args[]) {
		InsertElementIntoBST insertElementIntoBST = new InsertElementIntoBST();
		BinaryTreeNode node = insertElementIntoBST.new BinaryTreeNode(50);
		node.left = insertElementIntoBST.new BinaryTreeNode(30);
		node.right = insertElementIntoBST.new BinaryTreeNode(70);
		node.left.left = insertElementIntoBST.new BinaryTreeNode(20);
		node.left.right = insertElementIntoBST.new BinaryTreeNode(40);
		node.right.left = insertElementIntoBST.new BinaryTreeNode(60);
		node.right.right = insertElementIntoBST.new BinaryTreeNode(80);

		InsertElementIntoBST insert = new InsertElementIntoBST();
		System.out.println(insert.insertRecursive(node, 90).right.right.right.data);
		System.out.println(insert.addNode(10, node).left.left.left.data);

	}
}
