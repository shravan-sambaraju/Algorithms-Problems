package tobeorganized.trees;

import common.utils.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class WaysToConstructBinaryTree {
  public static List<BinaryTreeNode> findUniqueTrees(int n) {
    if (n <= 0) return new ArrayList<BinaryTreeNode>();
    return findUniqueTreesRecursive(1, n);
  }

  public static List<BinaryTreeNode> findUniqueTreesRecursive(int start, int end) {
    List<BinaryTreeNode> result = new ArrayList<>();
    // base condition, return 'null' for an empty sub-tree
    // consider n=1, in this case we will have start=end=1, this means we should have only one tree
    // we will have two recursive calls, findUniqueTreesRecursive(1, 0) & (2, 1)
    // both of these should return 'null' for the left and the right child
    if (start > end) {
      result.add(null);
      return result;
    }

    for (int i = start; i <= end; i++) {
      // making 'i' root of the tree
      List<BinaryTreeNode> leftSubtrees = findUniqueTreesRecursive(start, i - 1);
      List<BinaryTreeNode> rightSubtrees = findUniqueTreesRecursive(i + 1, end);
      for (BinaryTreeNode leftTree : leftSubtrees) {
        for (BinaryTreeNode rightTree : rightSubtrees) {
          BinaryTreeNode root = new BinaryTreeNode(i);
          root.left = leftTree;
          root.right = rightTree;
          result.add(root);
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    List<BinaryTreeNode> result = WaysToConstructBinaryTree.findUniqueTrees(2);
    System.out.print("Total trees: " + result.size());
  }
}
