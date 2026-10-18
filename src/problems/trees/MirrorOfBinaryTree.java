package problems.trees;

import common.utils.BinaryTreeNode;

/*
 * Given a binary tree, convert it into its mirror image (invert left and right subtrees of all
 * nodes) and check whether two binary trees are mirrors of each other.
 */
class MirrorOfBinaryTree {

  public static void main(String args[]) {
    BinaryTreeNode node = new BinaryTreeNode(1);
    node.setLeft(new BinaryTreeNode(2));
    node.setRight(new BinaryTreeNode(3));
    node.getLeft().setLeft(new BinaryTreeNode(4));
    node.getLeft().setRight(new BinaryTreeNode(5));
    node.getRight().setLeft(new BinaryTreeNode(6));
    node.getRight().setRight(new BinaryTreeNode(7));

    recursiveInorder(node);
    MirrorOfBinaryTree mirror = new MirrorOfBinaryTree();
    System.out.println();
    BinaryTreeNode mirrortree = mirror.mirrorOfBinaryTree(node);
    recursiveInorder(mirrortree);
  }

  private static void recursiveInorder(BinaryTreeNode head) {
    if (head != null) {
      recursiveInorder(head.getLeft());
      System.out.print(head.getData());
      recursiveInorder(head.getRight());
    }
  }

  private BinaryTreeNode mirrorOfBinaryTree(BinaryTreeNode root) {
    BinaryTreeNode temp;
    if (root != null) {
      mirrorOfBinaryTree(root.getLeft());
      mirrorOfBinaryTree(root.getRight());
      temp = root.getLeft();
      root.setLeft(root.getRight());
      root.setRight(temp);
    }
    return root;
  }
}
