package problems.trees;

/** Print inorder traversal of binary node */
import common.utils.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Stack;

class InOrderTraversal {

  private static void recursiveInorder(BinaryTreeNode head) {
    if (head != null) {
      recursiveInorder(head.getLeft());
      System.out.println(head.getData());
      recursiveInorder(head.getRight());
    }
  }

  private static ArrayList<Integer> iterativeInorder(BinaryTreeNode head) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (head == null) {
      return result;
    }
    Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
    BinaryTreeNode current = head;
    boolean done = false;
    while (!done) {
      if (current != null) {
        stack.push(current);
        current = current.getLeft();
      } else {
        if (stack.isEmpty()) {
          done = true;
        } else {
          current = stack.pop();
          result.add(current.getData());
          current = current.getRight();
        }
      }
    }
    return result;
  }

  public static void main(String args[]) {
    BinaryTreeNode node = new BinaryTreeNode(1);
    node.setLeft(new BinaryTreeNode(2));
    node.setRight(new BinaryTreeNode(3));
    node.getLeft().setLeft(new BinaryTreeNode(4));
    node.getLeft().setRight(new BinaryTreeNode(5));
    node.getRight().setLeft(new BinaryTreeNode(6));
    node.getRight().setRight(new BinaryTreeNode(7));

    System.out.println(iterativeInorder(node).toString());
    recursiveInorder(node);
  }
}
