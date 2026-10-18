package tobeorganized.trees;

import common.utils.BinaryTreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/*
 * Given a binary tree and a number 'S', find all paths in the tree such that the sum of all the
 * node values of each path equals 'S'. Please note that the paths can start or end at any node but
 * all paths must follow direction from parent to child (top to bottom).
 */
public class CountAllPathsSum {

  public static int countPaths(BinaryTreeNode root, int S) {
    List<Integer> currentPath = new LinkedList<>();
    return countPathsRecursive(root, S, currentPath);
  }

  private static int countPathsRecursive(
      BinaryTreeNode currentNode, int S, List<Integer> currentPath) {
    if (currentNode == null) return 0;

    // add the current node to the path
    currentPath.add(currentNode.data);
    int pathCount = 0, pathSum = 0;
    // find the sums of all sub-paths in the current path list
    ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size());
    while (pathIterator.hasPrevious()) {
      pathSum += pathIterator.previous();
      // if the sum of any sub-path is equal to 'S' we increment our path count.
      if (pathSum == S) {
        pathCount++;
      }
    }

    // traverse the left sub-tree
    pathCount += countPathsRecursive(currentNode.left, S, currentPath);
    // traverse the right sub-tree
    pathCount += countPathsRecursive(currentNode.right, S, currentPath);

    // remove the current node from the path to backtrack,
    // we need to remove the current node while we are going up the recursive call stack.
    currentPath.remove(currentPath.size() - 1);

    return pathCount;
  }

  public static void main(String[] args) {
    BinaryTreeNode root = new BinaryTreeNode(12);
    root.left = new BinaryTreeNode(7);
    root.right = new BinaryTreeNode(1);
    root.left.left = new BinaryTreeNode(4);
    root.right.left = new BinaryTreeNode(10);
    root.right.right = new BinaryTreeNode(5);
    System.out.println("Tree has path: " + CountAllPathsSum.countPaths(root, 11));
  }
}
