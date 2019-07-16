package tobeorganized.trees;

import common.utils.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsBinaryTree {
  public static List<Double> findLevelAverages(BinaryTreeNode root) {
    List<Double> result = new ArrayList<>();
    if (root == null) return result;

    Queue<BinaryTreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      double levelSum = 0;
      for (int i = 0; i < levelSize; i++) {
        BinaryTreeNode currentNode = queue.poll();
        // add the node's value to the running sum
        levelSum += currentNode.data;
        // insert the children of current node to the queue
        if (currentNode.left != null) queue.offer(currentNode.left);
        if (currentNode.right != null) queue.offer(currentNode.right);
      }
      // append the current level's average to the result array
      result.add(levelSum / levelSize);
    }

    return result;
  }

  public static void main(String[] args) {
    BinaryTreeNode root = new BinaryTreeNode(12);
    root.left = new BinaryTreeNode(7);
    root.right = new BinaryTreeNode(1);
    root.left.left = new BinaryTreeNode(9);
    root.left.right = new BinaryTreeNode(2);
    root.right.left = new BinaryTreeNode(10);
    root.right.right = new BinaryTreeNode(5);
    List<Double> result = AverageOfLevelsBinaryTree.findLevelAverages(root);
    System.out.print("Level averages are: " + result);
  }
}
