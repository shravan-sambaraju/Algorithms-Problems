package problems.trees;

/** Insert element into binary search tree */

import common.utils.BinaryTreeNode;

class InsertElementIntoBST {

  public static void main(String args[]) {

    BinaryTreeNode node = new BinaryTreeNode(50);
    node.setLeft(new BinaryTreeNode(30));
    node.setRight(new BinaryTreeNode(70));
    node.getLeft().setLeft(new BinaryTreeNode(20));
    node.getLeft().setRight(new BinaryTreeNode(40));
    node.getRight().setLeft(new BinaryTreeNode(60));
    node.getRight().setRight(new BinaryTreeNode(80));

    InsertElementIntoBST insert = new InsertElementIntoBST();
    System.out.println(insert.insertRecursive(node, 90).getRight().getRight().getRight().getData());
    System.out.println(insert.addNode(10, node).getLeft().getLeft().getLeft().getData());
  }

  private BinaryTreeNode insertRecursive(BinaryTreeNode root, int data) {
    if (root == null) {
      return new BinaryTreeNode(data);
    } else {
      if (data < root.getData()) {
        root.setLeft(insertRecursive(root.getLeft(), data));
      } else if (data > root.getData()) {
        root.setRight(insertRecursive(root.getRight(), data));
      }
    }
    return root;
  }

  private BinaryTreeNode addNode(int data, BinaryTreeNode head) {
    BinaryTreeNode tempHead = head;
    BinaryTreeNode n = new BinaryTreeNode(data);
    if (head == null) {
      head = n;
      return head;
    }
    BinaryTreeNode prev = null;
    while (head != null) {
      prev = head;
      if (head.getData() < data) {
        head = head.getRight();
      } else {
        head = head.getLeft();
      }
    }
    if (prev.getData() < data) {
      prev.setRight(n);
    } else {
      prev.setLeft(n);
    }
    return tempHead;
  }
}
