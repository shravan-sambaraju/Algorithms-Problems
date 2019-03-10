package problems.trees;

/** Print pre oder traversal of binary tree */

import common.utils.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Stack;

class PreOrderTraversal {

  private static ArrayList<Integer> interativePreOder(BinaryTreeNode head) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (head == null) {
      return result;
    }

    Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
    stack.push(head);
    while (!stack.isEmpty()) {
      BinaryTreeNode temp = stack.pop();
      result.add(temp.getData());
      if (temp.getRight() != null) {
        stack.push(temp.getRight());
      }
      if (temp.getLeft() != null) {
        stack.push(temp.getLeft());
      }
    }
    return result;
  }

  private static void recursivePreOrder(BinaryTreeNode head) {
    if (head != null) {
      System.out.println(head.getData());
      recursivePreOrder(head.getLeft());
      recursivePreOrder(head.getRight());
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

    System.out.println(interativePreOder(node).toString());
    recursivePreOrder(node);
  }
}
