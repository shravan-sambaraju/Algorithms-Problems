package problems.trees;

/* Find diameter of binary tree */

import common.utils.BinaryTreeNode;

class DiameterOfBinaryTree {

  private static int diameter(BinaryTreeNode root) {
    if (root == null) {
      return 0;
    }
    int len1 = height(root.getLeft()) + height(root.getRight()) + 1;
    int len2 = Math.max(diameter(root.getLeft()), diameter(root.getRight()));
    return Math.max(len1, len2);
  }

  private static int height(BinaryTreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftDepth = height(root.getLeft());
    int rightDepth = height(root.getRight());
    return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
  }

  public static void main(String args[]) {
    BinaryTreeNode node = new BinaryTreeNode(1);
    node.setLeft(new BinaryTreeNode(2));
    node.setRight(new BinaryTreeNode(3));
    node.getLeft().setLeft(new BinaryTreeNode(4));
    node.getLeft().setRight(new BinaryTreeNode(5));
    node.getRight().setLeft(new BinaryTreeNode(6));
    node.getRight().setRight(new BinaryTreeNode(7));
    System.out.println(diameter(node));
  }
}
