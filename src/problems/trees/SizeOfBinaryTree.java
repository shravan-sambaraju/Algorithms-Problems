package problems.trees;

/* Print size of binary tree */

import common.utils.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

class SizeOfBinaryTree {

  private static int getSizeRecursive(BinaryTreeNode node) {
    if (node == null) {
      return 0;
    }
    return 1 + getSizeRecursive(node.getLeft()) + getSizeRecursive(node.getRight());
  }

  private static int getSizeLevelOrder(BinaryTreeNode node) {
    int count = 0;
    if (node == null) {
      return count;
    }
    Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
    q.offer(node);
    while (!q.isEmpty()) {
      BinaryTreeNode temp = q.poll();
      count++;
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

    System.out.println(getSizeRecursive(node));
    System.out.println(getSizeLevelOrder(node));
  }
}
