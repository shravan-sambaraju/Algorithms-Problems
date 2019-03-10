package problems.trees;

/** Lowest common ancestor of two pointers in binary search tree */
import common.utils.BinaryTreeNode;

class LCAOfTwoPointersInBST {

  private static BinaryTreeNode findLCA(BinaryTreeNode root, BinaryTreeNode a, BinaryTreeNode b) {
    if (root == null) {
      return null;
    }
    if (root == a || root == b) {
      return root;
    }
    if (Math.max(a.getData(), b.getData()) < root.getData()) {
      return findLCA(root.getLeft(), a, b);

    } else if (Math.min(a.getData(), b.getData()) > root.getData()) {
      return findLCA(root.getRight(), a, b);
    } else {
      return root;
    }
  }

  public static void main(String args[]) {

    BinaryTreeNode node = new BinaryTreeNode(50);
    node.setLeft(new BinaryTreeNode(30));
    node.setRight(new BinaryTreeNode(70));
    node.getLeft().setLeft(new BinaryTreeNode(20));
    node.getLeft().setRight(new BinaryTreeNode(40));
    node.getRight().setLeft(new BinaryTreeNode(60));
    node.getRight().setRight(new BinaryTreeNode(80));
    node.getRight().getRight().setRight(new BinaryTreeNode(100));

    BinaryTreeNode lca = findLCA(node, node.getLeft().getLeft(), node.getRight().getLeft());
    System.out.println(lca.getData());
  }
}
