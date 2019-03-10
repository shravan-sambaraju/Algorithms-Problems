package problems.trees;

/** Find minimum element in binary search tree */

import common.utils.BinaryTreeNode;

class MinimumElementInBST {

  public static void main(String args[]) {

    MinimumElementInBST min = new MinimumElementInBST();
    BinaryTreeNode node = new BinaryTreeNode(50);
    node.setLeft(new BinaryTreeNode(30));
    node.setRight(new BinaryTreeNode(70));
    node.getLeft().setLeft(new BinaryTreeNode(20));
    node.getLeft().setRight(new BinaryTreeNode(40));
    node.getRight().setLeft(new BinaryTreeNode(60));
    node.getRight().setRight(new BinaryTreeNode(70));

    System.out.println(min.minimumElement(node).getData());
    System.out.println(min.minimumElementLevelOrder(node).getData());
  }

  private BinaryTreeNode minimumElement(BinaryTreeNode node) {
    if (node == null) {
      return node;
    } else {
      if (node.getLeft() == null) {
        return node;
      } else {
        return minimumElement(node.getLeft());
      }
    }
  }

  private BinaryTreeNode minimumElementLevelOrder(BinaryTreeNode root) {
    if (root == null) {
      return null;
    }
    while (root.getLeft() != null) {
      root = root.getLeft();
    }
    return root;
  }
}
