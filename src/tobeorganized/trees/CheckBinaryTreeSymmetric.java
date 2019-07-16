package tobeorganized.trees;

import java.util.LinkedList;
import java.util.Queue;

class CheckBinaryTreeSymmetric {

  public boolean isSymmetric(TreeNode root) {
    return root == null || isSymmetricHelper(root.left, root.right);
  }

  private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
    if (left == null || right == null) {
      return left == right;
    }
    if (left.val != right.val) {
      return false;
    }
    return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
  }

  public boolean isSymmetricIterative(TreeNode root) {
    if (root == null) {
      return true;
    }
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.add(root.left);
    q.add(root.right);
    while (!q.isEmpty()) {
      TreeNode left = q.poll();
      TreeNode right = q.poll();
      if (left == null && right == null) {
        continue;
      }
      if (left == null || right == null || left.val != right.val) {
        return false;
      }
      q.add(left.left);
      q.add(right.right);
      q.add(left.right);
      q.add(right.left);
    }
    return true;
  }
}
