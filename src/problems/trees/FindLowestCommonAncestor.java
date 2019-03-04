package problems.trees;

/* Find lowest common ancestor of given node */

import common.utils.BinaryTreeNode;

class FindLowestCommonAncestor {

  private static BinaryTreeNode lca(BinaryTreeNode root, BinaryTreeNode n1, BinaryTreeNode n2) {
    if (root == null) {
      return null;
    }
    if (root == n1 || root == n2) {
      return root;
    }

    BinaryTreeNode left = lca(root.getLeft(), n1, n2);
    BinaryTreeNode right = lca(root.getRight(), n1, n2);

    if (left != null && right != null) {
      return root;
    }
    return left != null ? left : right;
  }

  public static void main(String args[]) {

    BinaryTreeNode node = new BinaryTreeNode(1);
    node.setLeft(new BinaryTreeNode(2));
    node.setRight(new BinaryTreeNode(3));
    node.getLeft().setLeft(new BinaryTreeNode(4));
    node.getLeft().setRight(new BinaryTreeNode(5));
    node.getRight().setLeft(new BinaryTreeNode(6));
    node.getRight().setRight(new BinaryTreeNode(7));

    BinaryTreeNode result = lca(node, node.getLeft().getLeft(), node.getRight().getLeft());
    System.out.println(result.getData());

    BinaryTreeNode result2 = lca(node, node.getRight().getLeft(), node.getRight().getRight());
    System.out.println(result2.getData());
  }
}
