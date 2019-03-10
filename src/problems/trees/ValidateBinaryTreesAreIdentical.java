package problems.trees;

/** Validate if given binary trees are identical */

import common.utils.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

class ValidateBinaryTreesAreIdentical {

  private static boolean checkIdenticalRecursive(BinaryTreeNode head1, BinaryTreeNode head2) {
    if (head1 == null && head2 == null) {
      return true;
    }
    if (head1 == null || head2 == null) {
      return false;
    }
    return (checkIdenticalRecursive(head1.getLeft(), head2.getLeft())
        && checkIdenticalRecursive(head1.getRight(), head2.getRight()));
  }

  private static boolean checkIdenticalLevelOrder(BinaryTreeNode node1, BinaryTreeNode node2) {

    Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
    Queue<BinaryTreeNode> q1 = new LinkedList<BinaryTreeNode>();
    q.offer(node1);
    q1.offer(node2);

    while (!q.isEmpty() && !q1.isEmpty()) {
      BinaryTreeNode temp1 = q.poll();
      BinaryTreeNode temp2 = q1.poll();

      if (temp1.getLeft() != null && temp2.getLeft() != null) {
        q.offer(temp1.getLeft());
        q1.offer(temp2.getLeft());
      }
      if (temp2.getRight() != null && temp1.getRight() != null) {
        q.offer(temp1.getRight());
        q1.offer(temp2.getRight());
      }

      if ((temp1.getLeft() == null && temp2.getLeft() != null)
          || (temp2.getRight() == null && temp1.getRight() != null)
          || (temp1.getLeft() != null && temp2.getLeft() == null)
          || (temp2.getRight() != null && temp1.getRight() == null)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String args[]) {

    BinaryTreeNode node = new BinaryTreeNode(1);
    node.setLeft(new BinaryTreeNode(2));
    node.setRight(new BinaryTreeNode(3));
    node.getLeft().setLeft(new BinaryTreeNode(4));
    node.getLeft().setRight(new BinaryTreeNode(5));
    node.getRight().setLeft(new BinaryTreeNode(6));
    node.getRight().setRight(new BinaryTreeNode(7));

    BinaryTreeNode node2 = new BinaryTreeNode(1);
    node2.setLeft(new BinaryTreeNode(2));
    node2.setRight(new BinaryTreeNode(3));
    node2.getLeft().setLeft(new BinaryTreeNode(4));
    node2.getLeft().setRight(new BinaryTreeNode(5));
    node2.getRight().setLeft(new BinaryTreeNode(6));
    node2.getRight().setRight(new BinaryTreeNode(7));
    node2.getRight().getRight().setRight(new BinaryTreeNode(9));

    // System.out.println(checkIdenticalRecursive(node,node2));
    System.out.println(checkIdenticalLevelOrder(node, node2));
  }
}
