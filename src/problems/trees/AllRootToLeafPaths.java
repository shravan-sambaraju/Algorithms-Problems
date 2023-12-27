package problems.trees;

/* Find all root to leaf paths in binary tree */
import common.utils.BinaryTreeNode;

class AllRootToLeafPaths {

  public static void main(String args[]) {
    BinaryTreeNode node = new BinaryTreeNode(1);
    node.setLeft(new BinaryTreeNode(2));
    node.setRight(new BinaryTreeNode(3));
    node.getLeft().setLeft(new BinaryTreeNode(4));
    node.getLeft().setRight(new BinaryTreeNode(5));
    node.getRight().setLeft(new BinaryTreeNode(6));
    node.getRight().setRight(new BinaryTreeNode(7));

    AllRootToLeafPaths paths = new AllRootToLeafPaths();
    paths.printPaths(node);
  }

  private void printPaths(BinaryTreeNode root) {
    int[] path = new int[256];
    printPaths(root, path, 0);
  }

  private void printPaths(BinaryTreeNode root, int[] path, int pathLen) {
    if (root == null) {
      return;
    }
    path[pathLen] = root.getData();
    pathLen++;
    if (root.getLeft() == null && root.getRight() == null) {
      printArray(path, pathLen);
    } else {
      printPaths(root.getLeft(), path, pathLen);
      printPaths(root.getRight(), path, pathLen);
    }
  }

  private void printArray(int[] ints, int len) {
    for (int i = 0; i < len; i++) {
      System.out.print(ints[i] + " ");
    }
    System.out.println();
  }
}
