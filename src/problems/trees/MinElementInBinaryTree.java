package problems.trees;

/* Find minimum element in binary tree */

import common.utils.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

class MinElementInBinaryTree {

  private static int minElementRecursion(BinaryTreeNode head) {
    int minValue = Integer.MAX_VALUE;
    if (head != null) {
      int leftMax = minElementRecursion(head.getLeft());
      int rightMax = minElementRecursion(head.getRight());

      if (leftMax < rightMax) {
        minValue = leftMax;
      } else {
        minValue = rightMax;
      }
      if (head.getData() < minValue) {
        minValue = head.getData();
      }
    }
    return minValue;
  }

  private static int minValueLevelOrder(BinaryTreeNode head) {
    if (head == null) {
      return Integer.MIN_VALUE;
    }
    int minValue = Integer.MAX_VALUE;
    Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
    queue.offer(head);
    while (!queue.isEmpty()) {
      BinaryTreeNode temp = queue.poll();
      if (temp.getData() < minValue) {
        minValue = temp.getData();
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
    return minValue;
  }

  public static void main(String args[]) {

    BinaryTreeNode node = new BinaryTreeNode(1);
    node.setLeft(new BinaryTreeNode(2));
    node.setRight(new BinaryTreeNode(3));
    node.getLeft().setLeft(new BinaryTreeNode(4));
    node.getLeft().setRight(new BinaryTreeNode(5));
    node.getRight().setLeft(new BinaryTreeNode(6));
    node.getRight().setRight(new BinaryTreeNode(7));

    System.out.println(minElementRecursion(node));
    System.out.println(minValueLevelOrder(node));
  }
}
