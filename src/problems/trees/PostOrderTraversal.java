package problems.trees;

/** Print post order traversal of binary tree */
import common.utils.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Stack;

class PostOrderTraversal {

  private static void recursivePostOrder(BinaryTreeNode head) {
    if (head != null) {
      recursivePostOrder(head.getLeft());
      recursivePostOrder(head.getRight());
      System.out.println(head.getData());
    }
  }

  private static ArrayList<Integer> iterativePostOrderUsingOneStack(BinaryTreeNode head) {
    ArrayList<Integer> result = new ArrayList<>();
    if (head == null) {
      return result;
    }
    Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
    stack.push(head);
    BinaryTreeNode prev = null;
    while (!stack.isEmpty()) {
      BinaryTreeNode curr = stack.peek();
      if (prev == null || prev.getLeft() == curr || prev.getRight() == curr) {
        if (curr.getLeft() != null) {
          stack.push(curr.getLeft());
        } else if (curr.getRight() != null) {
          stack.push(curr.getRight());
        }
      } else if (curr.getLeft() == prev) {
        if (curr.getRight() != null) {
          stack.push(curr.getRight());
        }
      } else {
        result.add(curr.getData());
        stack.pop();
      }
      prev = curr;
    }
    return result;
  }

  private static void interativePostOrderUsingTwoStack(BinaryTreeNode head) {
    Stack<BinaryTreeNode> stack1 = new Stack<BinaryTreeNode>();
    Stack<BinaryTreeNode> stack2 = new Stack<BinaryTreeNode>();
    stack1.push(head);

    while (!stack1.isEmpty()) {
      head = stack1.pop();
      if (head.getLeft() != null) {
        stack1.push(head.getLeft());
      }
      if (head.getRight() != null) {
        stack1.push(head.getRight());
      }
      stack2.push(head);
    }

    while (!stack2.isEmpty()) {
      System.out.println(stack2.pop().getData());
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

    BinaryTreeNode node1 = node;
    BinaryTreeNode node2 = node;

    System.out.println(iterativePostOrderUsingOneStack(node).toString());
    recursivePostOrder(node1);
    interativePostOrderUsingTwoStack(node2);
  }
}
