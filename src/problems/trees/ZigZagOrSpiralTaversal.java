package problems.trees;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class ZigZagOrSpiralTaversal {

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

	public void spiralWithTwoStack(BinaryTreeNode root) {
		if (root == null) {
			return;
		}
		Stack<BinaryTreeNode> s1 = new Stack<>();
		Stack<BinaryTreeNode> s2 = new Stack<>();
		s1.push(root);

		while (!s1.isEmpty() || !s2.isEmpty()) {
			while (!s1.isEmpty()) {
				root = s1.pop();
				System.out.print(root.data + " ");
				if (root.left != null) {
					s2.push(root.left);
				}
				if (root.right != null) {
					s2.push(root.right);
				}
			}
			while (!s2.isEmpty()) {
				root = s2.pop();
				System.out.print(root.data + " ");
				if (root.right != null) {
					s1.push(root.right);
				}
				if (root.left != null) {
					s1.push(root.left);
				}
			}
		}
	}

	/**
	 * One deque with count method to print tree in spiral order
	 */
	public void spiralWithOneDeque(BinaryTreeNode root) {
		if (root == null) {
			return;
		}
		Deque<BinaryTreeNode> deque = new LinkedList<BinaryTreeNode>();
		deque.offerFirst(root);
		int count = 1;
		boolean flip = true;
		while (!deque.isEmpty()) {
			int currentCount = 0;
			while (count > 0) {
				if (flip) {
					root = deque.pollFirst();
					System.out.print(root.data + " ");
					if (root.left != null) {
						deque.offerLast(root.left);
						currentCount++;
					}
					if (root.right != null) {
						deque.offerLast(root.right);
						currentCount++;
					}
				} else {
					root = deque.pollLast();
					System.out.print(root.data + " ");
					if (root.right != null) {
						deque.offerFirst(root.right);
						currentCount++;
					}
					if (root.left != null) {
						deque.offerFirst(root.left);
						currentCount++;
					}
				}
				count--;
			}
			flip = !flip;
			count = currentCount;
		}
	}

	/**
	 * One deque with delimiter to print tree in spiral order
	 */
	public void spiralWithOneDequeDelimiter(BinaryTreeNode root) {
		if (root == null) {
			return;
		}
		Deque<BinaryTreeNode> q = new LinkedList<>();
		q.offer(null);
		q.offerFirst(root);
		// if only delimiter(in this case null) is left in queue then break
		while (q.size() > 1) {
			root = q.peekFirst();
			while (root != null) {
				root = q.pollFirst();
				System.out.print(root.data + " ");
				if (root.left != null) {
					q.offerLast(root.left);
				}
				if (root.right != null) {
					q.offerLast(root.right);
				}
				root = q.peekFirst();
			}
			root = q.peekLast();
			while (root != null) {
				System.out.print(root.data + " ");
				root = q.pollLast();
				if (root.right != null) {
					q.offerFirst(root.right);
				}
				if (root.left != null) {
					q.offerFirst(root.left);
				}
				root = q.peekLast();
			}
		}
	}

	public static void main(String args[]) {
		ZigZagOrSpiralTaversal zagOrSpiralTaversal = new ZigZagOrSpiralTaversal();
		BinaryTreeNode node = zagOrSpiralTaversal.new BinaryTreeNode(1);
		node.left = zagOrSpiralTaversal.new BinaryTreeNode(2);
		node.right = zagOrSpiralTaversal.new BinaryTreeNode(3);
		node.left.left = zagOrSpiralTaversal.new BinaryTreeNode(4);
		node.left.right = zagOrSpiralTaversal.new BinaryTreeNode(5);
		node.right.left = zagOrSpiralTaversal.new BinaryTreeNode(6);
		node.right.right = zagOrSpiralTaversal.new BinaryTreeNode(7);

		ZigZagOrSpiralTaversal zg = new ZigZagOrSpiralTaversal();
		zg.spiralWithTwoStack(node);
		System.out.println();

		zg.spiralWithOneDeque(node);
		System.out.println();
		zg.spiralWithOneDequeDelimiter(node);

	}
}
