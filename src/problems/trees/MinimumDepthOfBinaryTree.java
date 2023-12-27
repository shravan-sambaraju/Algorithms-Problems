package problems.trees;

/* Find minimum depth of binary tree */
import common.utils.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

class MinimumDepthOfBinaryTree {

  private static int getMinimumDepthRecursive(BinaryTreeNode node) {
    if (node == null) {
      return 0;
    }

    if (node.getLeft() == null && node.getRight() == null) {
      return 1;
    }

    if (node.getLeft() == null) {
      return getMinimumDepthRecursive(node.getRight()) + 1;
    }
    if (node.getRight() == null) {
      return getMinimumDepthRecursive(node.getLeft()) + 1;
    }
    return Math.min(
            getMinimumDepthRecursive(node.getLeft()), getMinimumDepthRecursive(node.getRight()))
        + 1;
  }

  private static int minDepthLevelOrder(BinaryTreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
    q.offer(root);
    q.offer(null);
    int count = 1;
    while (!q.isEmpty()) {
      BinaryTreeNode currentNode = q.poll();
      if (currentNode != null) {
        if (currentNode.getLeft() == null && currentNode.getRight() == null) {
          return count;
        }
        if (currentNode.getLeft() != null) {
          q.offer(currentNode.getLeft());
        }
        if (currentNode.getRight() != null) {
          q.offer(currentNode.getRight());
        }
      } else {
        if (!q.isEmpty()) {
          count++;
          q.offer(null);
        }
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
    node.getLeft().getLeft().setLeft(new BinaryTreeNode(8));
    node.getLeft().getLeft().setRight(new BinaryTreeNode(9));
    node.getRight().getLeft().setLeft(new BinaryTreeNode(10));
    node.getRight().getLeft().setRight(new BinaryTreeNode(11));
    node.getRight().getRight().setLeft(new BinaryTreeNode(12));
    node.getRight().getRight().setRight(new BinaryTreeNode(13));

    System.out.println(getMinimumDepthRecursive(node));
    System.out.println(minDepthLevelOrder(node));
  }
}
