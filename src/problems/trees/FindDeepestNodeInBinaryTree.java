package problems.trees;

/* Find deepest node in binary tree */
import common.utils.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

class FindDeepestNodeInBinaryTree {

  private static BinaryTreeNode getdeepestBinaryNode(BinaryTreeNode head) {
    BinaryTreeNode temp = null;
    if (head == null) {
      return null;
    }
    Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
    q.offer(head);
    while (!q.isEmpty()) {
      temp = q.poll();
      if (temp.getLeft() != null) {
        q.offer(temp.getLeft());
      }
      if (temp.getRight() != null) {
        q.offer(temp.getRight());
      }
    }
    return temp;
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
    System.out.println(getdeepestBinaryNode(node).getData());
  }
}
