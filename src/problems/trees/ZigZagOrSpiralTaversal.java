package problems.trees;

/** Print given binary tree in zig zag */

import common.utils.BinaryTreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class ZigZagOrSpiralTaversal {

  public static void main(String args[]) {

    BinaryTreeNode node = new BinaryTreeNode(1);
    node.setLeft(new BinaryTreeNode(2));
    node.setRight(new BinaryTreeNode(3));
    node.getLeft().setLeft(new BinaryTreeNode(4));
    node.getLeft().setRight(new BinaryTreeNode(5));
    node.getRight().setLeft(new BinaryTreeNode(6));
    node.getRight().setRight(new BinaryTreeNode(7));

    ZigZagOrSpiralTaversal zg = new ZigZagOrSpiralTaversal();
    zg.spiralWithTwoStack(node);
    System.out.println();

    zg.spiralWithOneDeque(node);
    System.out.println();
    zg.spiralWithOneDequeDelimiter(node);
  }

  private void spiralWithTwoStack(BinaryTreeNode root) {
    if (root == null) {
      return;
    }
    Stack<BinaryTreeNode> s1 = new Stack<>();
    Stack<BinaryTreeNode> s2 = new Stack<>();
    s1.push(root);

    while (!s1.isEmpty() || !s2.isEmpty()) {
      while (!s1.isEmpty()) {
        root = s1.pop();
        System.out.print(root.getData() + " ");
        if (root.getLeft() != null) {
          s2.push(root.getLeft());
        }
        if (root.getRight() != null) {
          s2.push(root.getRight());
        }
      }
      while (!s2.isEmpty()) {
        root = s2.pop();
        System.out.print(root.getData() + " ");
        if (root.getRight() != null) {
          s1.push(root.getRight());
        }
        if (root.getLeft() != null) {
          s1.push(root.getLeft());
        }
      }
    }
  }

  private void spiralWithOneDeque(BinaryTreeNode root) {
    if (root == null) {
      return;
    }
    Deque<BinaryTreeNode> deque = new LinkedList<BinaryTreeNode>();
    deque.offerFirst(root);
    int count = 1;
    boolean flip = true;
    while (!deque.isEmpty()) {
      int currentCount = 0;
      while (count > 0) {
        if (flip) {
          root = deque.pollFirst();
          System.out.print(root.getData() + " ");
          if (root.getLeft() != null) {
            deque.offerLast(root.getLeft());
            currentCount++;
          }
          if (root.getRight() != null) {
            deque.offerLast(root.getRight());
            currentCount++;
          }
        } else {
          root = deque.pollLast();
          System.out.print(root.getData() + " ");
          if (root.getRight() != null) {
            deque.offerFirst(root.getRight());
            currentCount++;
          }
          if (root.getLeft() != null) {
            deque.offerFirst(root.getLeft());
            currentCount++;
          }
        }
        count--;
      }
      flip = !flip;
      count = currentCount;
    }
  }

  private void spiralWithOneDequeDelimiter(BinaryTreeNode root) {
    if (root == null) {
      return;
    }
    Deque<BinaryTreeNode> q = new LinkedList<>();
    q.offer(null);
    q.offerFirst(root);
    while (q.size() > 1) {
      root = q.peekFirst();
      while (root != null) {
        root = q.pollFirst();
        System.out.print(root.getData() + " ");
        if (root.getLeft() != null) {
          q.offerLast(root.getLeft());
        }
        if (root.getRight() != null) {
          q.offerLast(root.getRight());
        }
        root = q.peekFirst();
      }
      root = q.peekLast();
      while (root != null) {
        System.out.print(root.getData() + " ");
        root = q.pollLast();
        if (root.getRight() != null) {
          q.offerFirst(root.getRight());
        }
        if (root.getLeft() != null) {
          q.offerFirst(root.getLeft());
        }
        root = q.peekLast();
      }
    }
  }
}
