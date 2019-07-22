package tobeorganized.trees;

import common.utils.BinaryTreeNode;

public class DeleteFromBinaryTree {

  private BinaryTreeNode root;

  public BinaryTreeNode getRoot() {
    return root;
  }

  public void setRoot(BinaryTreeNode root) {
    this.root = root;
  }

  // 3 conditions for delete
  // 1.BinaryTreeNode is leaf BinaryTreeNode.
  // 2.BinaryTreeNode has 1 child.
  // 3.BinaryTreeNode has 2 children.
  boolean delete(int value, BinaryTreeNode currentBinaryTreeNode) {

    if (root == null) {
      return false;
    }

    BinaryTreeNode parent = null; // To Store parent of currentBinaryTreeNode
    while (currentBinaryTreeNode != null && (currentBinaryTreeNode.getData() != value)) {
      parent = currentBinaryTreeNode;
      if (currentBinaryTreeNode.getData() > value)
        currentBinaryTreeNode = currentBinaryTreeNode.getLeft();
      else currentBinaryTreeNode = currentBinaryTreeNode.getRight();
    }

    if (currentBinaryTreeNode == null) {
      return false;
    } else if (currentBinaryTreeNode.getLeft() == null
        && currentBinaryTreeNode.getRight() == null) {
      // 1. BinaryTreeNode is Leaf BinaryTreeNode
      // if that leaf BinaryTreeNode is the root (a tree with just root)
      if (root.getData() == currentBinaryTreeNode.getData()) {
        setRoot(null);
        return true;
      } else if (currentBinaryTreeNode.getData() < parent.getData()) {
        parent.setLeft(null);
        return true;
      } else {
        parent.setRight(null);
        return true;
      }
    } else if (currentBinaryTreeNode.getRight() == null) {

      if (root.getData() == currentBinaryTreeNode.getData()) {
        setRoot(currentBinaryTreeNode.getLeft());
        return true;
      } else if (currentBinaryTreeNode.getData() < parent.getData()) {
        parent.setLeft(currentBinaryTreeNode.getLeft());
        return true;
      } else {

        parent.setRight(currentBinaryTreeNode.getLeft());
        return true;
      }

    } else if (currentBinaryTreeNode.getLeft() == null) {

      if (root.getData() == currentBinaryTreeNode.getData()) {
        setRoot(currentBinaryTreeNode.getRight());
        return true;
      } else if (currentBinaryTreeNode.getData() < parent.getData()) {
        parent.setLeft(currentBinaryTreeNode.getRight());
        return true;
      } else {
        parent.setRight(currentBinaryTreeNode.getRight());
        return true;
      }

    } else {
      // Find Least Value BinaryTreeNode in right-subtree of current BinaryTreeNode
      BinaryTreeNode leastBinaryTreeNode =
          findLeastBinaryTreeNode(currentBinaryTreeNode.getRight());
      // Set CurrentBinaryTreeNode's Data to the least value in its right-subtree
      int temp = leastBinaryTreeNode.getData();
      delete(temp, root);
      currentBinaryTreeNode.setData(temp);
      // Delete the leafBinaryTreeNode which had the least value
      return true;
    }
  }

  // Helper function to find least value BinaryTreeNode in right-subtree of currentBinaryTreeNode
  private BinaryTreeNode findLeastBinaryTreeNode(BinaryTreeNode currentBinaryTreeNode) {

    BinaryTreeNode temp = currentBinaryTreeNode;

    while (temp.getLeft() != null) {
      temp = temp.getLeft();
    }

    return temp;
  }

  // Iterative Function to insert a value in BST
  public boolean add(int value) {

    // If Tree is empty then insert Root with the given value inside Tree
    if (isEmpty()) {
      root = new BinaryTreeNode(value);
      return true;
    }

    // Starting from root
    BinaryTreeNode currentBinaryTreeNode = root;

    // Traversing the tree untill valid position to insert the value
    while (currentBinaryTreeNode != null) {

      BinaryTreeNode leftChild = currentBinaryTreeNode.getLeft();
      BinaryTreeNode rightChild = currentBinaryTreeNode.getRight();

      // If the value to insert is less than root value
      // then move to left subtree else move to right subtree of root
      // and before moving check if the subtree is null, if it's then insert the value.

      if (currentBinaryTreeNode.getData() > value) {
        if (leftChild == null) {
          leftChild = new BinaryTreeNode(value);
          currentBinaryTreeNode.setLeft(leftChild);
          return true;
        }
        currentBinaryTreeNode = leftChild;
      } else {
        if (rightChild == null) {
          rightChild = new BinaryTreeNode(value);
          currentBinaryTreeNode.setRight(rightChild);
          return true;
        }
        currentBinaryTreeNode = rightChild;
      } // end of else
    } // end of while
    return false;
  }

  // Function to check if Tree is empty or not
  public boolean isEmpty() {
    return root == null; // if root is null then it means Tree is empty
  }

  // Just for Testing purpose
  public void printTree(BinaryTreeNode current) {

    if (current == null) return;

    System.out.print(current.getData() + ",");
    printTree(current.getLeft());
    printTree(current.getRight());
  }

  public static void main(String args[]) {

    DeleteFromBinaryTree bsT = new DeleteFromBinaryTree();

    bsT.add(6);
    bsT.add(7);
    bsT.add(8);
    bsT.add(12);
    bsT.add(1);
    bsT.add(15);

    System.out.print("Tree : ");
    bsT.printTree(bsT.getRoot());

    System.out.print("\nDeleting BinaryTreeNode 6: ");
    bsT.delete(6, bsT.getRoot());
    bsT.printTree(bsT.getRoot());

    System.out.print("\nDeleting BinaryTreeNode 15: ");
    bsT.delete(15, bsT.getRoot());
    bsT.printTree(bsT.getRoot());

    System.out.print("\nDeleting BinaryTreeNode 1: ");
    bsT.delete(1, bsT.getRoot());
    bsT.printTree(bsT.getRoot());
  }
}
