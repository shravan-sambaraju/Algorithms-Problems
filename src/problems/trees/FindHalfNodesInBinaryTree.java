package problems.trees;

/* Find all half nodes in binary tree */

import common.utils.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

class FindHalfNodesInBinaryTree {

    private static int getNumberOfHalfNodesRecursion(BinaryTreeNode node) {
        int count = 0;
        if (node == null) {
            return 0;
        }
        if (node.getLeft() != null && node.getRight() == null
            || node.getLeft() == null && node.getRight() != null) {
            count++;
        }
        count +=
            getNumberOfHalfNodesRecursion(node.getLeft())
                + getNumberOfHalfNodesRecursion(node.getRight());
        return count;
    }

    private static int getNumberOfHalfNodesLevelOrder(BinaryTreeNode node) {
        int count = 0;
        if (node == null) {
            return 0;
        }
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(node);
        while (!q.isEmpty()) {
            BinaryTreeNode temp = q.poll();
            if (temp.getLeft() != null && temp.getRight() == null
                || temp.getLeft() == null && temp.getRight() != null) {
                count++;
            }
            if (temp.getLeft() != null) {
                q.offer(temp.getLeft());
            }
            if (temp.getRight() != null) {
                q.offer(temp.getRight());
            }
        }
        return count;
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
        node.getLeft().getLeft().setLeft(new BinaryTreeNode(9));

        System.out.println(getNumberOfHalfNodesRecursion(node));
        System.out.println(getNumberOfHalfNodesLevelOrder(node));
    }
}
