package problems.trees;

/* Create a minimal BST from given array */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ListOfDepths {

	static class TreeNode {
		public int data;
		public TreeNode left;
		public TreeNode right;
		public TreeNode parent;
		private int size = 0;

		public TreeNode(int d) {
			data = d;
			size = 1;
		}

		private void setLeftChild(TreeNode left) {
			this.left = left;
			if (left != null) {
				left.parent = this;
			}
		}

		private void setRightChild(TreeNode right) {
			this.right = right;
			if (right != null) {
				right.parent = this;
			}
		}

		public void insertInOrder(int d) {
			if (d <= data) {
				if (left == null) {
					setLeftChild(new TreeNode(d));
				} else {
					left.insertInOrder(d);
				}
			} else {
				if (right == null) {
					setRightChild(new TreeNode(d));
				} else {
					right.insertInOrder(d);
				}
			}
			size++;
		}

		public int size() {
			return size;
		}

		public boolean isBST() {
			if (left != null) {
				if (data < left.data || !left.isBST()) {
					return false;
				}
			}

			if (right != null) {
				if (data >= right.data || !right.isBST()) {
					return false;
				}
			}

			return true;
		}

		public int height() {
			int leftHeight = left != null ? left.height() : 0;
			int rightHeight = right != null ? right.height() : 0;
			return 1 + Math.max(leftHeight, rightHeight);
		}

		public TreeNode find(int d) {
			if (d == data) {
				return this;
			} else if (d <= data) {
				return left != null ? left.find(d) : null;
			} else if (d > data) {
				return right != null ? right.find(d) : null;
			}
			return null;
		}

		private static TreeNode createMinimalBST(int arr[], int start, int end) {
			if (end < start) {
				return null;
			}
			int mid = (start + end) / 2;
			TreeNode n = new TreeNode(arr[mid]);
			n.setLeftChild(createMinimalBST(arr, start, mid - 1));
			n.setRightChild(createMinimalBST(arr, mid + 1, end));
			return n;
		}

		public static TreeNode createMinimalBST(int array[]) {
			return createMinimalBST(array, 0, array.length - 1);
		}

	}

	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();

		/* "Visit" the root */
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		if (root != null) {
			current.add(root);
		}

		while (current.size() > 0) {
			result.add(current); // Add previous level
			LinkedList<TreeNode> parents = current; // Go to next level
			current = new LinkedList<TreeNode>();
			for (TreeNode parent : parents) {
				/* Visit the children */
				if (parent.left != null) {
					current.add(parent.left);
				}
				if (parent.right != null) {
					current.add(parent.right);
				}
			}
		}

		return result;
	}

	public static void printResult(ArrayList<LinkedList<TreeNode>> result) {
		int depth = 0;
		for (LinkedList<TreeNode> entry : result) {
			Iterator<TreeNode> i = entry.listIterator();
			System.out.print("Link list at depth " + depth + ":");
			while (i.hasNext()) {
				System.out.print(" " + ((TreeNode) i.next()).data);
			}
			System.out.println();
			depth++;
		}
	}

	public static void main(String[] args) {
		int[] nodes_flattened = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		TreeNode root = createTreeFromArray(nodes_flattened);
		ArrayList<LinkedList<TreeNode>> list = createLevelLinkedList(root);
		printResult(list);
	}

	public static TreeNode createTreeFromArray(int[] array) {
		if (array.length > 0) {
			TreeNode root = new TreeNode(array[0]);
			java.util.Queue<TreeNode> queue = new java.util.LinkedList<TreeNode>();
			queue.add(root);
			boolean done = false;
			int i = 1;
			while (!done) {
				TreeNode r = (TreeNode) queue.element();
				if (r.left == null) {
					r.left = new TreeNode(array[i]);
					i++;
					queue.add(r.left);
				} else if (r.right == null) {
					r.right = new TreeNode(array[i]);
					i++;
					queue.add(r.right);
				} else {
					queue.remove();
				}
				if (i == array.length) {
					done = true;
				}
			}
			return root;
		} else {
			return null;
		}
	}

}
