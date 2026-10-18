package common.utils;

/*
 * Utility class representing a node in a binary tree with integer data and left and right child
 * references, along with helper methods to construct and print trees.
 */
public class BinaryTreeNode {
  public int data;
  public BinaryTreeNode left;
  public BinaryTreeNode right;

  public BinaryTreeNode(int x) {
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
