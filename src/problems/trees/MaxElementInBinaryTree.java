package problems.trees;

/** Find maximum element in binary tree */
import common.utils.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

class MaxElementInBinaryTree {

  private static int maxElementRecursion(BinaryTreeNode head) {
    int maxValue = Integer.MIN_VALUE;
    if (head != null) {
      int leftMax = maxElementRecursion(head.getLeft());
      int rightMax = maxElementRecursion(head.getRight());

      if (leftMax > rightMax) {
        maxValue = leftMax;
      } else {
        maxValue = rightMax;
      }
      if (head.getData() > maxValue) {
        maxValue = head.getData();
      }
    }
    return maxValue;
  }

  private static int maxValueLevelOrder(BinaryTreeNode head) {
    if (head == null) {
      return Integer.MIN_VALUE;
    }
    int maxValue = Integer.MIN_VALUE;
    Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
    queue.offer(head);
    while (!queue.isEmpty()) {
      BinaryTreeNode temp = queue.poll();
      if (temp.getData() > maxValue) {
        maxValue = temp.getData();
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
    return maxValue;
  }

  public static void main(String args[]) {

    BinaryTreeNode node = new BinaryTreeNode(1);
    node.setLeft(new BinaryTreeNode(2));
    node.setRight(new BinaryTreeNode(3));
    node.getLeft().setLeft(new BinaryTreeNode(4));
    node.getLeft().setRight(new BinaryTreeNode(5));
    node.getRight().setLeft(new BinaryTreeNode(6));
    node.getRight().setRight(new BinaryTreeNode(7));

    System.out.println(maxElementRecursion(node));
    System.out.println(maxValueLevelOrder(node));
  }
}
