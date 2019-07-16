package tobeorganized.trees;

import common.utils.BinaryTreeNode;

public class PathWithMaximumSum {
  private static int globalMaximumSum;

  public static int findMaximumPathSum(BinaryTreeNode root) {
    globalMaximumSum = Integer.MIN_VALUE;
    findMaximumPathSumRecursive(root);
    return globalMaximumSum;
  }

  private static int findMaximumPathSumRecursive(BinaryTreeNode currentNode) {
    if (currentNode == null) return 0;

    int maxPathSumFromLeft = findMaximumPathSumRecursive(currentNode.left);
    int maxPathSumFromRight = findMaximumPathSumRecursive(currentNode.right);

    // ignore paths with negative sums, since we need to find the maximum sum we should
    // ignore any path which has an overall negative sum.
    maxPathSumFromLeft = Math.max(maxPathSumFromLeft, 0);
    maxPathSumFromRight = Math.max(maxPathSumFromRight, 0);

    // maximum path sum at the current node will be equal to the sum from the left subtree +
    // the sum from right subtree + data of current node
    int localMaximumSum = maxPathSumFromLeft + maxPathSumFromRight + currentNode.data;

    // update the global maximum sum
    globalMaximumSum = Math.max(globalMaximumSum, localMaximumSum);

    // maximum sum of any path from the current node will be equal to the maximum of
    // the sums from left or right subtrees plus the dataue of the current node
    return Math.max(maxPathSumFromLeft, maxPathSumFromRight) + currentNode.data;
  }

  public static void main(String[] args) {
    BinaryTreeNode root = new BinaryTreeNode(1);
    root.left = new BinaryTreeNode(2);
    root.right = new BinaryTreeNode(3);
    System.out.println("Maximum Path Sum: " + PathWithMaximumSum.findMaximumPathSum(root));

    root.left.left = new BinaryTreeNode(1);
    root.left.right = new BinaryTreeNode(3);
    root.right.left = new BinaryTreeNode(5);
    root.right.right = new BinaryTreeNode(6);
    root.right.left.left = new BinaryTreeNode(7);
    root.right.left.right = new BinaryTreeNode(8);
    root.right.right.left = new BinaryTreeNode(9);
    System.out.println("Maximum Path Sum: " + PathWithMaximumSum.findMaximumPathSum(root));

    root = new BinaryTreeNode(-1);
    root.left = new BinaryTreeNode(-3);
    System.out.println("Maximum Path Sum: " + PathWithMaximumSum.findMaximumPathSum(root));
  }
}
