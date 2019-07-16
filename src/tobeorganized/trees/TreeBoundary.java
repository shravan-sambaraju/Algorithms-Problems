package tobeorganized.trees;

import common.utils.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class TreeBoundary {
  public static List<BinaryTreeNode> findBoundary(BinaryTreeNode root) {
    if (root == null) return new ArrayList<>();

    List<BinaryTreeNode> leftView = new ArrayList<>();
    List<BinaryTreeNode> rightView = new LinkedList<>();

    Queue<BinaryTreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      for (int i = 0; i < levelSize; i++) {
        BinaryTreeNode currentNode = queue.poll();
        if (currentNode.left == null && currentNode.right == null) // skip leaf nodes
        continue;
        else if (i == 0) // if it is the first node of this level, add it to the leftView
        leftView.add(currentNode);
        else if (i
            == levelSize - 1) { // if it is the last node of this level, add it to the rightView
          // because of ant-clockwise direction, we need to populate rightView in the reverse
          // direction
          rightView.add(0, currentNode);
        }

        // insert the children of current node in the queue
        if (currentNode.left != null) queue.offer(currentNode.left);
        if (currentNode.right != null) queue.offer(currentNode.right);
      }
    }

    return new ArrayList<BinaryTreeNode>() {
      {
        addAll(leftView);
        addAll(findLeavesDFS(root));
        addAll(rightView);
      }
    };
  }

  private static List<BinaryTreeNode> findLeavesDFS(BinaryTreeNode root) {
    List<BinaryTreeNode> leaves = new ArrayList<>();
    Stack<BinaryTreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      BinaryTreeNode currentNode = stack.pop();
      if (currentNode.left == null && currentNode.right == null) leaves.add(currentNode);

      // insert the children of current node in the stack
      // add the right child first, this way left child will be at the top and processed first
      if (currentNode.right != null) stack.push(currentNode.right);
      if (currentNode.left != null) stack.push(currentNode.left);
    }
    return leaves;
  }

  public static void main(String[] args) {
    BinaryTreeNode root = new BinaryTreeNode(12);
    root.left = new BinaryTreeNode(7);
    root.right = new BinaryTreeNode(1);
    root.left.left = new BinaryTreeNode(4);
    root.left.left.left = new BinaryTreeNode(9);
    root.left.right = new BinaryTreeNode(3);
    root.left.right.left = new BinaryTreeNode(15);
    root.right.left = new BinaryTreeNode(10);
    root.right.right = new BinaryTreeNode(5);
    root.right.right.left = new BinaryTreeNode(6);
    List<BinaryTreeNode> result = TreeBoundary.findBoundary(root);
    for (BinaryTreeNode node : result) {
      System.out.print(node.data + " ");
    }
  }
}
