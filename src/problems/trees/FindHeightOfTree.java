package problems.trees;

/* Find height of binary tree */

import common.utils.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class FindHeightOfTree {

    private static int getDepthRecursive(BinaryTreeNode head) {
        if (head == null) {
            return 0;
        }
        int leftDepth = getDepthRecursive(head.getLeft());
        int rightDepth = getDepthRecursive(head.getRight());
        if (leftDepth > rightDepth) {
            return leftDepth + 1;

        } else {
            return rightDepth + 1;
        }
    }

    private static int maxDepthIterativeUsingStack(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
        s.push(root);
        int maxDepth = 0;
        BinaryTreeNode prev = null;
        while (!s.isEmpty()) {
            BinaryTreeNode curr = s.peek();
            if (prev == null || prev.getLeft() == curr || prev.getRight() == curr) {
                if (curr.getLeft() != null) {
                    s.push(curr.getLeft());
                } else if (curr.getRight() != null) {
                    s.push(curr.getRight());
                }
            } else if (curr.getLeft() == prev) {
                if (curr.getRight() != null) {
                    s.push(curr.getRight());
                }
            } else {
                s.pop();
            }
            prev = curr;
            if (s.size() > maxDepth) {
                maxDepth = s.size();
            }
        }
        return maxDepth;
    }

    public static int maxDepthLevelOrder(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 1;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        q.offer(null);
        while (!q.isEmpty()) {
            BinaryTreeNode tmp = q.poll();
            if (tmp != null) {
                if (tmp.getLeft() != null) {
                    q.offer(tmp.getLeft());
                }
                if (tmp.getRight() != null) {
                    q.offer(tmp.getRight());
                }
            } else {
                if (!q.isEmpty()) {
                    ++maxDepth;
                    q.offer(null);
                }
            }
        }
        return maxDepth;
    }

    public static void main(String args[]) {

        BinaryTreeNode node = new BinaryTreeNode(1);
        node.setLeft(new BinaryTreeNode(2));
        node.setRight(new BinaryTreeNode(3));
        node.getLeft().setLeft(new BinaryTreeNode(4));
        node.getLeft().setRight(new BinaryTreeNode(5));
        node.getRight().setLeft(new BinaryTreeNode(6));
        node.getRight().setRight(new BinaryTreeNode(7));
        node.getRight().getRight().setLeft(new BinaryTreeNode(8));

        System.out.println(getDepthRecursive(node));
        System.out.println(maxDepthIterativeUsingStack(node));
        System.out.println(maxDepthLevelOrder(node));
    }
}
