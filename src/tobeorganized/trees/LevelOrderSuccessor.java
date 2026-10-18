package tobeorganized.trees;

import common.utils.BinaryTreeNode;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a binary tree and a node, find the level order successor of the given node in the tree.
 * The level order successor is the node that appears right after the given node in the level order
 * traversal.
 */
public class LevelOrderSuccessor {
  public static BinaryTreeNode findSuccessor(BinaryTreeNode root, int key) {
    if (root == null) return null;

    Queue<BinaryTreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      BinaryTreeNode currentNode = queue.poll();
      // insert the children of current node in the queue
      if (currentNode.left != null) queue.offer(currentNode.left);
      if (currentNode.right != null) queue.offer(currentNode.right);

      // break if we have found the key
      if (currentNode.data == key) break;
    }

    return queue.peek();
  }

  public static void main(String[] args) {
    BinaryTreeNode root = new BinaryTreeNode(12);
    root.left = new BinaryTreeNode(7);
    root.right = new BinaryTreeNode(1);
    root.left.left = new BinaryTreeNode(9);
    root.right.left = new BinaryTreeNode(10);
    root.right.right = new BinaryTreeNode(5);
    BinaryTreeNode result = LevelOrderSuccessor.findSuccessor(root, 12);
    if (result != null) System.out.println(result.data + " ");
    result = LevelOrderSuccessor.findSuccessor(root, 9);
    if (result != null) System.out.println(result.data + " ");
  }
}
