package problems.trees;

/* Insert given element into binary tree */

import common.utils.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

class InsertElementIntoBinaryTree {

  private static BinaryTreeNode insertIntoTreeLevelOrder(BinaryTreeNode root, int data) {
    if (root == null) {
      return new BinaryTreeNode(data);
    }
    Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
    q.offer(root);
    while (!q.isEmpty()) {
      BinaryTreeNode temp = q.poll();
      if (temp != null) {
        if (temp.getLeft() != null) {
          q.offer(temp.getLeft());
        } else {
          temp.setLeft(new BinaryTreeNode(data));
          return root;
        }
        if (temp.getRight() != null) {
          q.offer(temp.getRight());
        } else {
          temp.setRight(new BinaryTreeNode(data));
          return root;
        }
      }
    }
    return root;
  }

  private static BinaryTreeNode insertElementIntoTreeRecursive(BinaryTreeNode root, int data) {
    if (root == null) {
      return new BinaryTreeNode(data);

    } else {
      insertHelper(root, data);
    }
    return root;
  }

  private static void insertHelper(BinaryTreeNode head, int element) {
    if (head.getLeft() == null) {
      head.setLeft(new BinaryTreeNode(element));
    } else {
      insertHelper(head.getLeft(), element);
    }
    if (head.getRight() == null) {
      head.setRight(new BinaryTreeNode(element));
    } else {
      insertHelper(head.getRight(), element);
    }
  }

  public static void main(String args[]) {

    BinaryTreeNode node = new BinaryTreeNode(1);
    node.setLeft(new BinaryTreeNode(2));
    node.setRight(new BinaryTreeNode(3));
    node.getLeft().setLeft(new BinaryTreeNode(4));
    node.getLeft().setRight(new BinaryTreeNode(5));
    node.getRight().setLeft(new BinaryTreeNode(6));
    node.getRight().setRight(new BinaryTreeNode(7));

    System.out.println(insertIntoTreeLevelOrder(node, 8).getLeft().getLeft().getLeft().getData());
    System.out.println(insertIntoTreeLevelOrder(node, 9).getLeft().getLeft().getRight().getData());
    System.out.println(
        insertElementIntoTreeRecursive(node, 8).getLeft().getLeft().getLeft().getData());
    System.out.println(
        insertElementIntoTreeRecursive(node, 9).getLeft().getLeft().getRight().getData());
  }
}
