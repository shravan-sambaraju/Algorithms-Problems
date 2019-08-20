package tobeorganized.trees;

import common.utils.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

  public BinaryTreeNode invertBinaryTreeRecursion(BinaryTreeNode root) {
    if (root == null) {
      return null;
    }
    BinaryTreeNode left = invertBinaryTreeRecursion(root.left);
    BinaryTreeNode right = invertBinaryTreeRecursion(root.right);
    root.left = right;
    root.right = left;
    return root;
  }

  public BinaryTreeNode invertTreeIterative(BinaryTreeNode root) {

    if (root == null) {
      return null;
    }

    Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
    queue.add(root);
    while (!queue.isEmpty()) {
      BinaryTreeNode current = queue.poll();
      BinaryTreeNode temp = current.left;
      current.left = current.right;
      current.right = temp;
      if (current.left != null) {
        queue.add(current.left);
      }
      if (current.right != null) {
        queue.add(current.right);
      }
    }

    return root;
  }
}
