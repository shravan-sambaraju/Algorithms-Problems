package problems.trees;

/** Find element in binary node */

import common.utils.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

class FindAnElementInBinaryTree {

  private static boolean findElementLevelOrder(BinaryTreeNode head, int data) {
    if (head == null) {
      return false;
    }
    Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
    queue.offer(head);
    while (!queue.isEmpty()) {
      BinaryTreeNode temp = queue.poll();
      if (temp.getData() == data) {
        return true;
      }

      if (temp != null) {
        if (temp.getLeft() != null) {
          queue.offer(temp.getLeft());
        }
        if (temp.getRight() != null) {
          queue.offer(temp.getRight());
        }
      }
    }
    return false;
  }

  private static boolean findElementRecursion(BinaryTreeNode head, int data) {
    if (head == null) {
      return false;
    }
    if (head.getData() == data) {
      return true;
    }
    return findElementRecursion(head.getLeft(), data)
        || findElementRecursion(head.getRight(), data);
  }

  public static void main(String args[]) {

    BinaryTreeNode node = new BinaryTreeNode(1);
    node.setLeft(new BinaryTreeNode(2));
    node.setRight(new BinaryTreeNode(3));
    node.getLeft().setLeft(new BinaryTreeNode(4));
    node.getLeft().setRight(new BinaryTreeNode(5));
    node.getRight().setLeft(new BinaryTreeNode(6));
    node.getRight().setRight(new BinaryTreeNode(7));

    System.out.println(findElementLevelOrder(node, 7));
    System.out.println(findElementLevelOrder(node, 11));
    System.out.println(findElementRecursion(node, 7));
    System.out.println(findElementRecursion(node, 11));
  }
}
